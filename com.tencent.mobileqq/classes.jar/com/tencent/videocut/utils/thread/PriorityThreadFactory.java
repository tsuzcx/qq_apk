package com.tencent.videocut.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/thread/PriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "mName", "", "mPriority", "", "(Ljava/lang/String;I)V", "mNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class PriorityThreadFactory
  implements ThreadFactory
{
  private final AtomicInteger a;
  private final String b;
  private final int c;
  
  public PriorityThreadFactory(@NotNull String paramString, int paramInt)
  {
    this.b = paramString;
    this.c = paramInt;
    this.a = new AtomicInteger();
  }
  
  @NotNull
  public Thread newThread(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkNotNullParameter(paramRunnable, "r");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append('-');
    localStringBuilder.append(this.a.getAndIncrement());
    return (Thread)new PriorityThreadFactory.newThread.1(this, paramRunnable, paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.thread.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */