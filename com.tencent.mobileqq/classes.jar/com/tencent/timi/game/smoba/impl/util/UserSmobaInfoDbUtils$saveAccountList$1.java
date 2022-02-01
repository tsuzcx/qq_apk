package com.tencent.timi.game.smoba.impl.util;

import kotlin.Metadata;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserSmobaInfoDbUtils$saveAccountList$1
  implements Runnable
{
  UserSmobaInfoDbUtils$saveAccountList$1(GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp) {}
  
  public final void run()
  {
    UserSmobaInfoDbUtils localUserSmobaInfoDbUtils = UserSmobaInfoDbUtils.a;
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((GameDataServerOuterClass.GetUserSmobaRoleListRsp)localObject).toByteArray();
    } else {
      localObject = null;
    }
    UserSmobaInfoDbUtils.a(localUserSmobaInfoDbUtils, (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.UserSmobaInfoDbUtils.saveAccountList.1
 * JD-Core Version:    0.7.0.1
 */