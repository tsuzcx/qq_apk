package com.tencent.timi.game.expand.hall.impl.gm.net;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import kotlin.Metadata;
import mqq.app.NewIntent;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.RecommendProxyOuterClass.GetTopKuolieRoomListReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/gm/net/GetTopKuolieRoomListServlet$Companion;", "", "()V", "createReqIntent", "Lmqq/app/NewIntent;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetTopKuolieRoomListServlet$Companion
{
  @Nullable
  public final NewIntent a()
  {
    return BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)new RecommendProxyOuterClass.GetTopKuolieRoomListReq(), GetTopKuolieRoomListServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.net.GetTopKuolieRoomListServlet.Companion
 * JD-Core Version:    0.7.0.1
 */