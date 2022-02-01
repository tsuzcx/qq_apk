package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class NearbyJsInterface$3
  implements ITroopMemberApiClientApi.Callback
{
  NearbyJsInterface$3(NearbyJsInterface paramNearbyJsInterface, TroopMemberApiClient paramTroopMemberApiClient, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("nearbyVideoConfig");
    this.a.b(new NearbyJsInterface.3.1(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.3
 * JD-Core Version:    0.7.0.1
 */