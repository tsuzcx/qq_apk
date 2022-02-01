package com.tencent.timi.game.tim.api.impl;

import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$internalLogin$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTimApiImpl$internalLogin$1
  implements IResultListener<TcloudServerOuterClass.GetUserTCloudSignRsp>
{
  TimiGameTimApiImpl$internalLogin$1(String paramString, ILoginCallback paramILoginCallback) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("p0 = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], p1 = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(']');
    Logger.a("TimManager", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((ILoginCallback)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(@Nullable TcloudServerOuterClass.GetUserTCloudSignRsp paramGetUserTCloudSignRsp)
  {
    paramGetUserTCloudSignRsp = this.a;
    String str = this.b;
    Intrinsics.checkExpressionValueIsNotNull(str, "uin");
    TimiGameTimApiImpl.a(paramGetUserTCloudSignRsp, str, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.internalLogin.1
 * JD-Core Version:    0.7.0.1
 */