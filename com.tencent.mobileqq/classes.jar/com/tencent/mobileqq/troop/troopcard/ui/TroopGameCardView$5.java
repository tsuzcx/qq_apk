package com.tencent.mobileqq.troop.troopcard.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class TroopGameCardView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopGameCardView$5(TroopGameCardView paramTroopGameCardView, TextView paramTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.setText(String.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopGameCardView.5
 * JD-Core Version:    0.7.0.1
 */