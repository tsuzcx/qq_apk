package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;

class TroopInfoActivity$6
  implements Runnable
{
  TroopInfoActivity$6(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    if (this.this$0.H != null)
    {
      ((ITroopInfoService)this.this$0.H.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(this.this$0.i);
      ITroopModifyHandler localITroopModifyHandler = (ITroopModifyHandler)this.this$0.H.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName());
      if (localITroopModifyHandler != null) {
        localITroopModifyHandler.a(TroopModifyObserver.d, true, this.this$0.i.troopuin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */