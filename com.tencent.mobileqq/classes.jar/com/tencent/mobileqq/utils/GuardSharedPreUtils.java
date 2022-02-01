package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class GuardSharedPreUtils
{
  public static long a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("daily_boot_report", 0L);
  }
  
  public static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("sp_report_login", 4).getLong("key_report_login_time_millis_today_zero_" + paramString, 0L);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("daily_boot_report", paramLong).apply();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("sp_report_login", 4).edit().putLong("key_report_login_time_millis_today_zero_" + paramString, paramLong).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.GuardSharedPreUtils
 * JD-Core Version:    0.7.0.1
 */