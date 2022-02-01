package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.Animator;
import android.os.Handler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.Iterator;
import java.util.List;

class PersonalityLabelGalleryActivity$10
  extends D8SafeAnimatorListener
{
  PersonalityLabelGalleryActivity$10(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, long paramLong) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).personalityLabelInfos.iterator();
    while (paramAnimator.hasNext())
    {
      PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)paramAnimator.next();
      if (this.jdField_a_of_type_Long == localPersonalityLabelInfo.id)
      {
        PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).personalityLabelInfos.remove(localPersonalityLabelInfo);
        paramAnimator = PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity);
        paramAnimator.remainCount += 1;
        paramAnimator = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity;
        paramAnimator.a(PersonalityLabelGalleryActivity.a(paramAnimator), false);
        PersonalityLabelGalleryActivity.b(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a()) && (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b)) {
          PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.hasMessages(0)) {
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.removeMessages(0);
        }
        paramAnimator = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.obtainMessage(0, PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity));
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.sendMessageDelayed(paramAnimator, 500L);
      }
    }
    ((PersonalityLabelHandler)this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(this.jdField_a_of_type_Long);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.10
 * JD-Core Version:    0.7.0.1
 */