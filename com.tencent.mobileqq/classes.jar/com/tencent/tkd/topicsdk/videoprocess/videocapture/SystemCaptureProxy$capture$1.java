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
    if (SystemCaptureProxy.a(this.this$0)) {
      TLog.b("SystemCaptureProxy", "capture return for released.");
    }
    label136:
    Object localObject2;
    label231:
    do
    {
      return;
      TLog.b("SystemCaptureProxy", "capture captureTask:" + this.$captureTask + "  useScaleAPI:" + SystemCaptureProxy.b(this.this$0));
      for (Object localObject1 = (Bitmap)null;; localObject1 = localObject3)
      {
        try
        {
          if ((!SystemCaptureProxy.b(this.this$0)) || (Build.VERSION.SDK_INT < 27)) {
            break label136;
          }
          localObject3 = SystemCaptureProxy.a(this.this$0, SystemCaptureProxy.a(this.this$0), this.$captureTask);
          localObject1 = localObject3;
        }
        catch (Error localError)
        {
          for (;;)
          {
            Object localObject3;
            SystemCaptureProxy.a(this.this$0, false);
            localObject2 = SystemCaptureProxy.b(this.this$0, SystemCaptureProxy.a(this.this$0), this.$captureTask);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            TLog.d("SystemCaptureProxy", "capture failed for captureTask" + this.$captureTask + ", " + localException);
          }
          localObject2 = this.$captureCallback;
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label231;
        }
        localObject3 = this.$captureCallback;
        if (localObject3 == null) {
          break;
        }
        ((CaptureTask.OnCaptureCallback)localObject3).a((Bitmap)localObject1, this.$captureTask);
        return;
        localObject3 = SystemCaptureProxy.b(this.this$0, SystemCaptureProxy.a(this.this$0), this.$captureTask);
      }
    } while (localObject2 == null);
    ((CaptureTask.OnCaptureCallback)localObject2).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.SystemCaptureProxy.capture.1
 * JD-Core Version:    0.7.0.1
 */