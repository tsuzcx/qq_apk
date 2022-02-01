package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ArrayQueue;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class EventLoop
  extends CoroutineDispatcher
{
  private boolean shared;
  private ArrayQueue<DispatchedTask<?>> unconfinedQueue;
  private long useCount;
  
  private final long delta(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 4294967296L;
    }
    return 1L;
  }
  
  public final void decrementUseCount(boolean paramBoolean)
  {
    this.useCount -= delta(paramBoolean);
    if (this.useCount > 0L) {
      return;
    }
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (this.useCount == 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (this.shared) {
      shutdown();
    }
  }
  
  public final void dispatchUnconfined(@NotNull DispatchedTask<?> paramDispatchedTask)
  {
    ArrayQueue localArrayQueue = this.unconfinedQueue;
    if (localArrayQueue == null)
    {
      localArrayQueue = new ArrayQueue();
      this.unconfinedQueue = localArrayQueue;
    }
    localArrayQueue.addLast(paramDispatchedTask);
  }
  
  protected long getNextTime()
  {
    ArrayQueue localArrayQueue = this.unconfinedQueue;
    long l = 9223372036854775807L;
    if (localArrayQueue != null)
    {
      if (localArrayQueue.isEmpty()) {
        return 9223372036854775807L;
      }
      l = 0L;
    }
    return l;
  }
  
  public final void incrementUseCount(boolean paramBoolean)
  {
    this.useCount += delta(paramBoolean);
    if (!paramBoolean) {
      this.shared = true;
    }
  }
  
  public final boolean isActive()
  {
    return this.useCount > 0L;
  }
  
  protected boolean isEmpty()
  {
    return isUnconfinedQueueEmpty();
  }
  
  public final boolean isUnconfinedLoopActive()
  {
    return this.useCount >= delta(true);
  }
  
  public final boolean isUnconfinedQueueEmpty()
  {
    ArrayQueue localArrayQueue = this.unconfinedQueue;
    if (localArrayQueue != null) {
      return localArrayQueue.isEmpty();
    }
    return true;
  }
  
  public long processNextEvent()
  {
    if (!processUnconfinedEvent()) {
      return 9223372036854775807L;
    }
    return getNextTime();
  }
  
  public final boolean processUnconfinedEvent()
  {
    Object localObject = this.unconfinedQueue;
    if (localObject != null)
    {
      localObject = (DispatchedTask)((ArrayQueue)localObject).removeFirstOrNull();
      if (localObject != null)
      {
        ((DispatchedTask)localObject).run();
        return true;
      }
    }
    return false;
  }
  
  public boolean shouldBeProcessedFromContext()
  {
    return false;
  }
  
  protected void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoop
 * JD-Core Version:    0.7.0.1
 */