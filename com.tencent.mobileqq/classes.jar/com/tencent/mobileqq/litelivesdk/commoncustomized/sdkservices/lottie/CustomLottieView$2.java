package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class CustomLottieView$2
  extends D8SafeAnimatorListener
{
  CustomLottieView$2(CustomLottieView paramCustomLottieView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView.2
 * JD-Core Version:    0.7.0.1
 */