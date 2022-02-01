package com.tencent.mobileqq.reminder.api.impl;

import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.Builder;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.reminder.calendar.CalenderUtils;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.util.DBBuildUtil;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class QQReminderCalendarServiceImpl
  implements IQQReminderCalendarService
{
  public static final String TAG = "QQReminderCalendarImpl";
  private AppRuntime app;
  private EntityManager mEntityManager;
  
  private void runAtOtherThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManagerV2.excute(paramRunnable, 32, null, true);
      return;
    }
    paramRunnable.run();
  }
  
  public void addCalendarEntity(CalendarEntity paramCalendarEntity)
  {
    runAtOtherThread(new QQReminderCalendarServiceImpl.1(this, paramCalendarEntity));
  }
  
  public void deleteCalendarAlarm(AppActivity paramAppActivity, CalendarEntity paramCalendarEntity)
  {
    if (isCalendarOpen(paramAppActivity)) {
      new CalenderUtils().b(paramAppActivity, paramCalendarEntity);
    }
  }
  
  public void deleteCalendarEntity(CalendarEntity paramCalendarEntity)
  {
    runAtOtherThread(new QQReminderCalendarServiceImpl.2(this, paramCalendarEntity));
  }
  
  public boolean isCalendarOpen(Context paramContext)
  {
    return TripleGraySwitchUtil.a(paramContext, "KEY_REMINDER_CALENDAR");
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.mEntityManager = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(null).build().createEntityManager();
  }
  
  public void onDestroy()
  {
    this.mEntityManager.close();
  }
  
  public List<CalendarEntity> queryCalendarEntity(String paramString)
  {
    return this.mEntityManager.query(CalendarEntity.class, CalendarEntity.class.getSimpleName(), false, "msg_id = ?", new String[] { paramString }, null, null, "notice_time", null);
  }
  
  public void setCalendarAlarm(AppActivity paramAppActivity, CalendarEntity paramCalendarEntity)
  {
    if (isCalendarOpen(paramAppActivity)) {
      new CalenderUtils().a(paramAppActivity, paramCalendarEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderCalendarServiceImpl
 * JD-Core Version:    0.7.0.1
 */