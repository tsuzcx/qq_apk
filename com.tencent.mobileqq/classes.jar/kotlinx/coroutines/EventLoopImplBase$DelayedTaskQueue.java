package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.ThreadSafeHeap;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class EventLoopImplBase$DelayedTaskQueue
  extends ThreadSafeHeap<EventLoopImplBase.DelayedTask>
{
  @JvmField
  public long timeNow;
  
  public EventLoopImplBase$DelayedTaskQueue(long paramLong)
  {
    this.timeNow = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue
 * JD-Core Version:    0.7.0.1
 */