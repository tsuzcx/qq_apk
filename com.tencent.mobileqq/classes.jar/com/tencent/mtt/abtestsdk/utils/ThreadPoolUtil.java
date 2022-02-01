package com.tencent.mtt.abtestsdk.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtil
{
  private static final ExecutorService sExecutor = ;
  
  public static void execute(Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        if ((sExecutor == null) || (sExecutor.isShutdown()))
        {
          ABTestLog.warn("sExecutor is closed, should not execute task", new Object[0]);
          return;
        }
        if (paramRunnable == null) {
          ABTestLog.warn("execute task is null", new Object[0]);
        } else {
          try
          {
            sExecutor.execute(paramRunnable);
          }
          catch (Exception paramRunnable)
          {
            ABTestLog.error(paramRunnable.getMessage(), new Object[0]);
          }
        }
      }
      finally {}
    }
  }
  
  public void close()
  {
    try
    {
      if ((sExecutor != null) && (!sExecutor.isShutdown()))
      {
        ABTestLog.debug("shutdown the sExecutor", new Object[0]);
        sExecutor.shutdown();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.ThreadPoolUtil
 * JD-Core Version:    0.7.0.1
 */