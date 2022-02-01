package com.tencent.mobileqq.engineering.preload;

import java.util.concurrent.ThreadFactory;

final class Worker$1
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre-loader-pool-");
    localStringBuilder.append(paramRunnable.getId());
    paramRunnable.setName(localStringBuilder.toString());
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.engineering.preload.Worker.1
 * JD-Core Version:    0.7.0.1
 */