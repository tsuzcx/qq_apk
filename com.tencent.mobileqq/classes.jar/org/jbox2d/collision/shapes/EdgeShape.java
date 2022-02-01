package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

public class EdgeShape
  extends Shape
{
  public boolean m_hasVertex0 = false;
  public boolean m_hasVertex3 = false;
  public final Vec2 m_vertex0 = new Vec2();
  public final Vec2 m_vertex1 = new Vec2();
  public final Vec2 m_vertex2 = new Vec2();
  public final Vec2 m_vertex3 = new Vec2();
  private final Vec2 normal = new Vec2();
  
  public EdgeShape()
  {
    super(ShapeType.EDGE);
    this.m_radius = 0.01F;
  }
  
  public Shape clone()
  {
    EdgeShape localEdgeShape = new EdgeShape();
    localEdgeShape.m_radius = this.m_radius;
    localEdgeShape.m_hasVertex0 = this.m_hasVertex0;
    localEdgeShape.m_hasVertex3 = this.m_hasVertex3;
    localEdgeShape.m_vertex0.set(this.m_vertex0);
    localEdgeShape.m_vertex1.set(this.m_vertex1);
    localEdgeShape.m_vertex2.set(this.m_vertex2);
    localEdgeShape.m_vertex3.set(this.m_vertex3);
    return localEdgeShape;
  }
  
  public void computeAABB(AABB paramAABB, Transform paramTransform, int paramInt)
  {
    Vec2 localVec2 = paramAABB.lowerBound;
    paramAABB = paramAABB.upperBound;
    Rot localRot = paramTransform.q;
    float f2 = localRot.c * this.m_vertex1.x - localRot.s * this.m_vertex1.y + paramTransform.p.x;
    float f1 = localRot.s * this.m_vertex1.x + localRot.c * this.m_vertex1.y + paramTransform.p.y;
    float f3 = localRot.c * this.m_vertex2.x - localRot.s * this.m_vertex2.y + paramTransform.p.x;
    float f4 = localRot.s;
    float f5 = this.m_vertex2.x;
    float f6 = localRot.c;
    float f7 = this.m_vertex2.y;
    f4 = paramTransform.p.y + (f4 * f5 + f6 * f7);
    if (f2 < f3) {
      f5 = f2;
    } else {
      f5 = f3;
    }
    localVec2.x = f5;
    if (f1 < f4) {
      f5 = f1;
    } else {
      f5 = f4;
    }
    localVec2.y = f5;
    if (f2 <= f3) {
      f2 = f3;
    }
    paramAABB.x = f2;
    f2 = f4;
    if (f1 > f4) {
      f2 = f1;
    }
    paramAABB.y = f2;
    localVec2.x -= this.m_radius;
    localVec2.y -= this.m_radius;
    paramAABB.x += this.m_radius;
    paramAABB.y += this.m_radius;
  }
  
  public void computeMass(MassData paramMassData, float paramFloat)
  {
    paramMassData.mass = 0.0F;
    paramMassData.center.set(this.m_vertex1).addLocal(this.m_vertex2).mulLocal(0.5F);
    paramMassData.I = 0.0F;
  }
  
  public int getChildCount()
  {
    return 1;
  }
  
  public boolean raycast(RayCastOutput paramRayCastOutput, RayCastInput paramRayCastInput, Transform paramTransform, int paramInt)
  {
    Vec2 localVec21 = this.m_vertex1;
    Vec2 localVec22 = this.m_vertex2;
    Rot localRot = paramTransform.q;
    paramTransform = paramTransform.p;
    float f2 = paramRayCastInput.p1.x - paramTransform.x;
    float f3 = paramRayCastInput.p1.y - paramTransform.y;
    float f1 = localRot.c * f2 + localRot.s * f3;
    f2 = -localRot.s * f2 + localRot.c * f3;
    float f4 = paramRayCastInput.p2.x - paramTransform.x;
    float f5 = paramRayCastInput.p2.y - paramTransform.y;
    f3 = localRot.c;
    float f8 = localRot.s;
    float f6 = -localRot.s;
    float f7 = localRot.c;
    f3 = f3 * f4 + f8 * f5 - f1;
    f7 = f6 * f4 + f7 * f5 - f2;
    this.normal.x = (localVec22.y - localVec21.y);
    this.normal.y = (localVec21.x - localVec22.x);
    this.normal.normalize();
    f4 = this.normal.x;
    f5 = this.normal.y;
    f6 = (localVec21.x - f1) * f4 + (localVec21.y - f2) * f5;
    f8 = f4 * f3 + f5 * f7;
    if (f8 == 0.0F) {
      return false;
    }
    f8 = f6 / f8;
    if (f8 >= 0.0F)
    {
      if (1.0F < f8) {
        return false;
      }
      float f9 = localVec22.x - localVec21.x;
      float f10 = localVec22.y - localVec21.y;
      float f11 = f9 * f9 + f10 * f10;
      if (f11 == 0.0F) {
        return false;
      }
      f1 = ((f1 + f3 * f8 - localVec21.x) * f9 + (f2 + f7 * f8 - localVec21.y) * f10) / f11;
      if (f1 >= 0.0F)
      {
        if (1.0F < f1) {
          return false;
        }
        paramRayCastOutput.fraction = f8;
        if (f6 > 0.0F)
        {
          paramRayCastOutput.normal.x = (-f4);
          paramRayCastOutput.normal.y = (-f5);
        }
        else
        {
          paramRayCastOutput.normal.x = f4;
          paramRayCastOutput.normal.y = f5;
        }
        return true;
      }
    }
    return false;
  }
  
  public void set(Vec2 paramVec21, Vec2 paramVec22)
  {
    this.m_vertex1.set(paramVec21);
    this.m_vertex2.set(paramVec22);
    this.m_hasVertex3 = false;
    this.m_hasVertex0 = false;
  }
  
  public boolean testPoint(Transform paramTransform, Vec2 paramVec2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.shapes.EdgeShape
 * JD-Core Version:    0.7.0.1
 */