package com.tencent.timi.game.liveroom.impl.live.widget;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/live/widget/LiveRoomDisplayView$mAnimListener$1", "Lcom/tencent/mobileqq/widget/D8SafeAnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveRoomDisplayView$mAnimListener$1
  extends D8SafeAnimatorListener
{
  public void onAnimationCancel(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animator");
    LiveRoomDisplayView.a(this.a, false);
  }
  
  public void onAnimationEnd(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animator");
    paramAnimator = this.a;
    LiveRoomDisplayView.b(paramAnimator, LiveRoomDisplayView.h(paramAnimator) ^ true);
    LiveRoomDisplayView.a(this.a, false);
  }
  
  public void onAnimationRepeat(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animator");
  }
  
  public void onAnimationStart(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animator");
    LiveRoomDisplayView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.mAnimListener.1
 * JD-Core Version:    0.7.0.1
 */