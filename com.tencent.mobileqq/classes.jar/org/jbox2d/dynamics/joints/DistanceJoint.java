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

public class DistanceJoint
  extends Joint
{
  private float m_bias;
  private float m_dampingRatio;
  private float m_frequencyHz;
  private float m_gamma;
  private float m_impulse;
  private int m_indexA;
  private int m_indexB;
  private float m_invIA;
  private float m_invIB;
  private float m_invMassA;
  private float m_invMassB;
  private float m_length;
  private final Vec2 m_localAnchorA;
  private final Vec2 m_localAnchorB;
  private final Vec2 m_localCenterA = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  private float m_mass;
  private final Vec2 m_rA = new Vec2();
  private final Vec2 m_rB = new Vec2();
  private final Vec2 m_u = new Vec2();
  
  protected DistanceJoint(IWorldPool paramIWorldPool, DistanceJointDef paramDistanceJointDef)
  {
    super(paramIWorldPool, paramDistanceJointDef);
    this.m_localAnchorA = paramDistanceJointDef.localAnchorA.clone();
    this.m_localAnchorB = paramDistanceJointDef.localAnchorB.clone();
    this.m_length = paramDistanceJointDef.length;
    this.m_impulse = 0.0F;
    this.m_frequencyHz = paramDistanceJointDef.frequencyHz;
    this.m_dampingRatio = paramDistanceJointDef.dampingRatio;
    this.m_gamma = 0.0F;
    this.m_bias = 0.0F;
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
  
  public float getLength()
  {
    return this.m_length;
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
    paramVec2.x = (this.m_impulse * this.m_u.x * paramFloat);
    paramVec2.y = (this.m_impulse * this.m_u.y * paramFloat);
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
    Vec2 localVec23 = paramSolverData.positions[this.m_indexA].c;
    float f1 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f3 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec24 = paramSolverData.positions[this.m_indexB].c;
    float f4 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Rot localRot1 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    localRot1.set(f1);
    localRot2.set(f4);
    Rot.mulToOutUnsafe(localRot1, this.m_u.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
    Rot.mulToOutUnsafe(localRot2, this.m_u.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
    this.m_u.set(localVec24).addLocal(this.m_rB).subLocal(localVec23).subLocal(this.m_rA);
    this.pool.pushRot(2);
    f4 = this.m_u.length();
    if (f4 > 0.005F)
    {
      localVec23 = this.m_u;
      f1 = localVec23.x;
      f5 = 1.0F / f4;
      localVec23.x = (f1 * f5);
      localVec23 = this.m_u;
      localVec23.y *= f5;
    }
    else
    {
      this.m_u.set(0.0F, 0.0F);
    }
    f1 = Vec2.cross(this.m_rA, this.m_u);
    float f5 = Vec2.cross(this.m_rB, this.m_u);
    f5 = this.m_invMassA + this.m_invIA * f1 * f1 + this.m_invMassB + this.m_invIB * f5 * f5;
    if (f5 != 0.0F) {
      f1 = 1.0F / f5;
    } else {
      f1 = 0.0F;
    }
    this.m_mass = f1;
    f1 = this.m_frequencyHz;
    if (f1 > 0.0F)
    {
      float f6 = this.m_length;
      f1 *= 6.283186F;
      float f9 = this.m_mass;
      float f10 = this.m_dampingRatio;
      float f7 = f9 * f1 * f1;
      float f8 = paramSolverData.step.dt;
      this.m_gamma = ((2.0F * f9 * f10 * f1 + f8 * f7) * f8);
      f1 = this.m_gamma;
      if (f1 != 0.0F) {
        f1 = 1.0F / f1;
      } else {
        f1 = 0.0F;
      }
      this.m_gamma = f1;
      f1 = this.m_gamma;
      this.m_bias = ((f4 - f6) * f8 * f7 * f1);
      f1 = f5 + f1;
      if (f1 != 0.0F) {
        f1 = 1.0F / f1;
      } else {
        f1 = 0.0F;
      }
      this.m_mass = f1;
    }
    else
    {
      this.m_gamma = 0.0F;
      this.m_bias = 0.0F;
    }
    if (paramSolverData.step.warmStarting)
    {
      this.m_impulse *= paramSolverData.step.dtRatio;
      localVec23 = this.pool.popVec2();
      localVec23.set(this.m_u).mulLocal(this.m_impulse);
      localVec21.x -= this.m_invMassA * localVec23.x;
      localVec21.y -= this.m_invMassA * localVec23.y;
      f1 = f3 - this.m_invIA * Vec2.cross(this.m_rA, localVec23);
      localVec22.x += this.m_invMassB * localVec23.x;
      localVec22.y += this.m_invMassB * localVec23.y;
      f2 += this.m_invIB * Vec2.cross(this.m_rB, localVec23);
      this.pool.pushVec2(1);
    }
    else
    {
      this.m_impulse = 0.0F;
      f1 = f3;
    }
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
  }
  
  public void setDampingRatio(float paramFloat)
  {
    this.m_dampingRatio = paramFloat;
  }
  
  public void setFrequency(float paramFloat)
  {
    this.m_frequencyHz = paramFloat;
  }
  
  public void setLength(float paramFloat)
  {
    this.m_length = paramFloat;
  }
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    if (this.m_frequencyHz > 0.0F) {
      return true;
    }
    Rot localRot1 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    Vec2 localVec21 = this.pool.popVec2();
    Vec2 localVec22 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = paramSolverData.positions[this.m_indexA].c;
    float f1 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec25 = paramSolverData.positions[this.m_indexB].c;
    float f2 = paramSolverData.positions[this.m_indexB].a;
    localRot1.set(f1);
    localRot2.set(f2);
    Rot.mulToOutUnsafe(localRot1, localVec23.set(this.m_localAnchorA).subLocal(this.m_localCenterA), localVec21);
    Rot.mulToOutUnsafe(localRot2, localVec23.set(this.m_localAnchorB).subLocal(this.m_localCenterB), localVec22);
    localVec23.set(localVec25).addLocal(localVec22).subLocal(localVec24).subLocal(localVec21);
    float f3 = MathUtils.clamp(localVec23.normalize() - this.m_length, -0.2F, 0.2F);
    float f5 = -this.m_mass * f3;
    float f4 = localVec23.x * f5;
    f5 *= localVec23.y;
    localVec24.x -= this.m_invMassA * f4;
    localVec24.y -= this.m_invMassA * f5;
    float f6 = this.m_invIA;
    float f7 = localVec21.x;
    float f8 = localVec21.y;
    localVec25.x += this.m_invMassB * f4;
    localVec25.y += this.m_invMassB * f5;
    float f9 = this.m_invIB;
    float f10 = localVec22.x;
    float f11 = localVec22.y;
    paramSolverData.positions[this.m_indexA].a = (f1 - f6 * (f7 * f5 - f8 * f4));
    paramSolverData.positions[this.m_indexB].a = (f2 + f9 * (f10 * f5 - f11 * f4));
    this.pool.pushVec2(3);
    this.pool.pushRot(2);
    return MathUtils.abs(f3) < 0.005F;
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f1 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    Vec2.crossToOutUnsafe(f1, this.m_rA, localVec23);
    localVec23.addLocal(localVec21);
    Vec2.crossToOutUnsafe(f2, this.m_rB, localVec24);
    localVec24.addLocal(localVec22);
    float f4 = Vec2.dot(this.m_u, localVec24.subLocal(localVec23));
    float f5 = -this.m_mass;
    float f6 = this.m_bias;
    float f7 = this.m_gamma;
    float f3 = this.m_impulse;
    f4 = f5 * (f4 + f6 + f7 * f3);
    this.m_impulse = (f3 + f4);
    f3 = this.m_u.x * f4;
    f4 *= this.m_u.y;
    localVec21.x -= this.m_invMassA * f3;
    localVec21.y -= this.m_invMassA * f4;
    f5 = this.m_invIA;
    f6 = this.m_rA.x;
    f7 = this.m_rA.y;
    localVec22.x += this.m_invMassB * f3;
    localVec22.y += this.m_invMassB * f4;
    float f8 = this.m_invIB;
    float f9 = this.m_rB.x;
    float f10 = this.m_rB.y;
    paramSolverData.velocities[this.m_indexA].w = (f1 - f5 * (f6 * f4 - f7 * f3));
    paramSolverData.velocities[this.m_indexB].w = (f2 + f8 * (f9 * f4 - f10 * f3));
    this.pool.pushVec2(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.DistanceJoint
 * JD-Core Version:    0.7.0.1
 */