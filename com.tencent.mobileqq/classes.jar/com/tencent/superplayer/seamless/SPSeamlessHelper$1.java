package com.tencent.superplayer.seamless;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.superplayer.view.ISPlayerVideoView;

class SPSeamlessHelper$1
  implements Animation.AnimationListener
{
  SPSeamlessHelper$1(SPSeamlessHelper paramSPSeamlessHelper, ISPlayerVideoView paramISPlayerVideoView, ViewGroup paramViewGroup) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((View)this.val$videoView).clearAnimation();
    this.val$parent.post(new SPSeamlessHelper.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.seamless.SPSeamlessHelper.1
 * JD-Core Version:    0.7.0.1
 */