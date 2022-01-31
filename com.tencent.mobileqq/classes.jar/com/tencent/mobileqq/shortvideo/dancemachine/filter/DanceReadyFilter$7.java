package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource;

class DanceReadyFilter$7
  implements Animation.AnimationListener
{
  DanceReadyFilter$7(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceReadyFilter.access$1000(this.this$0).setVisibility(true);
    DanceReadyFilter.access$1000(this.this$0).startAnimation(DanceReadyFilter.access$1100(this.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.mDanceManager.getContext().playSound(DanceReadyFilter.access$600(this.this$0).mReadyResource.readySound);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter.7
 * JD-Core Version:    0.7.0.1
 */