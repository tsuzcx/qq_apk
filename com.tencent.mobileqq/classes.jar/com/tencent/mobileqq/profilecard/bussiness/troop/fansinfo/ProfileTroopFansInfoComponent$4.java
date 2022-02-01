package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;

class ProfileTroopFansInfoComponent$4
  implements Runnable
{
  ProfileTroopFansInfoComponent$4(ProfileTroopFansInfoComponent paramProfileTroopFansInfoComponent) {}
  
  public void run()
  {
    if (ProfileTroopFansInfoComponent.access$600(this.this$0) != null)
    {
      int i = ((View)ProfileTroopFansInfoComponent.access$700(this.this$0)).getTop();
      if ((i >= 0) && (ProfileTroopFansInfoComponent.access$800(this.this$0) != null)) {
        ProfileTroopFansInfoComponent.access$900(this.this$0).scrollToMoreInfoView(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.4
 * JD-Core Version:    0.7.0.1
 */