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
    if (QQReminderDataServiceImpl.access$100(this.this$0) == null)
    {
      QQReminderDataServiceImpl localQQReminderDataServiceImpl = this.this$0;
      QQReminderDataServiceImpl.access$102(localQQReminderDataServiceImpl, (IQQReminderAlarmService)QQReminderDataServiceImpl.access$200(localQQReminderDataServiceImpl).getRuntimeService(IQQReminderAlarmService.class, ""));
    }
    if (this.a.type == 0) {
      if (QQReminderDataServiceImpl.access$100(this.this$0) != null) {
        QQReminderDataServiceImpl.access$100(this.this$0).setAlarmTimer(this.a);
      } else {
        QQReminderUtil.c(this.a);
      }
    }
    QQReminderDataServiceImpl.access$300(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */