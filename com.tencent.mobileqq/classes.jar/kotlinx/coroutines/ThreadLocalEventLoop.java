package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ThreadLocalEventLoop
{
  public static final ThreadLocalEventLoop INSTANCE = new ThreadLocalEventLoop();
  private static final ThreadLocal<EventLoop> ref = new ThreadLocal();
  
  @Nullable
  public final EventLoop currentOrNull$kotlinx_coroutines_core()
  {
    return (EventLoop)ref.get();
  }
  
  @NotNull
  public final EventLoop getEventLoop$kotlinx_coroutines_core()
  {
    EventLoop localEventLoop = (EventLoop)ref.get();
    if (localEventLoop != null) {
      return localEventLoop;
    }
    localEventLoop = EventLoopKt.createEventLoop();
    ref.set(localEventLoop);
    return localEventLoop;
  }
  
  public final void resetEventLoop$kotlinx_coroutines_core()
  {
    ref.set(null);
  }
  
  public final void setEventLoop$kotlinx_coroutines_core(@NotNull EventLoop paramEventLoop)
  {
    ref.set(paramEventLoop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ThreadLocalEventLoop
 * JD-Core Version:    0.7.0.1
 */