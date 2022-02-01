package com.tencent.mobileqq.mini.monitor.service;

import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;

class TaskMonitorManager$FpsListener
  implements FPSCalculator.GetFPSListener
{
  private TaskMonitorManager$FpsListener(TaskMonitorManager paramTaskMonitorManager) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    this.this$0.mCurrentFps = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager.FpsListener
 * JD-Core Version:    0.7.0.1
 */