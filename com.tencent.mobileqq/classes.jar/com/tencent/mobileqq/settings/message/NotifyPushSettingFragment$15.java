package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingFragment$15
  implements View.OnClickListener
{
  NotifyPushSettingFragment$15(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.getBaseActivity(), SoundAndVibrateActivity.class);
    this.a.startActivity(localIntent);
    ReportController.b(NotifyPushSettingFragment.a(this.a), "CliOper", "", "", "0X800403C", "0X800403C", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.15
 * JD-Core Version:    0.7.0.1
 */