package com.tencent.mobileqq.kandian.biz.video;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$performAnim$1$2", "Lcom/tencent/mobileqq/activity/richmedia/AnimatorAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnBannerManager$performAnim$$inlined$apply$lambda$4
  extends AnimatorAdapter
{
  VideoColumnBannerManager$performAnim$$inlined$apply$lambda$4(ShortVideoItemHolder paramShortVideoItemHolder, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b();
    if (paramAnimator != null) {
      paramAnimator.setTextColor(-16578534);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.c();
    if (paramAnimator != null) {
      paramAnimator.setTextColor(-16578534);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a;
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.a;
      if ((paramAnimator != null) && (paramAnimator.d() == true))
      {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.c(), 0, (int)200L);
        break label195;
      }
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.f();
    if (paramAnimator != null) {
      paramAnimator.setVisibility(0);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.f();
    if (paramAnimator != null) {
      paramAnimator.setScaleX(0.0F);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.f();
    if (paramAnimator != null) {
      paramAnimator.setScaleY(0.0F);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.f();
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.animate();
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.scaleX(1.0F);
        if (paramAnimator != null)
        {
          paramAnimator = paramAnimator.scaleY(1.0F);
          if (paramAnimator != null)
          {
            paramAnimator = paramAnimator.setDuration(200L);
            if (paramAnimator != null) {
              paramAnimator.start();
            }
          }
        }
      }
    }
    label195:
    paramAnimator = (View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b();
    int i = (int)200L;
    VideoFeedsHelper.a(paramAnimator, 8, i);
    VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.c(), 0, i);
    VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.d(), 0, i);
    VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.e(), 0, i);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.performAnim..inlined.apply.lambda.4
 * JD-Core Version:    0.7.0.1
 */