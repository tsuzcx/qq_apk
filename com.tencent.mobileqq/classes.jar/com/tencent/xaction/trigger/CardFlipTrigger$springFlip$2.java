package com.tencent.xaction.trigger;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class CardFlipTrigger$springFlip$2
  implements ValueAnimator.AnimatorUpdateListener
{
  CardFlipTrigger$springFlip$2(CardFlipTrigger paramCardFlipTrigger, boolean paramBoolean) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f = ((Float)paramValueAnimator).floatValue();
      if (this.jdField_a_of_type_Boolean)
      {
        paramValueAnimator = CardFlipTrigger.a(this.jdField_a_of_type_ComTencentXactionTriggerCardFlipTrigger);
        if (paramValueAnimator == null) {
          Intrinsics.throwNpe();
        }
        paramValueAnimator.setRotationX(f);
        paramValueAnimator = CardFlipTrigger.b(this.jdField_a_of_type_ComTencentXactionTriggerCardFlipTrigger);
        if (paramValueAnimator == null) {
          Intrinsics.throwNpe();
        }
        paramValueAnimator.setRotationX(f + '´');
        return;
      }
      paramValueAnimator = CardFlipTrigger.a(this.jdField_a_of_type_ComTencentXactionTriggerCardFlipTrigger);
      if (paramValueAnimator == null) {
        Intrinsics.throwNpe();
      }
      paramValueAnimator.setRotationY(f);
      paramValueAnimator = CardFlipTrigger.b(this.jdField_a_of_type_ComTencentXactionTriggerCardFlipTrigger);
      if (paramValueAnimator == null) {
        Intrinsics.throwNpe();
      }
      paramValueAnimator.setRotationY(f + '´');
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.CardFlipTrigger.springFlip.2
 * JD-Core Version:    0.7.0.1
 */