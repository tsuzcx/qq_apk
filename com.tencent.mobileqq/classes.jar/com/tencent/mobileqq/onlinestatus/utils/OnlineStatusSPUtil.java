package com.tencent.mobileqq.onlinestatus.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusSPUtil
{
  public static int a(Context paramContext)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("BatteryCapacity", 0);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusSPUtil", 2, new Object[] { "getBatteryCapacity", Integer.valueOf(i) });
    }
    return i;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("BatteryCapacity", paramInt);
    paramContext.apply();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusSPUtil", 2, new Object[] { "updateBatteryCapacity", Integer.valueOf(paramInt) });
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusSPUtil", 2, "putHasSetOlympicStatus");
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_has_show_olympic_status_rank_dialog_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_has_show_olympic_status_rank_dialog_");
    localStringBuilder.append(paramString);
    boolean bool = paramContext.getBoolean(localStringBuilder.toString(), false);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getHasShowOlympicStatusRankDialog hasShow: ");
      paramContext.append(bool);
      QLog.d("OnlineStatusSPUtil", 2, paramContext.toString());
    }
    return bool;
  }
  
  public static int b(Context paramContext)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("PowerConnectStatus", -1);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusSPUtil", 2, new Object[] { "getPowerConnectStatus", Integer.valueOf(i) });
    }
    return i;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("PowerConnectStatus", paramInt);
    paramContext.apply();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusSPUtil", 2, new Object[] { "updatePowerConnectStatus", Integer.valueOf(paramInt) });
    }
  }
  
  public static int c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("key_online_status_olympic_medal_egg_event_id", 0);
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("key_online_status_olympic_medal_egg_event_id", paramInt);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil
 * JD-Core Version:    0.7.0.1
 */