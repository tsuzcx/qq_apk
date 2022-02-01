package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class EventLoopImplBase$DelayedTask
  implements Comparable<DelayedTask>, Runnable, DisposableHandle, ThreadSafeHeapNode
{
  private Object _heap;
  private int index;
  @JvmField
  public long nanoTime;
  
  public EventLoopImplBase$DelayedTask(long paramLong)
  {
    this.nanoTime = paramLong;
    this.index = -1;
  }
  
  public int compareTo(@NotNull DelayedTask paramDelayedTask)
  {
    long l = this.nanoTime - paramDelayedTask.nanoTime;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
  
  public final void dispose()
  {
    try
    {
      Object localObject3 = this._heap;
      Object localObject1 = EventLoop_commonKt.access$getDISPOSED_TASK$p();
      if (localObject3 == localObject1) {
        return;
      }
      localObject1 = localObject3;
      if (!(localObject3 instanceof EventLoopImplBase.DelayedTaskQueue)) {
        localObject1 = null;
      }
      localObject1 = (EventLoopImplBase.DelayedTaskQueue)localObject1;
      if (localObject1 != null) {
        ((EventLoopImplBase.DelayedTaskQueue)localObject1).remove((ThreadSafeHeapNode)this);
      }
      this._heap = EventLoop_commonKt.access$getDISPOSED_TASK$p();
      return;
    }
    finally {}
  }
  
  @Nullable
  public ThreadSafeHeap<?> getHeap()
  {
    Object localObject2 = this._heap;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ThreadSafeHeap)) {
      localObject1 = null;
    }
    return (ThreadSafeHeap)localObject1;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public final int scheduleTask(long paramLong, @NotNull EventLoopImplBase.DelayedTaskQueue paramDelayedTaskQueue, @NotNull EventLoopImplBase paramEventLoopImplBase)
  {
    label163:
    for (;;)
    {
      try
      {
        Object localObject1 = this._heap;
        Object localObject2 = EventLoop_commonKt.access$getDISPOSED_TASK$p();
        if (localObject1 == localObject2) {
          return 2;
        }
        localObject1 = (ThreadSafeHeap)paramDelayedTaskQueue;
        localObject2 = (ThreadSafeHeapNode)this;
        long l;
        try
        {
          DelayedTask localDelayedTask = (DelayedTask)((ThreadSafeHeap)localObject1).firstImpl();
          boolean bool = EventLoopImplBase.access$isCompleted$p(paramEventLoopImplBase);
          if (bool) {
            return 1;
          }
          if (localDelayedTask == null)
          {
            paramDelayedTaskQueue.timeNow = paramLong;
          }
          else
          {
            l = localDelayedTask.nanoTime;
            if (l - paramLong < 0L) {
              break label163;
            }
            if (paramLong - paramDelayedTaskQueue.timeNow > 0L) {
              paramDelayedTaskQueue.timeNow = paramLong;
            }
          }
          if (this.nanoTime - paramDelayedTaskQueue.timeNow < 0L) {
            this.nanoTime = paramDelayedTaskQueue.timeNow;
          }
          ((ThreadSafeHeap)localObject1).addImpl((ThreadSafeHeapNode)localObject2);
          return 0;
        }
        finally {}
        paramLong = l;
      }
      finally {}
    }
  }
  
  public void setHeap(@Nullable ThreadSafeHeap<?> paramThreadSafeHeap)
  {
    int i;
    if (this._heap != EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this._heap = paramThreadSafeHeap;
      return;
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final boolean timeToExecute(long paramLong)
  {
    return paramLong - this.nanoTime >= 0L;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Delayed[nanos=");
    localStringBuilder.append(this.nanoTime);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoopImplBase.DelayedTask
 * JD-Core Version:    0.7.0.1
 */