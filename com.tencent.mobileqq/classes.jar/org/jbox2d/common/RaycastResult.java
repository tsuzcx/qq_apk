package org.jbox2d.common;

public class RaycastResult
{
  public float lambda = 0.0F;
  public final Vec2 normal = new Vec2();
  
  public RaycastResult set(RaycastResult paramRaycastResult)
  {
    this.lambda = paramRaycastResult.lambda;
    this.normal.set(paramRaycastResult.normal);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.RaycastResult
 * JD-Core Version:    0.7.0.1
 */