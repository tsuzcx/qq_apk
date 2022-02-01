package com.tencent.oskplayer.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtils$FlexibleSizeExecutor
  extends ThreadPoolExecutor
{
  String jobDescription = "";
  
  public ThreadUtils$FlexibleSizeExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue);
  }
  
  public ThreadUtils$FlexibleSizeExecutor(String paramString)
  {
    super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    this.jobDescription = paramString;
  }
  
  /* Error */
  protected void afterExecute(Runnable paramRunnable, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 39	java/util/concurrent/ThreadPoolExecutor:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   6: aload_2
    //   7: astore_3
    //   8: aload_2
    //   9: ifnonnull +112 -> 121
    //   12: aload_2
    //   13: astore_3
    //   14: aload_1
    //   15: instanceof 41
    //   18: ifeq +103 -> 121
    //   21: aload_1
    //   22: checkcast 41	java/util/concurrent/Future
    //   25: astore_1
    //   26: aload_2
    //   27: astore_3
    //   28: aload_1
    //   29: invokeinterface 45 1 0
    //   34: ifeq +87 -> 121
    //   37: aload_2
    //   38: astore_3
    //   39: aload_1
    //   40: invokeinterface 48 1 0
    //   45: ifne +76 -> 121
    //   48: iconst_3
    //   49: ldc 50
    //   51: ldc 52
    //   53: invokestatic 58	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   56: aload_1
    //   57: invokeinterface 62 1 0
    //   62: pop
    //   63: iconst_3
    //   64: ldc 50
    //   66: ldc 64
    //   68: invokestatic 58	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   71: aload_2
    //   72: astore_3
    //   73: goto +48 -> 121
    //   76: iconst_5
    //   77: ldc 50
    //   79: ldc 66
    //   81: invokestatic 58	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   84: invokestatic 72	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: invokevirtual 75	java/lang/Thread:interrupt	()V
    //   90: aload_2
    //   91: astore_3
    //   92: goto +29 -> 121
    //   95: astore_1
    //   96: iconst_5
    //   97: ldc 50
    //   99: ldc 77
    //   101: invokestatic 58	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   104: aload_1
    //   105: invokevirtual 81	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   108: astore_3
    //   109: goto +12 -> 121
    //   112: astore_3
    //   113: iconst_5
    //   114: ldc 50
    //   116: ldc 83
    //   118: invokestatic 58	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   121: aload_3
    //   122: ifnull +47 -> 169
    //   125: new 85	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: aload_0
    //   135: getfield 14	com/tencent/oskplayer/util/ThreadUtils$FlexibleSizeExecutor:jobDescription	Ljava/lang/String;
    //   138: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: ldc 92
    //   145: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: aload_3
    //   151: invokestatic 96	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   154: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: bipush 6
    //   160: ldc 50
    //   162: aload_1
    //   163: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 58	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   169: return
    //   170: astore_1
    //   171: goto -95 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	FlexibleSizeExecutor
    //   0	174	1	paramRunnable	Runnable
    //   0	174	2	paramThrowable	java.lang.Throwable
    //   7	102	3	localThrowable	java.lang.Throwable
    //   112	39	3	localCancellationException	java.util.concurrent.CancellationException
    // Exception table:
    //   from	to	target	type
    //   21	26	95	java/util/concurrent/ExecutionException
    //   28	37	95	java/util/concurrent/ExecutionException
    //   39	71	95	java/util/concurrent/ExecutionException
    //   21	26	112	java/util/concurrent/CancellationException
    //   28	37	112	java/util/concurrent/CancellationException
    //   39	71	112	java/util/concurrent/CancellationException
    //   21	26	170	java/lang/InterruptedException
    //   28	37	170	java/lang/InterruptedException
    //   39	71	170	java/lang/InterruptedException
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("beforeExecute: thread=");
    localStringBuilder.append(paramThread.toString());
    localStringBuilder.append(" thread.state=");
    localStringBuilder.append(paramThread.getState());
    localStringBuilder.append(" runnable=");
    localStringBuilder.append(paramRunnable.toString());
    PlayerUtils.log(4, "ThreadUtils", localStringBuilder.toString());
  }
  
  public int getPendingTaskCount()
  {
    return getActiveCount() + getQueue().size();
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return super.newTaskFor(paramRunnable, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.ThreadUtils.FlexibleSizeExecutor
 * JD-Core Version:    0.7.0.1
 */