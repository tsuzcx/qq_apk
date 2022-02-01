package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo;
import com.tencent.qphone.base.util.QLog;

class ProfileTroopMemGameInfoComponent$1
  extends TroopGameObserver
{
  ProfileTroopMemGameInfoComponent$1(ProfileTroopMemGameInfoComponent paramProfileTroopMemGameInfoComponent) {}
  
  protected void onGetMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetMemberGameCardSwitch.isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", errCode = ");
      localStringBuilder.append(paramLong3);
      QLog.d("ProfileTroopMemGameInfoComponent", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (ProfileTroopMemGameInfoComponent.access$600(this.this$0) != null) && (((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$700(this.this$0)).allInOne != null) && (((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$800(this.this$0)).troopUin.equals(String.valueOf(paramLong1))))
    {
      if (!((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$900(this.this$0)).allInOne.uin.equals(String.valueOf(paramLong2))) {
        return;
      }
      if (ProfileTroopMemGameInfoComponent.access$1000(this.this$0)) {
        ProfileTroopMemGameInfoComponent.access$1100(this.this$0, String.valueOf(paramLong1), String.valueOf(paramLong2));
      }
    }
  }
  
  protected void onGetTroopMemberGameCard(boolean paramBoolean, String paramString1, String paramString2, ProfileGameInfo paramProfileGameInfo)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetTroopMemberGameCard.isSuccess = ");
      paramString1.append(paramBoolean);
      paramString1.append(", hasProfileGameInfo = ");
      boolean bool;
      if (paramProfileGameInfo != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramString1.append(bool);
      QLog.d("ProfileTroopMemGameInfoComponent", 2, paramString1.toString());
    }
    if ((paramBoolean) && (ProfileTroopMemGameInfoComponent.access$000(this.this$0) != null) && (((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$100(this.this$0)).allInOne != null))
    {
      if (!((ProfileCardInfo)ProfileTroopMemGameInfoComponent.access$200(this.this$0)).allInOne.uin.equals(String.valueOf(paramString2))) {
        return;
      }
      ProfileTroopMemGameInfoComponent.access$302(this.this$0, paramProfileGameInfo);
      ProfileTroopMemGameInfoComponent.access$402(this.this$0, true);
      if (!TextUtils.isEmpty(TroopGameCardResDownloadManager.a())) {
        ProfileTroopMemGameInfoComponent.access$500(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troopgame.ProfileTroopMemGameInfoComponent.1
 * JD-Core Version:    0.7.0.1
 */