package com.tencent.mobileqq.location.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.widget.ISlidePanelListener;
import com.tencent.qphone.base.util.QLog;

class PoiSlideBottomPanel$2
  implements ValueAnimator.AnimatorUpdateListener
{
  PoiSlideBottomPanel$2(PoiSlideBottomPanel paramPoiSlideBottomPanel, View paramView, float paramFloat1, float paramFloat2) {}
  
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
        paramValueAnimator.append("[panel] onAnimationUpdate: show invoked. mPanel:");
        paramValueAnimator.append(this.jdField_a_of_type_AndroidViewView.getId());
        paramValueAnimator.append(" org: ");
        paramValueAnimator.append(this.jdField_a_of_type_Float);
        paramValueAnimator.append(" dest: ");
        paramValueAnimator.append(this.b);
        paramValueAnimator.append(" value: ");
        paramValueAnimator.append(this.jdField_a_of_type_AndroidViewView.getY());
        QLog.d("PoiSlideBottomPanel", 2, paramValueAnimator.toString());
      }
      if (PoiSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel) != null) {
        PoiSlideBottomPanel.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel).fadeBackground(1.0F - ((Float)localObject).floatValue() / (PoiSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel) - PoiSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.PoiSlideBottomPanel.2
 * JD-Core Version:    0.7.0.1
 */