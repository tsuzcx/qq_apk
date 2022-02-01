package com.tencent.timi.game.expand.hall.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/api/ExpandHallLifeCycleListener;", "", "joinHallFailed", "", "errorCode", "", "errorMsg", "", "hall", "Lcom/tencent/timi/game/expand/hall/api/IExpandHall;", "joinHallSucceed", "roomId", "", "onCreate", "onDestroy", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ExpandHallLifeCycleListener
{
  public abstract void a(int paramInt, @NotNull String paramString, @NotNull IExpandHall paramIExpandHall);
  
  public abstract void a(long paramLong, @NotNull IExpandHall paramIExpandHall);
  
  public abstract void a(@NotNull IExpandHall paramIExpandHall);
  
  public abstract void b(@NotNull IExpandHall paramIExpandHall);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.api.ExpandHallLifeCycleListener
 * JD-Core Version:    0.7.0.1
 */