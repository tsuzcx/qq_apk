package com.tencent.richframework.text.rich;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.text.SpannableStringBuilder;

class RFWTailExpandText$5
  implements Animator.AnimatorListener
{
  RFWTailExpandText$5(RFWTailExpandText paramRFWTailExpandText, SpannableStringBuilder paramSpannableStringBuilder) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.setText(this.a);
    paramAnimator = this.b;
    paramAnimator.setHeight(RFWTailExpandText.d(paramAnimator));
    RFWTailExpandText.b(this.b, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    RFWTailExpandText.b(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.RFWTailExpandText.5
 * JD-Core Version:    0.7.0.1
 */