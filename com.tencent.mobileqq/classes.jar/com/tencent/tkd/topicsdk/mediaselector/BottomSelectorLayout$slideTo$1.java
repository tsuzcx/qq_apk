package com.tencent.tkd.topicsdk.mediaselector;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$slideTo$1
  implements ValueAnimator.AnimatorUpdateListener
{
  BottomSelectorLayout$slideTo$1(BottomSelectorLayout paramBottomSelectorLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    BottomSelectorLayout localBottomSelectorLayout = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      localBottomSelectorLayout.setTranslationY(((Float)paramValueAnimator).floatValue());
      paramValueAnimator = this.a;
      BottomSelectorLayout.a(paramValueAnimator, paramValueAnimator.getTranslationY());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.slideTo.1
 * JD-Core Version:    0.7.0.1
 */