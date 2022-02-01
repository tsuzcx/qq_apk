package com.tencent.mobileqq.ecshop.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class SharedPreferencesUtil
{
  public static String a(String paramString)
  {
    try
    {
      paramString = MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).getString(paramString, "");
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramString);
    }
    return "";
  }
  
  public static void a(String paramString, int paramInt)
  {
    try
    {
      MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).edit().putInt(paramString, paramInt).apply();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramString);
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    try
    {
      MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).edit().putLong(paramString, paramLong).apply();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).edit().putString(paramString1, paramString2).apply();
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramString1);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).edit().putBoolean(paramString, paramBoolean).apply();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramString);
    }
  }
  
  public static int b(String paramString)
  {
    try
    {
      int i = MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).getInt(paramString, 0);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[getValueFromSP] fail.", paramString);
    }
    return 0;
  }
  
  public static void c(String paramString)
  {
    try
    {
      MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).edit().remove(paramString).apply();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramString);
    }
  }
  
  public static boolean d(String paramString)
  {
    try
    {
      boolean bool = MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).getBoolean(paramString, false);
      return bool;
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[getValueFromSP] fail.", paramString);
    }
    return false;
  }
  
  public static long e(String paramString)
  {
    try
    {
      long l = MobileQQ.sMobileQQ.getSharedPreferences("ecshop_pref", 4).getLong(paramString, 0L);
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[getValueFromSP] fail.", paramString);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.utils.SharedPreferencesUtil
 * JD-Core Version:    0.7.0.1
 */