package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class PersonalityLabelGalleryActivity$11
  extends D8SafeAnimatorListener
{
  PersonalityLabelGalleryActivity$11(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ObjectAnimator paramObjectAnimator) {}
  
  private ImageView a(ObjectAnimator paramObjectAnimator)
  {
    return (ImageView)paramObjectAnimator.getTarget();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = a(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
    if (paramAnimator != null)
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b) {
        i = 2130845827;
      } else {
        i = 2130845819;
      }
      paramAnimator.setImageResource(i);
      paramAnimator.setRotation(0.0F);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = a(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
    if (paramAnimator != null)
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b) {
        i = 2130845827;
      } else {
        i = 2130845819;
      }
      paramAnimator.setImageResource(i);
      paramAnimator.setRotation(0.0F);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.11
 * JD-Core Version:    0.7.0.1
 */