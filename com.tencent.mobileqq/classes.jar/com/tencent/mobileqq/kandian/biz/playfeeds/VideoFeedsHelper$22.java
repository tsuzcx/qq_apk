package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.WindowManager;

final class VideoFeedsHelper$22
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      paramValueAnimator = (Point)paramValueAnimator.getAnimatedValue();
      this.c.y = paramValueAnimator.y;
      this.c.x = paramValueAnimator.x;
      this.a.updateViewLayout(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.22
 * JD-Core Version:    0.7.0.1
 */