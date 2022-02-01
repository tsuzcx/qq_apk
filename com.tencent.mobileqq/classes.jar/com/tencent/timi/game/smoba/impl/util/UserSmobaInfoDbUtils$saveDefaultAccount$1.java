package com.tencent.timi.game.smoba.impl.util;

import kotlin.Metadata;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserSmobaInfoDbUtils$saveDefaultAccount$1
  implements Runnable
{
  UserSmobaInfoDbUtils$saveDefaultAccount$1(GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp) {}
  
  public final void run()
  {
    UserSmobaInfoDbUtils localUserSmobaInfoDbUtils = UserSmobaInfoDbUtils.a;
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((GameDataServerOuterClass.GetSmobaDefaultRoleRsp)localObject).toByteArray();
    } else {
      localObject = null;
    }
    UserSmobaInfoDbUtils.b(localUserSmobaInfoDbUtils, (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.UserSmobaInfoDbUtils.saveDefaultAccount.1
 * JD-Core Version:    0.7.0.1
 */