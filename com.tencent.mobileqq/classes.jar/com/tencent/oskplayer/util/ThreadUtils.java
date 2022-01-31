package com.tencent.oskplayer.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadUtils
{
  private static final String TAG = "ThreadUtils";
  
  public static void executePriorityTask(ArrayList<Runnable> paramArrayList)
  {
    try
    {
      executePriorityTask(paramArrayList, 2);
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public static void executePriorityTask(ArrayList<Runnable> paramArrayList, int paramInt)
  {
    try
    {
      ThreadUtils.PriorityExecutor localPriorityExecutor = new ThreadUtils.PriorityExecutor(paramInt);
      Iterator localIterator = paramArrayList.iterator();
      long l;
      for (paramArrayList = Long.valueOf(1L); localIterator.hasNext(); paramArrayList = Long.valueOf(l + 1L))
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        l = paramArrayList.longValue();
        localPriorityExecutor.execute(localRunnable, paramArrayList.longValue());
      }
      localPriorityExecutor.shutdown();
      return;
    }
    finally {}
  }
  
  public static Object submitTask(Callable<?> paramCallable, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = Executors.newSingleThreadExecutor();
    paramCallable = ((ExecutorService)localObject).submit(paramCallable);
    ((ExecutorService)localObject).shutdown();
    paramString1 = "job " + paramString1 + " ";
    long l = paramInt;
    try
    {
      localObject = paramCallable.get(l, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      if (paramBoolean)
      {
        PlayerUtils.log(4, paramString2, paramString1 + "cancelled");
        paramCallable.cancel(true);
      }
    }
    return null;
  }
  
  public static Future<?> submitTask(Runnable paramRunnable, String paramString)
  {
    paramString = new ThreadUtils.FlexibleSizeExecutor("job " + paramString + " ");
    paramRunnable = paramString.submit(paramRunnable);
    paramString.shutdown();
    return paramRunnable;
  }
  
  public static void submitTask(Runnable paramRunnable, int paramInt, boolean paramBoolean, String paramString)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    paramRunnable = localExecutorService.submit(paramRunnable);
    localExecutorService.shutdown();
    paramString = "job " + paramString + " ";
    long l = paramInt;
    try
    {
      paramRunnable.get(l, TimeUnit.MILLISECONDS);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      while (!paramBoolean) {}
      PlayerUtils.log(4, "ThreadUtils", paramString + "cancelled");
      paramRunnable.cancel(true);
    }
  }
  
  public static Object submitTaskCatchAll(Callable<?> paramCallable, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = Executors.newSingleThreadExecutor();
    paramCallable = ((ExecutorService)localObject).submit(paramCallable);
    ((ExecutorService)localObject).shutdown();
    paramString1 = "job " + paramString1 + " ";
    long l = paramInt;
    try
    {
      localObject = paramCallable.get(l, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (InterruptedException paramCallable)
    {
      PlayerUtils.log(4, paramString2, paramString1 + "interrupted");
      return null;
    }
    catch (ExecutionException paramCallable)
    {
      for (;;)
      {
        PlayerUtils.log(4, paramString2, paramString1 + "caught exception " + PlayerUtils.getPrintableStackTrace(paramCallable));
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        if (paramBoolean)
        {
          PlayerUtils.log(4, paramString2, paramString1 + "cancelled");
          paramCallable.cancel(true);
        }
      }
    }
  }
  
  public static void submitTaskCatchAll(Runnable paramRunnable, int paramInt, boolean paramBoolean, String paramString)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    paramRunnable = localExecutorService.submit(paramRunnable);
    localExecutorService.shutdown();
    paramString = "job " + paramString + " ";
    long l = paramInt;
    try
    {
      paramRunnable.get(l, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException paramRunnable)
    {
      PlayerUtils.log(5, "ThreadUtils", paramString + "interrupted");
      return;
    }
    catch (ExecutionException paramRunnable)
    {
      PlayerUtils.log(6, "ThreadUtils", paramString + "caught exception: " + PlayerUtils.getPrintableStackTrace(paramRunnable));
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      while (!paramBoolean) {}
      PlayerUtils.log(4, "ThreadUtils", paramString + "cancelled");
      paramRunnable.cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.util.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */