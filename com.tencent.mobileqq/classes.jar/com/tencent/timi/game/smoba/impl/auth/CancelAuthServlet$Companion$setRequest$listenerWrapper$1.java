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
import trpc.yes.common.GameDataServerOuterClass.CancelSmobaAuthRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/auth/CancelAuthServlet$Companion$setRequest$listenerWrapper$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$CancelSmobaAuthRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class CancelAuthServlet$Companion$setRequest$listenerWrapper$1
  implements RequestListener<GameDataServerOuterClass.CancelSmobaAuthRsp>
{
  CancelAuthServlet$Companion$setRequest$listenerWrapper$1(RequestListener paramRequestListener) {}
  
  public void a(@Nullable GameDataServerOuterClass.CancelSmobaAuthRsp paramCancelSmobaAuthRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if (paramCancelSmobaAuthRsp != null)
    {
      GameDataServerOuterClass.GetSmobaAuthInfoRsp localGetSmobaAuthInfoRsp = new GameDataServerOuterClass.GetSmobaAuthInfoRsp();
      localGetSmobaAuthInfoRsp.auth_desc.set(paramCancelSmobaAuthRsp.auth_desc.get());
      localGetSmobaAuthInfoRsp.is_auth.set(paramCancelSmobaAuthRsp.is_auth.get());
      UserSmobaInfoManager.a.a().a(localGetSmobaAuthInfoRsp);
    }
    else
    {
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d(null);
    }
    UserSmobaInfoManager.a.a().a(null);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).b(null);
    this.a.a((MessageMicro)paramCancelSmobaAuthRsp, paramFromServiceMsg);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.CancelSmobaAuthRsp paramCancelSmobaAuthRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    this.a.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramString1, paramString2, (MessageMicro)paramCancelSmobaAuthRsp, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.auth.CancelAuthServlet.Companion.setRequest.listenerWrapper.1
 * JD-Core Version:    0.7.0.1
 */