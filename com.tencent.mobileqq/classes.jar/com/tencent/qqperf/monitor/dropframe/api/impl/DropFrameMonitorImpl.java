package com.tencent.qqperf.monitor.dropframe.api.impl;

import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.qqperf.monitor.dropframe.api.IDropFrameMonitor;

public class DropFrameMonitorImpl
  implements IDropFrameMonitor
{
  public void startMonitorScene(String paramString)
  {
    DropFrameMonitor.b().a(paramString);
  }
  
  public void stopMonitorScene(String paramString, boolean paramBoolean)
  {
    DropFrameMonitor.b().a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.dropframe.api.impl.DropFrameMonitorImpl
 * JD-Core Version:    0.7.0.1
 */