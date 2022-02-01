package com.tencent.timi.game.smoba.impl.auth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthReq;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/auth/AgreeAuthServlet$Companion;", "", "()V", "TAG", "", "createReqIntent", "Lmqq/app/NewIntent;", "uin", "", "setRequest", "", "requestListener", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AgreeAuthServlet$Companion
{
  private final NewIntent a(long paramLong)
  {
    Object localObject = new GameDataServerOuterClass.AgreeSmobaAuthReq();
    ((GameDataServerOuterClass.AgreeSmobaAuthReq)localObject).uid.set(paramLong);
    localObject = BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localObject, AgreeAuthServlet.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "CreateReqIntentUtil.crea…:class.java\n            )");
    return localObject;
  }
  
  public final void a(@NotNull RequestListener<GameDataServerOuterClass.AgreeSmobaAuthRsp> paramRequestListener)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestListener, "requestListener");
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localObject).a();
    localObject = ((Companion)this).a(l);
    paramRequestListener = new AgreeAuthServlet.Companion.setRequest.listenerWrapper.1(paramRequestListener);
    ((NetApi)ServiceCenter.a(NetApi.class)).a((NewIntent)localObject, GameDataServerOuterClass.AgreeSmobaAuthRsp.class, (RequestListener)paramRequestListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.auth.AgreeAuthServlet.Companion
 * JD-Core Version:    0.7.0.1
 */