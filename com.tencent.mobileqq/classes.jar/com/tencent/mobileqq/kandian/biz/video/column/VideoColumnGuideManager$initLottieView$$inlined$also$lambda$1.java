package com.tencent.mobileqq.kandian.biz.video.column;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/column/VideoColumnGuideManager$initLottieView$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnGuideManager$initLottieView$$inlined$also$lambda$1
  extends AnimatorListenerAdapter
{
  VideoColumnGuideManager$initLottieView$$inlined$also$lambda$1(VideoColumnGuideManager paramVideoColumnGuideManager) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    VideoColumnGuideManager.b(this.a, true);
    paramAnimator = VideoColumnGuideManager.a(this.a);
    if (paramAnimator != null) {
      paramAnimator.pauseAnimation();
    }
    VideoColumnGuideManager.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager.initLottieView..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */