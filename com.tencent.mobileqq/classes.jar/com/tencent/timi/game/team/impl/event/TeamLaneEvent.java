package com.tencent.timi.game.team.impl.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/team/impl/event/TeamLaneEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "laneId", "", "(I)V", "getLaneId", "()I", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamLaneEvent
  extends SimpleBaseEvent
{
  private final int laneId;
  
  public TeamLaneEvent(int paramInt)
  {
    this.laneId = paramInt;
  }
  
  public final int getLaneId()
  {
    return this.laneId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.event.TeamLaneEvent
 * JD-Core Version:    0.7.0.1
 */