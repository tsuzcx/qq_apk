package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask.OnCaptureCallback;

class VideoCapturePresenter$PreviewCaptureCallback
  implements CaptureTask.OnCaptureCallback
{
  int a = -1;
  
  public VideoCapturePresenter$PreviewCaptureCallback(VideoCapturePresenter paramVideoCapturePresenter, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a() {}
  
  public void a(Bitmap paramBitmap, CaptureTask paramCaptureTask)
  {
    VideoCapturePresenter.a(this.b).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.VideoCapturePresenter.PreviewCaptureCallback
 * JD-Core Version:    0.7.0.1
 */