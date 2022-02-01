package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class VideoFeedsGuideView$GuideViewMoveAnimateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private VideoFeedsGuideView$GuideViewMoveAnimateListener(VideoFeedsGuideView paramVideoFeedsGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (VideoFeedsGuideView.b(this.a) == 1)
    {
      VideoFeedsGuideView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      paramValueAnimator = this.a;
      VideoFeedsGuideView.b(paramValueAnimator, VideoFeedsGuideView.c(paramValueAnimator) + VideoFeedsGuideView.d(this.a));
    }
    else
    {
      VideoFeedsGuideView.c(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      paramValueAnimator = this.a;
      VideoFeedsGuideView.d(paramValueAnimator, VideoFeedsGuideView.c(paramValueAnimator) + VideoFeedsGuideView.e(this.a));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGuideView.GuideViewMoveAnimateListener
 * JD-Core Version:    0.7.0.1
 */