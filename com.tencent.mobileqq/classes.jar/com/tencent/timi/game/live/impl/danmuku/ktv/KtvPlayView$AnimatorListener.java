package com.tencent.timi.game.live.impl.danmuku.ktv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView$AnimatorListener;", "Landroid/animation/AnimatorListenerAdapter;", "ktvPlayView", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "(Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;)V", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "isReverse", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
final class KtvPlayView$AnimatorListener
  extends AnimatorListenerAdapter
{
  private final KtvPlayView a;
  
  public KtvPlayView$AnimatorListener(@NotNull KtvPlayView paramKtvPlayView)
  {
    this.a = paramKtvPlayView;
  }
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    KtvPlayView.a(this.a, -1.0F);
    this.a.invalidate();
    KtvPlayView.a(this.a, false);
    paramAnimator = KtvPlayView.a(this.a);
    if (paramAnimator != null) {
      paramAnimator.a();
    }
  }
  
  public void onAnimationStart(@Nullable Animator paramAnimator, boolean paramBoolean)
  {
    KtvPlayView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.ktv.KtvPlayView.AnimatorListener
 * JD-Core Version:    0.7.0.1
 */