package com.tencent.oskplayer.util;

import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.Runnable;>;
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
      Object localObject = Long.valueOf(1L);
      Iterator localIterator = paramArrayList.iterator();
      long l;
      for (paramArrayList = (ArrayList<Runnable>)localObject; localIterator.hasNext(); paramArrayList = Long.valueOf(l + 1L))
      {
        localObject = (Runnable)localIterator.next();
        l = paramArrayList.longValue();
        localPriorityExecutor.execute((Runnable)localObject, paramArrayList.longValue());
      }
      localPriorityExecutor.shutdown();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  public static Object submitTask(Callable<?> paramCallable, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = Executors.newSingleThreadExecutor();
    paramCallable = ((ExecutorService)localObject).submit(paramCallable);
    ((ExecutorService)localObject).shutdown();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("job ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ");
    paramString1 = ((StringBuilder)localObject).toString();
    long l = paramInt;
    try
    {
      localObject = paramCallable.get(l, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      label79:
      break label79;
    }
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("cancelled");
      PlayerUtils.log(4, paramString2, ((StringBuilder)localObject).toString());
      paramCallable.cancel(true);
    }
    return null;
  }
  
  public static Future<?> submitTask(Runnable paramRunnable, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("job ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    paramString = new ThreadUtils.FlexibleSizeExecutor(localStringBuilder.toString());
    paramRunnable = paramString.submit(paramRunnable);
    paramString.shutdown();
    return paramRunnable;
  }
  
  public static void submitTask(Runnable paramRunnable, int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject = Executors.newSingleThreadExecutor();
    paramRunnable = ((ExecutorService)localObject).submit(paramRunnable);
    ((ExecutorService)localObject).shutdown();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("job ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ");
    paramString = ((StringBuilder)localObject).toString();
    long l = paramInt;
    try
    {
      paramRunnable.get(l, TimeUnit.MILLISECONDS);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      label76:
      break label76;
    }
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("cancelled");
      PlayerUtils.log(4, "ThreadUtils", ((StringBuilder)localObject).toString());
      paramRunnable.cancel(true);
    }
  }
  
  /* Error */
  public static Object submitTaskCatchAll(Callable<?> paramCallable, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 71	java/util/concurrent/Executors:newSingleThreadExecutor	()Ljava/util/concurrent/ExecutorService;
    //   3: astore 8
    //   5: aload 8
    //   7: aload_0
    //   8: invokeinterface 77 2 0
    //   13: astore 7
    //   15: aload 8
    //   17: invokeinterface 78 1 0
    //   22: new 80	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   29: astore_0
    //   30: aload_0
    //   31: ldc 83
    //   33: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_0
    //   38: aload_3
    //   39: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_0
    //   44: ldc 89
    //   46: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_0
    //   51: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore_0
    //   55: iload_1
    //   56: i2l
    //   57: lstore 5
    //   59: aload 7
    //   61: lload 5
    //   63: getstatic 99	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   66: invokeinterface 105 4 0
    //   71: astore_3
    //   72: aload_3
    //   73: areturn
    //   74: iload_2
    //   75: ifeq +126 -> 201
    //   78: new 80	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_0
    //   88: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: ldc 107
    //   95: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: iconst_4
    //   100: aload 4
    //   102: aload_3
    //   103: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 113	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   109: aload 7
    //   111: iconst_1
    //   112: invokeinterface 117 2 0
    //   117: pop
    //   118: goto +83 -> 201
    //   121: astore_3
    //   122: new 80	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   129: astore 7
    //   131: aload 7
    //   133: aload_0
    //   134: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 7
    //   140: ldc 136
    //   142: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 7
    //   148: aload_3
    //   149: invokestatic 140	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   152: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: iconst_4
    //   157: aload 4
    //   159: aload 7
    //   161: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 113	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   167: goto +34 -> 201
    //   170: new 80	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   177: astore_3
    //   178: aload_3
    //   179: aload_0
    //   180: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_3
    //   185: ldc 142
    //   187: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: iconst_4
    //   192: aload 4
    //   194: aload_3
    //   195: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 113	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   201: aconst_null
    //   202: areturn
    //   203: astore_3
    //   204: goto -34 -> 170
    //   207: astore_3
    //   208: goto -134 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramCallable	Callable<?>
    //   0	211	1	paramInt	int
    //   0	211	2	paramBoolean	boolean
    //   0	211	3	paramString1	String
    //   0	211	4	paramString2	String
    //   57	5	5	l	long
    //   13	147	7	localObject	Object
    //   3	13	8	localExecutorService	ExecutorService
    // Exception table:
    //   from	to	target	type
    //   59	72	121	java/util/concurrent/ExecutionException
    //   59	72	203	java/lang/InterruptedException
    //   59	72	207	java/util/concurrent/TimeoutException
  }
  
  public static void submitTaskCatchAll(Runnable paramRunnable, int paramInt, boolean paramBoolean, String paramString)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    localObject = localExecutorService.submit(paramRunnable);
    localExecutorService.shutdown();
    paramRunnable = new StringBuilder();
    paramRunnable.append("job ");
    paramRunnable.append(paramString);
    paramRunnable.append(" ");
    paramRunnable = paramRunnable.toString();
    long l = paramInt;
    try
    {
      ((Future)localObject).get(l, TimeUnit.MILLISECONDS);
      return;
    }
    catch (ExecutionException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRunnable);
      ((StringBuilder)localObject).append("caught exception: ");
      ((StringBuilder)localObject).append(PlayerUtils.getPrintableStackTrace(paramString));
      PlayerUtils.log(6, "ThreadUtils", ((StringBuilder)localObject).toString());
      return;
      paramString = new StringBuilder();
      paramString.append(paramRunnable);
      paramString.append("interrupted");
      PlayerUtils.log(5, "ThreadUtils", paramString.toString());
      return;
    }
    catch (InterruptedException paramString)
    {
      break label166;
    }
    catch (TimeoutException paramString)
    {
      label73:
      break label73;
    }
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append(paramRunnable);
      paramString.append("cancelled");
      PlayerUtils.log(4, "ThreadUtils", paramString.toString());
      ((Future)localObject).cancel(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */