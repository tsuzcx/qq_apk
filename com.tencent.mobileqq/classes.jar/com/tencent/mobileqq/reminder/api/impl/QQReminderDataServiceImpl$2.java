package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import mqq.app.AppRuntime;

class QQReminderDataServiceImpl$2
  implements Runnable
{
  QQReminderDataServiceImpl$2(QQReminderDataServiceImpl paramQQReminderDataServiceImpl, AcsMsg paramAcsMsg) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (QQReminderDataServiceImpl.access$100(this.this$0) == null) {
      QQReminderDataServiceImpl.access$102(this.this$0, (IQQReminderAlarmService)QQReminderDataServiceImpl.access$200(this.this$0).getRuntimeService(IQQReminderAlarmService.class, ""));
    }
    if (this.a.type == 0)
    {
      if (QQReminderDataServiceImpl.access$100(this.this$0) == null) {
        break label91;
      }
      QQReminderDataServiceImpl.access$100(this.this$0).setAlarmTimer(this.a);
    }
    for (;;)
    {
      QQReminderDataServiceImpl.access$300(this.this$0, this.a);
      return;
      label91:
      QQReminderUtil.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */