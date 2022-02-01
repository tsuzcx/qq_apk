package com.tencent.qplus.swingworker;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class SwingWorker$6
  implements ThreadFactory
{
  final ThreadFactory defaultFactory = Executors.defaultThreadFactory();
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.defaultFactory.newThread(paramRunnable);
    paramRunnable.setName("SwingWorker-" + paramRunnable.getName());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker.6
 * JD-Core Version:    0.7.0.1
 */