package com.tencent.mobileqq.utils;

import java.util.concurrent.ThreadFactory;

class UIThreadPool$InfiniteTaskThreadPool$1
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    UIThreadPool.InfiniteTaskThreadPool.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + UIThreadPool.InfiniteTaskThreadPool.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.UIThreadPool.InfiniteTaskThreadPool.1
 * JD-Core Version:    0.7.0.1
 */