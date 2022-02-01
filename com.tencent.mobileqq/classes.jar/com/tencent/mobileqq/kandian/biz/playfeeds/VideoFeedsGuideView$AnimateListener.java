package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class VideoFeedsGuideView$AnimateListener
  extends AnimatorListenerAdapter
{
  private VideoFeedsGuideView$AnimateListener(VideoFeedsGuideView paramVideoFeedsGuideView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    VideoFeedsGuideView.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoFeedsGuideView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGuideView.AnimateListener
 * JD-Core Version:    0.7.0.1
 */