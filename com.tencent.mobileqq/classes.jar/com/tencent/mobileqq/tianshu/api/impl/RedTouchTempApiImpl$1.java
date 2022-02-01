package com.tencent.mobileqq.tianshu.api.impl;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.ApngImage;

class RedTouchTempApiImpl$1
  implements Animation.AnimationListener
{
  RedTouchTempApiImpl$1(RedTouchTempApiImpl paramRedTouchTempApiImpl, Animation paramAnimation1, ImageView paramImageView1, Context paramContext, String paramString, TextView paramTextView1, boolean paramBoolean, TextView paramTextView2, Animation paramAnimation2, ImageView paramImageView2, TextView paramTextView3, TextView paramTextView4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramAnimation = this.jdField_a_of_type_ComTencentMobileqqTianshuApiImplRedTouchTempApiImpl.getApngDrawable(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAnimation);
      paramAnimation = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((paramAnimation != null) && (this.jdField_a_of_type_Boolean))
      {
        paramAnimation.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      paramAnimation = this.c;
      if ((paramAnimation != null) && (this.jdField_a_of_type_Boolean)) {
        paramAnimation.setVisibility(8);
      }
      paramAnimation = this.d;
      if ((paramAnimation != null) && (this.jdField_a_of_type_Boolean)) {
        paramAnimation.setVisibility(8);
      }
      ApngImage.playByTag(39);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchTempApiImpl.1
 * JD-Core Version:    0.7.0.1
 */