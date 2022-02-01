package com.tencent.qapmsdk.battery;

public abstract interface BatteryMonitor$IBatteryStatsCallback
{
  public abstract void onPrintLog(String paramString);
  
  public abstract void onUsageAlarm(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.BatteryMonitor.IBatteryStatsCallback
 * JD-Core Version:    0.7.0.1
 */