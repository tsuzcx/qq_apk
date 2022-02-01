package com.tencent.mobileqq.reminder.api.impl;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.qphone.base.util.QLog;

class QQReminderCalendarServiceImpl$2
  implements Runnable
{
  QQReminderCalendarServiceImpl$2(QQReminderCalendarServiceImpl paramQQReminderCalendarServiceImpl, CalendarEntity paramCalendarEntity) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((CalendarEntity)localObject).msg_id;
      int i = QQReminderCalendarServiceImpl.access$000(this.this$0).delete(CalendarEntity.class.getSimpleName(), "msg_id = ?", new String[] { localObject });
      if (QLog.isColorLevel()) {
        QLog.d("QQReminderCalendarImpl", 1, new Object[] { "deleteCalendar msgId: ", this.a.msg_id, " count: ", Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderCalendarServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */