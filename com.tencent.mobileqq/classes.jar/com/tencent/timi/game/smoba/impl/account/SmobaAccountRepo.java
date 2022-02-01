package com.tencent.timi.game.smoba.impl.account;

import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/account/SmobaAccountRepo;", "", "()V", "getDefaultSmobaAccountFromServer", "", "callback", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "getSmobaAccountListFromServer", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "loadSmobaUserSmobaInfoFromDB", "Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoEntity;", "uin", "", "setDefaultSmobaAccount", "defaultAccountInfo", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaAccountRepo
{
  public static final SmobaAccountRepo.Companion a = new SmobaAccountRepo.Companion(null);
  
  public final void a(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetUserSmobaRoleListRsp> paramCallback)
  {
    paramCallback = new SmobaAccountRepo.getSmobaAccountListFromServer.requestListener.1(paramCallback);
    GetSmobaAccountListServlet.a.a((RequestListener)paramCallback);
  }
  
  public final void a(@NotNull GameDataServerOuterClass.SmobaGameRoleAbsInfo paramSmobaGameRoleAbsInfo, @Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.SetSmobaDefaultRoleRsp> paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramSmobaGameRoleAbsInfo, "defaultAccountInfo");
    paramCallback = new SmobaAccountRepo.setDefaultSmobaAccount.requestListener.1(paramCallback);
    SetSmobaDefaultAccountServlet.a.a(paramSmobaGameRoleAbsInfo, (RequestListener)paramCallback);
  }
  
  public final void b(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> paramCallback)
  {
    paramCallback = new SmobaAccountRepo.getDefaultSmobaAccountFromServer.requestListener.1(paramCallback);
    GetSmobaDefaultAccountServlet.a.a((RequestListener)paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.account.SmobaAccountRepo
 * JD-Core Version:    0.7.0.1
 */