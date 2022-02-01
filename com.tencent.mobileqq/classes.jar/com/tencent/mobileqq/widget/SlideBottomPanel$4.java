package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class SlideBottomPanel$4
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideBottomPanel$4(SlideBottomPanel paramSlideBottomPanel, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = paramValueAnimator.getAnimatedValue();
    if ((localObject instanceof Float))
    {
      paramValueAnimator = this.a;
      localObject = (Float)localObject;
      paramValueAnimator.setY(((Float)localObject).floatValue());
      if (this.b.z != null) {
        this.b.z.fadeBackground(1.0F - ((Float)localObject).floatValue() / (this.b.h - this.b.p));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.4
 * JD-Core Version:    0.7.0.1
 */