package com.tencent.mobileqq.troop.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class TroopGameCardView$7
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopGameCardView$7(TroopGameCardView paramTroopGameCardView, ValueAnimator paramValueAnimator, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue("height")).intValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramValueAnimator.height = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView.7
 * JD-Core Version:    0.7.0.1
 */