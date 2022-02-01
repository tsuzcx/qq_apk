package com.tencent.timi.game.smoba.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$AuthToGetSmobaInfoCallback;", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$DialogCallback;", "authCancel", "", "authFailed", "errorCode", "", "errorMsg", "", "authSucceed", "authInfo", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IUserSmobaInfoService$AuthToGetSmobaInfoCallback
  extends IUserSmobaInfoService.DialogCallback
{
  public abstract void a();
  
  public abstract void a(int paramInt, @Nullable String paramString);
  
  public abstract void a(@NotNull GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback
 * JD-Core Version:    0.7.0.1
 */