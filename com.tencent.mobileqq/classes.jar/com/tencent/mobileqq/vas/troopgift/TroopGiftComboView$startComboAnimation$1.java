package com.tencent.mobileqq.vas.troopgift;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/troopgift/TroopGiftComboView$startComboAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftComboView$startComboAnimation$1
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    TroopGiftComboView.c(this.a, TroopGiftComboView.PlayState.PLAYED);
    if (TroopGiftComboView.a(this.a) == TroopGiftComboView.PlayState.PLAYED) {
      TroopGiftComboView.b(this.a, TroopGiftComboView.PlayState.PLAYED);
    }
  }
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    TroopGiftComboView.b(this.a, TroopGiftComboView.PlayState.PLAYING);
    TroopGiftComboView.c(this.a, TroopGiftComboView.PlayState.PLAYING);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView.startComboAnimation.1
 * JD-Core Version:    0.7.0.1
 */