package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.profile.ProfileCardShareHelper.OnShareListener;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.statistics.ReportController;

class ProfileCardMoreActivity$18
  implements ProfileCardShareHelper.OnShareListener
{
  ProfileCardMoreActivity$18(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      if (ProfilePAUtils.isPaTypeFriend(this.a.b)) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X80050E7", "0X80050E7", paramInt, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A4FD", "0X800A4FD", 0, 0, "", "0", "0", "");
      return;
    }
    if (paramInt == 2) {
      ReportController.b(null, "dc00898", "", "", "0X800A4FE", "0X800A4FE", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.18
 * JD-Core Version:    0.7.0.1
 */