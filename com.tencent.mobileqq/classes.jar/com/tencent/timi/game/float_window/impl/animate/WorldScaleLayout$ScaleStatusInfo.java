package com.tencent.timi.game.float_window.impl.animate;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/animate/WorldScaleLayout$ScaleStatusInfo;", "", "(Lcom/tencent/timi/game/float_window/impl/animate/WorldScaleLayout;)V", "aspectRatio", "", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "centerX", "", "getCenterX", "()I", "setCenterX", "(I)V", "centerY", "getCenterY", "setCenterY", "coverAlpha", "getCoverAlpha", "setCoverAlpha", "preDrawBitmapAlpha", "getPreDrawBitmapAlpha", "setPreDrawBitmapAlpha", "scaleSize", "getScaleSize", "setScaleSize", "widthRoundRatio", "getWidthRoundRatio", "setWidthRoundRatio", "toString", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
final class WorldScaleLayout$ScaleStatusInfo
{
  private int b;
  private int c;
  private float d = 1.0F;
  private float e;
  private float f = 1.0F;
  private float g;
  private float h;
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final float c()
  {
    return this.d;
  }
  
  public final void c(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public final float d()
  {
    return this.e;
  }
  
  public final void d(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public final float e()
  {
    return this.f;
  }
  
  public final void e(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public final float f()
  {
    return this.g;
  }
  
  public final float g()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScaleStatusInfo(centerX=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", centerY=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", scaleSize=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", coverAlpha=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", aspectRatio=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", widthRoundRatio=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout.ScaleStatusInfo
 * JD-Core Version:    0.7.0.1
 */