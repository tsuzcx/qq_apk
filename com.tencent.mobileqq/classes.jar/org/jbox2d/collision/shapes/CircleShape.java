package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

public class CircleShape
  extends Shape
{
  public final Vec2 m_p = new Vec2();
  
  public CircleShape()
  {
    super(ShapeType.CIRCLE);
    this.m_radius = 0.0F;
  }
  
  public final Shape clone()
  {
    CircleShape localCircleShape = new CircleShape();
    localCircleShape.m_p.x = this.m_p.x;
    localCircleShape.m_p.y = this.m_p.y;
    localCircleShape.m_radius = this.m_radius;
    return localCircleShape;
  }
  
  public final void computeAABB(AABB paramAABB, Transform paramTransform, int paramInt)
  {
    Rot localRot = paramTransform.q;
    paramTransform = paramTransform.p;
    float f1 = localRot.c * this.m_p.x - localRot.s * this.m_p.y + paramTransform.x;
    float f2 = localRot.s * this.m_p.x + localRot.c * this.m_p.y + paramTransform.y;
    paramAABB.lowerBound.x = (f1 - this.m_radius);
    paramAABB.lowerBound.y = (f2 - this.m_radius);
    paramAABB.upperBound.x = (f1 + this.m_radius);
    paramAABB.upperBound.y = (f2 + this.m_radius);
  }
  
  public final void computeMass(MassData paramMassData, float paramFloat)
  {
    paramMassData.mass = (paramFloat * 3.141593F * this.m_radius * this.m_radius);
    paramMassData.center.x = this.m_p.x;
    paramMassData.center.y = this.m_p.y;
    paramMassData.I = (paramMassData.mass * (this.m_radius * 0.5F * this.m_radius + (this.m_p.x * this.m_p.x + this.m_p.y * this.m_p.y)));
  }
  
  public final int getChildCount()
  {
    return 1;
  }
  
  public final int getSupport(Vec2 paramVec2)
  {
    return 0;
  }
  
  public final Vec2 getSupportVertex(Vec2 paramVec2)
  {
    return this.m_p;
  }
  
  public final Vec2 getVertex(int paramInt)
  {
    return this.m_p;
  }
  
  public final int getVertexCount()
  {
    return 1;
  }
  
  public final boolean raycast(RayCastOutput paramRayCastOutput, RayCastInput paramRayCastInput, Transform paramTransform, int paramInt)
  {
    Vec2 localVec21 = paramRayCastInput.p1;
    Vec2 localVec22 = paramRayCastInput.p2;
    Rot localRot = paramTransform.q;
    paramTransform = paramTransform.p;
    float f1 = localRot.c;
    float f7 = this.m_p.x;
    float f8 = localRot.s;
    float f9 = this.m_p.y;
    float f10 = paramTransform.x;
    float f2 = localRot.s;
    float f3 = this.m_p.x;
    float f4 = localRot.c;
    float f5 = this.m_p.y;
    float f6 = paramTransform.y;
    f1 = localVec21.x - (f1 * f7 - f8 * f9 + f10);
    f2 = localVec21.y - (f2 * f3 + f4 * f5 + f6);
    f7 = this.m_radius;
    f8 = this.m_radius;
    f3 = localVec22.x - localVec21.x;
    f4 = localVec22.y - localVec21.y;
    f6 = f1 * f3 + f2 * f4;
    f5 = f3 * f3 + f4 * f4;
    f7 = f6 * f6 - (f1 * f1 + f2 * f2 - f7 * f8) * f5;
    if (f7 >= 0.0F)
    {
      if (f5 < 1.192093E-007F) {
        return false;
      }
      f6 = -(f6 + MathUtils.sqrt(f7));
      if ((0.0F <= f6) && (f6 <= paramRayCastInput.maxFraction * f5))
      {
        f5 = f6 / f5;
        paramRayCastOutput.fraction = f5;
        paramRayCastOutput.normal.x = (f3 * f5 + f1);
        paramRayCastOutput.normal.y = (f4 * f5 + f2);
        paramRayCastOutput.normal.normalize();
        return true;
      }
    }
    return false;
  }
  
  public final boolean testPoint(Transform paramTransform, Vec2 paramVec2)
  {
    Rot localRot = paramTransform.q;
    paramTransform = paramTransform.p;
    float f1 = -(localRot.c * this.m_p.x - localRot.s * this.m_p.y + paramTransform.x - paramVec2.x);
    float f2 = -(localRot.s * this.m_p.x + localRot.c * this.m_p.y + paramTransform.y - paramVec2.y);
    return f1 * f1 + f2 * f2 <= this.m_radius * this.m_radius;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.shapes.CircleShape
 * JD-Core Version:    0.7.0.1
 */