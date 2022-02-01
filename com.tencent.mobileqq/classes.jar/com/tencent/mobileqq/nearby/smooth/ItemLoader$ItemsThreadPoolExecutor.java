package com.tencent.mobileqq.nearby.smooth;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

final class ItemLoader$ItemsThreadPoolExecutor<Params, Result>
  extends ThreadPoolExecutor
{
  public Future<?> submit(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      paramRunnable = new ItemLoader.LoadItemFutureTask((ItemLoader.LoadItemRunnable)paramRunnable);
      execute(paramRunnable);
      return paramRunnable;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.ItemsThreadPoolExecutor
 * JD-Core Version:    0.7.0.1
 */