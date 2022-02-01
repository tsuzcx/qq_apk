package com.tencent.timi.game.smoba.impl.account;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.Companion;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/account/SetSmobaDefaultAccountServlet$Companion$setRequest$listenerWrapper$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SetSmobaDefaultAccountServlet$Companion$setRequest$listenerWrapper$1
  implements RequestListener<GameDataServerOuterClass.SetSmobaDefaultRoleRsp>
{
  SetSmobaDefaultAccountServlet$Companion$setRequest$listenerWrapper$1(RequestListener paramRequestListener) {}
  
  public void a(@Nullable GameDataServerOuterClass.SetSmobaDefaultRoleRsp paramSetSmobaDefaultRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if (paramSetSmobaDefaultRoleRsp != null)
    {
      GameDataServerOuterClass.GetSmobaDefaultRoleRsp localGetSmobaDefaultRoleRsp = new GameDataServerOuterClass.GetSmobaDefaultRoleRsp();
      localGetSmobaDefaultRoleRsp.role_info.set(paramSetSmobaDefaultRoleRsp.role_info.get());
      UserSmobaInfoManager.a.a().a(localGetSmobaDefaultRoleRsp);
    }
    else
    {
      Logger.INSTANCE.e(new String[] { "SetSmobaDefaultAccountServlet", "SetSmobaDefaultAccountServlet#onSuccess response is null" });
      UserSmobaInfoManager.a.a().a(null);
    }
    this.a.a((MessageMicro)paramSetSmobaDefaultRoleRsp, paramFromServiceMsg);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.SetSmobaDefaultRoleRsp paramSetSmobaDefaultRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    this.a.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramString1, paramString2, (MessageMicro)paramSetSmobaDefaultRoleRsp, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.account.SetSmobaDefaultAccountServlet.Companion.setRequest.listenerWrapper.1
 * JD-Core Version:    0.7.0.1
 */