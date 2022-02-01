package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.D8SafeAnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/PositionChangedHandler$doScrollLeftAnimation$1$2", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/D8SafeAnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PositionChangedHandler$doScrollLeftAnimation$$inlined$apply$lambda$2
  extends D8SafeAnimatorListener
{
  PositionChangedHandler$doScrollLeftAnimation$$inlined$apply$lambda$2(PositionChangedHandler paramPositionChangedHandler, int paramInt1, int paramInt2, IDragView paramIDragView, int paramInt3) {}
  
  public void onAnimationCancel(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
    PositionChangedHandler.a(this.a, false);
    PositionChangedHandler.b(this.a, false);
    PositionChangedHandler.a(this.a, (ValueAnimator)null);
  }
  
  public void onAnimationEnd(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
    PositionChangedHandler.a(this.a, false);
    PositionChangedHandler.b(this.a, false);
    PositionChangedHandler.a(this.a, (ValueAnimator)null);
    this.d.c();
  }
  
  public void onAnimationRepeat(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
  }
  
  public void onAnimationStart(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.PositionChangedHandler.doScrollLeftAnimation..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */