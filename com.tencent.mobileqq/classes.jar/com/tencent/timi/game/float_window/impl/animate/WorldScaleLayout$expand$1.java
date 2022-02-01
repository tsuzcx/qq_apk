package com.tencent.timi.game.float_window.impl.animate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/float_window/impl/animate/WorldScaleLayout$expand$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class WorldScaleLayout$expand$1
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    WorldScaleLayout.a(this.a, false);
    paramAnimator = this.a.getWorldScaleListener();
    if (paramAnimator != null) {
      paramAnimator.d();
    }
    WorldScaleLayout.a(this.a);
  }
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    WorldScaleLayout.a(this.a, true);
    paramAnimator = this.a.getWorldScaleListener();
    if (paramAnimator != null) {
      paramAnimator.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout.expand.1
 * JD-Core Version:    0.7.0.1
 */