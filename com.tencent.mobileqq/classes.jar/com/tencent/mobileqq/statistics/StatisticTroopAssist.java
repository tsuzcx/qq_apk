package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class StatisticTroopAssist
{
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("Click_grp_asst");
    paramContext.putInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("grp_setting_asst");
    paramContext.putInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("grp_setting_msg");
    paramContext.putInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("grp_msg_equ");
    paramContext.putInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("grp_msg_dec");
    paramContext.putInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("grp_msg_inc");
    paramContext.putInt(localStringBuilder.toString(), 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    int i = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, i + 1).commit();
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_setting_asst");
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_equ");
  }
  
  public static void d(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_dec");
  }
  
  public static void e(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_inc");
  }
  
  public static int f(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "Click_grp_asst");
  }
  
  public static int g(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "grp_setting_asst");
  }
  
  public static int h(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "grp_setting_msg");
  }
  
  public static int i(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "grp_msg_equ");
  }
  
  public static int j(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "grp_msg_dec");
  }
  
  public static int k(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "grp_msg_inc");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticTroopAssist
 * JD-Core Version:    0.7.0.1
 */