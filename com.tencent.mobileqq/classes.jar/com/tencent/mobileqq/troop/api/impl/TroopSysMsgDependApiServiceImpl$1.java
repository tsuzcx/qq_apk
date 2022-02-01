package com.tencent.mobileqq.troop.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.FollowPublicAccountObserver;

class TroopSysMsgDependApiServiceImpl$1
  extends TroopBindPubAccountProtocol.FollowPublicAccountObserver
{
  TroopSysMsgDependApiServiceImpl$1(TroopSysMsgDependApiServiceImpl paramTroopSysMsgDependApiServiceImpl, ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver paramITransitTroopProtocolOnFollowObserver) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver localITransitTroopProtocolOnFollowObserver = this.a;
    if (localITransitTroopProtocolOnFollowObserver != null) {
      localITransitTroopProtocolOnFollowObserver.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopSysMsgDependApiServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */