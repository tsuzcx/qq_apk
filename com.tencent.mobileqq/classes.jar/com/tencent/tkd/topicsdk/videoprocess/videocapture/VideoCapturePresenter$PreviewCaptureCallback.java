package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter$PreviewCaptureCallback;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "dataPosition", "", "(Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter;I)V", "getDataPosition", "()I", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "captureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "topicsdk_release"}, k=1, mv={1, 1, 16})
final class VideoCapturePresenter$PreviewCaptureCallback
  implements CaptureTask.OnCaptureCallback
{
  private final int jdField_a_of_type_Int;
  
  public VideoCapturePresenter$PreviewCaptureCallback(int paramInt)
  {
    int i;
    this.jdField_a_of_type_Int = i;
  }
  
  public void a() {}
  
  public void a(@Nullable Bitmap paramBitmap, @NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "captureTask");
    paramBitmap = VideoCapturePresenter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter);
    if (paramBitmap != null) {
      paramBitmap.a(this.jdField_a_of_type_Int, paramCaptureTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter.PreviewCaptureCallback
 * JD-Core Version:    0.7.0.1
 */