package com.tencent.viola.ui.component;

import android.animation.Animator;
import com.tencent.viola.ui.view.D8SafeAnimatorListener;
import com.tencent.viola.utils.ViolaLogUtils;

class VLottie$1
  extends D8SafeAnimatorListener
{
  VLottie$1(VLottie paramVLottie) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ViolaLogUtils.d("VComponent", "lottie onAnimationCancel");
    VLottie.access$000(this.this$0, 2);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ViolaLogUtils.d("VComponent", "lottie onAnimationEnd");
    VLottie.access$000(this.this$0, 3);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    ViolaLogUtils.d("VComponent", "lottie onAnimationRepeat");
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ViolaLogUtils.d("VComponent", "lottie onAnimationStart");
    VLottie.access$000(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VLottie.1
 * JD-Core Version:    0.7.0.1
 */