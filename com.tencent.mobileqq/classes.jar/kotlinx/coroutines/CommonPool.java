package kotlinx.coroutines;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "parallelism", "", "getParallelism", "()I", "pool", "requestedParallelism", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getOrCreatePoolSync", "isGoodCommonPool", "fjpClass", "Ljava/lang/Class;", "isGoodCommonPool$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class CommonPool
  extends ExecutorCoroutineDispatcher
{
  @NotNull
  public static final String DEFAULT_PARALLELISM_PROPERTY_NAME = "kotlinx.coroutines.default.parallelism";
  public static final CommonPool INSTANCE = new CommonPool();
  private static volatile Executor pool;
  private static final int requestedParallelism;
  private static boolean usePrivatePool;
  
  static
  {
    Object localObject1 = INSTANCE;
    try
    {
      localObject1 = System.getProperty("kotlinx.coroutines.default.parallelism");
    }
    catch (Throwable localThrowable)
    {
      label23:
      Object localObject2;
      int i;
      break label23;
    }
    localObject1 = null;
    if (localObject1 != null)
    {
      localObject2 = StringsKt.toIntOrNull((String)localObject1);
      if ((localObject2 != null) && (((Integer)localObject2).intValue() >= 1))
      {
        i = ((Integer)localObject2).intValue();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Expected positive number in kotlinx.coroutines.default.parallelism, but has ");
        ((StringBuilder)localObject2).append((String)localObject1);
        throw ((Throwable)new IllegalStateException(((StringBuilder)localObject2).toString().toString()));
      }
    }
    else
    {
      i = -1;
    }
    requestedParallelism = i;
  }
  
  private final <T> T Try(Function0<? extends T> paramFunction0)
  {
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    catch (Throwable paramFunction0)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  private final ExecutorService createPlainPool()
  {
    AtomicInteger localAtomicInteger = new AtomicInteger();
    return Executors.newFixedThreadPool(getParallelism(), (ThreadFactory)new CommonPool.createPlainPool.1(localAtomicInteger));
  }
  
  private final ExecutorService createPool()
  {
    if (System.getSecurityManager() != null) {
      return createPlainPool();
    }
    localObject5 = null;
    try
    {
      localObject3 = Class.forName("java.util.concurrent.ForkJoinPool");
    }
    catch (Throwable localThrowable1)
    {
      Object localObject3;
      label23:
      break label23;
    }
    localObject3 = null;
    if ((localObject3 == null) || ((!usePrivatePool) && (requestedParallelism < 0))) {}
    try
    {
      localObject1 = ((Class)localObject3).getMethod("commonPool", new Class[0]);
      if (localObject1 == null) {
        break label197;
      }
      localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        continue;
        Object localObject2 = null;
      }
    }
    localObject4 = localObject1;
    if (!(localObject1 instanceof ExecutorService)) {
      localObject4 = null;
    }
    localObject1 = (ExecutorService)localObject4;
    break label90;
    localObject1 = null;
    label90:
    if (localObject1 != null)
    {
      if (!INSTANCE.isGoodCommonPool$kotlinx_coroutines_core((Class)localObject3, (ExecutorService)localObject1)) {
        localObject1 = null;
      }
      if (localObject1 != null) {
        return localObject1;
      }
    }
    try
    {
      localObject3 = ((Class)localObject3).getConstructor(new Class[] { Integer.TYPE }).newInstance(new Object[] { Integer.valueOf(INSTANCE.getParallelism()) });
      localObject1 = localObject3;
      if (!(localObject3 instanceof ExecutorService)) {
        localObject1 = null;
      }
      localObject1 = (ExecutorService)localObject1;
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        localObject2 = localObject5;
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return createPlainPool();
    return createPlainPool();
  }
  
  private final Executor getOrCreatePoolSync()
  {
    try
    {
      Object localObject1 = pool;
      if (localObject1 == null)
      {
        localObject1 = createPool();
        pool = (Executor)localObject1;
        localObject1 = (Executor)localObject1;
      }
      return localObject1;
    }
    finally {}
  }
  
  private final int getParallelism()
  {
    Integer localInteger = Integer.valueOf(requestedParallelism);
    int i;
    if (((Number)localInteger).intValue() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      localInteger = null;
    }
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
  }
  
  public void close()
  {
    throw ((Throwable)new IllegalStateException("Close cannot be invoked on CommonPool".toString()));
  }
  
  public void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    try
    {
      paramCoroutineContext = pool;
      if (paramCoroutineContext == null) {
        paramCoroutineContext = getOrCreatePoolSync();
      }
      localObject = TimeSourceKt.getTimeSource();
      if (localObject == null) {
        break label73;
      }
      localObject = ((TimeSource)localObject).wrapTask(paramRunnable);
      if (localObject == null) {
        break label73;
      }
    }
    catch (RejectedExecutionException paramCoroutineContext)
    {
      for (;;)
      {
        continue;
        label73:
        Object localObject = paramRunnable;
      }
    }
    paramCoroutineContext.execute((Runnable)localObject);
    return;
    paramCoroutineContext = TimeSourceKt.getTimeSource();
    if (paramCoroutineContext != null) {
      paramCoroutineContext.unTrackTask();
    }
    DefaultExecutor.INSTANCE.enqueue(paramRunnable);
  }
  
  @NotNull
  public Executor getExecutor()
  {
    Executor localExecutor = pool;
    if (localExecutor != null) {
      return localExecutor;
    }
    return getOrCreatePoolSync();
  }
  
  public final boolean isGoodCommonPool$kotlinx_coroutines_core(@NotNull Class<?> paramClass, @NotNull ExecutorService paramExecutorService)
  {
    paramExecutorService.submit((Runnable)CommonPool.isGoodCommonPool.1.INSTANCE);
    try
    {
      paramExecutorService = paramClass.getMethod("getPoolSize", new Class[0]).invoke(paramExecutorService, new Object[0]);
      paramClass = paramExecutorService;
      if (!(paramExecutorService instanceof Integer)) {
        paramClass = null;
      }
      paramClass = (Integer)paramClass;
    }
    catch (Throwable paramClass)
    {
      label52:
      break label52;
    }
    paramClass = null;
    if (paramClass != null) {
      return paramClass.intValue() >= 1;
    }
    return false;
  }
  
  public final void restore$kotlinx_coroutines_core()
  {
    try
    {
      shutdown$kotlinx_coroutines_core(0L);
      usePrivatePool = false;
      pool = (Executor)null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void shutdown$kotlinx_coroutines_core(long paramLong)
  {
    try
    {
      Object localObject3 = pool;
      Object localObject1 = localObject3;
      if (!(localObject3 instanceof ExecutorService)) {
        localObject1 = null;
      }
      localObject1 = (ExecutorService)localObject1;
      if (localObject1 != null)
      {
        ((ExecutorService)localObject1).shutdown();
        if (paramLong > 0L) {
          ((ExecutorService)localObject1).awaitTermination(paramLong, TimeUnit.MILLISECONDS);
        }
        localObject1 = ((Iterable)((ExecutorService)localObject1).shutdownNow()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Runnable)((Iterator)localObject1).next();
          DefaultExecutor.INSTANCE.enqueue((Runnable)localObject3);
        }
      }
      pool = (Executor)CommonPool.shutdown.2.INSTANCE;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "CommonPool";
  }
  
  public final void usePrivatePool$kotlinx_coroutines_core()
  {
    try
    {
      shutdown$kotlinx_coroutines_core(0L);
      usePrivatePool = true;
      pool = (Executor)null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CommonPool
 * JD-Core Version:    0.7.0.1
 */