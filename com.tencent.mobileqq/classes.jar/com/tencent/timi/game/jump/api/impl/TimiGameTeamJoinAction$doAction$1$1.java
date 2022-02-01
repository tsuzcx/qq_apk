package com.tencent.timi.game.jump.api.impl;

import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/jump/api/impl/TimiGameTeamJoinAction$doAction$1$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTeamJoinAction$doAction$1$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaAuthInfoRsp>
{
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp)
  {
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).b((IUserSmobaInfoService.Callback)new TimiGameTeamJoinAction.doAction.1.1.onResult.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameTeamJoinAction.doAction.1.1
 * JD-Core Version:    0.7.0.1
 */