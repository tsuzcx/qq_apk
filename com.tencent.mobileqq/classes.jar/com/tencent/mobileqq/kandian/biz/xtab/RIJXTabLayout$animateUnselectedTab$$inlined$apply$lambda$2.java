package com.tencent.mobileqq.kandian.biz.xtab;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Typeface;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabLayout$animateUnselectedTab$animation$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabLayout$animateUnselectedTab$$inlined$apply$lambda$2
  implements Animator.AnimatorListener
{
  RIJXTabLayout$animateUnselectedTab$$inlined$apply$lambda$2(TextView paramTextView) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    this.a.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabLayout.animateUnselectedTab..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */