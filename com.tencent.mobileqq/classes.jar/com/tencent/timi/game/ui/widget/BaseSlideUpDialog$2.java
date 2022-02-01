package com.tencent.timi.game.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class BaseSlideUpDialog$2
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseSlideUpDialog$2(BaseSlideUpDialog paramBaseSlideUpDialog) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2;
    float f3;
    float f1;
    if (!BaseSlideUpDialog.a(this.a))
    {
      f2 = BaseSlideUpDialog.b(this.a).getHeight();
      f3 = BaseSlideUpDialog.c(this.a);
      f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BaseSlideUpDialog.b(this.a).setTranslationY(f2 * f3 * f1);
    }
    else
    {
      f2 = BaseSlideUpDialog.b(this.a).getWidth();
      f3 = BaseSlideUpDialog.c(this.a);
      f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BaseSlideUpDialog.b(this.a).setTranslationX(f2 * f3 * f1);
    }
    paramValueAnimator = this.a;
    BaseSlideUpDialog.a(paramValueAnimator, BaseSlideUpDialog.d(paramValueAnimator), (1.0F - f1) * 0.7F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseSlideUpDialog.2
 * JD-Core Version:    0.7.0.1
 */