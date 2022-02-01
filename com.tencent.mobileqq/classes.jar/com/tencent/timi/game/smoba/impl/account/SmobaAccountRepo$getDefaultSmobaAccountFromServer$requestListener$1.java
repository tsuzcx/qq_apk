package com.tencent.timi.game.smoba.impl.account;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.Companion;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/account/SmobaAccountRepo$getDefaultSmobaAccountFromServer$requestListener$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaAccountRepo$getDefaultSmobaAccountFromServer$requestListener$1
  implements RequestListener<GameDataServerOuterClass.GetSmobaDefaultRoleRsp>
{
  SmobaAccountRepo$getDefaultSmobaAccountFromServer$requestListener$1(IUserSmobaInfoService.Callback paramCallback) {}
  
  public void a(@Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("getDefaultSmobaAccountFromServer onSuccess, rsp:");
    paramFromServiceMsg.append(paramGetSmobaDefaultRoleRsp);
    Logger.a("SmobaAccountRepo_", paramFromServiceMsg.toString());
    UserSmobaInfoManager.a.a().a(paramGetSmobaDefaultRoleRsp);
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(true, 0, "", paramGetSmobaDefaultRoleRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(false, paramInt2, paramString1, paramGetSmobaDefaultRoleRsp);
    }
    paramGetSmobaDefaultRoleRsp = new StringBuilder();
    paramGetSmobaDefaultRoleRsp.append("getDefaultSmobaAccountFromServer onError, isMsfSuccess:");
    paramGetSmobaDefaultRoleRsp.append(paramBoolean);
    paramGetSmobaDefaultRoleRsp.append(',');
    paramGetSmobaDefaultRoleRsp.append(" msfResultCode:");
    paramGetSmobaDefaultRoleRsp.append(paramInt1);
    paramGetSmobaDefaultRoleRsp.append(", timiErrCode:");
    paramGetSmobaDefaultRoleRsp.append(paramInt2);
    paramGetSmobaDefaultRoleRsp.append(',');
    paramGetSmobaDefaultRoleRsp.append(" timiSubErrCode:");
    paramGetSmobaDefaultRoleRsp.append(paramInt3);
    paramGetSmobaDefaultRoleRsp.append(", timiErrMsg:");
    paramGetSmobaDefaultRoleRsp.append(paramString1);
    paramGetSmobaDefaultRoleRsp.append(" timiDisplayErrMsg:");
    paramGetSmobaDefaultRoleRsp.append(paramString2);
    Logger.c("SmobaAccountRepo_", paramGetSmobaDefaultRoleRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.account.SmobaAccountRepo.getDefaultSmobaAccountFromServer.requestListener.1
 * JD-Core Version:    0.7.0.1
 */