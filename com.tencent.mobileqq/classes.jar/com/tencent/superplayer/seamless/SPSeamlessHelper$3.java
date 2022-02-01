package com.tencent.superplayer.seamless;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SPSeamlessHelper$3
  implements Animation.AnimationListener
{
  SPSeamlessHelper$3(SPSeamlessHelper paramSPSeamlessHelper, boolean paramBoolean, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$toViewGone) {
      this.val$contentView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.seamless.SPSeamlessHelper.3
 * JD-Core Version:    0.7.0.1
 */