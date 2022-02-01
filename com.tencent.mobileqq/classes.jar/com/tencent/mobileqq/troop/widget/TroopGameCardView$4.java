package com.tencent.mobileqq.troop.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import java.math.BigDecimal;

class TroopGameCardView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopGameCardView$4(TroopGameCardView paramTroopGameCardView, TextView paramTextView1, TextView paramTextView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (this.jdField_a_of_type_AndroidWidgetTextView.getText().equals("0.0")) {
      this.b.setVisibility(0);
    }
    paramValueAnimator = new BigDecimal(f).setScale(1, 4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramValueAnimator.floatValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView.4
 * JD-Core Version:    0.7.0.1
 */