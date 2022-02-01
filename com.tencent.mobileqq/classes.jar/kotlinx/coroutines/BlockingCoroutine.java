package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class BlockingCoroutine<T>
  extends AbstractCoroutine<T>
{
  private final Thread blockedThread;
  private final EventLoop eventLoop;
  
  public BlockingCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Thread paramThread, @Nullable EventLoop paramEventLoop)
  {
    super(paramCoroutineContext, true);
    this.blockedThread = paramThread;
    this.eventLoop = paramEventLoop;
  }
  
  protected void afterCompletion(@Nullable Object paramObject)
  {
    if ((Intrinsics.areEqual(Thread.currentThread(), this.blockedThread) ^ true)) {
      LockSupport.unpark(this.blockedThread);
    }
  }
  
  protected boolean isScopedCoroutine()
  {
    return true;
  }
  
  public final T joinBlocking()
  {
    Object localObject1 = TimeSourceKt.getTimeSource();
    if (localObject1 != null) {
      ((TimeSource)localObject1).registerTimeLoopThread();
    }
    for (;;)
    {
      try
      {
        localObject4 = this.eventLoop;
        localObject1 = null;
        if (localObject4 != null) {
          EventLoop.incrementUseCount$default((EventLoop)localObject4, false, 1, null);
        }
      }
      finally
      {
        Object localObject4 = TimeSourceKt.getTimeSource();
        if (localObject4 == null) {
          continue;
        }
        ((TimeSource)localObject4).unregisterTimeLoopThread();
        continue;
        throw localObject3;
        continue;
        long l = 9223372036854775807L;
        continue;
      }
      try
      {
        if (!Thread.interrupted())
        {
          localObject4 = this.eventLoop;
          if (localObject4 == null) {
            continue;
          }
          l = ((EventLoop)localObject4).processNextEvent();
          boolean bool = isCompleted();
          if (bool)
          {
            localObject4 = this.eventLoop;
            if (localObject4 != null) {
              EventLoop.decrementUseCount$default((EventLoop)localObject4, false, 1, null);
            }
            localObject4 = TimeSourceKt.getTimeSource();
            if (localObject4 != null) {
              ((TimeSource)localObject4).unregisterTimeLoopThread();
            }
            localObject4 = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
            if ((localObject4 instanceof CompletedExceptionally)) {
              localObject1 = localObject4;
            }
            localObject1 = (CompletedExceptionally)localObject1;
            if (localObject1 == null) {
              return localObject4;
            }
            throw ((CompletedExceptionally)localObject1).cause;
          }
          localObject4 = TimeSourceKt.getTimeSource();
          if (localObject4 != null)
          {
            ((TimeSource)localObject4).parkNanos(this, l);
            continue;
          }
          LockSupport.parkNanos(this, l);
          continue;
        }
        localObject1 = new InterruptedException();
        cancelCoroutine((Throwable)localObject1);
        throw ((Throwable)localObject1);
      }
      finally
      {
        localObject4 = this.eventLoop;
        if (localObject4 != null) {
          EventLoop.decrementUseCount$default((EventLoop)localObject4, false, 1, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.BlockingCoroutine
 * JD-Core Version:    0.7.0.1
 */