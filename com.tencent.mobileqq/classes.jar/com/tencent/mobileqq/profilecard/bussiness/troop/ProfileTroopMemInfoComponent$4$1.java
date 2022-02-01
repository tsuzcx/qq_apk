package com.tencent.mobileqq.profilecard.bussiness.troop;

import com.tencent.mobileqq.app.QBaseActivity;

class ProfileTroopMemInfoComponent$4$1
  implements Runnable
{
  ProfileTroopMemInfoComponent$4$1(ProfileTroopMemInfoComponent.4 param4) {}
  
  public void run()
  {
    if (ProfileTroopMemInfoComponent.access$4100(this.this$1.this$0) == null) {
      return;
    }
    if (!ProfileTroopMemInfoComponent.access$4200(this.this$1.this$0).isResume()) {
      return;
    }
    if ((this.this$1.this$0.isPluginInstalled) && (ProfileTroopMemInfoComponent.access$4300(this.this$1.this$0) != null)) {
      ProfileTroopMemInfoComponent.access$4400(ProfileTroopMemInfoComponent.access$4300(this.this$1.this$0), this.this$1.val$cardInfo, this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.4.1
 * JD-Core Version:    0.7.0.1
 */