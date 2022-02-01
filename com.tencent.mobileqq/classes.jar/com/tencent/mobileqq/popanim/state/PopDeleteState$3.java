package com.tencent.mobileqq.popanim.state;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.mobileqq.utils.ViewUtils;

class PopDeleteState$3
  implements Animator.AnimatorListener
{
  PopDeleteState$3(PopDeleteState paramPopDeleteState) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.a();
    PopOutAnimViewHelper.a(4, new View[] { PopDeleteState.a(this.a), PopDeleteState.a(this.a) });
    PopDeleteState.a(this.a).setTranslationY(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a();
    PopOutAnimViewHelper.a(4, new View[] { PopDeleteState.a(this.a), PopDeleteState.a(this.a) });
    PopDeleteState.a(this.a).setTranslationY(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    PopDeleteState.a(this.a).setTranslationY(0.0F);
    PopDeleteState.a(this.a).getLayoutParams().height = ViewUtils.b(95.0F);
    PopDeleteState.a(this.a).setBackgroundResource(2130839636);
    PopDeleteState.a(this.a).requestLayout();
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.PopDeleteState.3
 * JD-Core Version:    0.7.0.1
 */