package com.tencent.mobileqq.colornote.smallscreen;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.widget.LinearLayout.LayoutParams;

class ColorNoteSmallScreenRelativeLayout$4
  implements ValueAnimator.AnimatorUpdateListener
{
  ColorNoteSmallScreenRelativeLayout$4(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout1, ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout2, Point paramPoint, LinearLayout.LayoutParams paramLayoutParams, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(ColorNoteSmallScreenRelativeLayout.b(this.b) / 2 * f);
    paramValueAnimator = this.b;
    int j = ColorNoteSmallScreenRelativeLayout.a(paramValueAnimator, paramValueAnimator.e());
    int k = ColorNoteSmallScreenRelativeLayout.c(this.b);
    if (ColorNoteSmallScreenRelativeLayout.a(this.b) != null) {
      ColorNoteSmallScreenRelativeLayout.a(this.b).a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout, this.jdField_a_of_type_AndroidGraphicsPoint.x - i, this.jdField_a_of_type_AndroidGraphicsPoint.y, this.jdField_a_of_type_AndroidGraphicsPoint.x + j - i, this.jdField_a_of_type_AndroidGraphicsPoint.y + k);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = (this.jdField_a_of_type_Int + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.4
 * JD-Core Version:    0.7.0.1
 */