package com.tencent.superplayer.seamless;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class VideoMoveAnimator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoMoveAnimator$1(VideoMoveAnimator paramVideoMoveAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator != null)
    {
      if (paramValueAnimator.getAnimatedValue() == null) {
        return;
      }
      ViewGroup.LayoutParams localLayoutParams = VideoMoveAnimator.access$000(this.this$0).getLayoutParams();
      localLayoutParams.width = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      VideoMoveAnimator.access$000(this.this$0).setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.seamless.VideoMoveAnimator.1
 * JD-Core Version:    0.7.0.1
 */