package com.tencent.mobileqq.reminder.calendar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class CalendarPermissionHelper
{
  protected static final String[] a = { "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR" };
  private AppActivity b;
  
  public CalendarPermissionHelper(AppActivity paramAppActivity)
  {
    this.b = paramAppActivity;
  }
  
  public void a(int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    long l = System.currentTimeMillis();
    if (b() <= 0L)
    {
      a(l);
      this.b.requestPermissions(paramQQPermissionCallback, paramInt, a);
      return;
    }
    paramQQPermissionCallback.deny(paramInt, a, new int[] { 0, 0 });
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQReminder.CalenderUtils", 1, new Object[] { "set last dialogTime:", Long.valueOf(paramLong) });
    }
    this.b.getSharedPreferences(CalenderUtils.a, 0).edit().putLong("key_dialog_time", paramLong).apply();
  }
  
  public boolean a()
  {
    PackageManager localPackageManager = this.b.getPackageManager();
    String[] arrayOfString = a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localPackageManager.checkPermission(arrayOfString[0], "com.tencent.mobileqq") == 0)
    {
      bool1 = bool2;
      if (localPackageManager.checkPermission(a[1], "com.tencent.mobileqq") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long b()
  {
    long l = this.b.getSharedPreferences(CalenderUtils.a, 0).getLong("key_dialog_time", -1L);
    if (QLog.isColorLevel()) {
      QLog.d("QQReminder.CalenderUtils", 1, new Object[] { "last dialogTime:", Long.valueOf(l) });
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.calendar.CalendarPermissionHelper
 * JD-Core Version:    0.7.0.1
 */