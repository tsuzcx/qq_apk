package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;

class ProfileCardMoreActivity$1
  implements Runnable
{
  ProfileCardMoreActivity$1(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void run()
  {
    this.this$0.m();
    ProfileCardMoreActivity localProfileCardMoreActivity = this.this$0;
    localProfileCardMoreActivity.G = Boolean.valueOf(MutualMarkDataCenter.b(localProfileCardMoreActivity.app, this.this$0.b.uin, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.1
 * JD-Core Version:    0.7.0.1
 */