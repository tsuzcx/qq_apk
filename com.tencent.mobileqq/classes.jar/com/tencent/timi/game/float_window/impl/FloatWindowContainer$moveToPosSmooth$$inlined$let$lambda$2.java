package com.tencent.timi.game.float_window.impl;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.timi.game.float_window.impl.drag.IDragListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/float_window/impl/FloatWindowContainer$moveToPosSmooth$1$2", "Lcom/tencent/mobileqq/widget/D8SafeAnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FloatWindowContainer$moveToPosSmooth$$inlined$let$lambda$2
  extends D8SafeAnimatorListener
{
  FloatWindowContainer$moveToPosSmooth$$inlined$let$lambda$2(FloatWindowContainer paramFloatWindowContainer, int paramInt1, int paramInt2) {}
  
  public void onAnimationCancel(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animator");
  }
  
  public void onAnimationEnd(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animator");
    paramAnimator.removeAllListeners();
    paramAnimator = FloatWindowContainer.c(this.a);
    if (paramAnimator != null) {
      paramAnimator.b();
    }
  }
  
  public void onAnimationRepeat(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animator");
  }
  
  public void onAnimationStart(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animator");
    paramAnimator = FloatWindowContainer.c(this.a);
    if (paramAnimator != null) {
      paramAnimator.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.FloatWindowContainer.moveToPosSmooth..inlined.let.lambda.2
 * JD-Core Version:    0.7.0.1
 */