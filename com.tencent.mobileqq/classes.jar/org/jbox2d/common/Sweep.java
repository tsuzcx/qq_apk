package org.jbox2d.common;

import java.io.Serializable;

public class Sweep
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public float a;
  public float a0;
  public float alpha0;
  public final Vec2 c = new Vec2();
  public final Vec2 c0 = new Vec2();
  public final Vec2 localCenter = new Vec2();
  
  public final void advance(float paramFloat)
  {
    Vec2 localVec2 = this.c0;
    float f = 1.0F - paramFloat;
    localVec2.x = (localVec2.x * f + this.c.x * paramFloat);
    localVec2 = this.c0;
    localVec2.y = (localVec2.y * f + this.c.y * paramFloat);
    this.a0 = (f * this.a0 + paramFloat * this.a);
  }
  
  public final void getTransform(Transform paramTransform, float paramFloat)
  {
    Object localObject = paramTransform.p;
    float f = 1.0F - paramFloat;
    ((Vec2)localObject).x = (this.c0.x * f + this.c.x * paramFloat);
    paramTransform.p.y = (this.c0.y * f + this.c.y * paramFloat);
    paramTransform.q.set(f * this.a0 + paramFloat * this.a);
    localObject = paramTransform.q;
    Vec2 localVec2 = paramTransform.p;
    localVec2.x -= ((Rot)localObject).c * this.localCenter.x - ((Rot)localObject).s * this.localCenter.y;
    paramTransform = paramTransform.p;
    paramTransform.y -= ((Rot)localObject).s * this.localCenter.x + ((Rot)localObject).c * this.localCenter.y;
  }
  
  public final void normalize()
  {
    float f = MathUtils.floor(this.a0 / 6.283186F) * 6.283186F;
    this.a0 -= f;
    this.a -= f;
  }
  
  public final Sweep set(Sweep paramSweep)
  {
    this.localCenter.set(paramSweep.localCenter);
    this.c0.set(paramSweep.c0);
    this.c.set(paramSweep.c);
    this.a0 = paramSweep.a0;
    this.a = paramSweep.a;
    return this;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Sweep:\nlocalCenter: ");
    ((StringBuilder)localObject).append(this.localCenter);
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("c0: ");
    localStringBuilder.append(this.c0);
    localStringBuilder.append(", c: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("a0: ");
    localStringBuilder.append(this.a0);
    localStringBuilder.append(", a: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Sweep
 * JD-Core Version:    0.7.0.1
 */