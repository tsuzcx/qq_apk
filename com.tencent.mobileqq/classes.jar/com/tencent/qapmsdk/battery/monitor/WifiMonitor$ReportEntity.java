package com.tencent.qapmsdk.battery.monitor;

import android.util.Pair;
import java.util.HashSet;

class WifiMonitor$ReportEntity
{
  public String createStack;
  public String tag;
  public HashSet<Pair<Long, Long>> useList = new HashSet();
  
  private WifiMonitor$ReportEntity(WifiMonitor paramWifiMonitor) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.monitor.WifiMonitor.ReportEntity
 * JD-Core Version:    0.7.0.1
 */