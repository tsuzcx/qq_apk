package com.tencent.mobileqq.util;

import java.util.concurrent.ThreadFactory;

class InfiniteTaskThreadPool$1
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    InfiniteTaskThreadPool.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InfiniteTaskThread_");
    localStringBuilder.append(InfiniteTaskThreadPool.b());
    paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.InfiniteTaskThreadPool.1
 * JD-Core Version:    0.7.0.1
 */