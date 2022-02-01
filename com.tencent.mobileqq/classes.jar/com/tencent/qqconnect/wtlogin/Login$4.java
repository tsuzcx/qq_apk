package com.tencent.qqconnect.wtlogin;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class Login$4
  implements View.OnFocusChangeListener
{
  Login$4(Login paramLogin) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.pswd)
    {
      if (paramBoolean) {
        this.a.pswd.selectAll();
      }
      if (!paramBoolean) {
        this.a.mDelPassBtn.setVisibility(4);
      }
    }
    else if ((paramView == this.a.name) && (!paramBoolean))
    {
      this.a.mDelBtn.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.4
 * JD-Core Version:    0.7.0.1
 */