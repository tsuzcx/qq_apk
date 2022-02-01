package com.tencent.mobileqq.profilecard.bussiness.troop;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.qphone.base.util.QLog;

class ProfileTroopMemInfoComponent$4
  implements Runnable
{
  ProfileTroopMemInfoComponent$4(ProfileTroopMemInfoComponent paramProfileTroopMemInfoComponent, ProfileCardInfo paramProfileCardInfo) {}
  
  public void run()
  {
    if (ProfileTroopMemInfoComponent.access$4600(this.this$0) == null) {}
    do
    {
      do
      {
        return;
      } while (!ProfileTroopMemInfoComponent.access$4700(this.this$0).isResume());
      if (this.val$cardInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, "onPluginInstallFinish, updateRecentSaidView.");
        }
        ProfileTroopMemInfoComponent.access$4400(ProfileTroopMemInfoComponent.access$4300(this.this$0), this.val$cardInfo, this.this$0);
      }
    } while (ProfileTroopMemInfoComponent.access$4800(this.this$0) == null);
    ProfileTroopMemInfoComponent.access$4900(this.this$0).notifyCardUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.4
 * JD-Core Version:    0.7.0.1
 */