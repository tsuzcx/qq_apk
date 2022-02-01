package com.tencent.timi.game.liveroom.impl.view.operation;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/operation/AnchorOperationView$CubicBezierInterpolator;", "Landroid/view/animation/Interpolator;", "startX", "", "startY", "endX", "endY", "(FFFF)V", "start", "Landroid/graphics/PointF;", "end", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "a", "b", "c", "getBezierCoordinateX", "time", "getBezierCoordinateY", "getInterpolation", "getXDerivate", "t", "getXForTime", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
final class AnchorOperationView$CubicBezierInterpolator
  implements Interpolator
{
  private PointF a;
  private PointF b;
  private PointF c = new PointF();
  private PointF d = new PointF();
  private PointF e = new PointF();
  
  public AnchorOperationView$CubicBezierInterpolator(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new PointF(paramFloat3, paramFloat4));
  }
  
  public AnchorOperationView$CubicBezierInterpolator(@NotNull PointF paramPointF1, @NotNull PointF paramPointF2)
  {
    float f1 = paramPointF1.x;
    int j = 0;
    float f2 = 0;
    int i;
    if ((f1 >= f2) && (paramPointF1.x <= 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = j;
      if (paramPointF2.x >= f2)
      {
        i = j;
        if (paramPointF2.x <= 1) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.a = paramPointF1;
        this.b = paramPointF2;
        return;
      }
      throw ((Throwable)new IllegalArgumentException("endX value must be in the range [0, 1]".toString()));
    }
    throw ((Throwable)new IllegalArgumentException("startX value must be in the range [0, 1]".toString()));
  }
  
  private final float a(float paramFloat)
  {
    PointF localPointF = this.e;
    float f = 3;
    localPointF.y = (this.a.y * f);
    this.d.y = (f * (this.b.y - this.a.y) - this.e.y);
    this.c.y = (1 - this.e.y - this.d.y);
    return paramFloat * (this.e.y + (this.d.y + this.c.y * paramFloat) * paramFloat);
  }
  
  private final float b(float paramFloat)
  {
    int i = 1;
    float f1 = paramFloat;
    while (i <= 13)
    {
      float f2 = d(f1) - paramFloat;
      if (Math.abs(f2) < 0.001D) {
        return f1;
      }
      f1 -= f2 / c(f1);
      i += 1;
    }
    return f1;
  }
  
  private final float c(float paramFloat)
  {
    return this.e.x + paramFloat * (2 * this.d.x + 3 * this.c.x * paramFloat);
  }
  
  private final float d(float paramFloat)
  {
    PointF localPointF = this.e;
    float f = 3;
    localPointF.x = (this.a.x * f);
    this.d.x = (f * (this.b.x - this.a.x) - this.e.x);
    this.c.x = (1 - this.e.x - this.d.x);
    return paramFloat * (this.e.x + (this.d.x + this.c.x * paramFloat) * paramFloat);
  }
  
  public float getInterpolation(float paramFloat)
  {
    return a(b(paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationView.CubicBezierInterpolator
 * JD-Core Version:    0.7.0.1
 */