package com.tencent.mobileqq.kandian.biz.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$performAnim$1$1"}, k=3, mv={1, 1, 16})
final class VideoColumnBannerManager$performAnim$$inlined$apply$lambda$3
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoColumnBannerManager$performAnim$$inlined$apply$lambda$3(ShortVideoItemHolder paramShortVideoItemHolder, ValueAnimator paramValueAnimator) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = this.a.k();
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        if (paramValueAnimator != null) {
          ((ViewGroup.LayoutParams)localObject).height = ((Integer)paramValueAnimator).intValue();
        } else {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
      }
    }
    paramValueAnimator = this.a.k();
    if (paramValueAnimator != null) {
      paramValueAnimator.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.performAnim..inlined.apply.lambda.3
 * JD-Core Version:    0.7.0.1
 */