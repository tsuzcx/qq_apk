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
    Object localObject = this.a;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AcsMsg localAcsMsg = (AcsMsg)((Iterator)localObject).next();
        QQReminderDataServiceImpl.access$300(this.this$0, localAcsMsg);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, "save reminder msg list is null or empty!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */