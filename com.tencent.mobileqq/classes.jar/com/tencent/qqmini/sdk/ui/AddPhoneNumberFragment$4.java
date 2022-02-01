package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddPhoneNumberFragment$4
  implements View.OnClickListener
{
  AddPhoneNumberFragment$4(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if (AddPhoneNumberFragment.access$400(this.this$0) != null)
    {
      AddPhoneNumberFragment.access$400(this.this$0).performClick();
      AddPhoneNumberFragment.access$400(this.this$0).requestFocus();
      ((InputMethodManager)AddPhoneNumberFragment.access$400(this.this$0).getContext().getSystemService("input_method")).showSoftInput(AddPhoneNumberFragment.access$400(this.this$0), 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.4
 * JD-Core Version:    0.7.0.1
 */