package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.qphone.base.util.QLog;

class ProfileAnonymousComponent$1
  extends AnonymousObserver
{
  ProfileAnonymousComponent$1(ProfileAnonymousComponent paramProfileAnonymousComponent) {}
  
  public void onLikeAnonymousAnswer(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLikeAnonymousAnswer() success = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ProfileAnonymousComponent", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousComponent.1
 * JD-Core Version:    0.7.0.1
 */