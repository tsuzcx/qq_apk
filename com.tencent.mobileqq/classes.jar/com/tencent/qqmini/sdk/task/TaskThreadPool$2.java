package com.tencent.qqmini.sdk.task;

import bhhs;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskThreadPool$2
  implements Runnable
{
  public TaskThreadPool$2(bhhs parambhhs) {}
  
  public void run()
  {
    try
    {
      if (bhhs.a(this.this$0)) {
        bhhs.a(this.this$0).execute((Runnable)bhhs.a(this.this$0).poll());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ThreadPool", "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskThreadPool.2
 * JD-Core Version:    0.7.0.1
 */