package com.tencent.tkd.topicsdk.widget.videocapture;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class CaptureOperateTouchLayout$IndicatorTouchListener$onTouch$1
  implements ValueAnimator.AnimatorUpdateListener
{
  CaptureOperateTouchLayout$IndicatorTouchListener$onTouch$1(CaptureOperateTouchLayout.IndicatorTouchListener paramIndicatorTouchListener, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f = ((Float)paramValueAnimator).floatValue();
      this.b.setX(f);
      CaptureOperateTouchLayout.f(this.a.a).setX(f);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.IndicatorTouchListener.onTouch.1
 * JD-Core Version:    0.7.0.1
 */