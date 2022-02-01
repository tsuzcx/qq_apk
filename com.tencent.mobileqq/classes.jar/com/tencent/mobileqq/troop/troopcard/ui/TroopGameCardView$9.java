package com.tencent.mobileqq.troop.troopcard.ui;

import android.animation.Animator;
import android.widget.TextView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class TroopGameCardView$9
  extends D8SafeAnimatorListener
{
  TroopGameCardView$9(TroopGameCardView paramTroopGameCardView, TextView paramTextView, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    int i;
    if (this.b) {
      i = 0;
    } else {
      i = 8;
    }
    paramAnimator.setVisibility(i);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopGameCardView.9
 * JD-Core Version:    0.7.0.1
 */