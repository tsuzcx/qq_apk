package com.tencent.qplus.swingworker;

public class ThreadPoolExecutor$CallerRunsPolicy
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    if (!paramThreadPoolExecutor.isShutdown()) {
      paramRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.ThreadPoolExecutor.CallerRunsPolicy
 * JD-Core Version:    0.7.0.1
 */