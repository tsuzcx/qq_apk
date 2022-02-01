package com.tencent.tkd.topicsdk.entry.square;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class SquareEntryView$showSuccessStatus$1
  implements ValueAnimator.AnimatorUpdateListener
{
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      int i = ((Integer)paramValueAnimator).intValue();
      this.b.width = i;
      SquareEntryView.c(this.a).setLayoutParams(this.b);
      SquareEntryView.c(this.a).invalidate();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.square.SquareEntryView.showSuccessStatus.1
 * JD-Core Version:    0.7.0.1
 */