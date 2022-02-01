package com.tencent.timi.game.tim.api.impl;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$getUserSig$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTimApiImpl$getUserSig$1
  implements RequestListener<TcloudServerOuterClass.GetUserTCloudSignRsp>
{
  TimiGameTimApiImpl$getUserSig$1(long paramLong, IResultListener paramIResultListener) {}
  
  public void a(@Nullable TcloudServerOuterClass.GetUserTCloudSignRsp paramGetUserTCloudSignRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if (paramGetUserTCloudSignRsp != null)
    {
      TimiGameTimApiImpl.a(this.a, paramGetUserTCloudSignRsp);
      TimiGameTimApiImpl.a(this.a, this.b);
    }
    paramFromServiceMsg = this.c;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(paramGetUserTCloudSignRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable TcloudServerOuterClass.GetUserTCloudSignRsp paramGetUserTCloudSignRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramString2 = this.c;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.getUserSig.1
 * JD-Core Version:    0.7.0.1
 */