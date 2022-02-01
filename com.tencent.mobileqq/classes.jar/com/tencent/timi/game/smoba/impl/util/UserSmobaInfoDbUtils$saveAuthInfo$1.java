package com.tencent.timi.game.smoba.impl.util;

import kotlin.Metadata;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserSmobaInfoDbUtils$saveAuthInfo$1
  implements Runnable
{
  UserSmobaInfoDbUtils$saveAuthInfo$1(GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp) {}
  
  public final void run()
  {
    UserSmobaInfoDbUtils.c(UserSmobaInfoDbUtils.a, this.a.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.UserSmobaInfoDbUtils.saveAuthInfo.1
 * JD-Core Version:    0.7.0.1
 */