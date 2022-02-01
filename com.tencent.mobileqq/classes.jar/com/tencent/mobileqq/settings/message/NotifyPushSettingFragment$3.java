package com.tencent.mobileqq.settings.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity.TimePickDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingFragment$3
  implements View.OnClickListener
{
  NotifyPushSettingFragment$3(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.a(NotifyPushSettingFragment.a(this.a), "0X800B84A");
    if (NotifyPushSettingFragment.a(this.a) == null)
    {
      NotifyPushSettingFragment localNotifyPushSettingFragment = this.a;
      NotifyPushSettingFragment.a(localNotifyPushSettingFragment, new NotifyPushSettingActivity.TimePickDialog(localNotifyPushSettingFragment.getBaseActivity(), NotifyPushSettingFragment.a(this.a), NotifyPushSettingFragment.a(this.a), NotifyPushSettingFragment.a(this.a).a(), NotifyPushSettingFragment.a(this.a)));
      NotifyPushSettingFragment.a(this.a).a(NotifyPushSettingFragment.a(this.a));
    }
    if (NotifyPushSettingFragment.a(this.a))
    {
      int i = (int)NetConnInfoCenter.getServerTime();
      int j = SettingCloneUtil.readValueForInt(this.a.getBaseActivity().getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      NotifyPushSettingFragment.a(this.a).a(j - i);
    }
    NotifyPushSettingFragment.a(this.a).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */