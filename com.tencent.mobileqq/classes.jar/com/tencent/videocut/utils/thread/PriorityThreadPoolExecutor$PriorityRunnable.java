package com.tencent.videocut.utils.thread;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor$PriorityRunnable;", "T", "Ljava/lang/Runnable;", "", "mRunnable", "p", "Lcom/tencent/videocut/utils/thread/PriorityExecutorService$Priority;", "(Ljava/lang/Runnable;Lcom/tencent/videocut/utils/thread/PriorityExecutorService$Priority;)V", "mFifo", "", "mPriority", "", "mSeqNum", "", "compareTo", "other", "run", "", "subCompareTo", "another", "Companion", "lib_utils_release"}, k=1, mv={1, 4, 2})
final class PriorityThreadPoolExecutor$PriorityRunnable<T>
  implements Comparable<PriorityRunnable<?>>, Runnable
{
  @NotNull
  public static final PriorityThreadPoolExecutor.PriorityRunnable.Companion a = new PriorityThreadPoolExecutor.PriorityRunnable.Companion(null);
  private static final AtomicLong f = new AtomicLong(0L);
  private final int b;
  private final boolean c;
  private final long d;
  private final Runnable e;
  
  public PriorityThreadPoolExecutor$PriorityRunnable(@NotNull Runnable paramRunnable, @NotNull PriorityExecutorService.Priority paramPriority)
  {
    this.e = paramRunnable;
    this.b = paramPriority.a();
    this.c = paramPriority.b();
    this.d = f.getAndIncrement();
  }
  
  private final int b(PriorityRunnable<?> paramPriorityRunnable)
  {
    long l1 = this.d;
    long l2 = paramPriorityRunnable.d;
    int i;
    if (l1 < l2) {
      i = -1;
    } else if (l1 > l2) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.c) {
      return i;
    }
    return -i;
  }
  
  public int a(@NotNull PriorityRunnable<?> paramPriorityRunnable)
  {
    Intrinsics.checkNotNullParameter(paramPriorityRunnable, "other");
    int i = this.b;
    int j = paramPriorityRunnable.b;
    if (i > j) {
      return -1;
    }
    if (i < j) {
      return 1;
    }
    return b(paramPriorityRunnable);
  }
  
  public void run()
  {
    this.e.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.thread.PriorityThreadPoolExecutor.PriorityRunnable
 * JD-Core Version:    0.7.0.1
 */