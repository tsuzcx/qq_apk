package com.tencent.mobileqq.util;

import java.util.concurrent.ThreadFactory;

class InfiniteTaskThreadPool$1
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    InfiniteTaskThreadPool.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + InfiniteTaskThreadPool.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.InfiniteTaskThreadPool.1
 * JD-Core Version:    0.7.0.1
 */