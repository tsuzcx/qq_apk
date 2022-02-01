package com.tencent.qqmini.sdk.core.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/core/utils/thread/ThreadPools$TF;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "priority", "", "(Ljava/lang/String;I)V", "id", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
final class ThreadPools$TF
  implements ThreadFactory
{
  private final AtomicInteger id;
  private final String name;
  private final int priority;
  
  public ThreadPools$TF(@NotNull String paramString, int paramInt)
  {
    this.name = paramString;
    this.priority = paramInt;
    this.id = new AtomicInteger();
  }
  
  @NotNull
  public Thread newThread(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    paramRunnable = (Runnable)new ThreadPools.TF.newThread.1(this, paramRunnable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append('-');
    localStringBuilder.append(this.id.getAndIncrement());
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.thread.ThreadPools.TF
 * JD-Core Version:    0.7.0.1
 */