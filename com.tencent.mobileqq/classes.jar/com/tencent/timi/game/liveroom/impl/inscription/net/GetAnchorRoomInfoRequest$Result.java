package com.tencent.timi.game.liveroom.impl.inscription.net;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AnchorGameInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/net/GetAnchorRoomInfoRequest$Result;", "", "()V", "entranceShowFlag", "", "getEntranceShowFlag", "()Z", "setEntranceShowFlag", "(Z)V", "info", "Ltrpc/yes/common/GameDataServerOuterClass$AnchorGameInfo;", "getInfo", "()Ltrpc/yes/common/GameDataServerOuterClass$AnchorGameInfo;", "setInfo", "(Ltrpc/yes/common/GameDataServerOuterClass$AnchorGameInfo;)V", "period", "", "getPeriod", "()I", "setPeriod", "(I)V", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetAnchorRoomInfoRequest$Result
{
  @Nullable
  private GameDataServerOuterClass.AnchorGameInfo a;
  private long b;
  private int c;
  private boolean d;
  
  @Nullable
  public final GameDataServerOuterClass.AnchorGameInfo a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(@Nullable GameDataServerOuterClass.AnchorGameInfo paramAnchorGameInfo)
  {
    this.a = paramAnchorGameInfo;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorRoomInfoRequest.Result
 * JD-Core Version:    0.7.0.1
 */