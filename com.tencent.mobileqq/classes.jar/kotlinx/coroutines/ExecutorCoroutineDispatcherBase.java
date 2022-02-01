package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ConcurrentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "removesFutureOnCancellation", "", "close", "", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "initFutureCancellation", "initFutureCancellation$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class ExecutorCoroutineDispatcherBase
  extends ExecutorCoroutineDispatcher
  implements Delay
{
  private boolean removesFutureOnCancellation;
  
  private final ScheduledFuture<?> scheduleBlock(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = getExecutor();
      Object localObject1 = localObject3;
      if (!(localObject3 instanceof ScheduledExecutorService)) {
        localObject1 = null;
      }
      localObject3 = (ScheduledExecutorService)localObject1;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((ScheduledExecutorService)localObject3).schedule(paramRunnable, paramLong, paramTimeUnit);
      }
      return localObject1;
    }
    catch (RejectedExecutionException paramRunnable) {}
    return null;
  }
  
  public void close()
  {
    Executor localExecutor = getExecutor();
    Object localObject = localExecutor;
    if (!(localExecutor instanceof ExecutorService)) {
      localObject = null;
    }
    localObject = (ExecutorService)localObject;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdown();
    }
  }
  
  @Nullable
  public Object delay(long paramLong, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return Delay.DefaultImpls.delay(this, paramLong, paramContinuation);
  }
  
  public void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    try
    {
      localExecutor = getExecutor();
      paramCoroutineContext = TimeSourceKt.getTimeSource();
      if (paramCoroutineContext == null) {
        break label62;
      }
      paramCoroutineContext = paramCoroutineContext.wrapTask(paramRunnable);
      if (paramCoroutineContext == null) {
        break label62;
      }
    }
    catch (RejectedExecutionException paramCoroutineContext)
    {
      for (;;)
      {
        Executor localExecutor;
        continue;
        label62:
        paramCoroutineContext = paramRunnable;
      }
    }
    localExecutor.execute(paramCoroutineContext);
    return;
    paramCoroutineContext = TimeSourceKt.getTimeSource();
    if (paramCoroutineContext != null) {
      paramCoroutineContext.unTrackTask();
    }
    DefaultExecutor.INSTANCE.enqueue(paramRunnable);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ExecutorCoroutineDispatcherBase)) && (((ExecutorCoroutineDispatcherBase)paramObject).getExecutor() == getExecutor());
  }
  
  public int hashCode()
  {
    return System.identityHashCode(getExecutor());
  }
  
  public final void initFutureCancellation$kotlinx_coroutines_core()
  {
    this.removesFutureOnCancellation = ConcurrentKt.removeFutureOnCancel(getExecutor());
  }
  
  @NotNull
  public DisposableHandle invokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable)
  {
    ScheduledFuture localScheduledFuture;
    if (this.removesFutureOnCancellation) {
      localScheduledFuture = scheduleBlock(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
    } else {
      localScheduledFuture = null;
    }
    if (localScheduledFuture != null) {
      return (DisposableHandle)new DisposableFutureHandle((Future)localScheduledFuture);
    }
    return DefaultExecutor.INSTANCE.invokeOnTimeout(paramLong, paramRunnable);
  }
  
  public void scheduleResumeAfterDelay(long paramLong, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    ScheduledFuture localScheduledFuture;
    if (this.removesFutureOnCancellation) {
      localScheduledFuture = scheduleBlock((Runnable)new ResumeUndispatchedRunnable((CoroutineDispatcher)this, paramCancellableContinuation), paramLong, TimeUnit.MILLISECONDS);
    } else {
      localScheduledFuture = null;
    }
    if (localScheduledFuture != null)
    {
      JobKt.cancelFutureOnCancellation(paramCancellableContinuation, (Future)localScheduledFuture);
      return;
    }
    DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(paramLong, paramCancellableContinuation);
  }
  
  @NotNull
  public String toString()
  {
    return getExecutor().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ExecutorCoroutineDispatcherBase
 * JD-Core Version:    0.7.0.1
 */