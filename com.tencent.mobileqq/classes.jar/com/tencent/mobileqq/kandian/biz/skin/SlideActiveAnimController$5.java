package com.tencent.mobileqq.kandian.biz.skin;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInjoySlideAnimLayout;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;

class SlideActiveAnimController$5
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideActiveAnimController$5(SlideActiveAnimController paramSlideActiveAnimController, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.b.a.b.setTranslationY(this.a - paramValueAnimator.floatValue());
    this.b.b.setTranslationY(-paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController.5
 * JD-Core Version:    0.7.0.1
 */