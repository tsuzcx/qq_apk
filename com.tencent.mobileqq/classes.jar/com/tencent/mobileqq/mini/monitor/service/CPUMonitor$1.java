package com.tencent.mobileqq.mini.monitor.service;

import android.os.Handler;

final class CPUMonitor$1
  implements Runnable
{
  public void run()
  {
    if (!CPUMonitor.access$000())
    {
      CPUMonitor.access$100();
      if (CPUMonitor.access$200() != null) {
        CPUMonitor.access$200().postDelayed(CPUMonitor.access$300(), 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.service.CPUMonitor.1
 * JD-Core Version:    0.7.0.1
 */