package com.tencent.timi.game.smoba.impl.auth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.log.encrypt.Base64;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoReq;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/auth/GetAuthInfoServlet$Companion;", "", "()V", "TAG", "", "createReqIntent", "Lmqq/app/NewIntent;", "uin", "", "setRequest", "", "requestListener", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetAuthInfoServlet$Companion
{
  private final NewIntent a(long paramLong)
  {
    Object localObject1 = new GameDataServerOuterClass.GetSmobaAuthInfoReq();
    ((GameDataServerOuterClass.GetSmobaAuthInfoReq)localObject1).uid.set(paramLong);
    Object localObject2 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject2 != null)
    {
      int i;
      if (((IExpandHall)localObject2).b().a != 2) {
        i = 0;
      } else {
        i = 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createReqIntent scene:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append('}');
      Logger.a("GetAuthInfoServlet", ((StringBuilder)localObject2).toString());
      ((GameDataServerOuterClass.GetSmobaAuthInfoReq)localObject1).sense.set(i);
    }
    localObject1 = BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localObject1, GetAuthInfoServlet.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "CreateReqIntentUtil.crea…:class.java\n            )");
    return localObject1;
  }
  
  public final void a(long paramLong, @NotNull RequestListener<GameDataServerOuterClass.GetSmobaAuthInfoRsp> paramRequestListener)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestListener, "requestListener");
    Object localObject = ((Companion)this).a(paramLong);
    ((NetApi)ServiceCenter.a(NetApi.class)).a((NewIntent)localObject, GameDataServerOuterClass.GetSmobaAuthInfoRsp.class, paramRequestListener);
    paramRequestListener = new StringBuilder();
    paramRequestListener.append("send request, uin:");
    localObject = String.valueOf(paramLong);
    Charset localCharset = Charsets.UTF_8;
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
      paramRequestListener.append(Base64.encode((byte[])localObject));
      Logger.a("GetAuthInfoServlet", paramRequestListener.toString());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.auth.GetAuthInfoServlet.Companion
 * JD-Core Version:    0.7.0.1
 */