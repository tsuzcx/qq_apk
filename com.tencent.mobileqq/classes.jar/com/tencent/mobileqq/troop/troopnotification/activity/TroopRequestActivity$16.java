package com.tencent.mobileqq.troop.troopnotification.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class TroopRequestActivity$16
  extends ProfileCardObserver
{
  TroopRequestActivity$16(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (!(paramObject instanceof Card)) {
        return;
      }
      ThreadManager.post(new TroopRequestActivity.16.1(this, (Card)paramObject), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.16
 * JD-Core Version:    0.7.0.1
 */