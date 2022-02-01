package com.tencent.mobileqq.tritonaudio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tritonaudio/TritonAudioThreadPool;", "", "()V", "audioExecutorService", "Ljava/util/concurrent/ExecutorService;", "audioExecutorService$annotations", "getAudioExecutorService", "()Ljava/util/concurrent/ExecutorService;", "audioThreadPool", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "audioThreadPool$annotations", "getAudioThreadPool", "()Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class TritonAudioThreadPool
{
  public static final TritonAudioThreadPool INSTANCE = new TritonAudioThreadPool();
  @NotNull
  private static final ExecutorService audioExecutorService;
  @NotNull
  private static final ScheduledThreadPoolExecutor audioThreadPool;
  
  static
  {
    Object localObject = new ScheduledThreadPoolExecutor(4, (ThreadFactory)new TF("TritonAudio", -19));
    ((ScheduledThreadPoolExecutor)localObject).setKeepAliveTime(30L, TimeUnit.SECONDS);
    ((ScheduledThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    audioThreadPool = (ScheduledThreadPoolExecutor)localObject;
    localObject = Executors.newSingleThreadExecutor();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Executors.newSingleThreadExecutor()");
    audioExecutorService = (ExecutorService)localObject;
  }
  
  @NotNull
  public static final ExecutorService getAudioExecutorService()
  {
    return audioExecutorService;
  }
  
  @NotNull
  public static final ScheduledThreadPoolExecutor getAudioThreadPool()
  {
    return audioThreadPool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool
 * JD-Core Version:    0.7.0.1
 */