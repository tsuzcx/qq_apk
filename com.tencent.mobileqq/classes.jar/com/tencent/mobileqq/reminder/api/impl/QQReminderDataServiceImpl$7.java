package com.tencent.mobileqq.reminder.api.impl;

import com.tencent.qphone.base.util.QLog;

class QQReminderDataServiceImpl$7
  implements Runnable
{
  QQReminderDataServiceImpl$7(QQReminderDataServiceImpl paramQQReminderDataServiceImpl) {}
  
  public void run()
  {
    int i = QQReminderDataServiceImpl.access$000(this.this$0, 9223372036854775806L);
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "delete reminder list count: ", Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */