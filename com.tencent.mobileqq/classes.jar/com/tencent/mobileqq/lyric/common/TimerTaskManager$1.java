package com.tencent.mobileqq.lyric.common;

import java.util.concurrent.ScheduledThreadPoolExecutor;

class TimerTaskManager$1
  extends ScheduledThreadPoolExecutor
{
  TimerTaskManager$1(TimerTaskManager paramTimerTaskManager, int paramInt)
  {
    super(paramInt);
  }
  
  /* Error */
  protected void afterExecute(java.lang.Runnable paramRunnable, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 24	java/util/concurrent/ScheduledThreadPoolExecutor:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   6: aload_2
    //   7: astore_3
    //   8: aload_2
    //   9: ifnonnull +55 -> 64
    //   12: aload_2
    //   13: astore_3
    //   14: aload_1
    //   15: instanceof 26
    //   18: ifeq +46 -> 64
    //   21: aload_1
    //   22: checkcast 26	java/util/concurrent/Future
    //   25: astore_1
    //   26: aload_2
    //   27: astore_3
    //   28: aload_1
    //   29: invokeinterface 30 1 0
    //   34: ifeq +30 -> 64
    //   37: aload_1
    //   38: invokeinterface 34 1 0
    //   43: pop
    //   44: aload_2
    //   45: astore_3
    //   46: goto +18 -> 64
    //   49: aload_2
    //   50: astore_3
    //   51: goto +13 -> 64
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual 38	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   59: astore_3
    //   60: goto +4 -> 64
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull +37 -> 102
    //   68: new 40	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   75: astore_1
    //   76: aload_1
    //   77: ldc 45
    //   79: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_1
    //   84: aload_3
    //   85: invokevirtual 55	java/lang/Throwable:toString	()Ljava/lang/String;
    //   88: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 57
    //   94: aload_1
    //   95: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 64	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: return
    //   103: astore_1
    //   104: goto -55 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	1
    //   0	107	1	paramRunnable	java.lang.Runnable
    //   0	107	2	paramThrowable	java.lang.Throwable
    //   7	53	3	localThrowable	java.lang.Throwable
    //   63	22	3	localCancellationException	java.util.concurrent.CancellationException
    // Exception table:
    //   from	to	target	type
    //   21	26	54	java/util/concurrent/ExecutionException
    //   28	44	54	java/util/concurrent/ExecutionException
    //   21	26	63	java/util/concurrent/CancellationException
    //   28	44	63	java/util/concurrent/CancellationException
    //   21	26	103	java/lang/InterruptedException
    //   28	44	103	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.common.TimerTaskManager.1
 * JD-Core Version:    0.7.0.1
 */