package com.tencent.mobileqq.location.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.widget.ISlidePanelListener;
import com.tencent.qphone.base.util.QLog;

class PoiSlideBottomPanel$4
  implements ValueAnimator.AnimatorUpdateListener
{
  PoiSlideBottomPanel$4(PoiSlideBottomPanel paramPoiSlideBottomPanel, View paramView, float paramFloat, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = paramValueAnimator.getAnimatedValue();
    if ((localObject instanceof Float))
    {
      paramValueAnimator = this.jdField_a_of_type_AndroidViewView;
      localObject = (Float)localObject;
      paramValueAnimator.setY(((Float)localObject).floatValue());
      if (QLog.isColorLevel())
      {
        paramValueAnimator = new StringBuilder();
        paramValueAnimator.append("[panel] onAnimationUpdate: hide invoked. org: ");
        paramValueAnimator.append(this.jdField_a_of_type_Float);
        paramValueAnimator.append(" dest: ");
        paramValueAnimator.append(this.jdField_a_of_type_Int);
        paramValueAnimator.append(" value: ");
        paramValueAnimator.append(this.jdField_a_of_type_AndroidViewView.getY());
        QLog.d("PoiSlideBottomPanel", 2, paramValueAnimator.toString());
      }
      if (PoiSlideBottomPanel.g(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel) != null) {
        PoiSlideBottomPanel.h(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel).fadeBackground(1.0F - ((Float)localObject).floatValue() / this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.PoiSlideBottomPanel.4
 * JD-Core Version:    0.7.0.1
 */