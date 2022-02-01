package com.tencent.timi.game.smoba.impl;

import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserSmobaInfoManager$requestSmobaAuthInfoFromDbOrServer$cb$1$onResult$1
  implements Runnable
{
  UserSmobaInfoManager$requestSmobaAuthInfoFromDbOrServer$cb$1$onResult$1(UserSmobaInfoManager.requestSmobaAuthInfoFromDbOrServer.cb.1 param1, GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp) {}
  
  public final void run()
  {
    IUserSmobaInfoService.Callback localCallback = this.this$0.b;
    if (localCallback != null) {
      localCallback.a(true, 0, "", this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.requestSmobaAuthInfoFromDbOrServer.cb.1.onResult.1
 * JD-Core Version:    0.7.0.1
 */