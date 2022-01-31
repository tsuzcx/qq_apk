package com.tencent.qqmini.sdk.task;

import betc;
import bffn;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskThreadPool$2
  implements Runnable
{
  public TaskThreadPool$2(bffn parambffn) {}
  
  public void run()
  {
    try
    {
      if (bffn.a(this.this$0)) {
        bffn.a(this.this$0).execute((Runnable)bffn.a(this.this$0).poll());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("ThreadPool", "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskThreadPool.2
 * JD-Core Version:    0.7.0.1
 */