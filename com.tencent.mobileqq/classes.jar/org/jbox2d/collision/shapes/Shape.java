package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

public abstract class Shape
{
  public float m_radius;
  public final ShapeType m_type;
  
  public Shape(ShapeType paramShapeType)
  {
    this.m_type = paramShapeType;
  }
  
  public abstract Shape clone();
  
  public abstract void computeAABB(AABB paramAABB, Transform paramTransform, int paramInt);
  
  public abstract void computeMass(MassData paramMassData, float paramFloat);
  
  public abstract int getChildCount();
  
  public float getRadius()
  {
    return this.m_radius;
  }
  
  public ShapeType getType()
  {
    return this.m_type;
  }
  
  public abstract boolean raycast(RayCastOutput paramRayCastOutput, RayCastInput paramRayCastInput, Transform paramTransform, int paramInt);
  
  public void setRadius(float paramFloat)
  {
    this.m_radius = paramFloat;
  }
  
  public abstract boolean testPoint(Transform paramTransform, Vec2 paramVec2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.shapes.Shape
 * JD-Core Version:    0.7.0.1
 */