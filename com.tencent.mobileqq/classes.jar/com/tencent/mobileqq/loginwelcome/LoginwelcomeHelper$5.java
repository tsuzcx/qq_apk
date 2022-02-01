package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginwelcomeHelper$5
  implements View.OnClickListener
{
  LoginwelcomeHelper$5(LoginwelcomeHelper paramLoginwelcomeHelper, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    LoginUserGuideHelper.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.a.a(), LoginwelcomeHelper.a(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper));
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.g();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.a.a, "dc00898", "", "", "0X8009F4A", "0X8009F4A", 1, 0, "1", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.5
 * JD-Core Version:    0.7.0.1
 */