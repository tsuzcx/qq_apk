package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

public class Manifold
{
  public final Vec2 localNormal;
  public final Vec2 localPoint;
  public int pointCount;
  public final ManifoldPoint[] points = new ManifoldPoint[2];
  public Manifold.ManifoldType type;
  
  public Manifold()
  {
    int i = 0;
    while (i < 2)
    {
      this.points[i] = new ManifoldPoint();
      i += 1;
    }
    this.localNormal = new Vec2();
    this.localPoint = new Vec2();
    this.pointCount = 0;
  }
  
  public Manifold(Manifold paramManifold)
  {
    this.localNormal = paramManifold.localNormal.clone();
    this.localPoint = paramManifold.localPoint.clone();
    this.pointCount = paramManifold.pointCount;
    this.type = paramManifold.type;
    int i = 0;
    while (i < 2)
    {
      this.points[i] = new ManifoldPoint(paramManifold.points[i]);
      i += 1;
    }
  }
  
  public void set(Manifold paramManifold)
  {
    int i = 0;
    while (i < paramManifold.pointCount)
    {
      this.points[i].set(paramManifold.points[i]);
      i += 1;
    }
    this.type = paramManifold.type;
    this.localNormal.set(paramManifold.localNormal);
    this.localPoint.set(paramManifold.localPoint);
    this.pointCount = paramManifold.pointCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Manifold
 * JD-Core Version:    0.7.0.1
 */