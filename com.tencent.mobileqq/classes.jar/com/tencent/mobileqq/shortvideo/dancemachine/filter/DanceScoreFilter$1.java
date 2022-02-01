package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;

class DanceScoreFilter$1
  implements Animation.AnimationListener
{
  DanceScoreFilter$1(DanceScoreFilter paramDanceScoreFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceScoreFilter.access$000(this.this$0).setVisibility(true);
    if (DanceScoreFilter.access$100(this.this$0) != null) {
      DanceScoreFilter.access$000(this.this$0).startAnimation(DanceScoreFilter.access$100(this.this$0));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceScoreFilter.1
 * JD-Core Version:    0.7.0.1
 */