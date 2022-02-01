package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class BirthdayHbFragment$1
  implements TextView.OnEditorActionListener
{
  BirthdayHbFragment$1(BirthdayHbFragment paramBirthdayHbFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      BirthdayHbFragment.a(this.a).setVisibility(8);
      this.a.d.setText(BirthdayHbFragment.b(this.a).getText());
    }
    else if (paramInt == 5)
    {
      BirthdayHbFragment.a(this.a).setVisibility(8);
      this.a.d.setText(BirthdayHbFragment.b(this.a).getText());
      if (BirthdayHbFragment.c(this.a).getVisibility() == 0) {
        BirthdayHbFragment.c(this.a).setVisibility(8);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbFragment.1
 * JD-Core Version:    0.7.0.1
 */