package com.tencent.mobileqq.mini.appbrand.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;

class CapsuleButton$8$1
  implements Animator.AnimatorListener
{
  CapsuleButton$8$1(CapsuleButton.8 param8) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$1.this$0.updateRedDotVisible();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$1.this$0.updateRedDotVisible();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AppBrandTask.runTaskOnUiThread(new CapsuleButton.8.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.8.1
 * JD-Core Version:    0.7.0.1
 */