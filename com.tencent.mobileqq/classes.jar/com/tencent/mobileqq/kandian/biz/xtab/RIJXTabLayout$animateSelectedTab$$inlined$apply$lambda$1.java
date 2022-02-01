package com.tencent.mobileqq.kandian.biz.xtab;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabLayout$animateSelectedTab$animation$1$1"}, k=3, mv={1, 1, 16})
final class RIJXTabLayout$animateSelectedTab$$inlined$apply$lambda$1
  implements ValueAnimator.AnimatorUpdateListener
{
  RIJXTabLayout$animateSelectedTab$$inlined$apply$lambda$1(TextView paramTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TextView localTextView = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    Object localObject = paramValueAnimator.getAnimatedValue();
    if (localObject != null)
    {
      localTextView.setScaleX(((Float)localObject).floatValue());
      localTextView = this.a;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator != null)
      {
        localTextView.setScaleY(((Float)paramValueAnimator).floatValue());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabLayout.animateSelectedTab..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */