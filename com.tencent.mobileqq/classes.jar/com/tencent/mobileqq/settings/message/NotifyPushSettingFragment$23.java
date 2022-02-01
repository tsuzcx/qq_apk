package com.tencent.mobileqq.settings.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

class NotifyPushSettingFragment$23
  extends BroadcastReceiver
{
  NotifyPushSettingFragment$23(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("uin");
      NotifyPushSettingFragment.a(this.a, paramContext);
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!"com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive".equals(paramContext));
      paramContext = paramIntent.getStringExtra("uin");
      bool = paramIntent.getBooleanExtra("configPCActive", false);
    } while (!NotifyPushSettingFragment.a(this.a).getAccount().equals(paramContext));
    if (bool)
    {
      NotifyPushSettingFragment.f(this.a).setVisibility(0);
      return;
    }
    NotifyPushSettingFragment.f(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.23
 * JD-Core Version:    0.7.0.1
 */