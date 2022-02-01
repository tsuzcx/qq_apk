package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class SystemCaptureProxy$capture$1
  extends Lambda
  implements Function0<Unit>
{
  SystemCaptureProxy$capture$1(SystemCaptureProxy paramSystemCaptureProxy, CaptureTask paramCaptureTask, CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (SystemCaptureProxy.a(this.this$0))
    {
      TLog.b("SystemCaptureProxy", "capture return for released.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("capture captureTask: ");
    ((StringBuilder)localObject).append(this.$captureTask);
    ((StringBuilder)localObject).append(" useScaleAPI: ");
    ((StringBuilder)localObject).append(SystemCaptureProxy.b(this.this$0));
    TLog.b("SystemCaptureProxy", ((StringBuilder)localObject).toString());
    localObject = (Bitmap)null;
    int i;
    if (SystemCaptureProxy.c(this.this$0)) {
      i = 3;
    } else {
      i = 2;
    }
    try
    {
      try
      {
        Bitmap localBitmap;
        if ((SystemCaptureProxy.b(this.this$0)) && (Build.VERSION.SDK_INT >= 27))
        {
          localBitmap = SystemCaptureProxy.a(this.this$0, i, this.$captureTask);
          localObject = localBitmap;
        }
        else
        {
          localBitmap = SystemCaptureProxy.b(this.this$0, i, this.$captureTask);
          localObject = localBitmap;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("capture failed for captureTask");
        localStringBuilder.append(this.$captureTask);
        localStringBuilder.append(", ");
        localStringBuilder.append(localException);
        TLog.d("SystemCaptureProxy", localStringBuilder.toString());
      }
    }
    catch (Error localError)
    {
      label202:
      CaptureTask.OnCaptureCallback localOnCaptureCallback;
      break label202;
    }
    SystemCaptureProxy.a(this.this$0, false);
    localObject = SystemCaptureProxy.b(this.this$0, i, this.$captureTask);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      TLog.b("SystemCaptureProxy", "captureCallback.onCaptureSuccess");
      localOnCaptureCallback = this.$captureCallback;
      if (localOnCaptureCallback != null) {
        localOnCaptureCallback.a((Bitmap)localObject, this.$captureTask);
      }
    }
    else
    {
      TLog.b("SystemCaptureProxy", "captureCallback.onCaptureFailed");
      localObject = this.$captureCallback;
      if (localObject != null) {
        ((CaptureTask.OnCaptureCallback)localObject).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.SystemCaptureProxy.capture.1
 * JD-Core Version:    0.7.0.1
 */