package com.tencent.mobileqq.kandian.biz.skin;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInjoySlideAnimLayout;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;

class SlideActiveAnimController$5
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideActiveAnimController$5(SlideActiveAnimController paramSlideActiveAnimController, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.a.setTranslationY(this.jdField_a_of_type_Float - paramValueAnimator.floatValue());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setTranslationY(-paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController.5
 * JD-Core Version:    0.7.0.1
 */