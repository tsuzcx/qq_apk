package com.tencent.timi.game.float_window;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/FloatingConfigParams$FloatingBuilder;", "", "()V", "canMove", "", "customHeight", "", "customWidth", "isLandscape", "roundCorner", "shadowPadding", "visibleWhenBackground", "build", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "setCanMove", "setIsLandscape", "isHorizontal", "setRoundCorner", "corner", "setShadowPadding", "setSize", "width", "height", "setVisibleWhenBackground", "visible", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FloatingConfigParams$FloatingBuilder
{
  public static final FloatingConfigParams.FloatingBuilder.Companion a = new FloatingConfigParams.FloatingBuilder.Companion(null);
  private boolean b = true;
  private boolean c;
  private boolean d;
  private int e = -2147483648;
  private int f = -2147483648;
  private int g = 6;
  private int h;
  
  @NotNull
  public final FloatingBuilder a(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  @NotNull
  public final FloatingBuilder a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    return this;
  }
  
  @NotNull
  public final FloatingBuilder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  @NotNull
  public final FloatingConfigParams a()
  {
    FloatingConfigParams localFloatingConfigParams = new FloatingConfigParams();
    int i = this.e;
    if ((i != -2147483648) && (this.f != -2147483648))
    {
      localFloatingConfigParams.d(i);
      localFloatingConfigParams.e(this.f);
    }
    localFloatingConfigParams.d(this.c);
    FloatingConfigParams.a(localFloatingConfigParams, this.b);
    FloatingConfigParams.b(localFloatingConfigParams, this.d);
    localFloatingConfigParams.a(this.g);
    FloatingConfigParams.a(localFloatingConfigParams, this.h);
    FloatingConfigParams.a(localFloatingConfigParams);
    return localFloatingConfigParams;
  }
  
  @NotNull
  public final FloatingBuilder b(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  @NotNull
  public final FloatingBuilder b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.FloatingConfigParams.FloatingBuilder
 * JD-Core Version:    0.7.0.1
 */