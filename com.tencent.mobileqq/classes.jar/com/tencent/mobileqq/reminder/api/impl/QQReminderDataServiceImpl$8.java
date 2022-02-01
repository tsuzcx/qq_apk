package com.tencent.mobileqq.reminder.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.reminder.OnGetReminderListByDayListener;
import mqq.observer.BusinessObserver;

class QQReminderDataServiceImpl$8
  implements BusinessObserver
{
  QQReminderDataServiceImpl$8(QQReminderDataServiceImpl paramQQReminderDataServiceImpl, OnGetReminderListByDayListener paramOnGetReminderListByDayListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 2003)
    {
      OnGetReminderListByDayListener localOnGetReminderListByDayListener = this.a;
      if (localOnGetReminderListByDayListener != null) {
        localOnGetReminderListByDayListener.a(paramBoolean, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */