package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class SlideBottomPanel$2
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideBottomPanel$2(SlideBottomPanel paramSlideBottomPanel, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = paramValueAnimator.getAnimatedValue();
    if ((localObject instanceof Float))
    {
      paramValueAnimator = this.a;
      localObject = (Float)localObject;
      paramValueAnimator.setY(((Float)localObject).floatValue());
      if (this.c.z != null) {
        this.c.z.fadeBackground(1.0F - ((Float)localObject).floatValue() / this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.2
 * JD-Core Version:    0.7.0.1
 */