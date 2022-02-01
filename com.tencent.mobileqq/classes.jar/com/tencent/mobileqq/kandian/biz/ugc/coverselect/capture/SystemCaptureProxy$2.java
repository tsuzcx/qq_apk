package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

class SystemCaptureProxy$2
  implements Runnable
{
  SystemCaptureProxy$2(SystemCaptureProxy paramSystemCaptureProxy, CaptureTask paramCaptureTask, CaptureTask.OnCaptureCallback paramOnCaptureCallback) {}
  
  public void run()
  {
    if (SystemCaptureProxy.b(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemCaptureProxy", 2, "capture return for released.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("capture captureTask:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("  useScaleAPI:");
      ((StringBuilder)localObject).append(SystemCaptureProxy.c(this.this$0));
      QLog.d("SystemCaptureProxy", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    try
    {
      try
      {
        Bitmap localBitmap;
        if ((SystemCaptureProxy.c(this.this$0)) && (Build.VERSION.SDK_INT >= 27))
        {
          localBitmap = SystemCaptureProxy.d(this.this$0).getScaledFrameAtTime(this.a.d * 1000, 0, this.a.e, this.a.f);
          localObject = localBitmap;
        }
        else
        {
          localBitmap = SystemCaptureProxy.a(this.this$0, SystemCaptureProxy.d(this.this$0), this.a);
          localObject = localBitmap;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("capture failed for captureTask");
        localStringBuilder.append(this.a);
        QLog.e("SystemCaptureProxy", 1, localStringBuilder.toString(), localThrowable);
      }
    }
    catch (Error localError)
    {
      label210:
      break label210;
    }
    SystemCaptureProxy.a(this.this$0, false);
    localObject = this.this$0;
    localObject = SystemCaptureProxy.a((SystemCaptureProxy)localObject, SystemCaptureProxy.d((SystemCaptureProxy)localObject), this.a);
    if (this.b != null)
    {
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.b.a((Bitmap)localObject, this.a);
        return;
      }
      this.b.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.SystemCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */