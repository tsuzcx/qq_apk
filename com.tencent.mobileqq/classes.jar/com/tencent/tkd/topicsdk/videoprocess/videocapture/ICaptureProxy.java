package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.media.MediaPlayer.OnSeekCompleteListener;
import android.view.ViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "", "videoDuration", "", "getVideoDuration", "()J", "addCapturePreparedListener", "", "listener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "capture", "captureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "captureCallback", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "init", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "containerView", "Landroid/view/ViewGroup;", "release", "seek", "position", "", "seekCompleteListener", "Landroid/media/MediaPlayer$OnSeekCompleteListener;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface ICaptureProxy
{
  public abstract long a();
  
  public abstract void a();
  
  public abstract void a(int paramInt, @Nullable MediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void a(@NotNull CapturePreparedListener paramCapturePreparedListener);
  
  public abstract void a(@NotNull CaptureTask paramCaptureTask, @Nullable CaptureTask.OnCaptureCallback paramOnCaptureCallback);
  
  public abstract void a(@NotNull VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo, @Nullable ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.ICaptureProxy
 * JD-Core Version:    0.7.0.1
 */