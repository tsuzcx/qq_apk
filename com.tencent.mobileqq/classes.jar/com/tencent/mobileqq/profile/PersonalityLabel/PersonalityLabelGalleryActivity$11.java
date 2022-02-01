package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.widget.ImageView;

class PersonalityLabelGalleryActivity$11
  implements Animator.AnimatorListener
{
  PersonalityLabelGalleryActivity$11(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ObjectAnimator paramObjectAnimator) {}
  
  private ImageView a(ObjectAnimator paramObjectAnimator)
  {
    return (ImageView)paramObjectAnimator.getTarget();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = a(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
    if (paramAnimator != null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b) {
        break label37;
      }
    }
    label37:
    for (int i = 2130845953;; i = 2130845945)
    {
      paramAnimator.setImageResource(i);
      paramAnimator.setRotation(0.0F);
      return;
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = a(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
    if (paramAnimator != null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b) {
        break label37;
      }
    }
    label37:
    for (int i = 2130845953;; i = 2130845945)
    {
      paramAnimator.setImageResource(i);
      paramAnimator.setRotation(0.0F);
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.11
 * JD-Core Version:    0.7.0.1
 */