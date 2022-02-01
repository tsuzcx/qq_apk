package com.tencent.timi.game.float_window.impl;

import android.content.Context;
import android.view.View;
import com.tencent.timi.game.float_window.FloatingConfigParams;
import com.tencent.timi.game.float_window.IFloatWindowService;
import com.tencent.timi.game.float_window.IFloatWindowStatusListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/FloatWindowServiceImpl;", "Lcom/tencent/timi/game/float_window/IFloatWindowService;", "()V", "addScreenStatusReceiver", "", "listener", "Lcom/tencent/timi/game/float_window/IFloatWindowStatusListener;", "enterWindowFloat", "key", "", "floatParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "customView", "Landroid/view/View;", "hideFloatingView", "init", "context", "Landroid/content/Context;", "isEntered", "", "quitWindowFloat", "closeReason", "", "serviceDestroy", "showFloatingView", "updateSize", "w", "h", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FloatWindowServiceImpl
  implements IFloatWindowService
{
  public void a(@Nullable Context paramContext) {}
  
  public void a(@Nullable IFloatWindowStatusListener paramIFloatWindowStatusListener)
  {
    YesFloatWindowManager.a.b().a(paramIFloatWindowStatusListener);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    YesFloatWindowManager.a.b().b(paramString);
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    YesFloatWindowManager.a.b().a(paramString, paramInt);
  }
  
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    YesFloatWindowManager.a.b().a(paramString, paramInt1, paramInt2);
  }
  
  public void a(@NotNull String paramString, @Nullable FloatingConfigParams paramFloatingConfigParams, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    YesFloatWindowManager.a.b().a(paramString, paramFloatingConfigParams, paramView);
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    YesFloatWindowManager.a.b().a(paramString);
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.FloatWindowServiceImpl
 * JD-Core Version:    0.7.0.1
 */