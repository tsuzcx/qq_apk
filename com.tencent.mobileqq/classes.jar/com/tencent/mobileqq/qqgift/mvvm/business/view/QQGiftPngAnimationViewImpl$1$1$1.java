package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;

class QQGiftPngAnimationViewImpl$1$1$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QQGiftPngAnimationViewImpl$1$1$1(QQGiftPngAnimationViewImpl.1.1 param1) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i;
    if (f < 300.0F) {
      i = (int)(f / 300.0F * 255.0F);
    } else if ((1300.0F < f) && (f <= 1600.0F)) {
      i = (int)((1.0F - (f - 1300.0F) / 300.0F) * 255.0F);
    } else {
      i = 255;
    }
    QQGiftPngAnimationViewImpl.a(this.a.a.this$0).setAlpha(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPngAnimationViewImpl.1.1.1
 * JD-Core Version:    0.7.0.1
 */