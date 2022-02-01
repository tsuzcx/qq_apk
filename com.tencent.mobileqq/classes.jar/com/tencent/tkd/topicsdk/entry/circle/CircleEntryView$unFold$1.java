package com.tencent.tkd.topicsdk.entry.circle;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.widget.RoundProgressView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class CircleEntryView$unFold$1
  implements ValueAnimator.AnimatorUpdateListener
{
  CircleEntryView$unFold$1(CircleEntryView paramCircleEntryView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      int i = ((Integer)paramValueAnimator).intValue();
      CircleEntryView.a(this.a).getLayoutParams().width = i;
      paramValueAnimator = DisplayUtils.a;
      Object localObject = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      if (i > paramValueAnimator.a((Context)localObject, 60.0F))
      {
        CircleEntryView.f(this.a).setNeedNumProgress(false);
        CircleEntryView.b(this.a).setVisibility(0);
        CircleEntryView.c(this.a).setVisibility(0);
        CircleEntryView.d(this.a).setVisibility(0);
      }
      paramValueAnimator = CircleEntryView.e(this.a).getLayoutParams();
      localObject = DisplayUtils.a;
      Context localContext = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramValueAnimator.width = (i - ((DisplayUtils)localObject).a(localContext, 74.0F));
      paramValueAnimator = DisplayUtils.a;
      localObject = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      int j = -paramValueAnimator.a((Context)localObject, 68.0F);
      paramValueAnimator = DisplayUtils.a;
      localObject = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      int k = paramValueAnimator.a((Context)localObject, 74.0F);
      CircleEntryView.e(this.a).setPadding(j + i - k, 0, 0, 0);
      CircleEntryView.a(this.a).requestLayout();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.circle.CircleEntryView.unFold.1
 * JD-Core Version:    0.7.0.1
 */