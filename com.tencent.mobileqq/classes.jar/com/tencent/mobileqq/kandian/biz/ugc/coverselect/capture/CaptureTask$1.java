package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class CaptureTask$1
  implements CaptureTask.OnCaptureCallback
{
  CaptureTask$1(CaptureTask paramCaptureTask, Bitmap[] paramArrayOfBitmap) {}
  
  public void a()
  {
    CaptureTask.a(this.b);
    if (CaptureTask.b(this.b) <= 3)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCaptureFailed try angin tryCount:");
        localStringBuilder.append(CaptureTask.b(this.b));
        localStringBuilder.append("  CaptureTask:");
        localStringBuilder.append(this.b);
        QLog.d("CaptureTask", 2, localStringBuilder.toString());
      }
      this.b.a(null);
    }
  }
  
  public void a(Bitmap paramBitmap, CaptureTask paramCaptureTask)
  {
    this.a[0] = paramBitmap;
    CaptureTask.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask.1
 * JD-Core Version:    0.7.0.1
 */