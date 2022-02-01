package com.tencent.timi.game.float_window;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/IFloatView;", "", "getAnimateInfo", "Lcom/tencent/timi/game/float_window/FloatingAnimateInfo;", "getFloatingConfigParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "getView", "Landroid/view/View;", "init", "roomId", "", "onAttachFloat", "", "onBackground", "onDetachFloat", "onForground", "onHide", "onShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IFloatView
{
  @NotNull
  public abstract IFloatView a(long paramLong);
  
  public abstract void a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  @NotNull
  public abstract FloatingAnimateInfo getAnimateInfo();
  
  @NotNull
  public abstract FloatingConfigParams getFloatingConfigParams();
  
  @NotNull
  public abstract View getView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.IFloatView
 * JD-Core Version:    0.7.0.1
 */