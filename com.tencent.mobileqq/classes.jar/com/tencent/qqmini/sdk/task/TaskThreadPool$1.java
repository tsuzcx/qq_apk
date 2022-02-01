package com.tencent.qqmini.sdk.task;

import java.util.Queue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class TaskThreadPool$1
  implements RejectedExecutionHandler
{
  TaskThreadPool$1(TaskThreadPool paramTaskThreadPool) {}
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    TaskThreadPool.access$000(this.this$0).offer(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskThreadPool.1
 * JD-Core Version:    0.7.0.1
 */