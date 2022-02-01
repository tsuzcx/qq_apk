package com.tencent.mobileqq.profilecard.bussiness.troop;

import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ProfileTroopMemInfoComponent$TroopProfilePluginCallback
  implements TroopPluginCallback
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TroopProfilePluginCallback, onInstallFinish. code = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ProfileTroopMemInfoComponent", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      localObject = this.memInfoComp;
      if (localObject != null)
      {
        localObject = (ProfileTroopMemInfoComponent)((WeakReference)localObject).get();
        if (localObject != null) {
          ProfileTroopMemInfoComponent.access$5000((ProfileTroopMemInfoComponent)localObject, this.cardInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.TroopProfilePluginCallback
 * JD-Core Version:    0.7.0.1
 */