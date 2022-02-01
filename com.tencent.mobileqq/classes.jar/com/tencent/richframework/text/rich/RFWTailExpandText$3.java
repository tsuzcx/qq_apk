package com.tencent.richframework.text.rich;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.text.SpannableStringBuilder;

class RFWTailExpandText$3
  implements Animator.AnimatorListener
{
  RFWTailExpandText$3(RFWTailExpandText paramRFWTailExpandText, SpannableStringBuilder paramSpannableStringBuilder) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.b;
    paramAnimator.setHeight(RFWTailExpandText.c(paramAnimator));
    RFWTailExpandText.b(this.b, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    RFWTailExpandText.b(this.b, true);
    this.b.setText(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.RFWTailExpandText.3
 * JD-Core Version:    0.7.0.1
 */