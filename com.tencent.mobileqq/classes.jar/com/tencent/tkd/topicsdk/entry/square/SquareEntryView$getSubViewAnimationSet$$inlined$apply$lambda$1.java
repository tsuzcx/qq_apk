package com.tencent.tkd.topicsdk.entry.square;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/tkd/topicsdk/entry/square/SquareEntryView$getSubViewAnimationSet$1$1"}, k=3, mv={1, 1, 16})
final class SquareEntryView$getSubViewAnimationSet$$inlined$apply$lambda$1
  extends Lambda
  implements Function0<Unit>
{
  SquareEntryView$getSubViewAnimationSet$$inlined$apply$lambda$1(TranslateAnimation paramTranslateAnimation, AlphaAnimation paramAlphaAnimation, ScaleAnimation paramScaleAnimation, long paramLong1, long paramLong2, View paramView, float paramFloat, boolean paramBoolean)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$view$inlined.clearAnimation();
    this.$view$inlined.setAlpha(this.$endAlpha$inlined);
    if (!this.$isReverse$inlined)
    {
      this.$view$inlined.setVisibility(0);
      return;
    }
    this.$view$inlined.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.square.SquareEntryView.getSubViewAnimationSet..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */