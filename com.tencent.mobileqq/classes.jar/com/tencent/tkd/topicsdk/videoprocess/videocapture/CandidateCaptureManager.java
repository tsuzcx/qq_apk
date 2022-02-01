package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.view.ViewGroup;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CandidateCaptureManager;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "Landroid/media/MediaPlayer$OnSeekCompleteListener;", "()V", "captureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "currentCaptureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "executor", "Ljava/util/concurrent/ExecutorService;", "height", "", "onCaptureCallback", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "position", "getPosition", "()I", "setPosition", "(I)V", "width", "cancelCurrentCaptureTask", "", "doCapture", "init", "containerView", "Landroid/view/ViewGroup;", "listener", "onCapturePrepared", "duration", "", "onSeekComplete", "mp", "Landroid/media/MediaPlayer;", "seekCandidateImage", "setFinalCaptureCallback", "captureCallback", "stop", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CandidateCaptureManager
  implements MediaPlayer.OnSeekCompleteListener, CapturePreparedListener
{
  private int jdField_a_of_type_Int = -1;
  private CaptureTask.OnCaptureCallback jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback;
  private CaptureTask jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask;
  private final ICaptureProxy jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy = (ICaptureProxy)new SystemCaptureProxy(true);
  private VideoCaptureView.CaptureVideoInfo jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
  private final ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private int b;
  private int c;
  
  public CandidateCaptureManager()
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    Intrinsics.checkExpressionValueIsNotNull(localExecutorService, "Executors.newSingleThreadExecutor()");
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = localExecutorService;
  }
  
  private final void b()
  {
    c();
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    localObject = new CaptureTask(2, ((VideoCaptureView.CaptureVideoInfo)localObject).a(), this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask = ((CaptureTask)localObject);
    ((CaptureTask)localObject).a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy);
    ((CaptureTask)localObject).executeOnExecutor((Executor)this.jdField_a_of_type_JavaUtilConcurrentExecutorService, new Unit[] { null });
  }
  
  private final void c()
  {
    CaptureTask localCaptureTask = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask;
    if (localCaptureTask != null) {
      localCaptureTask.cancel(true);
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask = ((CaptureTask)null);
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback = ((CaptureTask.OnCaptureCallback)null);
    c();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
  }
  
  public final void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a(paramInt, (MediaPlayer.OnSeekCompleteListener)this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public final void a(@Nullable CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback = paramOnCaptureCallback;
  }
  
  public final void a(@NotNull VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo, @Nullable ViewGroup paramViewGroup, @NotNull CapturePreparedListener paramCapturePreparedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureVideoInfo, "captureVideoInfo");
    Intrinsics.checkParameterIsNotNull(paramCapturePreparedListener, "listener");
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo = paramCaptureVideoInfo;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a(paramCaptureVideoInfo, paramViewGroup);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a(paramCapturePreparedListener);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a((CapturePreparedListener)this);
  }
  
  public void onSeekComplete(@Nullable MediaPlayer paramMediaPlayer)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.CandidateCaptureManager
 * JD-Core Version:    0.7.0.1
 */