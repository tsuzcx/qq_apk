package com.tencent.mobileqq.profilecard.bussiness.troop;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.qphone.base.util.QLog;

class ProfileTroopMemInfoComponent$3
  extends TroopManagerBizObserver
{
  ProfileTroopMemInfoComponent$3(ProfileTroopMemInfoComponent paramProfileTroopMemInfoComponent) {}
  
  protected void onGetGolbalTroopLevel(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetGolbalTroopLevel isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", level = ");
      localStringBuilder.append(paramInt);
      QLog.d("ProfileTroopMemInfoComponent", 2, localStringBuilder.toString());
    }
    if (ProfileTroopMemInfoComponent.access$3100(this.this$0) == null) {
      return;
    }
    if (((TroopManager)ProfileTroopMemInfoComponent.access$3200(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER)).m(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3300(this.this$0)).troopUin)) {
      return;
    }
    if ((paramBoolean) && (paramLong == Long.parseLong(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3400(this.this$0)).allInOne.uin)))
    {
      ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3500(this.this$0)).troopGlamourLevel = paramInt;
      if ((ProfileTroopMemInfoComponent.access$3600(this.this$0) != null) && (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$3700(this.this$0)).allInOne != null)) {
        ProfileTroopMemInfoComponent.access$1400(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.3
 * JD-Core Version:    0.7.0.1
 */