package com.tencent.mobileqq.kandian.biz.video.column;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/column/VideoColumnGuideManager$startGuideAnimate$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnGuideManager$startGuideAnimate$1$1
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    if (VideoColumnGuideManager.a(this.a.this$0)) {
      return;
    }
    if (VideoColumnGuideManager.a(this.a.this$0) >= 1)
    {
      VideoColumnGuideManager.a(this.a.this$0);
      return;
    }
    paramAnimator = this.a.this$0;
    VideoColumnGuideManager.a(paramAnimator, VideoColumnGuideManager.a(paramAnimator) + 1);
    VideoColumnGuideManager.c(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager.startGuideAnimate.1.1
 * JD-Core Version:    0.7.0.1
 */