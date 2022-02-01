package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class ProfileCardMoreActivity$15
  extends ProfileCardObserver
{
  ProfileCardMoreActivity$15(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if ((!paramBoolean) || (paramInt != 0))
    {
      if ((!paramBoolean) && (paramInt == 34)) {
        return;
      }
      this.a.notifyUser(2131892847, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.15
 * JD-Core Version:    0.7.0.1
 */