package com.weibo.ssosdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

final class MfpBuilder$BatteryInfo
{
  private Intent batteryInfoIntent;
  
  private MfpBuilder$BatteryInfo(Context paramContext)
  {
    this.batteryInfoIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
  }
  
  private int getHealth()
  {
    return this.batteryInfoIntent.getIntExtra("health", 1);
  }
  
  private int getLevel()
  {
    return this.batteryInfoIntent.getIntExtra("level", 0);
  }
  
  private int getPlugged()
  {
    return this.batteryInfoIntent.getIntExtra("plugged", 0);
  }
  
  private boolean getPresent()
  {
    return this.batteryInfoIntent.getBooleanExtra("present", false);
  }
  
  private int getScale()
  {
    return this.batteryInfoIntent.getIntExtra("scale", 0);
  }
  
  private int getStatus()
  {
    return this.batteryInfoIntent.getIntExtra("status", 0);
  }
  
  private String getTechnology()
  {
    return this.batteryInfoIntent.getStringExtra("technology");
  }
  
  private int getTemperature()
  {
    return this.batteryInfoIntent.getIntExtra("temperature", 0);
  }
  
  private int getVoltage()
  {
    return this.batteryInfoIntent.getIntExtra("voltage", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.weibo.ssosdk.MfpBuilder.BatteryInfo
 * JD-Core Version:    0.7.0.1
 */