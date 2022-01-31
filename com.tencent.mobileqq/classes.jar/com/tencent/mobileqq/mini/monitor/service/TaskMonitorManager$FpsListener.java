package com.tencent.mobileqq.mini.monitor.service;

import bdav;

class TaskMonitorManager$FpsListener
  implements bdav
{
  private TaskMonitorManager$FpsListener(TaskMonitorManager paramTaskMonitorManager) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    this.this$0.mCurrentFps = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager.FpsListener
 * JD-Core Version:    0.7.0.1
 */