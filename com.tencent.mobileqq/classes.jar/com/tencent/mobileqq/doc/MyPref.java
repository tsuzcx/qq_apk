package com.tencent.mobileqq.doc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class MyPref
{
  protected static int a(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, paramInt);
  }
  
  protected static long a(Context paramContext, String paramString, long paramLong)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString, paramLong);
  }
  
  protected static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean);
  }
  
  protected static void b(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt(paramString, paramInt).commit();
  }
  
  protected static void b(Context paramContext, String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong(paramString, paramLong).commit();
  }
  
  protected static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.MyPref
 * JD-Core Version:    0.7.0.1
 */