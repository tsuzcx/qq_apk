package com.tencent.qqconnect.wtlogin;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.util.HandlerPlus;

class Login$12
  implements View.OnClickListener
{
  Login$12(Login paramLogin) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.login)
    {
      LoginStaticField.a(4);
      this.a.doLogin();
    }
    else if (paramView == this.a.leftView)
    {
      Object localObject = (InputMethodManager)this.a.getSystemService("input_method");
      if (localObject != null) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
      }
      localObject = this.a.mHandler.obtainMessage();
      ((Message)localObject).what = 0;
      this.a.mHandler.sendMessageDelayed((Message)localObject, 100L);
    }
    else if (paramView == this.a.mDelBtn)
    {
      this.a.name.setText("");
    }
    else if (paramView == this.a.mDelPassBtn)
    {
      this.a.pswd.setText("");
    }
    else if (paramView == this.a.unLoginTv)
    {
      this.a.showActionSheet();
    }
    else if (paramView == this.a.mQrCodeBtn)
    {
      Login.access$400(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.12
 * JD-Core Version:    0.7.0.1
 */