package com.tencent.timi.game.smoba.impl.account;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.Companion;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/account/SmobaAccountRepo$getSmobaAccountListFromServer$requestListener$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaAccountRepo$getSmobaAccountListFromServer$requestListener$1
  implements RequestListener<GameDataServerOuterClass.GetUserSmobaRoleListRsp>
{
  SmobaAccountRepo$getSmobaAccountListFromServer$requestListener$1(IUserSmobaInfoService.Callback paramCallback) {}
  
  public void a(@Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("SmobaAccountRepo_", "getSmobaAccountListFromServer onSuccess");
    paramFromServiceMsg = paramGetUserSmobaRoleListRsp;
    if (paramGetUserSmobaRoleListRsp == null) {
      paramFromServiceMsg = new GameDataServerOuterClass.GetUserSmobaRoleListRsp();
    }
    UserSmobaInfoManager.a.a().a(paramFromServiceMsg);
    paramGetUserSmobaRoleListRsp = this.a;
    if (paramGetUserSmobaRoleListRsp != null) {
      paramGetUserSmobaRoleListRsp.a(true, 0, "", paramFromServiceMsg);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(false, paramInt2, paramString1, paramGetUserSmobaRoleListRsp);
    }
    paramGetUserSmobaRoleListRsp = new StringBuilder();
    paramGetUserSmobaRoleListRsp.append("getSmobaAccountListFromServer onError, isMsfSuccess:");
    paramGetUserSmobaRoleListRsp.append(paramBoolean);
    paramGetUserSmobaRoleListRsp.append(',');
    paramGetUserSmobaRoleListRsp.append(" msfResultCode:");
    paramGetUserSmobaRoleListRsp.append(paramInt1);
    paramGetUserSmobaRoleListRsp.append(", timiErrCode:");
    paramGetUserSmobaRoleListRsp.append(paramInt2);
    paramGetUserSmobaRoleListRsp.append(',');
    paramGetUserSmobaRoleListRsp.append(" timiSubErrCode:");
    paramGetUserSmobaRoleListRsp.append(paramInt3);
    paramGetUserSmobaRoleListRsp.append(", timiErrMsg:");
    paramGetUserSmobaRoleListRsp.append(paramString1);
    paramGetUserSmobaRoleListRsp.append(" timiDisplayErrMsg:");
    paramGetUserSmobaRoleListRsp.append(paramString2);
    Logger.c("SmobaAccountRepo_", paramGetUserSmobaRoleListRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.account.SmobaAccountRepo.getSmobaAccountListFromServer.requestListener.1
 * JD-Core Version:    0.7.0.1
 */