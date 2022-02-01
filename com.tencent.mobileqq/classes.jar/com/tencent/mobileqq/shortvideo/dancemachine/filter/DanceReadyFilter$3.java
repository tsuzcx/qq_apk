package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource;
import java.util.List;

class DanceReadyFilter$3
  implements Animation.AnimationListener
{
  DanceReadyFilter$3(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (DanceReadyFilter.access$500(this.this$0) > 0)
    {
      DanceReadyFilter.access$1000(this.this$0).setImageRes((String)DanceReadyFilter.access$600(this.this$0).mReadyResource.readyNums.get(DanceReadyFilter.access$500(this.this$0) - 1));
      if (DanceReadyFilter.access$1100(this.this$0) != null)
      {
        DanceReadyFilter.access$1100(this.this$0).setStartOffset(300L);
        DanceReadyFilter.access$1000(this.this$0).clearAnimation();
        DanceReadyFilter.access$1000(this.this$0).startAnimation(DanceReadyFilter.access$1100(this.this$0));
      }
      return;
    }
    DanceReadyFilter.access$1000(this.this$0).setVisibility(false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    DanceReadyFilter.access$910(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter.3
 * JD-Core Version:    0.7.0.1
 */