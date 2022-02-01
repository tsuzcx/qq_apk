package com.tencent.mobileqq.kandian.biz.video.column;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/column/VideoColumnGuideManager$dismissGuideRootView$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnGuideManager$dismissGuideRootView$1$1
  extends AnimatorListenerAdapter
{
  VideoColumnGuideManager$dismissGuideRootView$1$1(View paramView) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator, boolean paramBoolean)
  {
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager.dismissGuideRootView.1.1
 * JD-Core Version:    0.7.0.1
 */