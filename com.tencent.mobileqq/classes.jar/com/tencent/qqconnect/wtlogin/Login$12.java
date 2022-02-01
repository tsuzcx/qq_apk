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
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton)
    {
      LoginStaticField.a(4);
      this.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.a.d)
      {
        Object localObject = (InputMethodManager)this.a.getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
        }
        localObject = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        ((Message)localObject).what = 0;
        this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessageDelayed((Message)localObject, 100L);
      }
      else if (paramView == this.a.jdField_a_of_type_AndroidViewView)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
      }
      else if (paramView == this.a.jdField_b_of_type_AndroidViewView)
      {
        this.a.jdField_b_of_type_AndroidWidgetEditText.setText("");
      }
      else if (paramView == this.a.jdField_b_of_type_AndroidWidgetTextView)
      {
        this.a.e();
      }
      else if (paramView == this.a.c)
      {
        Login.b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.12
 * JD-Core Version:    0.7.0.1
 */