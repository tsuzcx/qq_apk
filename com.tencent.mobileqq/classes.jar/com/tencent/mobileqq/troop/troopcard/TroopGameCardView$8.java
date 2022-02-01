package com.tencent.mobileqq.troop.troopcard;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class TroopGameCardView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopGameCardView$8(TroopGameCardView paramTroopGameCardView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue("startColor")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("endColor")).intValue();
    TroopGameCardView.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopGameCardView, this.jdField_a_of_type_AndroidViewView, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopGameCardView.8
 * JD-Core Version:    0.7.0.1
 */