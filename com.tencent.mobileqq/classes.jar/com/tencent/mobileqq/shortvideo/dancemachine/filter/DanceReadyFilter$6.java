package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;

class DanceReadyFilter$6
  implements Animation.AnimationListener
{
  DanceReadyFilter$6(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceReadyFilter.access$700(this.this$0).setVisibility(false);
    DanceReadyFilter.access$1200(this.this$0).startAnimation(DanceReadyFilter.access$1300(this.this$0));
    DanceReadyFilter.access$1200(this.this$0).setVisibility(true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter.6
 * JD-Core Version:    0.7.0.1
 */