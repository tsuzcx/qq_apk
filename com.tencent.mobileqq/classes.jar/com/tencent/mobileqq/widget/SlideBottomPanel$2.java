package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class SlideBottomPanel$2
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideBottomPanel$2(SlideBottomPanel paramSlideBottomPanel, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.jdField_a_of_type_AndroidViewView.setY(((Float)paramValueAnimator).floatValue());
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.a.fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.2
 * JD-Core Version:    0.7.0.1
 */