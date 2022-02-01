package com.tencent.tkd.topicsdk.widget.videocrop;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.tkd.topicsdk.common.MmrExtensionsKt;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$OnFetchFrameListener;", "mVideoPath", "", "mFrameWidth", "", "(Ljava/lang/String;F)V", "isInited", "", "()Z", "mAdapter", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter;", "mExecutor", "Ljava/util/concurrent/ExecutorService;", "mFramesFetchingQueue", "Ljava/util/concurrent/BlockingQueue;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchTask;", "mIsDestroyed", "mMilliPerSec", "", "mRequestingFrames", "Ljava/util/concurrent/ConcurrentHashMap;", "mRetriever", "Landroid/media/MediaMetadataRetriever;", "mStatus", "mVideoDuration", "fetchFrameAtTime", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame;", "frameMilliSec", "fetchFrameByIndex", "frameIndex", "", "startIndex", "endIndex", "init", "milliPerSec", "videoDuration", "adapter", "release", "Companion", "FrameFetchRunnable", "FrameFetchTask", "topicsdk_release"}, k=1, mv={1, 1, 16})
@TargetApi(10)
public final class VideoFramesRetriever
  implements FramesProcessor.OnFetchFrameListener
{
  public static final VideoFramesRetriever.Companion a = new VideoFramesRetriever.Companion(null);
  private static long m;
  private volatile int b;
  private int c;
  private int d;
  private FrameAdapter e;
  private BlockingQueue<VideoFramesRetriever.FrameFetchTask> f;
  private ConcurrentHashMap<Integer, VideoFramesRetriever.FrameFetchTask> g;
  private ExecutorService h;
  private volatile boolean i;
  private MediaMetadataRetriever j;
  private final String k;
  private final float l;
  
  public VideoFramesRetriever(@NotNull String paramString, float paramFloat)
  {
    this.k = paramString;
    this.l = paramFloat;
    this.b = 1;
    this.c = 1000;
  }
  
  private final FramesProcessor.Frame b(int paramInt)
  {
    Object localObject;
    if (!b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FetchFrameAtTime fail, status=");
      ((StringBuilder)localObject).append(this.b);
      TLog.b("VideoFramesRetriever", ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      localObject = this.g;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRequestingFrames");
      }
      long l1;
      if (((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(paramInt)))
      {
        localObject = this.g;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mRequestingFrames");
        }
        localObject = (VideoFramesRetriever.FrameFetchTask)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt));
        if (localObject != null)
        {
          l1 = m;
          m = 1L + l1;
          ((VideoFramesRetriever.FrameFetchTask)localObject).a(l1);
          return null;
        }
      }
      else
      {
        l1 = m;
        m = 1L + l1;
        localObject = new VideoFramesRetriever.FrameFetchTask(this, l1, paramInt, paramInt + this.c);
        BlockingQueue localBlockingQueue = this.f;
        if (localBlockingQueue == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mFramesFetchingQueue");
        }
        localBlockingQueue.offer(localObject);
        return null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    return null;
  }
  
  public int a(int paramInt1, int paramInt2, @Nullable FrameAdapter paramFrameAdapter)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramFrameAdapter;
    this.f = ((BlockingQueue)new PriorityBlockingQueue());
    this.g = new ConcurrentHashMap();
    paramFrameAdapter = MmrExtensionsKt.a(new MediaMetadataRetriever(), this.k);
    if (paramFrameAdapter != null) {
      this.j = paramFrameAdapter;
    }
    Executors.newSingleThreadExecutor().submit((Runnable)new VideoFramesRetriever.FrameFetchRunnable(this));
    return 0;
  }
  
  @Nullable
  public FramesProcessor.Frame a(int paramInt)
  {
    if ((b()) && (paramInt >= 0))
    {
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((FrameAdapter)localObject).b(paramInt))
      {
        localObject = this.e;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        return ((FrameAdapter)localObject).a(paramInt);
      }
      return b(paramInt * this.c);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fetchFrameByIndex1 fail, status=");
    ((StringBuilder)localObject).append(this.b);
    TLog.b("VideoFramesRetriever", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public void a()
  {
    this.b = 1;
    this.i = true;
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFramesFetchingQueue");
    }
    ((BlockingQueue)localObject).clear();
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRequestingFrames");
    }
    ((ConcurrentHashMap)localObject).clear();
    localObject = this.h;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdownNow();
    }
    localObject = this.j;
    if (localObject != null) {
      ((MediaMetadataRetriever)localObject).release();
    }
    m = 0L;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((b()) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      paramInt2 -= 1;
      if (paramInt2 >= paramInt1) {
        for (;;)
        {
          a(paramInt2);
          if (paramInt2 == paramInt1) {
            break;
          }
          paramInt2 -= 1;
        }
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchFrameByIndex2 fail, status=");
    localStringBuilder.append(this.b);
    TLog.b("VideoFramesRetriever", localStringBuilder.toString());
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoFramesRetriever
 * JD-Core Version:    0.7.0.1
 */