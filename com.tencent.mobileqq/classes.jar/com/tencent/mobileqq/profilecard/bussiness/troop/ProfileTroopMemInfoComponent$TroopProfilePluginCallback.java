package com.tencent.mobileqq.profilecard.bussiness.troop;

import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;
import java.lang.ref.WeakReference;

class ProfileTroopMemInfoComponent$TroopProfilePluginCallback
  implements TroopPluginManager.TroopPluginCallback
{
  ProfileCardInfo cardInfo;
  WeakReference<ProfileTroopMemInfoComponent> memInfoComp;
  
  ProfileTroopMemInfoComponent$TroopProfilePluginCallback(WeakReference<ProfileTroopMemInfoComponent> paramWeakReference, ProfileCardInfo paramProfileCardInfo)
  {
    this.memInfoComp = paramWeakReference;
    this.cardInfo = paramProfileCardInfo;
  }
  
  public void onInstallFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "TroopProfilePluginCallback, onInstallFinish. code = " + paramInt);
    }
    if ((paramInt == 0) && (this.memInfoComp != null))
    {
      ProfileTroopMemInfoComponent localProfileTroopMemInfoComponent = (ProfileTroopMemInfoComponent)this.memInfoComp.get();
      if (localProfileTroopMemInfoComponent != null) {
        ProfileTroopMemInfoComponent.access$5000(localProfileTroopMemInfoComponent, this.cardInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.TroopProfilePluginCallback
 * JD-Core Version:    0.7.0.1
 */