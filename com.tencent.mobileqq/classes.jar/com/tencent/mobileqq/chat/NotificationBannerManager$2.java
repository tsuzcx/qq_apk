package com.tencent.mobileqq.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotificationBannerManager$2
  implements View.OnClickListener
{
  NotificationBannerManager$2(NotificationBannerManager paramNotificationBannerManager, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    NotificationBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqChatNotificationBannerManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ReportController.a(null, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 23, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.NotificationBannerManager.2
 * JD-Core Version:    0.7.0.1
 */