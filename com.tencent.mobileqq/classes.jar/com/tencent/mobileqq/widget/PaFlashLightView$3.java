package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.image.URLImageView;

class PaFlashLightView$3
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.jdField_a_of_type_Boolean = true;
    int i = paramAnimation.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          this.a.c.setVisibility(8);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetPaFlashLightView$RefreshHandler.sendEmptyMessageDelayed(0, 3250L);
        }
      }
      else
      {
        this.a.b.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetPaFlashLightView$RefreshHandler.sendEmptyMessageDelayed(0, 1050L);
      }
    }
    else
    {
      this.a.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPaFlashLightView$RefreshHandler.sendEmptyMessageDelayed(0, 3250L);
    }
    paramAnimation = this.a;
    paramAnimation.jdField_a_of_type_Int = ((paramAnimation.jdField_a_of_type_Int + 1) % 3);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaFlashLightView.3
 * JD-Core Version:    0.7.0.1
 */