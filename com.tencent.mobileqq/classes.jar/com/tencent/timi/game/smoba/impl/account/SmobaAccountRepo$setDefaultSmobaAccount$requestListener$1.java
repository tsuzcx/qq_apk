package com.tencent.timi.game.smoba.impl.account;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/account/SmobaAccountRepo$setDefaultSmobaAccount$requestListener$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaAccountRepo$setDefaultSmobaAccount$requestListener$1
  implements RequestListener<GameDataServerOuterClass.SetSmobaDefaultRoleRsp>
{
  SmobaAccountRepo$setDefaultSmobaAccount$requestListener$1(IUserSmobaInfoService.Callback paramCallback) {}
  
  public void a(@Nullable GameDataServerOuterClass.SetSmobaDefaultRoleRsp paramSetSmobaDefaultRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("setDefaultSmobaAccount onSuccess, rsp:");
    paramFromServiceMsg.append(paramSetSmobaDefaultRoleRsp);
    Logger.a("SmobaAccountRepo_", paramFromServiceMsg.toString());
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(true, 0, "", paramSetSmobaDefaultRoleRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.SetSmobaDefaultRoleRsp paramSetSmobaDefaultRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(false, paramInt2, paramString1, paramSetSmobaDefaultRoleRsp);
    }
    paramSetSmobaDefaultRoleRsp = new StringBuilder();
    paramSetSmobaDefaultRoleRsp.append("setDefaultSmobaAccount onError, isMsfSuccess:");
    paramSetSmobaDefaultRoleRsp.append(paramBoolean);
    paramSetSmobaDefaultRoleRsp.append(',');
    paramSetSmobaDefaultRoleRsp.append(" msfResultCode:");
    paramSetSmobaDefaultRoleRsp.append(paramInt1);
    paramSetSmobaDefaultRoleRsp.append(", timiErrCode:");
    paramSetSmobaDefaultRoleRsp.append(paramInt2);
    paramSetSmobaDefaultRoleRsp.append(',');
    paramSetSmobaDefaultRoleRsp.append(" timiSubErrCode:");
    paramSetSmobaDefaultRoleRsp.append(paramInt3);
    paramSetSmobaDefaultRoleRsp.append(", timiErrMsg:");
    paramSetSmobaDefaultRoleRsp.append(paramString1);
    paramSetSmobaDefaultRoleRsp.append(" timiDisplayErrMsg:");
    paramSetSmobaDefaultRoleRsp.append(paramString2);
    Logger.c("SmobaAccountRepo_", paramSetSmobaDefaultRoleRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.account.SmobaAccountRepo.setDefaultSmobaAccount.requestListener.1
 * JD-Core Version:    0.7.0.1
 */