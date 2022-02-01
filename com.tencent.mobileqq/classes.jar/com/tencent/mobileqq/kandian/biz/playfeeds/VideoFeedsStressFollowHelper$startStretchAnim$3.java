package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.StressState;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowHelper$startStretchAnim$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsStressFollowHelper$startStretchAnim$3
  implements Animator.AnimatorListener
{
  VideoFeedsStressFollowHelper$startStretchAnim$3(Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.b;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    VideoFeedsStressFollowHelper.a(this.a, false);
    this.a.a().setStressState(StressState.Stretched);
    Animator.AnimatorListener localAnimatorListener = this.b;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.b;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.b;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowHelper.startStretchAnim.3
 * JD-Core Version:    0.7.0.1
 */