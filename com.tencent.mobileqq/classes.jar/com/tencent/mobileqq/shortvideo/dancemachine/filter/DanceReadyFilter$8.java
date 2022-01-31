package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLMaskImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

class DanceReadyFilter$8
  implements Animation.AnimationListener
{
  DanceReadyFilter$8(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceReadyFilter.access$700(this.this$0).setVisibility(true);
    DanceReadyFilter.access$1500(this.this$0).setVisibility(true);
    DanceReadyFilter.access$100(this.this$0).setVisibility(false);
    DanceReadyFilter.access$700(this.this$0).startAnimation(DanceReadyFilter.access$1600(this.this$0));
    DanceReadyFilter.access$1500(this.this$0).startAnimation(DanceReadyFilter.access$1700(this.this$0));
    paramAnimation = this.this$0.getQQFilterRenderManager().getBusinessOperation().getDanceEventHandler();
    if (paramAnimation != null)
    {
      DanceLog.print("DanceReadyFilter", "readySceneBegin begin...");
      paramAnimation.readySceneBegin(DanceReadyFilter.access$1800(this.this$0));
      DanceLog.print("DanceReadyFilter", "readySceneBegin end...");
      DanceReadyFilter.access$1902(this.this$0, true);
    }
    DanceReadyFilter.access$2000(this.this$0);
    TrAsyncTextureLoad.getInstance().asyncLoadBoyTexture();
    DanceLog.print("DanceReadyFilter", "TrAsyncTextureLoad[enter ready]");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    DanceReadyFilter.access$1400(this.this$0).setVisibility(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter.8
 * JD-Core Version:    0.7.0.1
 */