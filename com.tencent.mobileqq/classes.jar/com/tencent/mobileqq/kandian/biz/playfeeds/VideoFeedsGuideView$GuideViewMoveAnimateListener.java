package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class VideoFeedsGuideView$GuideViewMoveAnimateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private VideoFeedsGuideView$GuideViewMoveAnimateListener(VideoFeedsGuideView paramVideoFeedsGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (VideoFeedsGuideView.a(this.a) == 1)
    {
      VideoFeedsGuideView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      paramValueAnimator = this.a;
      VideoFeedsGuideView.b(paramValueAnimator, VideoFeedsGuideView.b(paramValueAnimator) + VideoFeedsGuideView.c(this.a));
    }
    else
    {
      VideoFeedsGuideView.c(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      paramValueAnimator = this.a;
      VideoFeedsGuideView.d(paramValueAnimator, VideoFeedsGuideView.b(paramValueAnimator) + VideoFeedsGuideView.d(this.a));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGuideView.GuideViewMoveAnimateListener
 * JD-Core Version:    0.7.0.1
 */