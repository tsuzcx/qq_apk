package com.tencent.mobileqq.kandian.biz.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$performAnim$columnTextTranslationAnim$1$1"}, k=3, mv={1, 1, 16})
final class VideoColumnBannerManager$performAnim$$inlined$apply$lambda$1
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoColumnBannerManager$performAnim$$inlined$apply$lambda$1(VideoColumnBannerManager paramVideoColumnBannerManager, ShortVideoItemHolder paramShortVideoItemHolder) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b();
    if (localObject1 != null) {
      localObject1 = ((TextView)localObject1).getLayoutParams();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      localObject2 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
    if (localObject1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b();
        if (paramValueAnimator != null) {
          paramValueAnimator.requestLayout();
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.performAnim..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */