package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

class PersonalityLabelGalleryActivity$7
  implements ValueAnimator.AnimatorUpdateListener
{
  PersonalityLabelGalleryActivity$7(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ValueAnimator paramValueAnimator, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramValueAnimator.height = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.7
 * JD-Core Version:    0.7.0.1
 */