package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class SlideBottomPanel$4
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideBottomPanel$4(SlideBottomPanel paramSlideBottomPanel, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = paramValueAnimator.getAnimatedValue();
    if ((localObject instanceof Float))
    {
      paramValueAnimator = this.jdField_a_of_type_AndroidViewView;
      localObject = (Float)localObject;
      paramValueAnimator.setY(((Float)localObject).floatValue());
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.a.fadeBackground(1.0F - ((Float)localObject).floatValue() / (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.b - this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.j));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.4
 * JD-Core Version:    0.7.0.1
 */