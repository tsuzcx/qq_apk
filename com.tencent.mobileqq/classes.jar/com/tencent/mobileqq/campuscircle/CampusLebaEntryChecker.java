package com.tencent.mobileqq.campuscircle;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class CampusLebaEntryChecker
{
  public long a;
  public boolean a;
  public boolean b;
  
  public CampusLebaEntryChecker(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    long l1;
    long l3;
    long l4;
    do
    {
      return;
      l1 = 0L;
      if (QLog.isColorLevel()) {
        l1 = SystemClock.elapsedRealtime();
      }
      SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
      this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(paramQQAppInterface.getCurrentAccountUin() + "campus_circle_leba_entry_flag", false);
      this.jdField_a_of_type_Long = localSharedPreferences.getLong(paramQQAppInterface.getCurrentAccountUin() + "campus_circle_leba_entry_time", 0L);
      long l2 = localSharedPreferences.getInt("campus_refresh_interval", 168);
      l3 = NetConnInfoCenter.getServerTime();
      l4 = Math.abs(l3 - this.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Long == 0L) || (l4 > l2 * 3600L)) {
        this.b = true;
      }
    } while (!QLog.isColorLevel());
    QLog.i("CampusLebaEntryChecker", 2, String.format(Locale.getDefault(), "CampusLebaEntryChecker flag: %b last: %d cur: %d  du: %d cost: %d", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(SystemClock.elapsedRealtime() - l1) }));
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQQAppInterface == null) {}
    boolean bool;
    do
    {
      return;
      bool = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = paramBoolean1;
      SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
      if (bool != paramBoolean1) {
        localSharedPreferences.edit().putBoolean(paramQQAppInterface.getCurrentAccountUin() + "campus_circle_leba_entry_flag", this.jdField_a_of_type_Boolean).apply();
      }
      if (paramBoolean2)
      {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
        localSharedPreferences.edit().putLong(paramQQAppInterface.getCurrentAccountUin() + "campus_circle_leba_entry_time", this.jdField_a_of_type_Long).apply();
      }
    } while (!QLog.isColorLevel());
    QLog.i("CampusLebaEntryChecker", 2, String.format(Locale.getDefault(), "update preSwitch: %s, curSwitch: %s, last: %s, bSaveUpdateTime: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusLebaEntryChecker
 * JD-Core Version:    0.7.0.1
 */