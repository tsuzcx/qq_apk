package com.tencent.qqperf.monitor.backgroundcpu;

import android.text.TextUtils;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleBattery;

public class BatteryStatsImpl
  extends BatteryStats
{
  private static BatteryStatsImpl a;
  private boolean b = false;
  
  public static BatteryStatsImpl d()
  {
    BatteryStatsImpl localBatteryStatsImpl = a;
    if (localBatteryStatsImpl != null) {
      return localBatteryStatsImpl;
    }
    try
    {
      if (a == null) {
        a = new BatteryStatsImpl();
      }
      localBatteryStatsImpl = a;
      return localBatteryStatsImpl;
    }
    finally {}
  }
  
  public void a()
  {
    Object localObject = MagnifierSDK.b().i().b().split("\\|");
    if ((localObject.length >= 11) && (!TextUtils.isEmpty(localObject[10]))) {
      localObject = localObject[10];
    } else {
      localObject = "0.1;0.0002;10;5;10;5;2;0;500;1";
    }
    BackgroundCpuMonitor.a().a((String)localObject);
  }
  
  public void b()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    BackgroundCpuMonitor.a().c();
  }
  
  public void c()
  {
    this.b = false;
    BackgroundCpuMonitor.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BatteryStatsImpl
 * JD-Core Version:    0.7.0.1
 */