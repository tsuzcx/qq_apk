package com.tencent.timi.game.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class BaseSlideUpDialog$6
  extends AnimatorListenerAdapter
{
  BaseSlideUpDialog$6(BaseSlideUpDialog paramBaseSlideUpDialog, float paramFloat) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (!BaseSlideUpDialog.a(this.b)) {
      BaseSlideUpDialog.b(this.b).setTranslationY(this.a);
    } else {
      BaseSlideUpDialog.b(this.b).setTranslationX(this.a);
    }
    paramAnimator = this.b;
    BaseSlideUpDialog.a(paramAnimator, BaseSlideUpDialog.d(paramAnimator), 0.0F);
    BaseSlideUpDialog.e(this.b);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!BaseSlideUpDialog.a(this.b)) {
      BaseSlideUpDialog.b(this.b).setTranslationY(this.a);
    } else {
      BaseSlideUpDialog.b(this.b).setTranslationX(this.a);
    }
    paramAnimator = this.b;
    BaseSlideUpDialog.a(paramAnimator, BaseSlideUpDialog.d(paramAnimator), 0.0F);
    BaseSlideUpDialog.f(this.b);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (!BaseSlideUpDialog.a(this.b)) {
      BaseSlideUpDialog.b(this.b).setTranslationY(0.0F);
    } else {
      BaseSlideUpDialog.b(this.b).setTranslationX(0.0F);
    }
    paramAnimator = this.b;
    BaseSlideUpDialog.a(paramAnimator, BaseSlideUpDialog.d(paramAnimator), 0.7F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseSlideUpDialog.6
 * JD-Core Version:    0.7.0.1
 */