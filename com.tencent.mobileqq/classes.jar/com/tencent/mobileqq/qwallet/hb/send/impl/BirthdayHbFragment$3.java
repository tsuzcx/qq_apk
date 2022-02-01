package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class BirthdayHbFragment$3
  implements TextView.OnEditorActionListener
{
  BirthdayHbFragment$3(BirthdayHbFragment paramBirthdayHbFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      BirthdayHbFragment.d(this.a).setVisibility(8);
      BirthdayHbFragment.f(this.a).setText(BirthdayHbFragment.e(this.a).getText());
    }
    else if (paramInt == 5)
    {
      BirthdayHbFragment.d(this.a).setVisibility(8);
      BirthdayHbFragment.f(this.a).setText(BirthdayHbFragment.e(this.a).getText());
      if (BirthdayHbFragment.c(this.a).getVisibility() == 0) {
        BirthdayHbFragment.c(this.a).setVisibility(8);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbFragment.3
 * JD-Core Version:    0.7.0.1
 */