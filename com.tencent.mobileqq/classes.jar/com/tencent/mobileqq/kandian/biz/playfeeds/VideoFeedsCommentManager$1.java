package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class VideoFeedsCommentManager$1
  implements Animation.AnimationListener
{
  VideoFeedsCommentManager$1(VideoFeedsCommentManager paramVideoFeedsCommentManager) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (VideoFeedsCommentManager.a(this.a) != null) {
      VideoFeedsCommentManager.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCommentManager.1
 * JD-Core Version:    0.7.0.1
 */