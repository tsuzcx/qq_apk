package com.tencent.mobileqq.loginwelcome;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginwelcomeHelper$3
  implements View.OnClickListener
{
  LoginwelcomeHelper$3(LoginwelcomeHelper paramLoginwelcomeHelper) {}
  
  public void onClick(View paramView)
  {
    this.a.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.3
 * JD-Core Version:    0.7.0.1
 */