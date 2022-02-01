package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoPlayController$eventListener$1$onInfo$1
  extends Lambda
  implements Function0<Unit>
{
  VideoPlayController$eventListener$1$onInfo$1(VideoPlayController.eventListener.1 param1, int paramInt)
  {
    super(0);
  }
  
  public final void invoke()
  {
    int i = this.$what;
    VideoView localVideoView;
    if (i != 112)
    {
      if (i != 113) {
        return;
      }
      localVideoView = this.this$0.a.a();
      if (localVideoView != null) {
        localVideoView.hideLoading();
      }
    }
    else
    {
      localVideoView = this.this$0.a.a();
      if (localVideoView != null) {
        localVideoView.showLoading();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.eventListener.1.onInfo.1
 * JD-Core Version:    0.7.0.1
 */