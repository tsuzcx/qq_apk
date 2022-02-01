package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"createEventLoop", "Lkotlinx/coroutines/EventLoop;", "processNextEventInCurrentThread", "", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class EventLoopKt
{
  @NotNull
  public static final EventLoop createEventLoop()
  {
    return (EventLoop)new BlockingEventLoop(Thread.currentThread());
  }
  
  @InternalCoroutinesApi
  public static final long processNextEventInCurrentThread()
  {
    EventLoop localEventLoop = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
    if (localEventLoop != null) {
      return localEventLoop.processNextEvent();
    }
    return 9223372036854775807L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoopKt
 * JD-Core Version:    0.7.0.1
 */