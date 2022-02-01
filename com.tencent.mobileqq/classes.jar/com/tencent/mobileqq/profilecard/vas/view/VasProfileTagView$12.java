package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;
import com.tencent.mobileqq.widget.RatioLayout;

class VasProfileTagView$12
  implements ValueAnimator.AnimatorUpdateListener
{
  VasProfileTagView$12(VasProfileTagView paramVasProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.val$child.setScaleX(paramValueAnimator.floatValue());
    this.val$child.setScaleY(paramValueAnimator.floatValue());
    float f1 = this.val$pos.x;
    float f2 = VasProfileTagView.access$1900(this.this$0).x;
    float f3 = VasProfileTagView.access$500(this.this$0).getWidth();
    float f4 = this.val$pos.y;
    float f5 = VasProfileTagView.access$1900(this.this$0).y;
    float f6 = VasProfileTagView.access$500(this.this$0).getHeight();
    this.val$child.setTranslationX((f1 - f2) * f3 * paramValueAnimator.floatValue());
    this.val$child.setTranslationY((f4 - f5) * f6 * paramValueAnimator.floatValue());
    this.val$child.setRotation(paramValueAnimator.floatValue() * 120.0F - 120.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.12
 * JD-Core Version:    0.7.0.1
 */