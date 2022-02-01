package com.tencent.qqmini.sdk.core.utils.thread;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/core/utils/thread/ThreadPools;", "", "()V", "IO_POOL_MIN_COUNT", "", "computationThreadPool", "Ljava/util/concurrent/ExecutorService;", "computationThreadPool$annotations", "getComputationThreadPool", "()Ljava/util/concurrent/ExecutorService;", "diskIOThreadPool", "Ljava/util/concurrent/Executor;", "diskIOThreadPool$annotations", "getDiskIOThreadPool", "()Ljava/util/concurrent/Executor;", "mainThreadExecutor", "mainThreadExecutor$annotations", "getMainThreadExecutor", "mainThreadHandler", "Landroid/os/Handler;", "mainThreadHandler$annotations", "getMainThreadHandler", "()Landroid/os/Handler;", "networkIOThreadPool", "networkIOThreadPool$annotations", "getNetworkIOThreadPool", "TF", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
public final class ThreadPools
{
  public static final ThreadPools INSTANCE = new ThreadPools();
  private static final int IO_POOL_MIN_COUNT = 4;
  @NotNull
  private static final ExecutorService computationThreadPool;
  @NotNull
  private static final Executor diskIOThreadPool;
  @NotNull
  private static final Executor mainThreadExecutor = (Executor)new ThreadPools.mainThreadExecutor.1();
  @NotNull
  private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
  @NotNull
  private static final Executor networkIOThreadPool;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    int j = RangesKt.coerceAtLeast(i, 4);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(j, j, 1L, TimeUnit.MINUTES, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new ThreadPools.TF("DiskIO", 11));
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    diskIOThreadPool = (Executor)localThreadPoolExecutor;
    j = RangesKt.coerceAtLeast(i * 2, 4);
    localThreadPoolExecutor = new ThreadPoolExecutor(j, j, 1L, TimeUnit.MINUTES, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new ThreadPools.TF("NetworkIO", 11));
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    networkIOThreadPool = (Executor)localThreadPoolExecutor;
    localThreadPoolExecutor = new ThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new ThreadPools.TF("Computation", 9));
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    computationThreadPool = (ExecutorService)localThreadPoolExecutor;
  }
  
  @NotNull
  public static final ExecutorService getComputationThreadPool()
  {
    return computationThreadPool;
  }
  
  @NotNull
  public static final Executor getDiskIOThreadPool()
  {
    return diskIOThreadPool;
  }
  
  @NotNull
  public static final Executor getMainThreadExecutor()
  {
    return mainThreadExecutor;
  }
  
  @NotNull
  public static final Handler getMainThreadHandler()
  {
    return mainThreadHandler;
  }
  
  @NotNull
  public static final Executor getNetworkIOThreadPool()
  {
    return networkIOThreadPool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.thread.ThreadPools
 * JD-Core Version:    0.7.0.1
 */