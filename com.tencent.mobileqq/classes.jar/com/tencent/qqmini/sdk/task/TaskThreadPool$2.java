package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

class TaskThreadPool$2
  implements Runnable
{
  TaskThreadPool$2(TaskThreadPool paramTaskThreadPool) {}
  
  public void run()
  {
    try
    {
      if (TaskThreadPool.access$100(this.this$0))
      {
        TaskThreadPool.access$200(this.this$0).execute((Runnable)TaskThreadPool.access$000(this.this$0).poll());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ThreadPool", "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskThreadPool.2
 * JD-Core Version:    0.7.0.1
 */