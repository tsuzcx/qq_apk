package com.tencent.qqmini.sdk.monitor.service;

import com.tencent.qqmini.sdk.monitor.common.ProcessStats;

class TaskMonitorManager$1
  implements Runnable
{
  TaskMonitorManager$1(TaskMonitorManager paramTaskMonitorManager) {}
  
  public void run()
  {
    TaskMonitorManager localTaskMonitorManager = this.this$0;
    localTaskMonitorManager.mAppLastUsage = localTaskMonitorManager.mAppCurUsage;
    this.this$0.mAppCurUsage = ProcessStats.collectCpuUsage("-1");
    long l2 = this.this$0.mAppCurUsage;
    long l3 = this.this$0.mAppLastUsage;
    long l1;
    if (this.this$0.isCalcDeviceUsageOk)
    {
      localTaskMonitorManager = this.this$0;
      localTaskMonitorManager.mDeviceLastUsage = localTaskMonitorManager.mDeviceCurUsage;
      this.this$0.mDeviceCurUsage = ProcessStats.collectCpuUsage("-2");
      l1 = this.this$0.mDeviceCurUsage - this.this$0.mDeviceLastUsage;
    }
    else
    {
      l1 = 0L;
    }
    localTaskMonitorManager = this.this$0;
    boolean bool;
    if ((localTaskMonitorManager.mDeviceCurUsage > 0L) && (l1 > 0L)) {
      bool = true;
    } else {
      bool = false;
    }
    localTaskMonitorManager.isCalcDeviceUsageOk = bool;
    if (this.this$0.isCalcDeviceUsageOk)
    {
      this.this$0.sTotalCpuUsage = ((int)((l2 - l3) * 100L / l1));
      return;
    }
    this.this$0.sTotalCpuUsage = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager.1
 * JD-Core Version:    0.7.0.1
 */