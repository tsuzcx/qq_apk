package com.tencent.mobileqq.troop.troopgame.handler;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import java.util.HashSet;

class TroopGameHandler$1
  implements WadlTrpcListener
{
  TroopGameHandler$1(TroopGameHandler paramTroopGameHandler) {}
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("/v1/3");
    localHashSet.add("/v1/4");
    return localHashSet;
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (paramString.equals("/v1/3"))
    {
      TroopGameHandler.a(this.a, paramIntent, paramLong, paramTrpcInovkeRsp);
      return;
    }
    if (paramString.equals("/v1/4")) {
      TroopGameHandler.b(this.a, paramIntent, paramLong, paramTrpcInovkeRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler.1
 * JD-Core Version:    0.7.0.1
 */