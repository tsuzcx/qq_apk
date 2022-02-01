package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;

class ProfileAnonymousComponent$1
  extends AnonymousObserver
{
  ProfileAnonymousComponent$1(ProfileAnonymousComponent paramProfileAnonymousComponent) {}
  
  public void onLikeAnonymousAnswer(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAnonymousComponent", 0, "onLikeAnonymousAnswer() success = " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousComponent.1
 * JD-Core Version:    0.7.0.1
 */