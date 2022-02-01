package org.jbox2d.dynamics.joints;

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

public class RopeJoint
  extends Joint
{
  private float m_impulse;
  private int m_indexA;
  private int m_indexB;
  private float m_invIA;
  private float m_invIB;
  private float m_invMassA;
  private float m_invMassB;
  private float m_length;
  private final Vec2 m_localAnchorA = new Vec2();
  private final Vec2 m_localAnchorB = new Vec2();
  private final Vec2 m_localCenterA = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  private float m_mass;
  private float m_maxLength;
  private final Vec2 m_rA = new Vec2();
  private final Vec2 m_rB = new Vec2();
  private LimitState m_state;
  private final Vec2 m_u = new Vec2();
  
  protected RopeJoint(IWorldPool paramIWorldPool, RopeJointDef paramRopeJointDef)
  {
    super(paramIWorldPool, paramRopeJointDef);
    this.m_localAnchorA.set(paramRopeJointDef.localAnchorA);
    this.m_localAnchorB.set(paramRopeJointDef.localAnchorB);
    this.m_maxLength = paramRopeJointDef.maxLength;
    this.m_mass = 0.0F;
    this.m_impulse = 0.0F;
    this.m_state = LimitState.INACTIVE;
    this.m_length = 0.0F;
  }
  
  public void getAnchorA(Vec2 paramVec2)
  {
    this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, paramVec2);
  }
  
  public void getAnchorB(Vec2 paramVec2)
  {
    this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, paramVec2);
  }
  
  public LimitState getLimitState()
  {
    return this.m_state;
  }
  
  public Vec2 getLocalAnchorA()
  {
    return this.m_localAnchorA;
  }
  
  public Vec2 getLocalAnchorB()
  {
    return this.m_localAnchorB;
  }
  
  public float getMaxLength()
  {
    return this.m_maxLength;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2)
  {
    paramVec2.set(this.m_u).mulLocal(paramFloat).mulLocal(this.m_impulse);
  }
  
  public float getReactionTorque(float paramFloat)
  {
    return 0.0F;
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
    Vec2 localVec21 = paramSolverData.positions[this.m_indexA].c;
    float f1 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexA].v;
    float f3 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec23 = paramSolverData.positions[this.m_indexB].c;
    float f4 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec24 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Rot localRot1 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    Vec2 localVec25 = this.pool.popVec2();
    localRot1.set(f1);
    localRot2.set(f4);
    Rot.mulToOutUnsafe(localRot1, localVec25.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
    Rot.mulToOutUnsafe(localRot2, localVec25.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
    this.m_u.set(localVec23).addLocal(this.m_rB).subLocal(localVec21).subLocal(this.m_rA);
    this.m_length = this.m_u.length();
    if (this.m_length - this.m_maxLength > 0.0F) {
      this.m_state = LimitState.AT_UPPER;
    } else {
      this.m_state = LimitState.INACTIVE;
    }
    f1 = this.m_length;
    if (f1 > 0.005F)
    {
      this.m_u.mulLocal(1.0F / f1);
      f1 = Vec2.cross(this.m_rA, this.m_u);
      f4 = Vec2.cross(this.m_rB, this.m_u);
      f1 = this.m_invMassA + this.m_invIA * f1 * f1 + this.m_invMassB + this.m_invIB * f4 * f4;
      if (f1 != 0.0F) {
        f1 = 1.0F / f1;
      } else {
        f1 = 0.0F;
      }
      this.m_mass = f1;
      if (paramSolverData.step.warmStarting)
      {
        this.m_impulse *= paramSolverData.step.dtRatio;
        f4 = this.m_impulse * this.m_u.x;
        float f5 = this.m_impulse * this.m_u.y;
        localVec22.x -= this.m_invMassA * f4;
        localVec22.y -= this.m_invMassA * f5;
        f1 = f3 - this.m_invIA * (this.m_rA.x * f5 - this.m_rA.y * f4);
        localVec24.x += this.m_invMassB * f4;
        localVec24.y += this.m_invMassB * f5;
        f2 += this.m_invIB * (this.m_rB.x * f5 - this.m_rB.y * f4);
      }
      else
      {
        this.m_impulse = 0.0F;
        f1 = f3;
      }
      this.pool.pushRot(2);
      this.pool.pushVec2(1);
      paramSolverData.velocities[this.m_indexA].w = f1;
      paramSolverData.velocities[this.m_indexB].w = f2;
      return;
    }
    this.m_u.setZero();
    this.m_mass = 0.0F;
    this.m_impulse = 0.0F;
  }
  
  public void setMaxLength(float paramFloat)
  {
    this.m_maxLength = paramFloat;
  }
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.positions[this.m_indexA].c;
    float f1 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec22 = paramSolverData.positions[this.m_indexB].c;
    float f2 = paramSolverData.positions[this.m_indexB].a;
    Rot localRot1 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec26 = this.pool.popVec2();
    localRot1.set(f1);
    localRot2.set(f2);
    Rot.mulToOutUnsafe(localRot1, localVec26.set(this.m_localAnchorA).subLocal(this.m_localCenterA), localVec24);
    Rot.mulToOutUnsafe(localRot2, localVec26.set(this.m_localAnchorB).subLocal(this.m_localCenterB), localVec25);
    localVec23.set(localVec22).addLocal(localVec25).subLocal(localVec21).subLocal(localVec24);
    float f3 = localVec23.normalize();
    float f4 = MathUtils.clamp(f3 - this.m_maxLength, 0.0F, 0.2F);
    float f5 = -this.m_mass * f4;
    f4 = localVec23.x * f5;
    f5 *= localVec23.y;
    localVec21.x -= this.m_invMassA * f4;
    localVec21.y -= this.m_invMassA * f5;
    float f6 = this.m_invIA;
    float f7 = localVec24.x;
    float f8 = localVec24.y;
    localVec22.x += this.m_invMassB * f4;
    localVec22.y += this.m_invMassB * f5;
    float f9 = this.m_invIB;
    float f10 = localVec25.x;
    float f11 = localVec25.y;
    this.pool.pushRot(2);
    this.pool.pushVec2(4);
    paramSolverData.positions[this.m_indexA].a = (f1 - f6 * (f7 * f5 - f8 * f4));
    paramSolverData.positions[this.m_indexB].a = (f2 + f9 * (f10 * f5 - f11 * f4));
    return f3 - this.m_maxLength < 0.005F;
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f3 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f4 = paramSolverData.velocities[this.m_indexB].w;
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    Vec2 localVec25 = this.pool.popVec2();
    Vec2.crossToOutUnsafe(f3, this.m_rA, localVec23);
    localVec23.addLocal(localVec21);
    Vec2.crossToOutUnsafe(f4, this.m_rB, localVec24);
    localVec24.addLocal(localVec22);
    float f5 = this.m_length - this.m_maxLength;
    float f2 = Vec2.dot(this.m_u, localVec25.set(localVec24).subLocal(localVec23));
    float f1 = f2;
    if (f5 < 0.0F) {
      f1 = f2 + paramSolverData.step.inv_dt * f5;
    }
    f2 = -this.m_mass;
    f5 = this.m_impulse;
    this.m_impulse = MathUtils.min(0.0F, f2 * f1 + f5);
    f2 = this.m_impulse - f5;
    f1 = this.m_u.x * f2;
    f2 *= this.m_u.y;
    localVec21.x -= this.m_invMassA * f1;
    localVec21.y -= this.m_invMassA * f2;
    f5 = this.m_invIA;
    float f6 = this.m_rA.x;
    float f7 = this.m_rA.y;
    localVec22.x += this.m_invMassB * f1;
    localVec22.y += this.m_invMassB * f2;
    float f8 = this.m_invIB;
    float f9 = this.m_rB.x;
    float f10 = this.m_rB.y;
    this.pool.pushVec2(3);
    paramSolverData.velocities[this.m_indexA].w = (f3 - f5 * (f6 * f2 - f7 * f1));
    paramSolverData.velocities[this.m_indexB].w = (f4 + f8 * (f9 * f2 - f10 * f1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.RopeJoint
 * JD-Core Version:    0.7.0.1
 */