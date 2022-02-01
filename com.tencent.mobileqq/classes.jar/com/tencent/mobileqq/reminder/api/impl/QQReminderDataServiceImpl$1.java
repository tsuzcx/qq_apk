package com.tencent.mobileqq.reminder.api.impl;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class QQReminderDataServiceImpl$1
  implements Runnable
{
  QQReminderDataServiceImpl$1(QQReminderDataServiceImpl paramQQReminderDataServiceImpl) {}
  
  public void run()
  {
    QQReminderDataServiceImpl.access$000(this.this$0, NetConnInfoCenter.getServerTime() - 86400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */