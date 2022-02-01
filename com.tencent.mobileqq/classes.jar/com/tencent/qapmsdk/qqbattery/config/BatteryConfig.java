package com.tencent.qapmsdk.qqbattery.config;

public class BatteryConfig
{
  public CmdMeta cmdConfig;
  public CpuMeta cpuConfig;
  public GpsMeta gpsConfig;
  public LogMeta logConfig;
  public long monitorEndTime;
  public boolean reportfile;
  public TrafficMeta trafficConfig;
  public WakeLockMeta wakeLockConfig;
  public WifiMeta wifiConfig;
  
  public BatteryConfig(boolean paramBoolean, long paramLong)
  {
    this.reportfile = paramBoolean;
    this.monitorEndTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.config.BatteryConfig
 * JD-Core Version:    0.7.0.1
 */