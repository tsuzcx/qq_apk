package com.tencent.timi.game.liveroom.impl.inscription.net;

import android.text.TextUtils;
import com.tencent.timi.game.liveroom.impl.inscription.net.servlet.GetAnchorRoomInfoServlet;
import com.tencent.timi.game.liveroom.impl.inscription.net.servlet.GetAnchorRoomInfoServlet.Companion;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetAnchorRoomInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/net/GetAnchorRoomInfoRequest;", "", "()V", "TAG", "", "requestAnchorRoomInfo", "", "anchorId", "gameId", "", "roomId", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/liveroom/impl/inscription/net/GetAnchorRoomInfoRequest$Result;", "Result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetAnchorRoomInfoRequest
{
  public static final GetAnchorRoomInfoRequest a = new GetAnchorRoomInfoRequest();
  
  public final void a(@NotNull String paramString, int paramInt, long paramLong, @Nullable IResultListener<GetAnchorRoomInfoRequest.Result> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "anchorId");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestAnchorRoomInfo ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramLong);
    Logger.a("GetAnchorRoomInfoRequest", localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramIResultListener != null) {
        paramIResultListener.a(-1, "anchorId null");
      }
      return;
    }
    ((NetApi)ServiceCenter.a(NetApi.class)).a(GetAnchorRoomInfoServlet.a.a(paramString, paramInt, paramLong), GameDataServerOuterClass.GetAnchorRoomInfoRsp.class, (RequestListener)new GetAnchorRoomInfoRequest.requestAnchorRoomInfo.1(paramLong, paramIResultListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorRoomInfoRequest
 * JD-Core Version:    0.7.0.1
 */