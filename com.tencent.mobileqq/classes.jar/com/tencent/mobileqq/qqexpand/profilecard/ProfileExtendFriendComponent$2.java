package com.tencent.mobileqq.qqexpand.profilecard;

import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;

class ProfileExtendFriendComponent$2
  extends ExpandObserver
{
  ProfileExtendFriendComponent$2(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 2) && (ProfileExtendFriendComponent.a(this.a) != null)) {
      ProfileExtendFriendComponent.b(this.a).requestUpdateCard();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.2
 * JD-Core Version:    0.7.0.1
 */