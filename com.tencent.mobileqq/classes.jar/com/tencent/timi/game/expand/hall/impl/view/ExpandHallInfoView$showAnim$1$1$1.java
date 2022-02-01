package com.tencent.timi.game.expand.hall.impl.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class ExpandHallInfoView$showAnim$1$1$1
  implements ValueAnimator.AnimatorUpdateListener
{
  public static final 1 a = new 1();
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#showAnim #addUpdateListener ");
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    localStringBuilder.append(paramValueAnimator.getAnimatedValue());
    Logger.a("ExpandHallInfoView_", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView.showAnim.1.1.1
 * JD-Core Version:    0.7.0.1
 */