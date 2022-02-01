package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.animation.Animator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderTransition$createAnimator$2", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/D8SafeAnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderTransition$createAnimator$2
  extends D8SafeAnimatorListener
{
  ReorderTransition$createAnimator$2(View paramView, float paramFloat) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    paramAnimator = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "target");
    paramAnimator.setTranslationX(this.b);
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderTransition.createAnimator.2
 * JD-Core Version:    0.7.0.1
 */