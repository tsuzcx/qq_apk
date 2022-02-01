package com.tencent.timi.game.tim.api.impl;

import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$login$1$onUserSigExpired$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTimApiImpl$login$1$onUserSigExpired$1
  implements IResultListener<TcloudServerOuterClass.GetUserTCloudSignRsp>
{
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@NotNull TcloudServerOuterClass.GetUserTCloudSignRsp paramGetUserTCloudSignRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetUserTCloudSignRsp, "result");
    TimiGameTimApiImpl.a(this.a.a, paramGetUserTCloudSignRsp);
    this.a.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.login.1.onUserSigExpired.1
 * JD-Core Version:    0.7.0.1
 */