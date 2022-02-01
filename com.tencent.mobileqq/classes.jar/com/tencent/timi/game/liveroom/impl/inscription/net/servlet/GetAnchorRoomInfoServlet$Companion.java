package com.tencent.timi.game.liveroom.impl.inscription.net.servlet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetAnchorRoomInfoReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/net/servlet/GetAnchorRoomInfoServlet$Companion;", "", "()V", "createReqIntent", "Lmqq/app/NewIntent;", "anchorId", "", "gameId", "", "roomId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetAnchorRoomInfoServlet$Companion
{
  @Nullable
  public final NewIntent a(@NotNull String paramString, int paramInt, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "anchorId");
    GameDataServerOuterClass.GetAnchorRoomInfoReq localGetAnchorRoomInfoReq = new GameDataServerOuterClass.GetAnchorRoomInfoReq();
    localGetAnchorRoomInfoReq.anchor_id.set(paramString);
    localGetAnchorRoomInfoReq.game_id.set(paramInt);
    localGetAnchorRoomInfoReq.room_id.set(paramLong);
    return BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localGetAnchorRoomInfoReq, GetAnchorRoomInfoServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.servlet.GetAnchorRoomInfoServlet.Companion
 * JD-Core Version:    0.7.0.1
 */