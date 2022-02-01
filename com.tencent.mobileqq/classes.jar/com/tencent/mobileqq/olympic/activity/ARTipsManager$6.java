package com.tencent.mobileqq.olympic.activity;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ARTipsManager$6
  implements ValueAnimator.AnimatorUpdateListener
{
  ARTipsManager$6(ARTipsManager paramARTipsManager) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (ARTipsManager.a(this.a) != null)
    {
      ARTipsManager.a(this.a).setAlpha(f);
      ARTipsManager.a(this.a).setTranslationY((1.0F - f) * AIOUtils.a(25.0F, ARTipsManager.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.6
 * JD-Core Version:    0.7.0.1
 */