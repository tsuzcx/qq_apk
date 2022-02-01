package com.tencent.mobileqq.reminder.biz;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

class QQReminderServlet$1
  implements Runnable
{
  QQReminderServlet$1(QQReminderServlet paramQQReminderServlet, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.biz.QQReminderServlet.1
 * JD-Core Version:    0.7.0.1
 */