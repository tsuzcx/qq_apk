package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileGameInfo;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager;
import com.tencent.qphone.base.util.QLog;

class ProfileTroopMemGameInfoComponent$1
  extends TroopBusinessObserver
{
  ProfileTroopMemGameInfoComponent$1(ProfileTroopMemGameInfoComponent paramProfileTroopMemGameInfoComponent) {}
  
  public void onGetMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "onGetMemberGameCardSwitch.isSuccess = " + paramBoolean + ", errCode = " + paramLong3);
    }
    if ((!paramBoolean) || (ProfileTroopMemGameInfoComponent.access$000(this.this$0) == null) || (((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$100(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$200(this.this$0)).jdField_a_of_type_JavaLangString.equals(String.valueOf(paramLong1))) || (!((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$300(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramLong2)))) {}
    while (!ProfileTroopMemGameInfoComponent.access$400(this.this$0)) {
      return;
    }
    ProfileTroopMemGameInfoComponent.access$500(this.this$0, String.valueOf(paramLong1), String.valueOf(paramLong2));
  }
  
  public void onGetTroopMemberGameCard(boolean paramBoolean, String paramString1, String paramString2, ProfileGameInfo paramProfileGameInfo)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onGetTroopMemberGameCard.isSuccess = ").append(paramBoolean).append(", hasProfileGameInfo = ");
      if (paramProfileGameInfo != null)
      {
        bool = true;
        QLog.d("ProfileTroopMemGameInfoComponent", 2, bool);
      }
    }
    else
    {
      if ((paramBoolean) && (ProfileTroopMemGameInfoComponent.access$600(this.this$0) != null) && (((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$700(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$800(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramString2)))) {
        break label114;
      }
    }
    label114:
    do
    {
      return;
      bool = false;
      break;
      ProfileTroopMemGameInfoComponent.access$902(this.this$0, paramProfileGameInfo);
      ProfileTroopMemGameInfoComponent.access$1002(this.this$0, true);
    } while (TextUtils.isEmpty(TroopGameCardResDownloadManager.a()));
    ProfileTroopMemGameInfoComponent.access$1100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troopgame.ProfileTroopMemGameInfoComponent.1
 * JD-Core Version:    0.7.0.1
 */