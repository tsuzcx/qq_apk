package com.tencent.mobileqq.troop.troopnotification.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import mqq.os.MqqHandler;

class TroopRequestActivity$3
  implements Runnable
{
  TroopRequestActivity$3(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void run()
  {
    Object localObject = (IProfileDataService)TroopRequestActivity.a(this.this$0).getRuntimeService(IProfileDataService.class, "");
    if (localObject != null)
    {
      localObject = ((IProfileDataService)localObject).getProfileCard(this.this$0.b, false);
      ThreadManager.getUIHandler().post(new TroopRequestActivity.3.1(this, (Card)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.3
 * JD-Core Version:    0.7.0.1
 */