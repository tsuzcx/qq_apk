package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "identitySet", "", "E", "expectedSize", "", "removeFutureOnCancel", "", "executor", "Ljava/util/concurrent/Executor;", "subscriberList", "", "Lkotlinx/coroutines/internal/SubscribersList;", "withLock", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ConcurrentKt
{
  private static final Method REMOVE_FUTURE_ON_CANCEL;
  
  static
  {
    try
    {
      localMethod = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[] { Boolean.TYPE });
    }
    catch (Throwable localThrowable)
    {
      Method localMethod;
      label21:
      break label21;
    }
    localMethod = null;
    REMOVE_FUTURE_ON_CANCEL = localMethod;
  }
  
  @NotNull
  public static final <E> Set<E> identitySet(int paramInt)
  {
    return Collections.newSetFromMap((Map)new IdentityHashMap(paramInt));
  }
  
  public static final boolean removeFutureOnCancel(@NotNull Executor paramExecutor)
  {
    Object localObject = paramExecutor;
    try
    {
      if (!(paramExecutor instanceof ScheduledExecutorService)) {
        localObject = null;
      }
      paramExecutor = (ScheduledExecutorService)localObject;
      if (paramExecutor != null)
      {
        localObject = REMOVE_FUTURE_ON_CANCEL;
        if (localObject != null)
        {
          ((Method)localObject).invoke(paramExecutor, new Object[] { Boolean.valueOf(true) });
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramExecutor) {}
    return true;
  }
  
  @NotNull
  public static final <E> List<E> subscriberList()
  {
    return (List)new CopyOnWriteArrayList();
  }
  
  public static final <T> T withLock(@NotNull ReentrantLock paramReentrantLock, @NotNull Function0<? extends T> paramFunction0)
  {
    paramReentrantLock = (Lock)paramReentrantLock;
    paramReentrantLock.lock();
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      paramReentrantLock.unlock();
      InlineMarker.finallyEnd(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ConcurrentKt
 * JD-Core Version:    0.7.0.1
 */