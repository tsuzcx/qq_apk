package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class ProfileCardMoreActivity$10
  extends ProfileCardObserver
{
  ProfileCardMoreActivity$10(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (((paramBoolean) && (paramInt == 0)) || ((!paramBoolean) && (paramInt == 34))) {
      return;
    }
    this.a.notifyUser(2131695129, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.10
 * JD-Core Version:    0.7.0.1
 */