package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.view.ViewGroup;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCaptureView;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ImageUpdateListener;", "getCandidateView", "Landroid/view/ViewGroup;", "getPreviewImageCount", "", "getPreviewImageHeight", "getPreviewImageWidth", "onCandidateVideoPrepared", "", "duration", "", "onIndicatorChange", "percent", "", "isDoingLongPress", "", "onPreviewImageListInitialized", "dataList", "", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "onPreviewImageListRefresh", "onPreviewImageLoaded", "dataPosition", "captureTask", "onPreviewImageUpdate", "path", "", "onPreviewVideoPrepared", "durationInMills", "onSeekCandidateImage", "position", "showCoverProcessDialog", "isVisible", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface VideoCaptureContract$IVideoCaptureView
  extends ImageUpdateListener
{
  public abstract void a(float paramFloat, boolean paramBoolean);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, @NotNull CaptureTask paramCaptureTask);
  
  public abstract void a(long paramLong);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(@NotNull List<CaptureTask> paramList);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(long paramLong);
  
  public abstract void b(@NotNull List<CaptureTask> paramList);
  
  @NotNull
  public abstract ViewGroup getCandidateView();
  
  public abstract int getPreviewImageCount();
  
  public abstract int getPreviewImageHeight();
  
  public abstract int getPreviewImageWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureContract.IVideoCaptureView
 * JD-Core Version:    0.7.0.1
 */