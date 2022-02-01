package com.tencent.timi.game.team.impl.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/team/impl/event/ChooseLaneEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "laneId", "", "resId", "x", "y", "duration", "", "(IIIIJ)V", "getDuration", "()J", "getLaneId", "()I", "getResId", "getX", "getY", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ChooseLaneEvent
  extends SimpleBaseEvent
{
  private final long duration;
  private final int laneId;
  private final int resId;
  private final int x;
  private final int y;
  
  public ChooseLaneEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.laneId = paramInt1;
    this.resId = paramInt2;
    this.x = paramInt3;
    this.y = paramInt4;
    this.duration = paramLong;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final int getLaneId()
  {
    return this.laneId;
  }
  
  public final int getResId()
  {
    return this.resId;
  }
  
  public final int getX()
  {
    return this.x;
  }
  
  public final int getY()
  {
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.event.ChooseLaneEvent
 * JD-Core Version:    0.7.0.1
 */