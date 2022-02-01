package com.tencent.mobileqq.profilecard.bussiness.personalitylabel;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelObserver;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

class ProfilePersonalityLabelComponent$1
  extends PersonalityLabelObserver
{
  ProfilePersonalityLabelComponent$1(ProfilePersonalityLabelComponent paramProfilePersonalityLabelComponent) {}
  
  public void onGetPersonalityLabel(boolean paramBoolean, String paramString, ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePersonalityLabelComponent", 2, String.format("onGetPersonalityLabel isSuccess=%s uin=%s flag=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    if ((ProfilePersonalityLabelComponent.access$000(this.this$0) != null) && (TextUtils.equals(paramString, ((ProfileCardInfo)ProfilePersonalityLabelComponent.access$100(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) && (paramInt == 0))
    {
      ((ProfileCardInfo)ProfilePersonalityLabelComponent.access$200(this.this$0)).a(paramProfilePersonalityLabelInfo);
      ProfilePersonalityLabelComponent.access$400(this.this$0, ((ProfileCardInfo)ProfilePersonalityLabelComponent.access$300(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataCard, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent.1
 * JD-Core Version:    0.7.0.1
 */