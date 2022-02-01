package com.tencent.mobileqq.guild.animate;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/animate/ViewZoomAnimateController$startOpenAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "isReverse", "", "onAnimationRepeat", "onAnimationStart", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class ViewZoomAnimateController$startOpenAnimation$1
  implements Animator.AnimatorListener
{
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator, boolean paramBoolean)
  {
    paramAnimator = ViewZoomAnimateController.c(this.a);
    if (paramAnimator != null) {
      ViewZoomAnimateController.d(this.a).setBackground(paramAnimator);
    }
    ViewZoomAnimateController.a(this.a, (Drawable)null);
    ViewZoomAnimateController.a(this.a, false);
    paramAnimator = ViewZoomAnimateController.b(this.a);
    if (paramAnimator != null) {
      ViewZoomAnimateController.a(this.a, paramAnimator, false);
    }
    paramAnimator = ViewZoomAnimateController.a(this.a);
    if (paramAnimator != null) {
      paramAnimator.a(2);
    }
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator, boolean paramBoolean)
  {
    paramAnimator = this.a;
    ViewZoomAnimateController.a(paramAnimator, ViewZoomAnimateController.d(paramAnimator).getBackground());
    ViewZoomAnimateController.d(this.a).setBackground(null);
    ViewZoomAnimateController.d(this.a).setVisibility(0);
    ViewZoomAnimateController.a(this.a, true);
    paramAnimator = ViewZoomAnimateController.a(this.a);
    if (paramAnimator != null) {
      paramAnimator.b(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.ViewZoomAnimateController.startOpenAnimation.1
 * JD-Core Version:    0.7.0.1
 */