package com.example.xaboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.xaboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDone.setOnClickListener { onDoneClicked(it) }
        binding.txtNicknameDone.setOnClickListener { updateNickname() }
    }

    private fun onDoneClicked(view: View) {
        binding.txtNicknameDone.text = binding.txtNickname.text
        binding.txtNicknameDone.visibility = View.VISIBLE

        binding.txtNickname.visibility = View.GONE
        binding.btnDone.visibility = View.GONE

        // hide keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(){
        binding.txtNicknameDone.visibility = View.GONE
        binding.txtNickname.visibility = View.VISIBLE
        binding.btnDone.visibility = View.VISIBLE

        //focus the edit view
        binding.txtNickname.requestFocus()

        //show keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.txtNickname, 0)
    }
}