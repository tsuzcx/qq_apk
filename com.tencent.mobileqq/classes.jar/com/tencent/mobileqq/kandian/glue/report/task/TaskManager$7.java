package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class TaskManager$7
  implements Runnable
{
  public void run()
  {
    QLog.d("kandianreport.taskmanager", 1, "reset");
    this.this$0.e();
    FileUtils.deleteDirectory(TaskManager.f());
    FileUtils.deleteDirectory(KandianReportSoLoader.c());
    RIJSPUtils.a("kandianreport_ON", Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.7
 * JD-Core Version:    0.7.0.1
 */