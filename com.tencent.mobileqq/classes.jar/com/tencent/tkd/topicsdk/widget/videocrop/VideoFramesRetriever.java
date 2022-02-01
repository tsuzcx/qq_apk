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
  private static long jdField_a_of_type_Long;
  public static final VideoFramesRetriever.Companion a;
  private final float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  private FrameAdapter jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter;
  private final String jdField_a_of_type_JavaLangString;
  private BlockingQueue<VideoFramesRetriever.FrameFetchTask> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private ConcurrentHashMap<Integer, VideoFramesRetriever.FrameFetchTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFramesRetriever$Companion = new VideoFramesRetriever.Companion(null);
  }
  
  public VideoFramesRetriever(@NotNull String paramString, float paramFloat)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = 1;
    this.b = 1000;
  }
  
  private final FramesProcessor.Frame b(int paramInt)
  {
    Object localObject;
    if (!a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FetchFrameAtTime fail, status=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      TLog.b("VideoFramesRetriever", ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRequestingFrames");
      }
      long l;
      if (((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(paramInt)))
      {
        localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mRequestingFrames");
        }
        localObject = (VideoFramesRetriever.FrameFetchTask)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt));
        if (localObject != null)
        {
          l = jdField_a_of_type_Long;
          jdField_a_of_type_Long = 1L + l;
          ((VideoFramesRetriever.FrameFetchTask)localObject).a(l);
          return null;
        }
      }
      else
      {
        l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localObject = new VideoFramesRetriever.FrameFetchTask(this, l, paramInt, paramInt + this.b);
        BlockingQueue localBlockingQueue = this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
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
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter = paramFrameAdapter;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = ((BlockingQueue)new PriorityBlockingQueue());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    paramFrameAdapter = MmrExtensionsKt.a(new MediaMetadataRetriever(), this.jdField_a_of_type_JavaLangString);
    if (paramFrameAdapter != null) {
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = paramFrameAdapter;
    }
    Executors.newSingleThreadExecutor().submit((Runnable)new VideoFramesRetriever.FrameFetchRunnable(this));
    return 0;
  }
  
  @Nullable
  public FramesProcessor.Frame a(int paramInt)
  {
    if ((a()) && (paramInt >= 0))
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((FrameAdapter)localObject).a(paramInt))
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        return ((FrameAdapter)localObject).a(paramInt);
      }
      return b(paramInt * this.b);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fetchFrameByIndex1 fail, status=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    TLog.b("VideoFramesRetriever", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFramesFetchingQueue");
    }
    ((BlockingQueue)localObject).clear();
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRequestingFrames");
    }
    ((ConcurrentHashMap)localObject).clear();
    localObject = this.jdField_a_of_type_JavaUtilConcurrentExecutorService;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdownNow();
    }
    localObject = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
    if (localObject != null) {
      ((MediaMetadataRetriever)localObject).release();
    }
    jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((a()) && (paramInt1 >= 0) && (paramInt2 >= 0))
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    TLog.b("VideoFramesRetriever", localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoFramesRetriever
 * JD-Core Version:    0.7.0.1
 */