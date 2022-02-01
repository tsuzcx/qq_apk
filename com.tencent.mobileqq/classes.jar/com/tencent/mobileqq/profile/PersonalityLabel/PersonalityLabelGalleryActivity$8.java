package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.Animator;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.HashSet;

class PersonalityLabelGalleryActivity$8
  extends D8SafeAnimatorListener
{
  PersonalityLabelGalleryActivity$8(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, PersonalityLabelGalleryActivity.LabelItemViewHolder paramLabelItemViewHolder, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$LabelItemViewHolder.a));
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$LabelItemViewHolder.a));
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.8
 * JD-Core Version:    0.7.0.1
 */