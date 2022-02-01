package com.tencent.tbs.one.impl.common.statistic;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class b$1
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder("StatisticExecutor #");
    localStringBuilder.append(this.a.getAndIncrement());
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.b.1
 * JD-Core Version:    0.7.0.1
 */