package com.tencent.mobileqq.wifi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class WifiSdkSharedPreUtils
{
  public static int a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwsjt_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), -1);
  }
  
  public static long a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwslcdt_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), -1L);
  }
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("kwsbddbw", null);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwsg_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("kwsbddbw", paramString);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwscdf_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwsjt_");
    localStringBuilder.append(paramString1);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwsjhu_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwslcdt_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwsg_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.apply();
  }
  
  public static int b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwscdf_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 24);
  }
  
  public static long b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwslftjt_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), -1L);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwsjhu_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), null);
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwslftjt_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static long c(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwsrgrt_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), -1L);
  }
  
  public static void c(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kwsrgrt_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.WifiSdkSharedPreUtils
 * JD-Core Version:    0.7.0.1
 */