package com.tencent.mobileqq.util;

import java.util.concurrent.ThreadPoolExecutor;

public class InfiniteTaskThreadPool
  extends ThreadPoolExecutor
{
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      super.execute(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.util.InfiniteTaskThreadPool
 * JD-Core Version:    0.7.0.1
 */