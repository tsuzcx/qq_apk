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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil
 * JD-Core Version:    0.7.0.1
 */