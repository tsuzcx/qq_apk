package com.tencent.qqconnect.wtlogin;

import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class Login$5
  implements View.OnTouchListener
{
  Login$5(Login paramLogin) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.a.pswd)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.a.pswd.getText().length() > 0))
      {
        this.a.mDelPassBtn.setVisibility(0);
        return false;
      }
    }
    else if ((paramView == this.a.name) && (paramMotionEvent.getAction() == 0) && (this.a.name.getText().length() > 0)) {
      this.a.mDelBtn.setVisibility(0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.5
 * JD-Core Version:    0.7.0.1
 */