package com.tencent.timi.game.jump.api.impl;

import android.app.Activity;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.team.api.ITeamService;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/jump/api/impl/TimiGameTeamCreateAction$doAction$1$1$onResult$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTeamCreateAction$doAction$1$1$onResult$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp>
{
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    ((ITeamService)ServiceCenter.a(ITeamService.class)).a((Activity)TimiGameActivityManager.a(), 2, 2, 0L, this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameTeamCreateAction.doAction.1.1.onResult.1
 * JD-Core Version:    0.7.0.1
 */