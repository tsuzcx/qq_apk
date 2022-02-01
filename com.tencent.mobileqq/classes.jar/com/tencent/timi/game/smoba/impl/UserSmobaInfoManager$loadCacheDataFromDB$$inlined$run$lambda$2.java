package com.tencent.timi.game.smoba.impl;

import androidx.lifecycle.MutableLiveData;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/timi/game/smoba/impl/UserSmobaInfoManager$loadCacheDataFromDB$2$1"}, k=3, mv={1, 1, 16})
final class UserSmobaInfoManager$loadCacheDataFromDB$$inlined$run$lambda$2
  implements Runnable
{
  UserSmobaInfoManager$loadCacheDataFromDB$$inlined$run$lambda$2(GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp, UserSmobaInfoManager paramUserSmobaInfoManager) {}
  
  public final void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadCacheDataFromDB defaultAccount:");
    localStringBuilder.append(this.a);
    Logger.a("UserSmobaInfoImpl_", localStringBuilder.toString());
    UserSmobaInfoManager.c(this.this$0).setValue(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.loadCacheDataFromDB..inlined.run.lambda.2
 * JD-Core Version:    0.7.0.1
 */