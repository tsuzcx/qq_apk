package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class BarrageController$startBarrageItemAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  BarrageController$startBarrageItemAnimation$1(BarrageController paramBarrageController, BarrageItemView paramBarrageItemView, float paramFloat) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator == null) {
      return;
    }
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f1 = ((Float)paramValueAnimator).floatValue();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageItemView.setX(f1);
      float f2 = this.jdField_a_of_type_Float;
      float f3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageItemView.getWidth();
      BarrageController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageController, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageItemView, (int)(f2 - (f3 + f1)));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageController.startBarrageItemAnimation.1
 * JD-Core Version:    0.7.0.1
 */