package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

public class ManifoldPoint
{
  public final ContactID id;
  public final Vec2 localPoint;
  public float normalImpulse;
  public float tangentImpulse;
  
  public ManifoldPoint()
  {
    this.localPoint = new Vec2();
    this.tangentImpulse = 0.0F;
    this.normalImpulse = 0.0F;
    this.id = new ContactID();
  }
  
  public ManifoldPoint(ManifoldPoint paramManifoldPoint)
  {
    this.localPoint = paramManifoldPoint.localPoint.clone();
    this.normalImpulse = paramManifoldPoint.normalImpulse;
    this.tangentImpulse = paramManifoldPoint.tangentImpulse;
    this.id = new ContactID(paramManifoldPoint.id);
  }
  
  public void set(ManifoldPoint paramManifoldPoint)
  {
    this.localPoint.set(paramManifoldPoint.localPoint);
    this.normalImpulse = paramManifoldPoint.normalImpulse;
    this.tangentImpulse = paramManifoldPoint.tangentImpulse;
    this.id.set(paramManifoldPoint.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.ManifoldPoint
 * JD-Core Version:    0.7.0.1
 */