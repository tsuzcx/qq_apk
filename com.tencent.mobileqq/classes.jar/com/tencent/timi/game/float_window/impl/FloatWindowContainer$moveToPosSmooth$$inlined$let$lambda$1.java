package com.tencent.timi.game.float_window.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.timi.game.float_window.FloatingConfigParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/timi/game/float_window/impl/FloatWindowContainer$moveToPosSmooth$1$1"}, k=3, mv={1, 1, 16})
final class FloatWindowContainer$moveToPosSmooth$$inlined$let$lambda$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatWindowContainer$moveToPosSmooth$$inlined$let$lambda$1(WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatWindowContainer paramFloatWindowContainer, int paramInt5, int paramInt6) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f1 = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = this.a;
      int i = this.b;
      paramValueAnimator.x = ((int)(i + (this.c - i) * f1));
      i = this.d;
      paramValueAnimator.y = ((int)(i + f1 * (this.e - i)));
      this.f.a(paramValueAnimator);
      paramValueAnimator = FloatWindowContainer.a(this.f);
      if (paramValueAnimator == null) {
        Intrinsics.throwNpe();
      }
      paramValueAnimator.b(this.a.x);
      paramValueAnimator = FloatWindowContainer.a(this.f);
      if (paramValueAnimator == null) {
        Intrinsics.throwNpe();
      }
      paramValueAnimator.c(this.a.y);
      paramValueAnimator = FloatWindowContainer.b(this.f);
      if (paramValueAnimator == null) {
        Intrinsics.throwNpe();
      }
      paramValueAnimator.b(this.a.x);
      paramValueAnimator = FloatWindowContainer.b(this.f);
      if (paramValueAnimator == null) {
        Intrinsics.throwNpe();
      }
      paramValueAnimator.c(this.a.y);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.FloatWindowContainer.moveToPosSmooth..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */