package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat33;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

public class WeldJoint
  extends Joint
{
  private float m_bias;
  private float m_dampingRatio;
  private float m_frequencyHz;
  private float m_gamma;
  private final Vec3 m_impulse;
  private int m_indexA;
  private int m_indexB;
  private float m_invIA;
  private float m_invIB;
  private float m_invMassA;
  private float m_invMassB;
  private final Vec2 m_localAnchorA;
  private final Vec2 m_localAnchorB;
  private final Vec2 m_localCenterA = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  private final Mat33 m_mass = new Mat33();
  private final Vec2 m_rA = new Vec2();
  private final Vec2 m_rB = new Vec2();
  private float m_referenceAngle;
  
  protected WeldJoint(IWorldPool paramIWorldPool, WeldJointDef paramWeldJointDef)
  {
    super(paramIWorldPool, paramWeldJointDef);
    this.m_localAnchorA = new Vec2(paramWeldJointDef.localAnchorA);
    this.m_localAnchorB = new Vec2(paramWeldJointDef.localAnchorB);
    this.m_referenceAngle = paramWeldJointDef.referenceAngle;
    this.m_frequencyHz = paramWeldJointDef.frequencyHz;
    this.m_dampingRatio = paramWeldJointDef.dampingRatio;
    this.m_impulse = new Vec3();
    this.m_impulse.setZero();
  }
  
  public void getAnchorA(Vec2 paramVec2)
  {
    this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, paramVec2);
  }
  
  public void getAnchorB(Vec2 paramVec2)
  {
    this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, paramVec2);
  }
  
  public float getDampingRatio()
  {
    return this.m_dampingRatio;
  }
  
  public float getFrequency()
  {
    return this.m_frequencyHz;
  }
  
  public Vec2 getLocalAnchorA()
  {
    return this.m_localAnchorA;
  }
  
  public Vec2 getLocalAnchorB()
  {
    return this.m_localAnchorB;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2)
  {
    paramVec2.set(this.m_impulse.x, this.m_impulse.y);
    paramVec2.mulLocal(paramFloat);
  }
  
  public float getReactionTorque(float paramFloat)
  {
    return paramFloat * this.m_impulse.z;
  }
  
  public float getReferenceAngle()
  {
    return this.m_referenceAngle;
  }
  
  public void initVelocityConstraints(SolverData paramSolverData)
  {
    this.m_indexA = this.m_bodyA.m_islandIndex;
    this.m_indexB = this.m_bodyB.m_islandIndex;
    this.m_localCenterA.set(this.m_bodyA.m_sweep.localCenter);
    this.m_localCenterB.set(this.m_bodyB.m_sweep.localCenter);
    this.m_invMassA = this.m_bodyA.m_invMass;
    this.m_invMassB = this.m_bodyB.m_invMass;
    this.m_invIA = this.m_bodyA.m_invI;
    this.m_invIB = this.m_bodyB.m_invI;
    float f9 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f3 = paramSolverData.velocities[this.m_indexA].w;
    float f10 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Object localObject1 = this.pool.popRot();
    Object localObject2 = this.pool.popRot();
    Vec2 localVec23 = this.pool.popVec2();
    ((Rot)localObject1).set(f9);
    ((Rot)localObject2).set(f10);
    Rot.mulToOutUnsafe((Rot)localObject1, localVec23.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
    Rot.mulToOutUnsafe((Rot)localObject2, localVec23.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
    float f7 = this.m_invMassA;
    float f5 = this.m_invMassB;
    float f8 = this.m_invIA;
    float f6 = this.m_invIB;
    localObject1 = this.pool.popMat33();
    localObject2 = ((Mat33)localObject1).ex;
    float f1 = f7 + f5;
    ((Vec3)localObject2).x = (this.m_rA.y * this.m_rA.y * f8 + f1 + this.m_rB.y * this.m_rB.y * f6);
    ((Mat33)localObject1).ey.x = (-this.m_rA.y * this.m_rA.x * f8 - this.m_rB.y * this.m_rB.x * f6);
    ((Mat33)localObject1).ez.x = (-this.m_rA.y * f8 - this.m_rB.y * f6);
    ((Mat33)localObject1).ex.y = ((Mat33)localObject1).ey.x;
    ((Mat33)localObject1).ey.y = (f1 + this.m_rA.x * this.m_rA.x * f8 + this.m_rB.x * this.m_rB.x * f6);
    ((Mat33)localObject1).ez.y = (this.m_rA.x * f8 + this.m_rB.x * f6);
    ((Mat33)localObject1).ex.z = ((Mat33)localObject1).ez.x;
    ((Mat33)localObject1).ey.z = ((Mat33)localObject1).ez.y;
    localObject2 = ((Mat33)localObject1).ez;
    float f11 = f8 + f6;
    ((Vec3)localObject2).z = f11;
    f1 = this.m_frequencyHz;
    float f4 = 0.0F;
    if (f1 > 0.0F)
    {
      ((Mat33)localObject1).getInverse22(this.m_mass);
      if (f11 > 0.0F) {
        f1 = 1.0F / f11;
      } else {
        f1 = 0.0F;
      }
      float f12 = this.m_referenceAngle;
      float f15 = this.m_frequencyHz * 6.283186F;
      float f16 = this.m_dampingRatio;
      float f13 = f1 * f15 * f15;
      float f14 = paramSolverData.step.dt;
      this.m_gamma = ((2.0F * f1 * f16 * f15 + f14 * f13) * f14);
      f1 = this.m_gamma;
      if (f1 != 0.0F) {
        f1 = 1.0F / f1;
      } else {
        f1 = 0.0F;
      }
      this.m_gamma = f1;
      f1 = this.m_gamma;
      this.m_bias = ((f10 - f9 - f12) * f14 * f13 * f1);
      f9 = f11 + f1;
      localObject1 = this.m_mass.ez;
      f1 = f4;
      if (f9 != 0.0F) {
        f1 = 1.0F / f9;
      }
      ((Vec3)localObject1).z = f1;
    }
    else
    {
      ((Mat33)localObject1).getSymInverse33(this.m_mass);
      this.m_gamma = 0.0F;
      this.m_bias = 0.0F;
    }
    if (paramSolverData.step.warmStarting)
    {
      localObject1 = this.pool.popVec2();
      this.m_impulse.mulLocal(paramSolverData.step.dtRatio);
      ((Vec2)localObject1).set(this.m_impulse.x, this.m_impulse.y);
      localVec21.x -= ((Vec2)localObject1).x * f7;
      localVec21.y -= f7 * ((Vec2)localObject1).y;
      f1 = f3 - f8 * (Vec2.cross(this.m_rA, (Vec2)localObject1) + this.m_impulse.z);
      localVec22.x += f5 * ((Vec2)localObject1).x;
      localVec22.y += f5 * ((Vec2)localObject1).y;
      f2 += f6 * (Vec2.cross(this.m_rB, (Vec2)localObject1) + this.m_impulse.z);
      this.pool.pushVec2(1);
    }
    else
    {
      this.m_impulse.setZero();
      f1 = f3;
    }
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
    this.pool.pushVec2(1);
    this.pool.pushRot(2);
    this.pool.pushMat33(1);
  }
  
  public void setDampingRatio(float paramFloat)
  {
    this.m_dampingRatio = paramFloat;
  }
  
  public void setFrequency(float paramFloat)
  {
    this.m_frequencyHz = paramFloat;
  }
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.positions[this.m_indexA].c;
    float f2 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec22 = paramSolverData.positions[this.m_indexB].c;
    float f3 = paramSolverData.positions[this.m_indexB].a;
    Object localObject1 = this.pool.popRot();
    Object localObject2 = this.pool.popRot();
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    ((Rot)localObject1).set(f2);
    ((Rot)localObject2).set(f3);
    float f7 = this.m_invMassA;
    float f6 = this.m_invMassB;
    float f8 = this.m_invIA;
    float f5 = this.m_invIB;
    Rot.mulToOutUnsafe((Rot)localObject1, localVec25.set(this.m_localAnchorA).subLocal(this.m_localCenterA), localVec23);
    Rot.mulToOutUnsafe((Rot)localObject2, localVec25.set(this.m_localAnchorB).subLocal(this.m_localCenterB), localVec24);
    localObject1 = this.pool.popMat33();
    localObject2 = this.pool.popVec2();
    localVec25 = this.pool.popVec2();
    Vec3 localVec31 = ((Mat33)localObject1).ex;
    float f1 = f7 + f6;
    localVec31.x = (localVec23.y * localVec23.y * f8 + f1 + localVec24.y * localVec24.y * f5);
    ((Mat33)localObject1).ey.x = (-localVec23.y * localVec23.x * f8 - localVec24.y * localVec24.x * f5);
    ((Mat33)localObject1).ez.x = (-localVec23.y * f8 - localVec24.y * f5);
    ((Mat33)localObject1).ex.y = ((Mat33)localObject1).ey.x;
    ((Mat33)localObject1).ey.y = (f1 + localVec23.x * localVec23.x * f8 + localVec24.x * localVec24.x * f5);
    ((Mat33)localObject1).ez.y = (localVec23.x * f8 + localVec24.x * f5);
    ((Mat33)localObject1).ex.z = ((Mat33)localObject1).ez.x;
    ((Mat33)localObject1).ey.z = ((Mat33)localObject1).ez.y;
    ((Mat33)localObject1).ez.z = (f8 + f5);
    f1 = this.m_frequencyHz;
    float f4 = 0.0F;
    if (f1 > 0.0F)
    {
      ((Vec2)localObject2).set(localVec22).addLocal(localVec24).subLocal(localVec21).subLocal(localVec23);
      f1 = ((Vec2)localObject2).length();
      ((Mat33)localObject1).solve22ToOut((Vec2)localObject2, localVec25);
      localVec25.negateLocal();
      localVec21.x -= localVec25.x * f7;
      localVec21.y -= f7 * localVec25.y;
      f2 -= f8 * Vec2.cross(localVec23, localVec25);
      localVec22.x += f6 * localVec25.x;
      localVec22.y += f6 * localVec25.y;
      f6 = Vec2.cross(localVec24, localVec25);
      f3 += f5 * f6;
    }
    else
    {
      ((Vec2)localObject2).set(localVec22).addLocal(localVec24).subLocal(localVec21).subLocal(localVec23);
      float f9 = f3 - f2 - this.m_referenceAngle;
      f1 = ((Vec2)localObject2).length();
      f4 = MathUtils.abs(f9);
      localVec31 = this.pool.popVec3();
      Vec3 localVec32 = this.pool.popVec3();
      localVec31.set(((Vec2)localObject2).x, ((Vec2)localObject2).y, f9);
      ((Mat33)localObject1).solve33ToOut(localVec31, localVec32);
      localVec32.negateLocal();
      localVec25.set(localVec32.x, localVec32.y);
      localVec21.x -= localVec25.x * f7;
      localVec21.y -= f7 * localVec25.y;
      f2 -= f8 * (Vec2.cross(localVec23, localVec25) + localVec32.z);
      localVec22.x += localVec25.x * f6;
      localVec22.y += localVec25.y * f6;
      f6 = Vec2.cross(localVec24, localVec25);
      f7 = localVec32.z;
      this.pool.pushVec3(2);
      f3 += f5 * (f6 + f7);
    }
    paramSolverData.positions[this.m_indexA].a = f2;
    paramSolverData.positions[this.m_indexB].a = f3;
    this.pool.pushVec2(5);
    this.pool.pushRot(2);
    this.pool.pushMat33(1);
    return (f1 <= 0.005F) && (f4 <= 0.03490659F);
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f7 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f4 = paramSolverData.velocities[this.m_indexB].w;
    float f1 = this.m_invMassA;
    float f2 = this.m_invMassB;
    float f5 = this.m_invIA;
    float f3 = this.m_invIB;
    Object localObject1 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Object localObject2 = this.pool.popVec2();
    if (this.m_frequencyHz > 0.0F)
    {
      float f6 = -this.m_mass.ez.z * (f4 - f7 + this.m_bias + this.m_gamma * this.m_impulse.z);
      Vec3 localVec3 = this.m_impulse;
      localVec3.z += f6;
      f7 -= f5 * f6;
      f4 += f6 * f3;
      Vec2.crossToOutUnsafe(f4, this.m_rB, (Vec2)localObject1);
      Vec2.crossToOutUnsafe(f7, this.m_rA, (Vec2)localObject2);
      ((Vec2)localObject1).addLocal(localVec22).subLocal(localVec21).subLocal((Vec2)localObject2);
      Mat33.mul22ToOutUnsafe(this.m_mass, (Vec2)localObject1, localVec23);
      localVec23.negateLocal();
      localObject1 = this.m_impulse;
      ((Vec3)localObject1).x += localVec23.x;
      localObject1 = this.m_impulse;
      ((Vec3)localObject1).y += localVec23.y;
      localVec21.x -= localVec23.x * f1;
      localVec21.y -= f1 * localVec23.y;
      f1 = f7 - f5 * Vec2.cross(this.m_rA, localVec23);
      localVec22.x += localVec23.x * f2;
      localVec22.y += f2 * localVec23.y;
      f2 = f4 + f3 * Vec2.cross(this.m_rB, localVec23);
    }
    else
    {
      Vec2.crossToOutUnsafe(f7, this.m_rA, (Vec2)localObject2);
      Vec2.crossToOutUnsafe(f4, this.m_rB, (Vec2)localObject1);
      ((Vec2)localObject1).addLocal(localVec22).subLocal(localVec21).subLocal((Vec2)localObject2);
      localObject2 = this.pool.popVec3();
      ((Vec3)localObject2).set(((Vec2)localObject1).x, ((Vec2)localObject1).y, f4 - f7);
      localObject1 = this.pool.popVec3();
      Mat33.mulToOutUnsafe(this.m_mass, (Vec3)localObject2, (Vec3)localObject1);
      ((Vec3)localObject1).negateLocal();
      this.m_impulse.addLocal((Vec3)localObject1);
      localVec23.set(((Vec3)localObject1).x, ((Vec3)localObject1).y);
      localVec21.x -= localVec23.x * f1;
      localVec21.y -= f1 * localVec23.y;
      f1 = f7 - f5 * (Vec2.cross(this.m_rA, localVec23) + ((Vec3)localObject1).z);
      localVec22.x += localVec23.x * f2;
      localVec22.y += f2 * localVec23.y;
      f2 = f4 + f3 * (Vec2.cross(this.m_rB, localVec23) + ((Vec3)localObject1).z);
      this.pool.pushVec3(2);
    }
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
    this.pool.pushVec2(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.WeldJoint
 * JD-Core Version:    0.7.0.1
 */