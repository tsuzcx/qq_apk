package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class EventLoopImplPlatform
  extends EventLoop
{
  @NotNull
  protected abstract Thread getThread();
  
  protected final void reschedule(long paramLong, @NotNull EventLoopImplBase.DelayedTask paramDelayedTask)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if ((EventLoopImplPlatform)this != DefaultExecutor.INSTANCE) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    DefaultExecutor.INSTANCE.schedule(paramLong, paramDelayedTask);
  }
  
  protected final void unpark()
  {
    Thread localThread = getThread();
    if (Thread.currentThread() != localThread)
    {
      TimeSource localTimeSource = TimeSourceKt.getTimeSource();
      if (localTimeSource != null)
      {
        localTimeSource.unpark(localThread);
        return;
      }
      LockSupport.unpark(localThread);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoopImplPlatform
 * JD-Core Version:    0.7.0.1
 */