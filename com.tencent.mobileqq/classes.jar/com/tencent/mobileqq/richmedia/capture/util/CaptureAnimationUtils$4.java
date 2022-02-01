package com.tencent.mobileqq.richmedia.capture.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;

final class CaptureAnimationUtils$4
  implements ValueAnimator.AnimatorUpdateListener
{
  final int jdField_a_of_type_Int;
  final int b;
  final int c;
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(i, this.jdField_a_of_type_Int, this.b, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureAnimationUtils.4
 * JD-Core Version:    0.7.0.1
 */