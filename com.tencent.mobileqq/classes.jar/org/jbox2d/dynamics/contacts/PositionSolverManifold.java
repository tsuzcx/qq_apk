package org.jbox2d.dynamics.contacts;

import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

class PositionSolverManifold
{
  public final Vec2 normal = new Vec2();
  public final Vec2 point = new Vec2();
  public float separation;
  
  public void initialize(ContactPositionConstraint paramContactPositionConstraint, Transform paramTransform1, Transform paramTransform2, int paramInt)
  {
    Rot localRot1 = paramTransform1.q;
    Rot localRot2 = paramTransform2.q;
    Vec2 localVec21 = paramContactPositionConstraint.localPoints[paramInt];
    paramInt = PositionSolverManifold.1.$SwitchMap$org$jbox2d$collision$Manifold$ManifoldType[paramContactPositionConstraint.type.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        localVec22 = paramContactPositionConstraint.localNormal;
        localVec23 = paramContactPositionConstraint.localPoint;
        this.normal.x = (localRot2.c * localVec22.x - localRot2.s * localVec22.y);
        this.normal.y = (localRot2.s * localVec22.x + localRot2.c * localVec22.y);
        f1 = localRot2.c;
        f2 = localVec23.x;
        f3 = localRot2.s;
        f4 = localVec23.y;
        f5 = paramTransform2.p.x;
        f6 = localRot2.s;
        f7 = localVec23.x;
        f8 = localRot2.c;
        f9 = localVec23.y;
        f10 = paramTransform2.p.y;
        f11 = localRot1.c * localVec21.x - localRot1.s * localVec21.y + paramTransform1.p.x;
        f12 = localRot1.s * localVec21.x + localRot1.c * localVec21.y + paramTransform1.p.y;
        this.separation = ((f11 - (f1 * f2 - f3 * f4 + f5)) * this.normal.x + (f12 - (f6 * f7 + f8 * f9 + f10)) * this.normal.y - paramContactPositionConstraint.radiusA - paramContactPositionConstraint.radiusB);
        paramContactPositionConstraint = this.point;
        paramContactPositionConstraint.x = f11;
        paramContactPositionConstraint.y = f12;
        paramContactPositionConstraint = this.normal;
        paramContactPositionConstraint.x *= -1.0F;
        paramContactPositionConstraint = this.normal;
        paramContactPositionConstraint.y *= -1.0F;
        return;
      }
      localVec22 = paramContactPositionConstraint.localNormal;
      Vec2 localVec23 = paramContactPositionConstraint.localPoint;
      this.normal.x = (localRot1.c * localVec22.x - localRot1.s * localVec22.y);
      this.normal.y = (localRot1.s * localVec22.x + localRot1.c * localVec22.y);
      f1 = localRot1.c;
      f2 = localVec23.x;
      f3 = localRot1.s;
      f4 = localVec23.y;
      f5 = paramTransform1.p.x;
      f6 = localRot1.s;
      float f7 = localVec23.x;
      float f8 = localRot1.c;
      float f9 = localVec23.y;
      float f10 = paramTransform1.p.y;
      float f11 = localRot2.c * localVec21.x - localRot2.s * localVec21.y + paramTransform2.p.x;
      float f12 = localRot2.s * localVec21.x + localRot2.c * localVec21.y + paramTransform2.p.y;
      this.separation = ((f11 - (f1 * f2 - f3 * f4 + f5)) * this.normal.x + (f12 - (f6 * f7 + f8 * f9 + f10)) * this.normal.y - paramContactPositionConstraint.radiusA - paramContactPositionConstraint.radiusB);
      paramContactPositionConstraint = this.point;
      paramContactPositionConstraint.x = f11;
      paramContactPositionConstraint.y = f12;
      return;
    }
    localVec21 = paramContactPositionConstraint.localPoint;
    Vec2 localVec22 = paramContactPositionConstraint.localPoints[0];
    float f1 = localRot1.c * localVec21.x - localRot1.s * localVec21.y + paramTransform1.p.x;
    float f2 = localRot1.s * localVec21.x + localRot1.c * localVec21.y + paramTransform1.p.y;
    float f3 = localRot2.c * localVec22.x - localRot2.s * localVec22.y + paramTransform2.p.x;
    float f4 = localRot2.s * localVec22.x + localRot2.c * localVec22.y + paramTransform2.p.y;
    paramTransform1 = this.normal;
    float f5 = f3 - f1;
    paramTransform1.x = f5;
    float f6 = f4 - f2;
    paramTransform1.y = f6;
    paramTransform1.normalize();
    paramTransform1 = this.point;
    paramTransform1.x = ((f1 + f3) * 0.5F);
    paramTransform1.y = ((f2 + f4) * 0.5F);
    this.separation = (f5 * this.normal.x + f6 * this.normal.y - paramContactPositionConstraint.radiusA - paramContactPositionConstraint.radiusB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.contacts.PositionSolverManifold
 * JD-Core Version:    0.7.0.1
 */