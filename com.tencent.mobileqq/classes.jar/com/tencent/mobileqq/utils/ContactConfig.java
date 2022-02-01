package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;

public class ContactConfig
{
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 60 * 1000;
    paramContext = paramContext.getSharedPreferences(paramString, 0).edit();
    paramContext.putLong("fl_pre_get_last_login_info", l1);
    paramContext.putLong("fl_get_last_login_info_time_period", l2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_req_self_level_time");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences(paramString, 0).edit();
    paramContext.putBoolean("fl_show_pc_icon", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0).getBoolean("fl_show_pc_icon", false);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_req_x_man_prefix");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences(paramString, 0);
    long l1 = paramContext.getLong("fl_pre_get_last_login_info", 0L);
    long l2 = paramContext.getLong("fl_get_last_login_info_time_period", 0L);
    long l3 = System.currentTimeMillis();
    if ((l1 >= l3) || (l3 >= l1 + l2)) {
      bool = true;
    }
    return bool;
  }
  
  public static long c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_req_self_level_time");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static void c(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_last_req_x_man_scene_2_time_prefix_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public static long d(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_req_x_man_prefix");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long e(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_last_req_x_man_scene_2_time_prefix_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactConfig
 * JD-Core Version:    0.7.0.1
 */