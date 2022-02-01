package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter$onDianZanClick$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsRecommendPresenter$onDianZanClick$1
  implements Animation.AnimationListener
{
  VideoFeedsRecommendPresenter$onDianZanClick$1(VideoItemHolder paramVideoItemHolder, int paramInt) {}
  
  public void onAnimationEnd(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a() == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder)
    {
      paramAnimation = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a();
      if (paramAnimation != null) {
        paramAnimation = paramAnimation.a;
      } else {
        paramAnimation = null;
      }
      if (paramAnimation != null)
      {
        paramAnimation = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a();
        if (paramAnimation != null)
        {
          paramAnimation = paramAnimation.a;
          if (paramAnimation != null) {
            paramAnimation.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.a != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.a;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((VideoPlayParam)localObject1).a;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.a;
        if (localObject1 != null)
        {
          localObject1 = ((VideoPlayParam)localObject1).a;
          if (localObject1 != null) {
            boolean bool = ((VideoInfo)localObject1).q;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.m != null)
        {
          ImageView localImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.m;
          if (localImageView != null)
          {
            VideoFeedsAdapter localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a();
            localObject1 = localObject2;
            if (localVideoFeedsAdapter != null) {
              localObject1 = localVideoFeedsAdapter.a(this.jdField_a_of_type_Int);
            }
            localImageView.setImageDrawable((Drawable)localObject1);
          }
        }
      }
    }
    paramAnimation.setInterpolator((Interpolator)new AnticipateInterpolator());
  }
  
  public void onAnimationStart(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter.onDianZanClick.1
 * JD-Core Version:    0.7.0.1
 */