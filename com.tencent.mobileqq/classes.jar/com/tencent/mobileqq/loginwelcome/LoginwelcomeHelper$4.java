package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginwelcomeHelper$4
  implements View.OnClickListener
{
  LoginwelcomeHelper$4(LoginwelcomeHelper paramLoginwelcomeHelper, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    LoginUserGuideHelper.a(this.a, this.b.a.s(), LoginwelcomeHelper.b(this.b));
    this.b.g();
    ReportController.b(this.b.a.aF, "dc00898", "", "", "0X8009F4A", "0X8009F4A", 2, 0, "2", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.4
 * JD-Core Version:    0.7.0.1
 */