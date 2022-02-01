package org.light.utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.lang.reflect.Method;

class LightDataUtils
{
  public static String getValue(String paramString)
  {
    try
    {
      paramString = PreferenceManager.getDefaultSharedPreferences(((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext()).getString(paramString, "");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void saveValue(String paramString1, String paramString2)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext()).edit().putString(paramString1, paramString2).apply();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.utils.LightDataUtils
 * JD-Core Version:    0.7.0.1
 */