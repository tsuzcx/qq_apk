package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.image.URLImageView;

class PaFlashLightView$3
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_Boolean = true;
    switch (this.a.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = ((this.a.jdField_a_of_type_Int + 1) % 3);
      return;
      this.a.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPaFlashLightView$RefreshHandler.sendEmptyMessageDelayed(0, 3250L);
      continue;
      this.a.b.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPaFlashLightView$RefreshHandler.sendEmptyMessageDelayed(0, 1050L);
      continue;
      this.a.c.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPaFlashLightView$RefreshHandler.sendEmptyMessageDelayed(0, 3250L);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaFlashLightView.3
 * JD-Core Version:    0.7.0.1
 */