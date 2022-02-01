package com.tencent.mobileqq.vas.troopgift;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/troopgift/TroopGiftComboXAController$setComboAnimationForXA$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftComboXAController$setComboAnimationForXA$1
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    TroopGiftComboXAController.a(this.a, TroopGiftPAGAnimationController.PlayState.PLAYED);
    if (TroopGiftComboXAController.a(this.a) == TroopGiftPAGAnimationController.PlayState.PLAYED) {
      this.a.a(TroopGiftPAGAnimationController.PlayState.PLAYED);
    }
  }
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    this.a.a(TroopGiftPAGAnimationController.PlayState.PLAYING);
    TroopGiftComboXAController.a(this.a, TroopGiftPAGAnimationController.PlayState.PLAYING);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboXAController.setComboAnimationForXA.1
 * JD-Core Version:    0.7.0.1
 */