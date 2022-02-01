package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoMaskController$showVideoMaskForAWhile$1
  implements Runnable
{
  VideoMaskController$showVideoMaskForAWhile$1(VideoMaskController paramVideoMaskController) {}
  
  public final void run()
  {
    if ((VideoMaskController.a(this.this$0).isPlaying()) && (!this.this$0.a()))
    {
      VideoMaskController.d(this.this$0);
      return;
    }
    VideoMaskController.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoMaskController.showVideoMaskForAWhile.1
 * JD-Core Version:    0.7.0.1
 */