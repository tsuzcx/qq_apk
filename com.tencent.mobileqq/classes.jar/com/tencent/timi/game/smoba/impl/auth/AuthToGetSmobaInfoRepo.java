package com.tencent.timi.game.smoba.impl.auth;

import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.CancelSmobaAuthRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/auth/AuthToGetSmobaInfoRepo;", "", "()V", "agreeSmobaAuth", "", "cb", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "cancelSmobaAuth", "Ltrpc/yes/common/GameDataServerOuterClass$CancelSmobaAuthRsp;", "getAuthInfoRsp", "callback", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AuthToGetSmobaInfoRepo
{
  public static final AuthToGetSmobaInfoRepo.Companion a = new AuthToGetSmobaInfoRepo.Companion(null);
  
  public final void a(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaAuthInfoRsp> paramCallback)
  {
    paramCallback = new AuthToGetSmobaInfoRepo.getAuthInfoRsp.requestListener.1(paramCallback);
    IService localIService = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localIService).a();
    GetAuthInfoServlet.a.a(l, (RequestListener)paramCallback);
  }
  
  public final void b(@NotNull IUserSmobaInfoService.Callback<GameDataServerOuterClass.CancelSmobaAuthRsp> paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCallback, "cb");
    paramCallback = new AuthToGetSmobaInfoRepo.cancelSmobaAuth.requestListener.1(paramCallback);
    CancelAuthServlet.a.a((RequestListener)paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.auth.AuthToGetSmobaInfoRepo
 * JD-Core Version:    0.7.0.1
 */