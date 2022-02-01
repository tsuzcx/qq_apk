package com.tencent.mobileqq.profilecard.bussiness.extendfriend;

import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.qphone.base.util.QLog;

class ProfileExtendFriendComponent$2
  extends ExtendFriendObserver
{
  ProfileExtendFriendComponent$2(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  public void onUpdateCampusCertificateStatus(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 2) && (ProfileExtendFriendComponent.access$100(this.this$0) != null)) {
      ProfileExtendFriendComponent.access$200(this.this$0).requestUpdateCard();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.2
 * JD-Core Version:    0.7.0.1
 */