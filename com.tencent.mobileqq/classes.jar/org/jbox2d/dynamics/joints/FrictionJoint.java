package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat22;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

public class FrictionJoint
  extends Joint
{
  private float m_angularImpulse;
  private float m_angularMass;
  private int m_indexA;
  private int m_indexB;
  private float m_invIA;
  private float m_invIB;
  private float m_invMassA;
  private float m_invMassB;
  private final Vec2 m_linearImpulse;
  private final Mat22 m_linearMass = new Mat22();
  private final Vec2 m_localAnchorA;
  private final Vec2 m_localAnchorB;
  private final Vec2 m_localCenterA = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  private float m_maxForce;
  private float m_maxTorque;
  private final Vec2 m_rA = new Vec2();
  private final Vec2 m_rB = new Vec2();
  
  protected FrictionJoint(IWorldPool paramIWorldPool, FrictionJointDef paramFrictionJointDef)
  {
    super(paramIWorldPool, paramFrictionJointDef);
    this.m_localAnchorA = new Vec2(paramFrictionJointDef.localAnchorA);
    this.m_localAnchorB = new Vec2(paramFrictionJointDef.localAnchorB);
    this.m_linearImpulse = new Vec2();
    this.m_angularImpulse = 0.0F;
    this.m_maxForce = paramFrictionJointDef.maxForce;
    this.m_maxTorque = paramFrictionJointDef.maxTorque;
  }
  
  public void getAnchorA(Vec2 paramVec2)
  {
    this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, paramVec2);
  }
  
  public void getAnchorB(Vec2 paramVec2)
  {
    this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, paramVec2);
  }
  
  public Vec2 getLocalAnchorA()
  {
    return this.m_localAnchorA;
  }
  
  public Vec2 getLocalAnchorB()
  {
    return this.m_localAnchorB;
  }
  
  public float getMaxForce()
  {
    return this.m_maxForce;
  }
  
  public float getMaxTorque()
  {
    return this.m_maxTorque;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2)
  {
    paramVec2.set(this.m_linearImpulse).mulLocal(paramFloat);
  }
  
  public float getReactionTorque(float paramFloat)
  {
    return paramFloat * this.m_angularImpulse;
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
    float f3 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f1 = paramSolverData.velocities[this.m_indexA].w;
    float f4 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Vec2 localVec23 = this.pool.popVec2();
    Object localObject1 = this.pool.popRot();
    Object localObject2 = this.pool.popRot();
    ((Rot)localObject1).set(f3);
    ((Rot)localObject2).set(f4);
    Rot.mulToOutUnsafe((Rot)localObject1, localVec23.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
    Rot.mulToOutUnsafe((Rot)localObject2, localVec23.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
    float f5 = this.m_invMassA;
    f3 = this.m_invMassB;
    float f6 = this.m_invIA;
    f4 = this.m_invIB;
    localObject1 = this.pool.popMat22();
    localObject2 = ((Mat22)localObject1).ex;
    float f7 = f5 + f3;
    ((Vec2)localObject2).x = (this.m_rA.y * f6 * this.m_rA.y + f7 + this.m_rB.y * f4 * this.m_rB.y);
    ((Mat22)localObject1).ex.y = (-f6 * this.m_rA.x * this.m_rA.y - this.m_rB.x * f4 * this.m_rB.y);
    ((Mat22)localObject1).ey.x = ((Mat22)localObject1).ex.y;
    ((Mat22)localObject1).ey.y = (f7 + this.m_rA.x * f6 * this.m_rA.x + this.m_rB.x * f4 * this.m_rB.x);
    ((Mat22)localObject1).invertToOut(this.m_linearMass);
    this.m_angularMass = (f6 + f4);
    f7 = this.m_angularMass;
    if (f7 > 0.0F) {
      this.m_angularMass = (1.0F / f7);
    }
    if (paramSolverData.step.warmStarting)
    {
      this.m_linearImpulse.mulLocal(paramSolverData.step.dtRatio);
      this.m_angularImpulse *= paramSolverData.step.dtRatio;
      localObject1 = this.pool.popVec2();
      ((Vec2)localObject1).set(this.m_linearImpulse);
      localVec23.set((Vec2)localObject1).mulLocal(f5);
      localVec21.subLocal(localVec23);
      f1 -= f6 * (Vec2.cross(this.m_rA, (Vec2)localObject1) + this.m_angularImpulse);
      localVec23.set((Vec2)localObject1).mulLocal(f3);
      localVec22.addLocal(localVec23);
      f2 += f4 * (Vec2.cross(this.m_rB, (Vec2)localObject1) + this.m_angularImpulse);
      this.pool.pushVec2(1);
    }
    else
    {
      this.m_linearImpulse.setZero();
      this.m_angularImpulse = 0.0F;
    }
    f3 = paramSolverData.velocities[this.m_indexA].w;
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
    this.pool.pushRot(2);
    this.pool.pushVec2(1);
    this.pool.pushMat22(1);
  }
  
  public void setMaxForce(float paramFloat)
  {
    this.m_maxForce = paramFloat;
  }
  
  public void setMaxTorque(float paramFloat)
  {
    this.m_maxTorque = paramFloat;
  }
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    return true;
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f7 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f6 = paramSolverData.velocities[this.m_indexB].w;
    float f3 = this.m_invMassA;
    float f2 = this.m_invMassB;
    float f4 = this.m_invIA;
    float f1 = this.m_invIB;
    float f5 = paramSolverData.step.dt;
    float f8 = -this.m_angularMass;
    float f9 = this.m_angularImpulse;
    float f10 = this.m_maxTorque * f5;
    this.m_angularImpulse = MathUtils.clamp(f8 * (f6 - f7) + f9, -f10, f10);
    f8 = this.m_angularImpulse - f9;
    f7 -= f4 * f8;
    f6 += f8 * f1;
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Vec2.crossToOutUnsafe(f7, this.m_rA, localVec23);
    Vec2.crossToOutUnsafe(f6, this.m_rB, localVec25);
    localVec25.addLocal(localVec22).subLocal(localVec21).subLocal(localVec23);
    Vec2 localVec24 = this.pool.popVec2();
    Mat22.mulToOutUnsafe(this.m_linearMass, localVec25, localVec24);
    localVec24.negateLocal();
    localVec25 = this.pool.popVec2();
    localVec25.set(this.m_linearImpulse);
    this.m_linearImpulse.addLocal(localVec24);
    f5 *= this.m_maxForce;
    if (this.m_linearImpulse.lengthSquared() > f5 * f5)
    {
      this.m_linearImpulse.normalize();
      this.m_linearImpulse.mulLocal(f5);
    }
    localVec24.set(this.m_linearImpulse).subLocal(localVec25);
    localVec23.set(localVec24).mulLocal(f3);
    localVec21.subLocal(localVec23);
    f3 = f7 - f4 * Vec2.cross(this.m_rA, localVec24);
    localVec23.set(localVec24).mulLocal(f2);
    localVec22.addLocal(localVec23);
    f2 = Vec2.cross(this.m_rB, localVec24);
    f4 = paramSolverData.velocities[this.m_indexA].w;
    paramSolverData.velocities[this.m_indexA].w = f3;
    paramSolverData.velocities[this.m_indexB].w = (f6 + f1 * f2);
    this.pool.pushVec2(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.FrictionJoint
 * JD-Core Version:    0.7.0.1
 */