package com.tencent.tkd.topicsdk.entry;

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
final class EntryView$unFold$1
  implements ValueAnimator.AnimatorUpdateListener
{
  EntryView$unFold$1(EntryView paramEntryView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int i = ((Integer)paramValueAnimator).intValue();
    EntryView.a(this.a).getLayoutParams().width = i;
    paramValueAnimator = DisplayUtils.a;
    Object localObject = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    if (i > paramValueAnimator.a((Context)localObject, 60.0F))
    {
      EntryView.a(this.a).setNeedNumProgress(false);
      EntryView.a(this.a).setVisibility(0);
      EntryView.b(this.a).setVisibility(0);
      EntryView.a(this.a).setVisibility(0);
    }
    paramValueAnimator = EntryView.a(this.a).getLayoutParams();
    localObject = DisplayUtils.a;
    Context localContext = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramValueAnimator.width = (i - ((DisplayUtils)localObject).a(localContext, 74.0F));
    paramValueAnimator = EntryView.a(this.a);
    localObject = DisplayUtils.a;
    localContext = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int j = -((DisplayUtils)localObject).a(localContext, 68.0F);
    localObject = DisplayUtils.a;
    localContext = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramValueAnimator.setPadding(i + j - ((DisplayUtils)localObject).a(localContext, 74.0F), 0, 0, 0);
    EntryView.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryView.unFold.1
 * JD-Core Version:    0.7.0.1
 */