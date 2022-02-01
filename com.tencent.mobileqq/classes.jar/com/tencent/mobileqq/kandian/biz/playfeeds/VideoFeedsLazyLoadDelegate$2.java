package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.biz.qqstory.view.widget.DragFrameLayout;

class VideoFeedsLazyLoadDelegate$2
  implements Runnable
{
  VideoFeedsLazyLoadDelegate$2(VideoFeedsLazyLoadDelegate paramVideoFeedsLazyLoadDelegate, DragFrameLayout paramDragFrameLayout) {}
  
  public void run()
  {
    DragFrameLayout localDragFrameLayout = this.a;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a(200, new VideoFeedsPlayActivity.EaseInInterpolator());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLazyLoadDelegate.2
 * JD-Core Version:    0.7.0.1
 */