package com.tencent.videocut.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/thread/AppThreadPool;", "", "()V", "threadPoolForComputation", "Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "getThreadPoolForComputation$annotations", "getThreadPoolForComputation", "()Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "threadPoolForIo", "getThreadPoolForIo$annotations", "getThreadPoolForIo", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class AppThreadPool
{
  @NotNull
  public static final AppThreadPool a = new AppThreadPool();
  @NotNull
  private static final PriorityThreadPoolExecutor b;
  @NotNull
  private static final PriorityThreadPoolExecutor c;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    int j = Math.max(2, i);
    b = new PriorityThreadPoolExecutor(Math.max(2, i / 2), 60L, TimeUnit.SECONDS);
    b.setThreadFactory((ThreadFactory)new PriorityThreadFactory("app-compute", 10));
    c = new PriorityThreadPoolExecutor(j, 60L, TimeUnit.SECONDS);
    c.setThreadFactory((ThreadFactory)new PriorityThreadFactory("app-io", 10));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.thread.AppThreadPool
 * JD-Core Version:    0.7.0.1
 */