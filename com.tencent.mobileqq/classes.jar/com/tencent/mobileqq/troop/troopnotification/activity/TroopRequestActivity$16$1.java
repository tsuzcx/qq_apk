package com.tencent.mobileqq.troop.troopnotification.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$16$1
  implements Runnable
{
  TroopRequestActivity$16$1(TroopRequestActivity.16 param16, Card paramCard) {}
  
  public void run()
  {
    if (TroopRequestActivity.a(this.b.a) != null)
    {
      Object localObject = (IProfileDataService)TroopRequestActivity.a(this.b.a).getRuntimeService(IProfileDataService.class, "");
      if (localObject != null)
      {
        localObject = ((IProfileDataService)localObject).getProfileCard(this.a.uin, false);
        if (localObject != null) {
          this.b.a.runOnUiThread(new TroopRequestActivity.16.1.1(this, (Card)localObject));
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.systemmsg.TroopRequestActivity", 2, "onUpdateFriendInfo app is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.16.1
 * JD-Core Version:    0.7.0.1
 */