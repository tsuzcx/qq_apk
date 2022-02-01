package com.tencent.mobileqq.mini.appbrand.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/appbrand/utils/ThreadPools$TF;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "priority", "", "(Ljava/lang/String;I)V", "id", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    return new Thread((Runnable)new ThreadPools.TF.newThread.1(this, paramRunnable), this.name + '-' + this.id.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ThreadPools.TF
 * JD-Core Version:    0.7.0.1
 */