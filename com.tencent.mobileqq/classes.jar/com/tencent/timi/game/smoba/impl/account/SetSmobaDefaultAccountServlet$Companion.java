package com.tencent.timi.game.smoba.impl.account;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleReq;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/account/SetSmobaDefaultAccountServlet$Companion;", "", "()V", "TAG", "", "createReqIntent", "Lmqq/app/NewIntent;", "defaultAccountAbsInfo", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "setRequest", "", "requestListener", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SetSmobaDefaultAccountServlet$Companion
{
  private final NewIntent a(GameDataServerOuterClass.SmobaGameRoleAbsInfo paramSmobaGameRoleAbsInfo)
  {
    GameDataServerOuterClass.SetSmobaDefaultRoleReq localSetSmobaDefaultRoleReq = new GameDataServerOuterClass.SetSmobaDefaultRoleReq();
    IService localIService = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localIService).a();
    localSetSmobaDefaultRoleReq.uid.set(l);
    localSetSmobaDefaultRoleReq.area.set(paramSmobaGameRoleAbsInfo.area.get());
    localSetSmobaDefaultRoleReq.partition.set(paramSmobaGameRoleAbsInfo.partition.get());
    paramSmobaGameRoleAbsInfo = BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localSetSmobaDefaultRoleReq, SetSmobaDefaultAccountServlet.class);
    Intrinsics.checkExpressionValueIsNotNull(paramSmobaGameRoleAbsInfo, "CreateReqIntentUtil.crea…:class.java\n            )");
    return paramSmobaGameRoleAbsInfo;
  }
  
  public final void a(@NotNull GameDataServerOuterClass.SmobaGameRoleAbsInfo paramSmobaGameRoleAbsInfo, @NotNull RequestListener<GameDataServerOuterClass.SetSmobaDefaultRoleRsp> paramRequestListener)
  {
    Intrinsics.checkParameterIsNotNull(paramSmobaGameRoleAbsInfo, "defaultAccountAbsInfo");
    Intrinsics.checkParameterIsNotNull(paramRequestListener, "requestListener");
    paramSmobaGameRoleAbsInfo = ((Companion)this).a(paramSmobaGameRoleAbsInfo);
    paramRequestListener = new SetSmobaDefaultAccountServlet.Companion.setRequest.listenerWrapper.1(paramRequestListener);
    ((NetApi)ServiceCenter.a(NetApi.class)).a(paramSmobaGameRoleAbsInfo, GameDataServerOuterClass.SetSmobaDefaultRoleRsp.class, (RequestListener)paramRequestListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.account.SetSmobaDefaultAccountServlet.Companion
 * JD-Core Version:    0.7.0.1
 */