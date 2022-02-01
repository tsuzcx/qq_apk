package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QQReminderDataServiceImpl$3
  implements Runnable
{
  QQReminderDataServiceImpl$3(QQReminderDataServiceImpl paramQQReminderDataServiceImpl, List paramList) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, "save reminder msg list is null or empty!");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        AcsMsg localAcsMsg = (AcsMsg)localIterator.next();
        QQReminderDataServiceImpl.access$300(this.this$0, localAcsMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */