package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter$loadPreviewListCapture$1", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "onCapturePrepared", "", "width", "", "height", "duration", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCapturePresenter$loadPreviewListCapture$1
  implements CapturePreparedListener
{
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = VideoCapturePresenter.a(this.a);
    if (localIVideoCaptureView != null) {
      localIVideoCaptureView.b(paramLong);
    }
    this.a.a((int)(this.a.a() * (float)paramLong));
    localIVideoCaptureView = VideoCapturePresenter.a(this.a);
    if (localIVideoCaptureView != null) {
      localIVideoCaptureView.a(this.a.a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter.loadPreviewListCapture.1
 * JD-Core Version:    0.7.0.1
 */