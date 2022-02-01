package com.tencent.qqconnect.wtlogin;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class Login$2
  implements TextView.OnEditorActionListener
{
  Login$2(Login paramLogin) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.a.b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.2
 * JD-Core Version:    0.7.0.1
 */