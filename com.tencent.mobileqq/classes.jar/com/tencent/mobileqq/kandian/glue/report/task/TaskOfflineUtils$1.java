package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class TaskOfflineUtils$1
  implements Runnable
{
  TaskOfflineUtils$1(String paramString, int paramInt, TaskOfflineUtils.OfflineCallBack paramOfflineCallBack) {}
  
  public void run()
  {
    try
    {
      HtmlOffline.a(this.a, BaseApplicationImpl.getApplication().getRuntime(), new TaskOfflineUtils.TaskAsyncBack(this.a, this.b, this.c), true, 5, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TaskOfflineUtils.a(), 1, "checkUpByBusinessId ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils.1
 * JD-Core Version:    0.7.0.1
 */