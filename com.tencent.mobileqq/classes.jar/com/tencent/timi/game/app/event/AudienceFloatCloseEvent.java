package com.tencent.timi.game.app.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/app/event/AudienceFloatCloseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "(J)V", "getRoomId", "()J", "setRoomId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AudienceFloatCloseEvent
  extends SimpleBaseEvent
{
  private long roomId;
  
  public AudienceFloatCloseEvent(long paramLong)
  {
    this.roomId = paramLong;
  }
  
  public final long getRoomId()
  {
    return this.roomId;
  }
  
  public final void setRoomId(long paramLong)
  {
    this.roomId = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.app.event.AudienceFloatCloseEvent
 * JD-Core Version:    0.7.0.1
 */