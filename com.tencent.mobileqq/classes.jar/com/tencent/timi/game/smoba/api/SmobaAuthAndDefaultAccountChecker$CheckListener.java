package com.tencent.timi.game.smoba.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/api/SmobaAuthAndDefaultAccountChecker$CheckListener;", "", "hideHintView", "", "defaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "showHintView", "authInfo", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "accountList", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface SmobaAuthAndDefaultAccountChecker$CheckListener
{
  public abstract void a(@Nullable GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp, @Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp);
  
  public abstract void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.SmobaAuthAndDefaultAccountChecker.CheckListener
 * JD-Core Version:    0.7.0.1
 */