package com.tencent.qapmsdk.qqbattery.monitor;

import android.util.Pair;
import java.util.HashSet;

class WakeLockMonitor$ReportEntity
{
  public int flag;
  public String tag;
  public HashSet<Pair<Long, Long>> useList = new HashSet();
  
  private WakeLockMonitor$ReportEntity(WakeLockMonitor paramWakeLockMonitor) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.WakeLockMonitor.ReportEntity
 * JD-Core Version:    0.7.0.1
 */