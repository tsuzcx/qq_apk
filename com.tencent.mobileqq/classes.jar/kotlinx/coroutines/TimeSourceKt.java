package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"timeSource", "Lkotlinx/coroutines/TimeSource;", "getTimeSource", "()Lkotlinx/coroutines/TimeSource;", "setTimeSource", "(Lkotlinx/coroutines/TimeSource;)V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class TimeSourceKt
{
  @Nullable
  private static TimeSource timeSource;
  
  @InlineOnly
  private static final long currentTimeMillis()
  {
    TimeSource localTimeSource = getTimeSource();
    if (localTimeSource != null) {
      return localTimeSource.currentTimeMillis();
    }
    return System.currentTimeMillis();
  }
  
  @Nullable
  public static final TimeSource getTimeSource()
  {
    return timeSource;
  }
  
  @InlineOnly
  private static final long nanoTime()
  {
    TimeSource localTimeSource = getTimeSource();
    if (localTimeSource != null) {
      return localTimeSource.nanoTime();
    }
    return System.nanoTime();
  }
  
  @InlineOnly
  private static final void parkNanos(Object paramObject, long paramLong)
  {
    TimeSource localTimeSource = getTimeSource();
    if (localTimeSource != null)
    {
      localTimeSource.parkNanos(paramObject, paramLong);
      return;
    }
    LockSupport.parkNanos(paramObject, paramLong);
  }
  
  @InlineOnly
  private static final void registerTimeLoopThread()
  {
    TimeSource localTimeSource = getTimeSource();
    if (localTimeSource != null) {
      localTimeSource.registerTimeLoopThread();
    }
  }
  
  public static final void setTimeSource(@Nullable TimeSource paramTimeSource)
  {
    timeSource = paramTimeSource;
  }
  
  @InlineOnly
  private static final void trackTask()
  {
    TimeSource localTimeSource = getTimeSource();
    if (localTimeSource != null) {
      localTimeSource.trackTask();
    }
  }
  
  @InlineOnly
  private static final void unTrackTask()
  {
    TimeSource localTimeSource = getTimeSource();
    if (localTimeSource != null) {
      localTimeSource.unTrackTask();
    }
  }
  
  @InlineOnly
  private static final void unpark(Thread paramThread)
  {
    TimeSource localTimeSource = getTimeSource();
    if (localTimeSource != null)
    {
      localTimeSource.unpark(paramThread);
      return;
    }
    LockSupport.unpark(paramThread);
  }
  
  @InlineOnly
  private static final void unregisterTimeLoopThread()
  {
    TimeSource localTimeSource = getTimeSource();
    if (localTimeSource != null) {
      localTimeSource.unregisterTimeLoopThread();
    }
  }
  
  @InlineOnly
  private static final Runnable wrapTask(Runnable paramRunnable)
  {
    Object localObject2 = getTimeSource();
    Object localObject1 = paramRunnable;
    if (localObject2 != null)
    {
      localObject2 = ((TimeSource)localObject2).wrapTask(paramRunnable);
      localObject1 = paramRunnable;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.TimeSourceKt
 * JD-Core Version:    0.7.0.1
 */