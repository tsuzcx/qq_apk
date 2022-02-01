package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.qphone.base.util.QLog;

class TaskManager$30
  implements TaskOfflineUtils.OfflineCallBack
{
  TaskManager$30(TaskManager paramTaskManager, boolean paramBoolean) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (paramInt1 == 0)
    {
      TaskManager.a = paramInt2;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download scripts success: a new version: ");
      localStringBuilder.append(TaskManager.a);
      QLog.d("kandianreport.taskmanager", 1, localStringBuilder.toString());
      if (this.a)
      {
        QLog.d("kandianreport.taskmanager", 1, "startAfterDownload");
        TaskManager.b().d();
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download scripts fail or not update");
      localStringBuilder.append(paramInt1);
      QLog.d("kandianreport.taskmanager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.30
 * JD-Core Version:    0.7.0.1
 */