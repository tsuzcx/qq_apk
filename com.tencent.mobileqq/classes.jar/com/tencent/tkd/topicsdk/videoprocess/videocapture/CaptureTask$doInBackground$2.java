package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$doInBackground$2", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "captureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CaptureTask$doInBackground$2
  implements CaptureTask.OnCaptureCallback
{
  CaptureTask$doInBackground$2(Bitmap[] paramArrayOfBitmap) {}
  
  public void a()
  {
    CaptureTask.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask);
    if (CaptureTask.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask) <= 3)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCaptureFailed try angin tryCount: ");
      localStringBuilder.append(CaptureTask.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask));
      localStringBuilder.append(" CaptureTask: ");
      localStringBuilder.append(this);
      TLog.b("CaptureTask", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask.a(new Unit[] { null });
    }
  }
  
  public void a(@Nullable Bitmap paramBitmap, @NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "captureTask");
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = paramBitmap;
    CaptureTask.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.CaptureTask.doInBackground.2
 * JD-Core Version:    0.7.0.1
 */