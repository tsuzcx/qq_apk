package com.tencent.qqmini.sdk.monitor.service;

import com.tencent.qqmini.sdk.monitor.common.FPSCalculator.GetFPSListener;

class TaskMonitorManager$FpsListener
  implements FPSCalculator.GetFPSListener
{
  private TaskMonitorManager$FpsListener(TaskMonitorManager paramTaskMonitorManager) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    this.this$0.mCurrentFps = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager.FpsListener
 * JD-Core Version:    0.7.0.1
 */