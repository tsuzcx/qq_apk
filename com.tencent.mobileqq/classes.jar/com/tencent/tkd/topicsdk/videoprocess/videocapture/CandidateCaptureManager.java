package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.view.ViewGroup;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CandidateCaptureManager;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "Landroid/media/MediaPlayer$OnSeekCompleteListener;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnTaskListener;", "()V", "captureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "getCaptureProxy", "()Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "currentCaptureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "executor", "Ljava/util/concurrent/ExecutorService;", "height", "", "isRunningTask", "", "()Z", "setRunningTask", "(Z)V", "onCaptureCallback", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "position", "getPosition", "()I", "setPosition", "(I)V", "width", "cancelCurrentCaptureTask", "", "doCapture", "init", "containerView", "Landroid/view/ViewGroup;", "listener", "onCapturePrepared", "duration", "", "onSeekComplete", "mp", "Landroid/media/MediaPlayer;", "onTaskComplete", "task", "onTaskStart", "seekCandidateImage", "setFinalCaptureCallback", "captureCallback", "stop", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CandidateCaptureManager
  implements MediaPlayer.OnSeekCompleteListener, CapturePreparedListener, CaptureTask.OnTaskListener
{
  public static final CandidateCaptureManager.Companion a = new CandidateCaptureManager.Companion(null);
  @NotNull
  private final ICaptureProxy b = (ICaptureProxy)new SystemCaptureProxy(true);
  private int c = -1;
  private VideoCaptureView.CaptureVideoInfo d;
  private int e;
  private int f;
  private CaptureTask.OnCaptureCallback g;
  private CaptureTask h;
  private final ExecutorService i;
  private boolean j;
  
  public CandidateCaptureManager()
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    Intrinsics.checkExpressionValueIsNotNull(localExecutorService, "Executors.newSingleThreadExecutor()");
    this.i = localExecutorService;
  }
  
  private final void c()
  {
    d();
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    localObject = new CaptureTask(2, ((VideoCaptureView.CaptureVideoInfo)localObject).f(), this.c, this.e, this.f, this.g);
    this.h = ((CaptureTask)localObject);
    ((CaptureTask)localObject).a((CaptureTask.OnTaskListener)this);
    ((CaptureTask)localObject).a(this.b);
    ((CaptureTask)localObject).executeOnExecutor((Executor)this.i, new Unit[] { null });
  }
  
  private final void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelCurrentCaptureTask id: ");
    Object localObject = this.h;
    if (localObject != null) {
      localObject = ((CaptureTask)localObject).a();
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    TLog.b("CandidateCaptureManager", localStringBuilder.toString());
    localObject = this.h;
    if (localObject != null) {
      ((CaptureTask)localObject).cancel(true);
    }
    this.h = ((CaptureTask)null);
  }
  
  @NotNull
  public final ICaptureProxy a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    if (this.c == paramInt) {
      return;
    }
    this.c = paramInt;
    this.b.a(paramInt, (MediaPlayer.OnSeekCompleteListener)this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public final void a(@Nullable CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.g = paramOnCaptureCallback;
  }
  
  public void a(@NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "task");
    this.j = true;
  }
  
  public final void a(@NotNull VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo, @Nullable ViewGroup paramViewGroup, @NotNull CapturePreparedListener paramCapturePreparedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureVideoInfo, "captureVideoInfo");
    Intrinsics.checkParameterIsNotNull(paramCapturePreparedListener, "listener");
    this.d = paramCaptureVideoInfo;
    this.b.a(paramCaptureVideoInfo, paramViewGroup);
    this.b.a(paramCapturePreparedListener);
    this.b.a((CapturePreparedListener)this);
  }
  
  public final void b()
  {
    this.g = ((CaptureTask.OnCaptureCallback)null);
    d();
    this.b.b();
    this.i.shutdown();
  }
  
  public void b(@NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "task");
    String str = paramCaptureTask.a();
    paramCaptureTask = this.h;
    if (paramCaptureTask != null) {
      paramCaptureTask = paramCaptureTask.a();
    } else {
      paramCaptureTask = null;
    }
    if (Intrinsics.areEqual(str, paramCaptureTask)) {
      this.j = false;
    }
  }
  
  public void onSeekComplete(@Nullable MediaPlayer paramMediaPlayer)
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.CandidateCaptureManager
 * JD-Core Version:    0.7.0.1
 */