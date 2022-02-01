package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IQZoneStartupMonitor;
import cooperation.qzone.QZoneStartupMonitor;

public class QZoneStartupMonitorImpl
  implements IQZoneStartupMonitor
{
  public void afterLoadPlugin() {}
  
  public void beforeLoadPlugin() {}
  
  public void monitor()
  {
    QZoneStartupMonitor.getInstance().monitor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneStartupMonitorImpl
 * JD-Core Version:    0.7.0.1
 */