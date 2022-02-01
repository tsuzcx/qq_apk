package cooperation.qzone.contentbox.model;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class CubicBezierInterpolator
  implements Interpolator
{
  protected PointF a = new PointF();
  protected PointF b = new PointF();
  protected PointF c = new PointF();
  protected PointF end;
  protected PointF start;
  
  public CubicBezierInterpolator(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this((float)paramDouble1, (float)paramDouble2, (float)paramDouble3, (float)paramDouble4);
  }
  
  public CubicBezierInterpolator(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new PointF(paramFloat3, paramFloat4));
  }
  
  public CubicBezierInterpolator(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1.x >= 0.0F) && (paramPointF1.x <= 1.0F))
    {
      if ((paramPointF2.x >= 0.0F) && (paramPointF2.x <= 1.0F))
      {
        this.start = paramPointF1;
        this.end = paramPointF2;
        return;
      }
      throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    }
    throw new IllegalArgumentException("startX value must be in the range [0, 1]");
  }
  
  private float getBezierCoordinateX(float paramFloat)
  {
    this.c.x = (this.start.x * 3.0F);
    this.b.x = ((this.end.x - this.start.x) * 3.0F - this.c.x);
    this.a.x = (1.0F - this.c.x - this.b.x);
    return paramFloat * (this.c.x + (this.b.x + this.a.x * paramFloat) * paramFloat);
  }
  
  private float getXDerivate(float paramFloat)
  {
    return this.c.x + paramFloat * (this.b.x * 2.0F + this.a.x * 3.0F * paramFloat);
  }
  
  protected float getBezierCoordinateY(float paramFloat)
  {
    this.c.y = (this.start.y * 3.0F);
    this.b.y = ((this.end.y - this.start.y) * 3.0F - this.c.y);
    this.a.y = (1.0F - this.c.y - this.b.y);
    return paramFloat * (this.c.y + (this.b.y + this.a.y * paramFloat) * paramFloat);
  }
  
  public float getInterpolation(float paramFloat)
  {
    return getBezierCoordinateY(getXForTime(paramFloat));
  }
  
  protected float getXForTime(float paramFloat)
  {
    int i = 1;
    float f1 = paramFloat;
    while (i < 14)
    {
      float f2 = getBezierCoordinateX(f1) - paramFloat;
      if (Math.abs(f2) < 0.001D) {
        return f1;
      }
      f1 -= f2 / getXDerivate(f1);
      i += 1;
    }
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.CubicBezierInterpolator
 * JD-Core Version:    0.7.0.1
 */