package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.StartResource;

class DanceReadyFilter$4
  implements Animation.AnimationListener
{
  DanceReadyFilter$4(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.mDanceManager.getContext().playSound(DanceReadyFilter.access$600(this.this$0).mStartResource.startSound);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter.4
 * JD-Core Version:    0.7.0.1
 */