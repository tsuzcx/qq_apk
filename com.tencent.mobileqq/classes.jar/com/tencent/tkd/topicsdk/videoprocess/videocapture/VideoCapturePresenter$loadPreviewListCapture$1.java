package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter$loadPreviewListCapture$1", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "onCapturePrepared", "", "width", "", "height", "duration", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCapturePresenter$loadPreviewListCapture$1
  implements CapturePreparedListener
{
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = VideoCapturePresenter.a(this.a);
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).b(paramLong);
    }
    localObject = this.a;
    ((VideoCapturePresenter)localObject).b((int)(((VideoCapturePresenter)localObject).b() * (float)paramLong));
    localObject = VideoCapturePresenter.a(this.a);
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).a(this.a.b(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter.loadPreviewListCapture.1
 * JD-Core Version:    0.7.0.1
 */