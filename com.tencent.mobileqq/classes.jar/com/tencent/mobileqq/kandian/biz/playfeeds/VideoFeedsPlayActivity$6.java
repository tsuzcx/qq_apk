package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

class VideoFeedsPlayActivity$6
  implements TopGestureLayout.OnGestureListener
{
  VideoFeedsPlayActivity$6(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void flingLToR()
  {
    if ((VideoFeedsPlayActivity.h(this.a) != null) && (VideoFeedsPlayActivity.h(this.a).g())) {
      return;
    }
    VideoFeedsPlayActivity.a(this.a, true);
    this.a.d();
  }
  
  public void flingRToL()
  {
    if (VideoFeedsPlayActivity.h(this.a) != null) {
      VideoFeedsPlayActivity.h(this.a).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity.6
 * JD-Core Version:    0.7.0.1
 */