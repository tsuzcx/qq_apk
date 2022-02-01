package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter$1", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "captureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCapturePresenter$1
  implements CaptureTask.OnCaptureCallback
{
  public void a() {}
  
  public void a(@Nullable Bitmap paramBitmap, @NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "captureTask");
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = VideoCapturePresenter.a(this.a);
    if (localIVideoCaptureView != null) {
      localIVideoCaptureView.a(paramBitmap);
    }
    VideoCapturePresenter.a(this.a, paramBitmap, paramCaptureTask.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter.1
 * JD-Core Version:    0.7.0.1
 */