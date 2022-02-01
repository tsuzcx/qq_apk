package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat22;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

public class MouseJoint
  extends Joint
{
  private final Vec2 m_C = new Vec2();
  private float m_beta;
  private float m_dampingRatio;
  private float m_frequencyHz;
  private float m_gamma;
  private final Vec2 m_impulse = new Vec2();
  private int m_indexB;
  private float m_invIB;
  private float m_invMassB;
  private final Vec2 m_localAnchorB = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  private final Mat22 m_mass = new Mat22();
  private float m_maxForce;
  private final Vec2 m_rB = new Vec2();
  private final Vec2 m_targetA = new Vec2();
  
  protected MouseJoint(IWorldPool paramIWorldPool, MouseJointDef paramMouseJointDef)
  {
    super(paramIWorldPool, paramMouseJointDef);
    this.m_targetA.set(paramMouseJointDef.target);
    Transform.mulTransToOutUnsafe(this.m_bodyB.getTransform(), this.m_targetA, this.m_localAnchorB);
    this.m_maxForce = paramMouseJointDef.maxForce;
    this.m_impulse.setZero();
    this.m_frequencyHz = paramMouseJointDef.frequencyHz;
    this.m_dampingRatio = paramMouseJointDef.dampingRatio;
    this.m_beta = 0.0F;
    this.m_gamma = 0.0F;
  }
  
  public void getAnchorA(Vec2 paramVec2)
  {
    paramVec2.set(this.m_targetA);
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
  
  public float getMaxForce()
  {
    return this.m_maxForce;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2)
  {
    paramVec2.set(this.m_impulse).mulLocal(paramFloat);
  }
  
  public float getReactionTorque(float paramFloat)
  {
    return paramFloat * 0.0F;
  }
  
  public Vec2 getTarget()
  {
    return this.m_targetA;
  }
  
  public void initVelocityConstraints(SolverData paramSolverData)
  {
    this.m_indexB = this.m_bodyB.m_islandIndex;
    this.m_localCenterB.set(this.m_bodyB.m_sweep.localCenter);
    this.m_invMassB = this.m_bodyB.m_invMass;
    this.m_invIB = this.m_bodyB.m_invI;
    Vec2 localVec21 = paramSolverData.positions[this.m_indexB].c;
    float f2 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f1 = paramSolverData.velocities[this.m_indexB].w;
    Object localObject = this.pool.popRot();
    ((Rot)localObject).set(f2);
    float f3 = this.m_bodyB.getMass();
    float f4 = this.m_frequencyHz * 6.283186F;
    float f5 = this.m_dampingRatio;
    float f6 = paramSolverData.step.dt;
    f2 = f3 * (f4 * f4) * f6;
    this.m_gamma = (f6 * (2.0F * f3 * f5 * f4 + f2));
    f3 = this.m_gamma;
    if (f3 != 0.0F) {
      this.m_gamma = (1.0F / f3);
    }
    this.m_beta = (f2 * this.m_gamma);
    Rot.mulToOutUnsafe((Rot)localObject, this.pool.popVec2().set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
    localObject = this.pool.popMat22();
    ((Mat22)localObject).ex.x = (this.m_invMassB + this.m_invIB * this.m_rB.y * this.m_rB.y + this.m_gamma);
    ((Mat22)localObject).ex.y = (-this.m_invIB * this.m_rB.x * this.m_rB.y);
    ((Mat22)localObject).ey.x = ((Mat22)localObject).ex.y;
    ((Mat22)localObject).ey.y = (this.m_invMassB + this.m_invIB * this.m_rB.x * this.m_rB.x + this.m_gamma);
    ((Mat22)localObject).invertToOut(this.m_mass);
    this.m_C.set(localVec21).addLocal(this.m_rB).subLocal(this.m_targetA);
    this.m_C.mulLocal(this.m_beta);
    f1 *= 0.98F;
    if (paramSolverData.step.warmStarting)
    {
      this.m_impulse.mulLocal(paramSolverData.step.dtRatio);
      localVec22.x += this.m_invMassB * this.m_impulse.x;
      localVec22.y += this.m_invMassB * this.m_impulse.y;
      f1 += this.m_invIB * Vec2.cross(this.m_rB, this.m_impulse);
    }
    else
    {
      this.m_impulse.setZero();
    }
    paramSolverData.velocities[this.m_indexB].w = f1;
    this.pool.pushVec2(1);
    this.pool.pushMat22(1);
    this.pool.pushRot(1);
  }
  
  public void setDampingRatio(float paramFloat)
  {
    this.m_dampingRatio = paramFloat;
  }
  
  public void setFrequency(float paramFloat)
  {
    this.m_frequencyHz = paramFloat;
  }
  
  public void setMaxForce(float paramFloat)
  {
    this.m_maxForce = paramFloat;
  }
  
  public void setTarget(Vec2 paramVec2)
  {
    if (!this.m_bodyB.isAwake()) {
      this.m_bodyB.setAwake(true);
    }
    this.m_targetA.set(paramVec2);
  }
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    return true;
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexB].v;
    float f1 = paramSolverData.velocities[this.m_indexB].w;
    Vec2 localVec24 = this.pool.popVec2();
    Vec2.crossToOutUnsafe(f1, this.m_rB, localVec24);
    localVec24.addLocal(localVec21);
    Vec2 localVec22 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    localVec23.set(this.m_impulse).mulLocal(this.m_gamma).addLocal(this.m_C).addLocal(localVec24).negateLocal();
    Mat22.mulToOutUnsafe(this.m_mass, localVec23, localVec22);
    localVec23.set(this.m_impulse);
    this.m_impulse.addLocal(localVec22);
    float f2 = paramSolverData.step.dt * this.m_maxForce;
    if (this.m_impulse.lengthSquared() > f2 * f2)
    {
      localVec24 = this.m_impulse;
      localVec24.mulLocal(f2 / localVec24.length());
    }
    localVec22.set(this.m_impulse).subLocal(localVec23);
    localVec21.x += this.m_invMassB * localVec22.x;
    localVec21.y += this.m_invMassB * localVec22.y;
    f2 = this.m_invIB;
    float f3 = Vec2.cross(this.m_rB, localVec22);
    paramSolverData.velocities[this.m_indexB].w = (f1 + f2 * f3);
    this.pool.pushVec2(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.MouseJoint
 * JD-Core Version:    0.7.0.1
 */