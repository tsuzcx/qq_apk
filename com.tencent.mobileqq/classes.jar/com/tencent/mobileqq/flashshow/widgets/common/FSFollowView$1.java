package com.tencent.mobileqq.flashshow.widgets.common;

import android.view.animation.AlphaAnimation;

class FSFollowView$1
  implements Runnable
{
  FSFollowView$1(FSFollowView paramFSFollowView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillEnabled(false);
    this.this$0.startAnimation(localAlphaAnimation);
    this.this$0.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSFollowView.1
 * JD-Core Version:    0.7.0.1
 */