package com.tencent.mobileqq.troop.troopnotification.activity;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$15
  extends ProfileCardObserver
{
  TroopRequestActivity$15(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCardDownload() isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("  data:");
      localStringBuilder.append(paramObject);
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localStringBuilder.toString());
    }
    if (paramObject == null) {
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      if ((paramObject.uin != null) && (paramObject.uin.equals(this.a.b))) {
        TroopRequestActivity.a(this.a, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.15
 * JD-Core Version:    0.7.0.1
 */