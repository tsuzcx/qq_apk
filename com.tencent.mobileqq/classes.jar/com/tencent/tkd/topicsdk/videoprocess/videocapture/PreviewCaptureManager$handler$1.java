package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.os.Handler;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/PreviewCaptureManager$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PreviewCaptureManager$handler$1
  extends Handler
{
  public void handleMessage(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "msg");
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    PreviewCaptureManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.PreviewCaptureManager.handler.1
 * JD-Core Version:    0.7.0.1
 */