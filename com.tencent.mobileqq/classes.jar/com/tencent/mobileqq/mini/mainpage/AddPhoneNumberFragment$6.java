package com.tencent.mobileqq.mini.mainpage;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class AddPhoneNumberFragment$6
  implements View.OnClickListener
{
  AddPhoneNumberFragment$6(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if (AddPhoneNumberFragment.access$900(this.this$0) != null)
    {
      AddPhoneNumberFragment.access$900(this.this$0).performClick();
      AddPhoneNumberFragment.access$900(this.this$0).requestFocus();
      ((InputMethodManager)AddPhoneNumberFragment.access$900(this.this$0).getContext().getSystemService("input_method")).showSoftInput(AddPhoneNumberFragment.access$900(this.this$0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.6
 * JD-Core Version:    0.7.0.1
 */