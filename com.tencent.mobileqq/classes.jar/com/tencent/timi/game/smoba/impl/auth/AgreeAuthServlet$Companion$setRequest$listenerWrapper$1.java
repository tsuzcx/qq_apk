package com.tencent.timi.game.smoba.impl.auth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.Companion;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/auth/AgreeAuthServlet$Companion$setRequest$listenerWrapper$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AgreeAuthServlet$Companion$setRequest$listenerWrapper$1
  implements RequestListener<GameDataServerOuterClass.AgreeSmobaAuthRsp>
{
  AgreeAuthServlet$Companion$setRequest$listenerWrapper$1(RequestListener paramRequestListener) {}
  
  public void a(@Nullable GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if (paramAgreeSmobaAuthRsp != null)
    {
      GameDataServerOuterClass.GetSmobaAuthInfoRsp localGetSmobaAuthInfoRsp = new GameDataServerOuterClass.GetSmobaAuthInfoRsp();
      localGetSmobaAuthInfoRsp.auth_desc.set(paramAgreeSmobaAuthRsp.auth_desc.get());
      localGetSmobaAuthInfoRsp.is_auth.set(paramAgreeSmobaAuthRsp.is_auth.get());
      UserSmobaInfoManager.a.a().a(localGetSmobaAuthInfoRsp);
    }
    if (paramAgreeSmobaAuthRsp == null) {
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d(null);
    }
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).b(null);
    this.a.a((MessageMicro)paramAgreeSmobaAuthRsp, paramFromServiceMsg);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    this.a.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramString1, paramString2, (MessageMicro)paramAgreeSmobaAuthRsp, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.auth.AgreeAuthServlet.Companion.setRequest.listenerWrapper.1
 * JD-Core Version:    0.7.0.1
 */