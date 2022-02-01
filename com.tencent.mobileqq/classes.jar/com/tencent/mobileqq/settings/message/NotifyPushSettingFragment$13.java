package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingFragment$13
  implements View.OnClickListener
{
  NotifyPushSettingFragment$13(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.getBaseActivity(), TroopAssisSettingActivity.class);
    this.a.startActivity(localIntent);
    ReportController.a(NotifyPushSettingFragment.c(this.a), "0X800B84B");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.13
 * JD-Core Version:    0.7.0.1
 */