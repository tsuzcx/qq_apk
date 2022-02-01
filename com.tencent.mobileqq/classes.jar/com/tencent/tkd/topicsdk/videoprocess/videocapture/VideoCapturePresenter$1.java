package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter$1", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "captureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCapturePresenter$1
  implements CaptureTask.OnCaptureCallback
{
  public void a()
  {
    Log.d("VideoCapturePresenter", "onCaptureFailed");
  }
  
  public void a(@Nullable Bitmap paramBitmap, @NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "captureTask");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCaptureSuccess: position: ");
    ((StringBuilder)localObject).append(paramCaptureTask.a());
    Log.d("VideoCapturePresenter", ((StringBuilder)localObject).toString());
    localObject = VideoCapturePresenter.a(this.a);
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).a(paramBitmap);
    }
    this.a.a(paramBitmap);
    this.a.a(paramCaptureTask.a());
    VideoCapturePresenter.a(this.a, paramBitmap, paramCaptureTask.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter.1
 * JD-Core Version:    0.7.0.1
 */