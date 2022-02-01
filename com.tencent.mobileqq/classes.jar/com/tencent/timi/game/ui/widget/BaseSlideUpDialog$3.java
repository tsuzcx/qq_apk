package com.tencent.timi.game.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class BaseSlideUpDialog$3
  extends AnimatorListenerAdapter
{
  BaseSlideUpDialog$3(BaseSlideUpDialog paramBaseSlideUpDialog) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    BaseSlideUpDialog.b(this.a).setTranslationY(0.0F);
    BaseSlideUpDialog.b(this.a).setTranslationX(0.0F);
    paramAnimator = this.a;
    BaseSlideUpDialog.a(paramAnimator, BaseSlideUpDialog.d(paramAnimator), 0.7F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    BaseSlideUpDialog.b(this.a).setTranslationY(0.0F);
    BaseSlideUpDialog.b(this.a).setTranslationX(0.0F);
    paramAnimator = this.a;
    BaseSlideUpDialog.a(paramAnimator, BaseSlideUpDialog.d(paramAnimator), 0.7F);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    float f1;
    float f2;
    if (!BaseSlideUpDialog.a(this.a))
    {
      f1 = BaseSlideUpDialog.b(this.a).getHeight();
      f2 = BaseSlideUpDialog.c(this.a);
      BaseSlideUpDialog.b(this.a).setTranslationY(f1 * f2);
    }
    else
    {
      f1 = BaseSlideUpDialog.b(this.a).getWidth();
      f2 = BaseSlideUpDialog.c(this.a);
      BaseSlideUpDialog.b(this.a).setTranslationX(f1 * f2);
    }
    if (BaseSlideUpDialog.d(this.a) != null)
    {
      paramAnimator = this.a;
      BaseSlideUpDialog.a(paramAnimator, BaseSlideUpDialog.d(paramAnimator), 0.0F);
      BaseSlideUpDialog.d(this.a).setVisibility(0);
    }
    BaseSlideUpDialog.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseSlideUpDialog.3
 * JD-Core Version:    0.7.0.1
 */