package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CapturePreparedListener;

class VideoCapturePresenter$2
  implements CapturePreparedListener
{
  VideoCapturePresenter$2(VideoCapturePresenter paramVideoCapturePresenter) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    VideoCapturePresenter.a(this.a).b(paramLong);
    VideoCapturePresenter localVideoCapturePresenter = this.a;
    localVideoCapturePresenter.a((int)(VideoCapturePresenter.a(localVideoCapturePresenter) * (float)paramLong));
    VideoCapturePresenter.a(this.a).a(VideoCapturePresenter.a(this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.VideoCapturePresenter.2
 * JD-Core Version:    0.7.0.1
 */