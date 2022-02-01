package com.tencent.qplus.swingworker;

import java.util.concurrent.RejectedExecutionException;

public class ThreadPoolExecutor$AbortPolicy
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    throw new RejectedExecutionException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.ThreadPoolExecutor.AbortPolicy
 * JD-Core Version:    0.7.0.1
 */