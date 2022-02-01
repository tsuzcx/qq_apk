package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.StressState;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowHelper$startShrinkAnim$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsStressFollowHelper$startShrinkAnim$2
  implements Animator.AnimatorListener
{
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    VideoFeedsStressFollowHelper.a(this.a, false);
    this.a.a().setStressState(StressState.Shrink);
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowHelper.startShrinkAnim.2
 * JD-Core Version:    0.7.0.1
 */