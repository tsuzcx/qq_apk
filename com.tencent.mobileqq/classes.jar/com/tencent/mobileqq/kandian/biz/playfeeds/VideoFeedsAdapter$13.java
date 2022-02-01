package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;

class VideoFeedsAdapter$13
  implements Runnable
{
  VideoFeedsAdapter$13(VideoFeedsAdapter paramVideoFeedsAdapter, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.h != null) && (this.this$0.h.aA != null)) {
      this.this$0.h.aA.l(this.a);
    }
    if ((this.a) && (!this.this$0.f.k()) && (VideoFeedsAdapter.r(this.this$0) != null))
    {
      VideoFeedsAdapter.r(this.this$0).h();
      return;
    }
    if ((!this.a) && (VideoFeedsHelper.e())) {
      this.this$0.f.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.13
 * JD-Core Version:    0.7.0.1
 */