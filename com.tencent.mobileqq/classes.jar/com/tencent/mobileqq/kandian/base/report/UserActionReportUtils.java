package com.tencent.mobileqq.kandian.base.report;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mqpsdk.util.NetUtil;

public class UserActionReportUtils
{
  public static double getBatteryLevel()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      d1 = ((BatteryManager)BaseApplicationImpl.getApplication().getSystemService("batterymanager")).getIntProperty(4);
      Double.isNaN(d1);
      return d1 / 100.0D;
    }
    Intent localIntent = new ContextWrapper(BaseApplicationImpl.getApplication().getApplicationContext()).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    double d2 = localIntent.getIntExtra("level", -1);
    double d1 = 1.0D;
    Double.isNaN(d2);
    double d3 = localIntent.getIntExtra("scale", -1);
    Double.isNaN(d3);
    if (d2 * 1.0D / d3 != 0.0D) {
      d1 = localIntent.getIntExtra("scale", -1);
    }
    return d1;
  }
  
  public static String getDeviceModel()
  {
    return Build.MODEL;
  }
  
  public static double getDeviceVolume(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    int i = paramContext.getStreamVolume(3);
    int j = paramContext.getStreamMaxVolume(3);
    double d1 = i;
    Double.isNaN(d1);
    double d2 = j;
    Double.isNaN(d2);
    return d1 * 1.0D / d2;
  }
  
  public static int getNetType()
  {
    return NetUtil.a(null);
  }
  
  public static double getScreenLightness(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "screen_brightness", 255) * 1.0F / 255.0F;
  }
  
  public static String getScreenSizeInfo(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.widthPixels);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext.heightPixels);
    return localStringBuilder.toString();
  }
  
  public static boolean isHasHeadset(Context paramContext)
  {
    boolean bool2 = ((AudioManager)paramContext.getSystemService("audio")).isWiredHeadsetOn();
    paramContext = BluetoothAdapter.getDefaultAdapter();
    boolean bool1 = true;
    int i;
    if (paramContext.getProfileConnectionState(1) == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (!bool2)
    {
      if (i != 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.UserActionReportUtils
 * JD-Core Version:    0.7.0.1
 */