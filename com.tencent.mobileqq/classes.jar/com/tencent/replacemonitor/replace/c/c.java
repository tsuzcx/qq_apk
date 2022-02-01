package com.tencent.replacemonitor.replace.c;

import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.tmassistantbase.util.ab;

class c
  implements Runnable
{
  c(a parama, MonitorTask paramMonitorTask) {}
  
  public void run()
  {
    MonitorTask localMonitorTask = com.tencent.replacemonitor.replace.b.a.a().a(this.a.id);
    ab.c("WashMonitor", "ReplaceMonitorImpl>>执行安装后定时检查 task1 = " + localMonitorTask);
    if (localMonitorTask != null) {
      new com.tencent.replacemonitor.replace.c(localMonitorTask, MonitorStep.AFTER_INSTALL, this.b).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.c.c
 * JD-Core Version:    0.7.0.1
 */