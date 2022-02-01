package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.qphone.base.util.QLog;

class TaskManager$2
  implements Runnable
{
  TaskManager$2(TaskManager paramTaskManager) {}
  
  public void run()
  {
    try
    {
      TaskManager.b = TaskManager.a();
      if (TaskManager.b)
      {
        QLog.d("kandianreport.taskmanager", 1, "configure is on");
        KandianReportSoLoader.f();
        this.this$0.a(false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.taskmanager", 2, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.2
 * JD-Core Version:    0.7.0.1
 */