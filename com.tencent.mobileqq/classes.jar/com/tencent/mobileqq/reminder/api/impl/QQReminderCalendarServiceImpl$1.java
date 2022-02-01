package com.tencent.mobileqq.reminder.api.impl;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;

class QQReminderCalendarServiceImpl$1
  implements Runnable
{
  QQReminderCalendarServiceImpl$1(QQReminderCalendarServiceImpl paramQQReminderCalendarServiceImpl, CalendarEntity paramCalendarEntity) {}
  
  public void run()
  {
    if (this.a != null) {
      QQReminderCalendarServiceImpl.access$000(this.this$0).persistOrReplace(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderCalendarServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */