package com.tencent.timi.game.liveroom.impl;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/AnchorLiveSysMsgEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "sysNotice", "", "(JLjava/lang/String;)V", "getRoomId", "()J", "getSysNotice", "()Ljava/lang/String;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorLiveSysMsgEvent
  extends SimpleBaseEvent
{
  private final long roomId;
  @NotNull
  private final String sysNotice;
  
  public AnchorLiveSysMsgEvent(long paramLong, @NotNull String paramString)
  {
    this.roomId = paramLong;
    this.sysNotice = paramString;
  }
  
  public final long getRoomId()
  {
    return this.roomId;
  }
  
  @NotNull
  public final String getSysNotice()
  {
    return this.sysNotice;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.AnchorLiveSysMsgEvent
 * JD-Core Version:    0.7.0.1
 */