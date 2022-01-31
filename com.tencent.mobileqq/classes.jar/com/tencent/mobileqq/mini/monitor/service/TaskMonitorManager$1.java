package com.tencent.mobileqq.mini.monitor.service;

import akde;

class TaskMonitorManager$1
  implements Runnable
{
  TaskMonitorManager$1(TaskMonitorManager paramTaskMonitorManager) {}
  
  public void run()
  {
    this.this$0.mAppLastUsage = this.this$0.mAppCurUsage;
    this.this$0.mAppCurUsage = akde.a("-1");
    long l2 = this.this$0.mAppCurUsage;
    long l3 = this.this$0.mAppLastUsage;
    if (this.this$0.isCalcDeviceUsageOk)
    {
      this.this$0.mDeviceLastUsage = this.this$0.mDeviceCurUsage;
      this.this$0.mDeviceCurUsage = akde.a("-2");
    }
    for (long l1 = this.this$0.mDeviceCurUsage - this.this$0.mDeviceLastUsage;; l1 = 0L)
    {
      TaskMonitorManager localTaskMonitorManager = this.this$0;
      if ((this.this$0.mDeviceCurUsage > 0L) && (l1 > 0L)) {}
      for (boolean bool = true;; bool = false)
      {
        localTaskMonitorManager.isCalcDeviceUsageOk = bool;
        if (!this.this$0.isCalcDeviceUsageOk) {
          break;
        }
        this.this$0.sTotalCpuUsage = ((int)(100L * (l2 - l3) / l1));
        return;
      }
      this.this$0.sTotalCpuUsage = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager.1
 * JD-Core Version:    0.7.0.1
 */