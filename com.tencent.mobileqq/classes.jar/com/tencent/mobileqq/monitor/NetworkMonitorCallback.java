package com.tencent.mobileqq.monitor;

import com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo;

public abstract interface NetworkMonitorCallback
{
  public abstract void addDownloadURL(String paramString);
  
  public abstract void addHttpInfo(MonitorHttpInfo paramMonitorHttpInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.monitor.NetworkMonitorCallback
 * JD-Core Version:    0.7.0.1
 */