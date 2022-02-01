package com.tencent.mobileqq.kandian.biz.video;

import android.animation.Animator;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$performAnim$columnTextTranslationAnim$1$2", "Lcom/tencent/mobileqq/activity/richmedia/AnimatorAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnBannerManager$performAnim$$inlined$apply$lambda$2
  extends AnimatorAdapter
{
  VideoColumnBannerManager$performAnim$$inlined$apply$lambda$2(VideoColumnBannerManager paramVideoColumnBannerManager, ShortVideoItemHolder paramShortVideoItemHolder) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    VideoColumnBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager, false);
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
    if (paramAnimator != null) {
      paramAnimator.setVisibility(0);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
    if (paramAnimator != null) {
      paramAnimator.post((Runnable)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.performAnim..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */