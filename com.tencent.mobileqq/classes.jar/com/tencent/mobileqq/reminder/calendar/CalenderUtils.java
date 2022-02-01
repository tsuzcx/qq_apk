package com.tencent.mobileqq.reminder.calendar;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.CalendarContract.Calendars;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class CalenderUtils
{
  protected static String a = "sp_reminder_calendar";
  private static String b = "content://com.android.calendar/calendars";
  private static String c = "content://com.android.calendar/events";
  private static String d = "content://com.android.calendar/reminders";
  
  private long a(String paramString)
  {
    return MobileQQ.sMobileQQ.getSharedPreferences(a, 0).getLong(paramString, -1L);
  }
  
  private static String a(CalendarEntity paramCalendarEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://ti.qq.com/remind/calendar?msgid=");
    localStringBuilder.append(paramCalendarEntity.msg_id);
    return localStringBuilder.toString();
  }
  
  private void a(String paramString)
  {
    MobileQQ.sMobileQQ.getSharedPreferences(a, 0).edit().remove(paramString).apply();
  }
  
  private void a(String paramString, Long paramLong)
  {
    MobileQQ.sMobileQQ.getSharedPreferences(a, 0).edit().putLong(paramString, paramLong.longValue()).apply();
  }
  
  protected int a()
  {
    int j = b();
    int i = j;
    if (j == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQReminder.CalenderUtils", 2, "getCalendarAccount first time is -1");
      }
      if (a() >= 0L) {
        return b();
      }
      i = -1;
    }
    return i;
  }
  
  protected long a()
  {
    Object localObject1 = MobileQQ.sMobileQQ;
    Object localObject2 = TimeZone.getDefault();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", "QQ");
    localContentValues.put("account_name", "QQ");
    localContentValues.put("account_type", "com.tencent.mobileqq");
    localContentValues.put("calendar_displayName", "QQ");
    Integer localInteger = Integer.valueOf(1);
    localContentValues.put("visible", localInteger);
    localContentValues.put("calendar_color", Integer.valueOf(-16776961));
    localContentValues.put("calendar_access_level", Integer.valueOf(700));
    localContentValues.put("sync_events", localInteger);
    localContentValues.put("calendar_timezone", ((TimeZone)localObject2).getID());
    localContentValues.put("ownerAccount", "QQ");
    localContentValues.put("canOrganizerRespond", Integer.valueOf(0));
    if (Build.VERSION.SDK_INT >= 17) {
      localContentValues.put("isPrimary", localInteger);
    }
    localObject2 = Uri.parse(b).buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "QQ").appendQueryParameter("account_type", "com.tencent.mobileqq").build();
    localObject1 = ((Context)localObject1).getContentResolver().insert((Uri)localObject2, localContentValues);
    if (localObject1 == null) {
      return -1L;
    }
    return ContentUris.parseId((Uri)localObject1);
  }
  
  protected void a(CalendarEntity paramCalendarEntity)
  {
    Object localObject3 = paramCalendarEntity.title;
    Object localObject1 = paramCalendarEntity.content;
    long l = paramCalendarEntity.notice_time;
    try
    {
      int i = a();
      if (i < 0) {
        QLog.e("QQReminder.CalenderUtils", 1, "getQQAccount is empty");
      }
      Object localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(l * 1000L);
      l = ((Calendar)localObject2).getTime().getTime();
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("title", (String)localObject3);
      ((ContentValues)localObject2).put("calendar_id", Integer.valueOf(i));
      ((ContentValues)localObject2).put("eventTimezone", TimeZone.getDefault().getID());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("\n");
      ((StringBuilder)localObject3).append(a(paramCalendarEntity));
      ((ContentValues)localObject2).put("description", ((StringBuilder)localObject3).toString());
      ((ContentValues)localObject2).put("dtstart", Long.valueOf(l));
      ((ContentValues)localObject2).put("dtend", Long.valueOf(l + 7200000L));
      localObject1 = MobileQQ.sMobileQQ;
      localObject2 = ((Context)localObject1).getContentResolver().insert(Uri.parse(c), (ContentValues)localObject2);
      if (localObject2 == null) {
        QLog.e("QQReminder.CalenderUtils", 1, "add to calendar error");
      }
      a(paramCalendarEntity.msg_id, Long.valueOf(ContentUris.parseId((Uri)localObject2)));
      paramCalendarEntity = new ContentValues();
      paramCalendarEntity.put("event_id", Long.valueOf(ContentUris.parseId((Uri)localObject2)));
      paramCalendarEntity.put("minutes", Integer.valueOf(10));
      paramCalendarEntity.put("method", Integer.valueOf(1));
      if (((Context)localObject1).getContentResolver().insert(Uri.parse(d), paramCalendarEntity) == null)
      {
        QLog.e("QQReminder.CalenderUtils", 1, "add to reminder error");
        return;
      }
    }
    catch (Throwable paramCalendarEntity)
    {
      QLog.e("QQReminder.CalenderUtils", 1, "addToCalendar err: ", paramCalendarEntity);
    }
  }
  
  protected void a(Runnable paramRunnable)
  {
    ThreadManagerV2.excute(paramRunnable, 32, null, true);
  }
  
  public void a(AppActivity paramAppActivity, CalendarEntity paramCalendarEntity)
  {
    ((IQQReminderCalendarService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQReminderCalendarService.class, "")).addCalendarEntity(paramCalendarEntity);
    a(paramAppActivity, new CalenderUtils.1(this, paramCalendarEntity));
  }
  
  protected void a(AppActivity paramAppActivity, Runnable paramRunnable)
  {
    CalendarPermissionHelper localCalendarPermissionHelper = new CalendarPermissionHelper(paramAppActivity);
    if (localCalendarPermissionHelper.a())
    {
      a(paramRunnable);
      return;
    }
    localCalendarPermissionHelper.a(23441, new CalenderUtils.3(this, paramRunnable, paramAppActivity));
  }
  
  protected int b()
  {
    ContentResolver localContentResolver = MobileQQ.sMobileQQ.getContentResolver();
    Cursor localCursor2 = localContentResolver.query(CalendarContract.Calendars.CONTENT_URI, null, "visible = 1 AND isPrimary=1", null, "_id ASC");
    Cursor localCursor1;
    if (localCursor2 != null) {
      localCursor1 = localCursor2;
    }
    try
    {
      if (localCursor2.getCount() > 0) {
        break label146;
      }
      localCursor1 = localContentResolver.query(CalendarContract.Calendars.CONTENT_URI, null, "visible = 1", null, "_id ASC");
    }
    catch (Exception localException)
    {
      label131:
      label146:
      do
      {
        int i;
        break label131;
      } while (localException != null);
    }
    if (localCursor1.getCount() > 0)
    {
      localCursor1.moveToFirst();
      i = localCursor1.getInt(localCursor1.getColumnIndex("_id"));
      if (QLog.isColorLevel()) {
        QLog.d("QQReminder.CalenderUtils", 2, new Object[] { "useId: ", Integer.valueOf(i) });
      }
      localCursor1.close();
      return i;
    }
    return -1;
    QLog.e("QQReminder.CalenderUtils", 1, "check calendar error");
    return -1;
    return -1;
  }
  
  protected void b(CalendarEntity paramCalendarEntity)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    paramCalendarEntity = paramCalendarEntity.msg_id;
    try
    {
      long l = a(paramCalendarEntity);
      if (l == -1L) {
        return;
      }
      Uri localUri = ContentUris.withAppendedId(Uri.parse(c), l);
      if (localMobileQQ.getContentResolver().delete(localUri, null, null) == -1) {
        QLog.e("QQReminder.CalenderUtils", 1, "delete reminder fail");
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQReminder.CalenderUtils", 1, "deleteCalendar err: ", localThrowable);
    }
    a(paramCalendarEntity);
  }
  
  public void b(AppActivity paramAppActivity, CalendarEntity paramCalendarEntity)
  {
    ((IQQReminderCalendarService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQReminderCalendarService.class, "")).deleteCalendarEntity(paramCalendarEntity);
    if (a(paramCalendarEntity.msg_id) != -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQReminder.CalenderUtils", 2, "delete: check sp contain key");
      }
      a(paramAppActivity, new CalenderUtils.2(this, paramCalendarEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.calendar.CalenderUtils
 * JD-Core Version:    0.7.0.1
 */