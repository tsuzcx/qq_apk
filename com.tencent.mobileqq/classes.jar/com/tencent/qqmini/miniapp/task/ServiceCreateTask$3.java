package com.tencent.qqmini.miniapp.task;

import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.report.MiniReportManager;

class ServiceCreateTask$3
  implements Runnable
{
  ServiceCreateTask$3(ServiceCreateTask paramServiceCreateTask, int paramInt, String paramString) {}
  
  public void run()
  {
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), this.val$id, "0", this.val$type, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceCreateTask.3
 * JD-Core Version:    0.7.0.1
 */