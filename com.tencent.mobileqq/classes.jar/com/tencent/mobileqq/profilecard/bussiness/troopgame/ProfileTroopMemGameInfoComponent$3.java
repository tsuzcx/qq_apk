package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;

class ProfileTroopMemGameInfoComponent$3
  implements Runnable
{
  ProfileTroopMemGameInfoComponent$3(ProfileTroopMemGameInfoComponent paramProfileTroopMemGameInfoComponent) {}
  
  public void run()
  {
    if (ProfileTroopMemGameInfoComponent.access$1300(this.this$0) != null)
    {
      int i = ((View)ProfileTroopMemGameInfoComponent.access$1400(this.this$0)).getTop();
      if ((i >= 0) && (ProfileTroopMemGameInfoComponent.access$1500(this.this$0) != null)) {
        ProfileTroopMemGameInfoComponent.access$1600(this.this$0).scrollToMoreInfoView(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troopgame.ProfileTroopMemGameInfoComponent.3
 * JD-Core Version:    0.7.0.1
 */