package com.tencent.mobileqq.reminder.biz;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

class QQReminderServlet$1
  implements Runnable
{
  QQReminderServlet$1(QQReminderServlet paramQQReminderServlet, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.a.onReceive(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.biz.QQReminderServlet.1
 * JD-Core Version:    0.7.0.1
 */