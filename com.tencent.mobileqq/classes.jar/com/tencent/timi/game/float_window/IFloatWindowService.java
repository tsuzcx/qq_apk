package com.tencent.timi.game.float_window;

import android.view.View;
import com.tencent.timi.game.router.IService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/IFloatWindowService;", "Lcom/tencent/timi/game/router/IService;", "addScreenStatusReceiver", "", "listener", "Lcom/tencent/timi/game/float_window/IFloatWindowStatusListener;", "enterWindowFloat", "key", "", "floatParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "customView", "Landroid/view/View;", "hideFloatingView", "isEntered", "", "quitWindowFloat", "closeReason", "", "showFloatingView", "updateSize", "w", "h", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IFloatWindowService
  extends IService
{
  public abstract void a(@Nullable IFloatWindowStatusListener paramIFloatWindowStatusListener);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(@NotNull String paramString, int paramInt);
  
  public abstract void a(@NotNull String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(@NotNull String paramString, @Nullable FloatingConfigParams paramFloatingConfigParams, @Nullable View paramView);
  
  public abstract void b(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.IFloatWindowService
 * JD-Core Version:    0.7.0.1
 */