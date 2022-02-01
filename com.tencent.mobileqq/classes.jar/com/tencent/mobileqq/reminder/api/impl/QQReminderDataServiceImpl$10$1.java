package com.tencent.mobileqq.reminder.api.impl;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class QQReminderDataServiceImpl$10$1
  implements BusinessObserver
{
  QQReminderDataServiceImpl$10$1(QQReminderDataServiceImpl.10 param10) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2004) && (paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("ReminderDataManagerNew", 2, "acs msg succ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.10.1
 * JD-Core Version:    0.7.0.1
 */