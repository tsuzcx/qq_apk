package com.tencent.mobileqq.reminder.biz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQReminderAlarmReceiver
  extends BroadcastReceiver
{
  private AppRuntime a;
  
  public QQReminderAlarmReceiver(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("notification_alram_action".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("msg");
      paramIntent = paramIntent.getStringExtra("msg_id");
      if (QLog.isColorLevel()) {
        QLog.d("QQReminderAlarmReceiver", 2, "---" + paramContext + "---msgId---" + paramIntent);
      }
      IQQReminderDataService localIQQReminderDataService = (IQQReminderDataService)this.a.getRuntimeService(IQQReminderDataService.class, "");
      if (localIQQReminderDataService != null) {
        localIQQReminderDataService.doNotifaction(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.biz.QQReminderAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */