package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

class VideoFeedsPlayActivity$6
  implements TopGestureLayout.OnGestureListener
{
  VideoFeedsPlayActivity$6(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void flingLToR()
  {
    if ((VideoFeedsPlayActivity.a(this.a) != null) && (VideoFeedsPlayActivity.a(this.a).a())) {
      return;
    }
    VideoFeedsPlayActivity.a(this.a, true);
    this.a.e();
  }
  
  public void flingRToL()
  {
    if (VideoFeedsPlayActivity.a(this.a) != null) {
      VideoFeedsPlayActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity.6
 * JD-Core Version:    0.7.0.1
 */