package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

public class RayCastInput
{
  public float maxFraction = 0.0F;
  public final Vec2 p1 = new Vec2();
  public final Vec2 p2 = new Vec2();
  
  public void set(RayCastInput paramRayCastInput)
  {
    this.p1.set(paramRayCastInput.p1);
    this.p2.set(paramRayCastInput.p2);
    this.maxFraction = paramRayCastInput.maxFraction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.RayCastInput
 * JD-Core Version:    0.7.0.1
 */