package com.tencent.mobileqq.reminder.calendar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class CalendarPermissionHelper
{
  protected static final String[] a;
  private AppActivity a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR" };
  }
  
  public CalendarPermissionHelper(AppActivity paramAppActivity)
  {
    this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
  }
  
  public long a()
  {
    long l = this.jdField_a_of_type_MqqAppAppActivity.getSharedPreferences(CalenderUtils.a, 0).getLong("key_dialog_time", -1L);
    if (QLog.isColorLevel()) {
      QLog.d("QQReminder.CalenderUtils", 1, new Object[] { "last dialogTime:", Long.valueOf(l) });
    }
    return l;
  }
  
  public void a(int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    long l = System.currentTimeMillis();
    if (a() <= 0L)
    {
      a(l);
      this.jdField_a_of_type_MqqAppAppActivity.requestPermissions(paramQQPermissionCallback, paramInt, jdField_a_of_type_ArrayOfJavaLangString);
      return;
    }
    paramQQPermissionCallback.deny(paramInt, jdField_a_of_type_ArrayOfJavaLangString, new int[] { 0, 0 });
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQReminder.CalenderUtils", 1, new Object[] { "set last dialogTime:", Long.valueOf(paramLong) });
    }
    this.jdField_a_of_type_MqqAppAppActivity.getSharedPreferences(CalenderUtils.a, 0).edit().putLong("key_dialog_time", paramLong).apply();
  }
  
  public boolean a()
  {
    PackageManager localPackageManager = this.jdField_a_of_type_MqqAppAppActivity.getPackageManager();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localPackageManager.checkPermission(arrayOfString[0], "com.tencent.mobileqq") == 0)
    {
      bool1 = bool2;
      if (localPackageManager.checkPermission(jdField_a_of_type_ArrayOfJavaLangString[1], "com.tencent.mobileqq") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.calendar.CalendarPermissionHelper
 * JD-Core Version:    0.7.0.1
 */