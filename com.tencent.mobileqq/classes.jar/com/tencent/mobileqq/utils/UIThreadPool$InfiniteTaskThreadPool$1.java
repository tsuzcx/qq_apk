package com.tencent.mobileqq.utils;

import java.util.concurrent.ThreadFactory;

class UIThreadPool$InfiniteTaskThreadPool$1
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    UIThreadPool.InfiniteTaskThreadPool.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InfiniteTaskThread_");
    localStringBuilder.append(UIThreadPool.InfiniteTaskThreadPool.b());
    paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.UIThreadPool.InfiniteTaskThreadPool.1
 * JD-Core Version:    0.7.0.1
 */