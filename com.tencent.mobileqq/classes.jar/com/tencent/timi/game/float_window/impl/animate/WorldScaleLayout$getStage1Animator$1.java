package com.tencent.timi.game.float_window.impl.animate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class WorldScaleLayout$getStage1Animator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  WorldScaleLayout$getStage1Animator$1(WorldScaleLayout paramWorldScaleLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    WorldScaleLayout localWorldScaleLayout = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      WorldScaleLayout.a(localWorldScaleLayout, ((Float)paramValueAnimator).floatValue());
      WorldScaleLayout.a(this.a);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout.getStage1Animator.1
 * JD-Core Version:    0.7.0.1
 */