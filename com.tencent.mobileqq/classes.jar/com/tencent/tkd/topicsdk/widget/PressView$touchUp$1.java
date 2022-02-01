package com.tencent.tkd.topicsdk.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class PressView$touchUp$1
  implements ValueAnimator.AnimatorUpdateListener
{
  PressView$touchUp$1(View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
    float f = ((Float)paramValueAnimator).floatValue();
    Drawable localDrawable = this.a.getBackground();
    paramValueAnimator = localDrawable;
    if (localDrawable == null)
    {
      paramValueAnimator = localDrawable;
      if ((this.a instanceof ImageView)) {
        paramValueAnimator = ((ImageView)this.a).getDrawable();
      }
    }
    int i = (int)(f * 'ÿ');
    if (paramValueAnimator != null) {
      paramValueAnimator.setColorFilter(Color.argb(255, i, i, i), PorterDuff.Mode.MULTIPLY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.PressView.touchUp.1
 * JD-Core Version:    0.7.0.1
 */