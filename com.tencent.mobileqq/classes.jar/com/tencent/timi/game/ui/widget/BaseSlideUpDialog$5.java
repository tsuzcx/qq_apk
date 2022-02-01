package com.tencent.timi.game.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class BaseSlideUpDialog$5
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseSlideUpDialog$5(BaseSlideUpDialog paramBaseSlideUpDialog, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (!BaseSlideUpDialog.a(this.b)) {
      BaseSlideUpDialog.b(this.b).setTranslationY(this.a * f);
    } else {
      BaseSlideUpDialog.b(this.b).setTranslationX(this.a * f);
    }
    paramValueAnimator = this.b;
    BaseSlideUpDialog.a(paramValueAnimator, BaseSlideUpDialog.d(paramValueAnimator), (1.0F - f) * 0.7F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseSlideUpDialog.5
 * JD-Core Version:    0.7.0.1
 */