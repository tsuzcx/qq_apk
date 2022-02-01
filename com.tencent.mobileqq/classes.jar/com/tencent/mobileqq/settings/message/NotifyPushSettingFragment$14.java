package com.tencent.mobileqq.settings.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingFragment$14
  implements View.OnClickListener
{
  NotifyPushSettingFragment$14(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.a(NotifyPushSettingFragment.c(this.a), "0X800B84C");
    PublicFragmentActivity.a(this.a.getBaseActivity(), NewTempMsgSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.14
 * JD-Core Version:    0.7.0.1
 */