package com.tencent.timi.game.relationship.impl.net;

import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.UserProxyCmdOuterClass.GetSessionInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/relationship/impl/net/GetSessionInfoRequest;", "", "()V", "TAG", "", "getSessionInfo", "", "fromUin", "", "toUin", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetSessionInfoRequest
{
  public static final GetSessionInfoRequest a = new GetSessionInfoRequest();
  
  public final void a(long paramLong1, long paramLong2, @NotNull IResultListener<byte[]> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIResultListener, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSessionInfo - ");
    localStringBuilder.append(Logger.b(paramLong2));
    Logger.a("GetSessionInfoRequest", localStringBuilder.toString());
    ((NetApi)ServiceCenter.a(NetApi.class)).a(GetSessionInfoServlet.a.a(paramLong1, paramLong2), UserProxyCmdOuterClass.GetSessionInfoRsp.class, (RequestListener)new GetSessionInfoRequest.getSessionInfo.1(paramIResultListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.impl.net.GetSessionInfoRequest
 * JD-Core Version:    0.7.0.1
 */