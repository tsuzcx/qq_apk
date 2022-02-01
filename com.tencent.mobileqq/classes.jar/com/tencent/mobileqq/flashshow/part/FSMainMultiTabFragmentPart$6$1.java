package com.tencent.mobileqq.flashshow.part;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;

class FSMainMultiTabFragmentPart$6$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FSMainMultiTabFragmentPart$6$1(FSMainMultiTabFragmentPart.6 param6, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    FSMainMultiTabFragmentPart.f(this.b.this$0).setTranslationY(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    float f = (this.a - ((Float)paramValueAnimator.getAnimatedValue()).floatValue()) / this.a;
    FSMainMultiTabFragmentPart.f(this.b.this$0).setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSMainMultiTabFragmentPart.6.1
 * JD-Core Version:    0.7.0.1
 */