package com.tencent.mobileqq.kandian.glue.viola;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CommonSuspensionGestureLayout$8
  implements Animation.AnimationListener
{
  CommonSuspensionGestureLayout$8(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.g(this.b).a(false, this.a, 2);
    CommonSuspensionGestureLayout.d(this.b, 2);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.8
 * JD-Core Version:    0.7.0.1
 */