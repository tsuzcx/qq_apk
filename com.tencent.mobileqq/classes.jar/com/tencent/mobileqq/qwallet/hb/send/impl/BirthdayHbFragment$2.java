package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.LinearLayout;

class BirthdayHbFragment$2
  implements View.OnTouchListener
{
  BirthdayHbFragment$2(BirthdayHbFragment paramBirthdayHbFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    BirthdayHbFragment.c(this.a).setVisibility(0);
    BirthdayHbFragment.a(this.a).setVisibility(0);
    this.a.d.setFocusable(false);
    BirthdayHbFragment.b(this.a).setFocusable(true);
    BirthdayHbFragment.b(this.a).setFocusableInTouchMode(true);
    BirthdayHbFragment.b(this.a).requestFocus();
    this.a.d.setImeOptions(6);
    BirthdayHbFragment.b(this.a).setImeOptions(6);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbFragment.2
 * JD-Core Version:    0.7.0.1
 */