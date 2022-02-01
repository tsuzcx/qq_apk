package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/TimeSource;", "", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface TimeSource
{
  public abstract long currentTimeMillis();
  
  public abstract long nanoTime();
  
  public abstract void parkNanos(@NotNull Object paramObject, long paramLong);
  
  public abstract void registerTimeLoopThread();
  
  public abstract void trackTask();
  
  public abstract void unTrackTask();
  
  public abstract void unpark(@NotNull Thread paramThread);
  
  public abstract void unregisterTimeLoopThread();
  
  @NotNull
  public abstract Runnable wrapTask(@NotNull Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.TimeSource
 * JD-Core Version:    0.7.0.1
 */