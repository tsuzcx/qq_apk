package com.tencent.mobileqq.kandian.glue.viola;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CommonSuspensionGestureLayout$7
  implements Animation.AnimationListener
{
  CommonSuspensionGestureLayout$7(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.f(this.c).setVisibility(8);
    CommonSuspensionGestureLayout.g(this.c).a(true, this.a, this.b);
    CommonSuspensionGestureLayout.d(this.c, this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.7
 * JD-Core Version:    0.7.0.1
 */