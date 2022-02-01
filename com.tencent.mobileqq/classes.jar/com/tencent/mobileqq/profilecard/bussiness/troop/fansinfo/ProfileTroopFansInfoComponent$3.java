package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.view.View;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;

class ProfileTroopFansInfoComponent$3
  implements Runnable
{
  ProfileTroopFansInfoComponent$3(ProfileTroopFansInfoComponent paramProfileTroopFansInfoComponent) {}
  
  public void run()
  {
    if ((ProfileUtils.isVisible((View)ProfileTroopFansInfoComponent.access$400(this.this$0))) && (!ProfileTroopFansInfoComponent.access$500(this.this$0)))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B597", "0X800B597", 0, 0, "", "", "", "");
      ProfileTroopFansInfoComponent.access$502(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.3
 * JD-Core Version:    0.7.0.1
 */