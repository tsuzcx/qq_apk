package com.tencent.timi.game.smoba.impl.account;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.log.encrypt.Base64;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
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
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleReq;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/account/GetSmobaDefaultAccountServlet$Companion;", "", "()V", "TAG", "", "createReqIntent", "Lmqq/app/NewIntent;", "uin", "", "setRequest", "", "requestListener", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetSmobaDefaultAccountServlet$Companion
{
  private final NewIntent a(long paramLong)
  {
    Object localObject = new GameDataServerOuterClass.GetSmobaDefaultRoleReq();
    ((GameDataServerOuterClass.GetSmobaDefaultRoleReq)localObject).uid.set(paramLong);
    localObject = BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localObject, GetSmobaDefaultAccountServlet.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "CreateReqIntentUtil.crea…:class.java\n            )");
    return localObject;
  }
  
  public final void a(@NotNull RequestListener<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> paramRequestListener)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestListener, "requestListener");
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localObject).a();
    localObject = ((Companion)this).a(l);
    ((NetApi)ServiceCenter.a(NetApi.class)).a((NewIntent)localObject, GameDataServerOuterClass.GetSmobaDefaultRoleRsp.class, paramRequestListener);
    paramRequestListener = new StringBuilder();
    paramRequestListener.append("send request, uin:");
    localObject = String.valueOf(l);
    Charset localCharset = Charsets.UTF_8;
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
      paramRequestListener.append(Base64.encode((byte[])localObject));
      Logger.a("GetSmobaDefaultAccountServlet", paramRequestListener.toString());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.account.GetSmobaDefaultAccountServlet.Companion
 * JD-Core Version:    0.7.0.1
 */