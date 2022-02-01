package com.tencent.timi.game.smoba.impl;

import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserSmobaInfoManager$requestDefaultSmobaAccountFromDbOrServer$cb$1$onResult$1
  implements Runnable
{
  UserSmobaInfoManager$requestDefaultSmobaAccountFromDbOrServer$cb$1$onResult$1(UserSmobaInfoManager.requestDefaultSmobaAccountFromDbOrServer.cb.1 param1, GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp) {}
  
  public final void run()
  {
    IUserSmobaInfoService.Callback localCallback = this.this$0.b;
    if (localCallback != null) {
      localCallback.a(true, 0, "", this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.requestDefaultSmobaAccountFromDbOrServer.cb.1.onResult.1
 * JD-Core Version:    0.7.0.1
 */