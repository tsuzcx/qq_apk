package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "value", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class VideoFeedsStressFollowHelper$startStretchAnim$2
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoFeedsStressFollowHelper$startStretchAnim$2(VideoFeedsStressFollowHelper paramVideoFeedsStressFollowHelper) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    VideoFeedsStressFollowLayout localVideoFeedsStressFollowLayout = this.a.a();
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "value");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      localVideoFeedsStressFollowLayout.a(((Float)paramValueAnimator).floatValue());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowHelper.startStretchAnim.2
 * JD-Core Version:    0.7.0.1
 */