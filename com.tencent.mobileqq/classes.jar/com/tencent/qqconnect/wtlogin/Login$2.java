package com.tencent.qqconnect.wtlogin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Login$2
  implements View.OnClickListener
{
  Login$2(Login paramLogin) {}
  
  public void onClick(View paramView)
  {
    this.a.mBaseUI.t();
    Login.access$100(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.2
 * JD-Core Version:    0.7.0.1
 */