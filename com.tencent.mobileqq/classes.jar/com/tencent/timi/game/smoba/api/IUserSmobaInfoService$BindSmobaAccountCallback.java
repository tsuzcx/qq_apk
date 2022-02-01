package com.tencent.timi.game.smoba.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$BindSmobaAccountCallback;", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$DialogCallback;", "bindCancel", "", "bindFailed", "errorCode", "", "errorMsg", "", "bindSucceed", "selectedDefaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IUserSmobaInfoService$BindSmobaAccountCallback
  extends IUserSmobaInfoService.DialogCallback
{
  public abstract void a();
  
  public abstract void a(int paramInt, @Nullable String paramString);
  
  public abstract void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback
 * JD-Core Version:    0.7.0.1
 */