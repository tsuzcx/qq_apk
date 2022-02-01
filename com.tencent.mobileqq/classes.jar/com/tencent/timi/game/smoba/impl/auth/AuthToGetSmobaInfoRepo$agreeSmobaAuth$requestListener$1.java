package com.tencent.timi.game.smoba.impl.auth;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/auth/AuthToGetSmobaInfoRepo$agreeSmobaAuth$requestListener$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AuthToGetSmobaInfoRepo$agreeSmobaAuth$requestListener$1
  implements RequestListener<GameDataServerOuterClass.AgreeSmobaAuthRsp>
{
  public void a(@Nullable GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("UserSmobaInfoImpl_", "agreeSmobaAuth onSuccess");
    this.a.a(true, 0, "", paramAgreeSmobaAuthRsp);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("agreeSmobaAuth onError, isMsfSuccess:");
    paramFromServiceMsg.append(paramBoolean);
    paramFromServiceMsg.append(',');
    paramFromServiceMsg.append(" msfResultCode:");
    paramFromServiceMsg.append(paramInt1);
    paramFromServiceMsg.append(", timiErrCode:");
    paramFromServiceMsg.append(paramInt2);
    paramFromServiceMsg.append(',');
    paramFromServiceMsg.append(" timiSubErrCode:");
    paramFromServiceMsg.append(paramInt3);
    paramFromServiceMsg.append(", timiErrMsg:");
    paramFromServiceMsg.append(paramString1);
    paramFromServiceMsg.append(" timiDisplayErrMsg:");
    paramFromServiceMsg.append(paramString2);
    Logger.c("AuthToGetSmobaInfoRepo_", paramFromServiceMsg.toString());
    this.a.a(false, paramInt2, paramString1, paramAgreeSmobaAuthRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.auth.AuthToGetSmobaInfoRepo.agreeSmobaAuth.requestListener.1
 * JD-Core Version:    0.7.0.1
 */