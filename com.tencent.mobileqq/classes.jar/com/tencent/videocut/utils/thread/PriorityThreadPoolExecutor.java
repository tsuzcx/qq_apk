package com.tencent.videocut.utils.thread;

import android.annotation.TargetApi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "Lcom/tencent/videocut/utils/thread/PriorityExecutorService;", "poolSize", "", "(I)V", "keepAliveTime", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(IJLjava/util/concurrent/TimeUnit;)V", "coreSize", "maxPoolSize", "workQueue", "Ljava/util/concurrent/PriorityBlockingQueue;", "Ljava/lang/Runnable;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/PriorityBlockingQueue;)V", "handler", "Ljava/util/concurrent/RejectedExecutionHandler;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/PriorityBlockingQueue;Ljava/util/concurrent/RejectedExecutionHandler;)V", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/PriorityBlockingQueue;Ljava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "execute", "", "command", "priority", "Lcom/tencent/videocut/utils/thread/PriorityExecutorService$Priority;", "submit", "Ljava/util/concurrent/Future;", "T", "task", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;Lcom/tencent/videocut/utils/thread/PriorityExecutorService$Priority;)Ljava/util/concurrent/Future;", "Ljava/util/concurrent/Callable;", "submitInternal", "V", "(Ljava/lang/Runnable;Lcom/tencent/videocut/utils/thread/PriorityExecutorService$Priority;)Ljava/util/concurrent/Future;", "Companion", "PriorityRunnable", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class PriorityThreadPoolExecutor
  extends ThreadPoolExecutor
  implements PriorityExecutorService
{
  @NotNull
  public static final PriorityThreadPoolExecutor.Companion a = new PriorityThreadPoolExecutor.Companion(null);
  
  @TargetApi(9)
  public PriorityThreadPoolExecutor(int paramInt, long paramLong, @Nullable TimeUnit paramTimeUnit)
  {
    super(paramInt, paramInt, paramLong, paramTimeUnit, (BlockingQueue)new PriorityBlockingQueue());
    if (paramLong > 0L) {
      allowCoreThreadTimeOut(true);
    }
  }
  
  public void a(@Nullable Runnable paramRunnable, @Nullable PriorityExecutorService.Priority paramPriority)
  {
    if (paramRunnable != null)
    {
      PriorityExecutorService.Priority localPriority = paramPriority;
      if (paramPriority == null) {
        localPriority = PriorityExecutorService.Priority.b;
      }
      super.execute((Runnable)new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable, localPriority));
      return;
    }
    throw ((Throwable)new NullPointerException());
  }
  
  public void execute(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkNotNullParameter(paramRunnable, "command");
    a(paramRunnable, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.thread.PriorityThreadPoolExecutor
 * JD-Core Version:    0.7.0.1
 */