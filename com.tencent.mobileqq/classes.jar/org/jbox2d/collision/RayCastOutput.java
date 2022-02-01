package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

public class RayCastOutput
{
  public float fraction = 0.0F;
  public final Vec2 normal = new Vec2();
  
  public void set(RayCastOutput paramRayCastOutput)
  {
    this.normal.set(paramRayCastOutput.normal);
    this.fraction = paramRayCastOutput.fraction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.RayCastOutput
 * JD-Core Version:    0.7.0.1
 */