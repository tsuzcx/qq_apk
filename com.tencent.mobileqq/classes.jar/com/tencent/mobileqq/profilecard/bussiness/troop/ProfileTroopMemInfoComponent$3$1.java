package com.tencent.mobileqq.profilecard.bussiness.troop;

import com.tencent.mobileqq.app.BaseActivity;

class ProfileTroopMemInfoComponent$3$1
  implements Runnable
{
  ProfileTroopMemInfoComponent$3$1(ProfileTroopMemInfoComponent.3 param3) {}
  
  public void run()
  {
    if (ProfileTroopMemInfoComponent.access$4100(this.this$1.this$0) == null) {}
    while ((!ProfileTroopMemInfoComponent.access$4200(this.this$1.this$0).isResume()) || (!this.this$1.this$0.isPluginInstalled) || (ProfileTroopMemInfoComponent.access$4300(this.this$1.this$0) == null)) {
      return;
    }
    ProfileTroopMemInfoComponent.access$4400(ProfileTroopMemInfoComponent.access$4300(this.this$1.this$0), this.this$1.val$cardInfo, this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.3.1
 * JD-Core Version:    0.7.0.1
 */