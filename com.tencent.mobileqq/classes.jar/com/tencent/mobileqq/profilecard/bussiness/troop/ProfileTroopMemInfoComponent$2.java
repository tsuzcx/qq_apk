package com.tencent.mobileqq.profilecard.bussiness.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

class ProfileTroopMemInfoComponent$2
  extends TroopBusinessObserver
{
  ProfileTroopMemInfoComponent$2(ProfileTroopMemInfoComponent paramProfileTroopMemInfoComponent) {}
  
  public void onGetGolbalTroopLevel(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "onGetGolbalTroopLevel isSuccess = " + paramBoolean + ", uin = " + paramLong + ", level = " + paramInt);
    }
    if (ProfileTroopMemInfoComponent.access$1800(this.this$0) == null) {}
    do
    {
      do
      {
        return;
      } while ((((TroopManager)ProfileTroopMemInfoComponent.access$1900(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER)).n(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2000(this.this$0)).jdField_a_of_type_JavaLangString)) || (!paramBoolean) || (paramLong != Long.parseLong(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2100(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
      ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2200(this.this$0)).jdField_a_of_type_Int = paramInt;
    } while ((ProfileTroopMemInfoComponent.access$2300(this.this$0) == null) || (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2400(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
    ProfileTroopMemInfoComponent.access$1400(this.this$0);
  }
  
  public void onTroopRankSwitchUpdate(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s,switchOpen: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((ProfileTroopMemInfoComponent.access$3300(this.this$0) == null) || (!((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3400(this.this$0)).b) || (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3500(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard == null) || (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3600(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.equals(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3700(this.this$0)).jdField_a_of_type_JavaLangString)) {
      return;
    }
    ProfileTroopMemInfoComponent.access$3200(this.this$0);
  }
  
  public void onTroopRankTitleUpdate(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((ProfileTroopMemInfoComponent.access$2500(this.this$0) == null) || (!((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2600(this.this$0)).b) || (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2700(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard == null) || (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2800(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while ((!paramString1.equals(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2900(this.this$0)).jdField_a_of_type_JavaLangString)) || (!paramString2.equals(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3000(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3100(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.titleId = paramInt;
    ProfileTroopMemInfoComponent.access$3200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.2
 * JD-Core Version:    0.7.0.1
 */