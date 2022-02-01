package com.tencent.timi.game.smoba.impl;

import androidx.lifecycle.MutableLiveData;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/timi/game/smoba/impl/UserSmobaInfoManager$loadCacheDataFromDB$3$1"}, k=3, mv={1, 1, 16})
final class UserSmobaInfoManager$loadCacheDataFromDB$$inlined$run$lambda$3
  implements Runnable
{
  UserSmobaInfoManager$loadCacheDataFromDB$$inlined$run$lambda$3(GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp, UserSmobaInfoManager paramUserSmobaInfoManager) {}
  
  public final void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadCacheDataFromDB accountList:");
    localStringBuilder.append(this.a);
    Logger.a("UserSmobaInfoImpl_", localStringBuilder.toString());
    UserSmobaInfoManager.d(this.this$0).setValue(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.loadCacheDataFromDB..inlined.run.lambda.3
 * JD-Core Version:    0.7.0.1
 */