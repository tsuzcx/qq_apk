package com.tencent.timi.game.expand.hall.api;

import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/api/IExpandHall;", "", "currentRoomId", "", "destroySelf", "", "getAttachedContext", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getLaunchParam", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "getReportHelper", "Lcom/tencent/timi/game/expand/hall/api/HallReportHelper;", "isMicCardWhiteListUser", "", "micCardSwitch", "openCreateSmobaTeam", "openHallSetting", "openRightDrawer", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandHall
{
  @NotNull
  public abstract ExpandHallLaunchParam b();
  
  @NotNull
  public abstract HallReportHelper e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract long h();
  
  public abstract void i();
  
  public abstract boolean j();
  
  public abstract boolean k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.api.IExpandHall
 * JD-Core Version:    0.7.0.1
 */