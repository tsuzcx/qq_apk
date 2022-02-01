package com.tencent.mobileqq.profilecard.bussiness.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.qphone.base.util.QLog;

class ProfileTroopMemInfoComponent$2
  extends TroopOnlinePushObserver
{
  ProfileTroopMemInfoComponent$2(ProfileTroopMemInfoComponent paramProfileTroopMemInfoComponent) {}
  
  protected void onTroopRankSwitchUpdate(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s,switchOpen: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((ProfileTroopMemInfoComponent.access$2600(this.this$0) != null) && (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2700(this.this$0)).isTroopMemberCard) && (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2800(this.this$0)).troopMemberCard != null) && (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2900(this.this$0)).allInOne != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramString.equals(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3000(this.this$0)).troopUin)) {
        ProfileTroopMemInfoComponent.access$2500(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.2
 * JD-Core Version:    0.7.0.1
 */