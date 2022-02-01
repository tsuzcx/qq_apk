package com.tencent.qqperf.monitor.backgroundcpu;

import android.text.TextUtils;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleBattery;

public class BatteryStatsImpl
  extends BatteryStats
{
  private static BatteryStatsImpl jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBatteryStatsImpl;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static BatteryStatsImpl a()
  {
    BatteryStatsImpl localBatteryStatsImpl = jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBatteryStatsImpl;
    if (localBatteryStatsImpl != null) {
      return localBatteryStatsImpl;
    }
    try
    {
      if (jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBatteryStatsImpl == null) {
        jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBatteryStatsImpl = new BatteryStatsImpl();
      }
      localBatteryStatsImpl = jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBatteryStatsImpl;
      return localBatteryStatsImpl;
    }
    finally {}
  }
  
  public void a()
  {
    Object localObject = MagnifierSDK.a().a().b().split("\\|");
    if ((localObject.length >= 11) && (!TextUtils.isEmpty(localObject[10]))) {
      localObject = localObject[10];
    } else {
      localObject = "0.1;0.0002;10;5;10;5;2;0;500;1";
    }
    BackgroundCpuMonitor.a().a((String)localObject);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    BackgroundCpuMonitor.a().a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    BackgroundCpuMonitor.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BatteryStatsImpl
 * JD-Core Version:    0.7.0.1
 */