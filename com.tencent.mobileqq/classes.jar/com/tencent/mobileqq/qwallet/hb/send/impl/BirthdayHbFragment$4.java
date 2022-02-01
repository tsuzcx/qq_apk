package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

class BirthdayHbFragment$4
  implements View.OnTouchListener
{
  BirthdayHbFragment$4(BirthdayHbFragment paramBirthdayHbFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    BirthdayHbFragment.c(this.a).setVisibility(0);
    BirthdayHbFragment.d(this.a).setVisibility(0);
    BirthdayHbFragment.f(this.a).setFocusable(false);
    BirthdayHbFragment.e(this.a).setFocusable(true);
    BirthdayHbFragment.e(this.a).setFocusableInTouchMode(true);
    BirthdayHbFragment.e(this.a).requestFocus();
    if (!TextUtils.isEmpty(BirthdayHbFragment.f(this.a).getText()))
    {
      BirthdayHbFragment.e(this.a).setText(BirthdayHbFragment.f(this.a).getText());
      BirthdayHbFragment.e(this.a).setSelection(BirthdayHbFragment.f(this.a).getText().length());
    }
    paramView = (InputMethodManager)this.a.getContext().getSystemService("input_method");
    if (paramView != null) {
      paramView.showSoftInput(BirthdayHbFragment.e(this.a), 1);
    }
    BirthdayHbFragment.f(this.a).setImeOptions(6);
    BirthdayHbFragment.e(this.a).setImeOptions(6);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbFragment.4
 * JD-Core Version:    0.7.0.1
 */