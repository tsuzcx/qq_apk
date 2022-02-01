package com.tencent.timi.game.expand.hall.api;

import android.content.Context;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.router.IService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/api/IExpandHallService;", "Lcom/tencent/timi/game/router/IService;", "destroyHall", "", "hall", "Lcom/tencent/timi/game/expand/hall/api/IExpandHall;", "getCurrentHall", "hallDestroy", "hallOnCreate", "joinHallRoomFailed", "errorCode", "", "errorMsg", "", "joinHallRoomSucceed", "roomId", "", "openExpandHall", "context", "Landroid/content/Context;", "param", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "registerLifeCycleListener", "lifeCycleListener", "Lcom/tencent/timi/game/expand/hall/api/ExpandHallLifeCycleListener;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandHallService
  extends IService
{
  @Nullable
  public abstract IExpandHall a();
  
  public abstract void a(int paramInt, @NotNull String paramString, @NotNull IExpandHall paramIExpandHall);
  
  public abstract void a(long paramLong, @NotNull IExpandHall paramIExpandHall);
  
  public abstract void a(@NotNull Context paramContext, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam);
  
  public abstract void a(@NotNull ExpandHallLifeCycleListener paramExpandHallLifeCycleListener);
  
  public abstract void a(@NotNull IExpandHall paramIExpandHall);
  
  public abstract void b();
  
  public abstract void b(@NotNull IExpandHall paramIExpandHall);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.api.IExpandHallService
 * JD-Core Version:    0.7.0.1
 */