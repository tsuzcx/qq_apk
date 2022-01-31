package com.tencent.qplus.swingworker;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolExecutor$DiscardOldestPolicy
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    if (!paramThreadPoolExecutor.isShutdown())
    {
      paramThreadPoolExecutor.getQueue().poll();
      paramThreadPoolExecutor.execute(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.swingworker.ThreadPoolExecutor.DiscardOldestPolicy
 * JD-Core Version:    0.7.0.1
 */