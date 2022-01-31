package com.tencent.qqmini.sdk.task;

import besl;
import bfew;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskThreadPool$2
  implements Runnable
{
  public TaskThreadPool$2(bfew parambfew) {}
  
  public void run()
  {
    try
    {
      if (bfew.a(this.this$0)) {
        bfew.a(this.this$0).execute((Runnable)bfew.a(this.this$0).poll());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("ThreadPool", "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskThreadPool.2
 * JD-Core Version:    0.7.0.1
 */