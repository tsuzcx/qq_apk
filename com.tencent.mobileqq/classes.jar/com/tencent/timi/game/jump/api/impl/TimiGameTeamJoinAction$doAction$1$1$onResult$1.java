package com.tencent.timi.game.jump.api.impl;

import android.app.Activity;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/jump/api/impl/TimiGameTeamJoinAction$doAction$1$1$onResult$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTeamJoinAction$doAction$1$1$onResult$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp>
{
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(true, (Activity)TimiGameActivityManager.a(), this.a.a.a, 2, 2, 1, 0, 0, CollectionsKt.emptyList(), ((IRoomService)ServiceCenter.a(IRoomService.class)).b(1), this.a.a.b, this.a.a.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameTeamJoinAction.doAction.1.1.onResult.1
 * JD-Core Version:    0.7.0.1
 */