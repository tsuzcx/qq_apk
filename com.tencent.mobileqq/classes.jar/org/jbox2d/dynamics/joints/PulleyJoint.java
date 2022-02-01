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

public class PulleyJoint
  extends Joint
{
  public static final float MIN_PULLEY_LENGTH = 2.0F;
  private float m_constant;
  private final Vec2 m_groundAnchorA = new Vec2();
  private final Vec2 m_groundAnchorB = new Vec2();
  private float m_impulse;
  private int m_indexA;
  private int m_indexB;
  private float m_invIA;
  private float m_invIB;
  private float m_invMassA;
  private float m_invMassB;
  private float m_lengthA;
  private float m_lengthB;
  private final Vec2 m_localAnchorA = new Vec2();
  private final Vec2 m_localAnchorB = new Vec2();
  private final Vec2 m_localCenterA = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  private float m_mass;
  private final Vec2 m_rA = new Vec2();
  private final Vec2 m_rB = new Vec2();
  private float m_ratio;
  private final Vec2 m_uA = new Vec2();
  private final Vec2 m_uB = new Vec2();
  
  protected PulleyJoint(IWorldPool paramIWorldPool, PulleyJointDef paramPulleyJointDef)
  {
    super(paramIWorldPool, paramPulleyJointDef);
    this.m_groundAnchorA.set(paramPulleyJointDef.groundAnchorA);
    this.m_groundAnchorB.set(paramPulleyJointDef.groundAnchorB);
    this.m_localAnchorA.set(paramPulleyJointDef.localAnchorA);
    this.m_localAnchorB.set(paramPulleyJointDef.localAnchorB);
    this.m_ratio = paramPulleyJointDef.ratio;
    this.m_lengthA = paramPulleyJointDef.lengthA;
    this.m_lengthB = paramPulleyJointDef.lengthB;
    this.m_constant = (paramPulleyJointDef.lengthA + this.m_ratio * paramPulleyJointDef.lengthB);
    this.m_impulse = 0.0F;
  }
  
  public void getAnchorA(Vec2 paramVec2)
  {
    this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, paramVec2);
  }
  
  public void getAnchorB(Vec2 paramVec2)
  {
    this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, paramVec2);
  }
  
  public float getCurrentLengthA()
  {
    Vec2 localVec2 = this.pool.popVec2();
    this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, localVec2);
    localVec2.subLocal(this.m_groundAnchorA);
    float f = localVec2.length();
    this.pool.pushVec2(1);
    return f;
  }
  
  public float getCurrentLengthB()
  {
    Vec2 localVec2 = this.pool.popVec2();
    this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, localVec2);
    localVec2.subLocal(this.m_groundAnchorB);
    float f = localVec2.length();
    this.pool.pushVec2(1);
    return f;
  }
  
  public Vec2 getGroundAnchorA()
  {
    return this.m_groundAnchorA;
  }
  
  public Vec2 getGroundAnchorB()
  {
    return this.m_groundAnchorB;
  }
  
  public float getLength1()
  {
    Vec2 localVec2 = this.pool.popVec2();
    this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, localVec2);
    localVec2.subLocal(this.m_groundAnchorA);
    float f = localVec2.length();
    this.pool.pushVec2(1);
    return f;
  }
  
  public float getLength2()
  {
    Vec2 localVec2 = this.pool.popVec2();
    this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, localVec2);
    localVec2.subLocal(this.m_groundAnchorB);
    float f = localVec2.length();
    this.pool.pushVec2(1);
    return f;
  }
  
  public float getLengthA()
  {
    return this.m_lengthA;
  }
  
  public float getLengthB()
  {
    return this.m_lengthB;
  }
  
  public Vec2 getLocalAnchorA()
  {
    return this.m_localAnchorA;
  }
  
  public Vec2 getLocalAnchorB()
  {
    return this.m_localAnchorB;
  }
  
  public float getRatio()
  {
    return this.m_ratio;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2)
  {
    paramVec2.set(this.m_uB).mulLocal(this.m_impulse).mulLocal(paramFloat);
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
    float f3 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f1 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec24 = paramSolverData.positions[this.m_indexB].c;
    float f4 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Rot localRot1 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    Vec2 localVec25 = this.pool.popVec2();
    localRot1.set(f3);
    localRot2.set(f4);
    Rot.mulToOutUnsafe(localRot1, localVec25.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
    Rot.mulToOutUnsafe(localRot2, localVec25.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
    this.m_uA.set(localVec23).addLocal(this.m_rA).subLocal(this.m_groundAnchorA);
    this.m_uB.set(localVec24).addLocal(this.m_rB).subLocal(this.m_groundAnchorB);
    f3 = this.m_uA.length();
    f4 = this.m_uB.length();
    if (f3 > 0.05F) {
      this.m_uA.mulLocal(1.0F / f3);
    } else {
      this.m_uA.setZero();
    }
    if (f4 > 0.05F) {
      this.m_uB.mulLocal(1.0F / f4);
    } else {
      this.m_uB.setZero();
    }
    f3 = Vec2.cross(this.m_rA, this.m_uA);
    f4 = Vec2.cross(this.m_rB, this.m_uB);
    float f5 = this.m_invMassA;
    float f6 = this.m_invIA;
    float f7 = this.m_invMassB;
    float f8 = this.m_invIB;
    float f9 = this.m_ratio;
    this.m_mass = (f5 + f6 * f3 * f3 + f9 * f9 * (f7 + f8 * f4 * f4));
    f3 = this.m_mass;
    if (f3 > 0.0F) {
      this.m_mass = (1.0F / f3);
    }
    if (paramSolverData.step.warmStarting)
    {
      this.m_impulse *= paramSolverData.step.dtRatio;
      localVec23 = this.pool.popVec2();
      localVec24 = this.pool.popVec2();
      localVec23.set(this.m_uA).mulLocal(-this.m_impulse);
      localVec24.set(this.m_uB).mulLocal(-this.m_ratio * this.m_impulse);
      localVec21.x += this.m_invMassA * localVec23.x;
      localVec21.y += this.m_invMassA * localVec23.y;
      f1 += this.m_invIA * Vec2.cross(this.m_rA, localVec23);
      localVec22.x += this.m_invMassB * localVec24.x;
      localVec22.y += this.m_invMassB * localVec24.y;
      f2 += this.m_invIB * Vec2.cross(this.m_rB, localVec24);
      this.pool.pushVec2(2);
    }
    else
    {
      this.m_impulse = 0.0F;
    }
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
    this.pool.pushVec2(1);
    this.pool.pushRot(2);
  }
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    Rot localRot1 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    Vec2 localVec21 = this.pool.popVec2();
    Vec2 localVec22 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec26 = this.pool.popVec2();
    Vec2 localVec27 = this.pool.popVec2();
    Vec2 localVec28 = paramSolverData.positions[this.m_indexA].c;
    float f3 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec29 = paramSolverData.positions[this.m_indexB].c;
    float f4 = paramSolverData.positions[this.m_indexB].a;
    localRot1.set(f3);
    localRot2.set(f4);
    Rot.mulToOutUnsafe(localRot1, localVec25.set(this.m_localAnchorA).subLocal(this.m_localCenterA), localVec21);
    Rot.mulToOutUnsafe(localRot2, localVec25.set(this.m_localAnchorB).subLocal(this.m_localCenterB), localVec22);
    localVec23.set(localVec28).addLocal(localVec21).subLocal(this.m_groundAnchorA);
    localVec24.set(localVec29).addLocal(localVec22).subLocal(this.m_groundAnchorB);
    float f5 = localVec23.length();
    float f6 = localVec24.length();
    if (f5 > 0.05F) {
      localVec23.mulLocal(1.0F / f5);
    } else {
      localVec23.setZero();
    }
    if (f6 > 0.05F) {
      localVec24.mulLocal(1.0F / f6);
    } else {
      localVec24.setZero();
    }
    float f1 = Vec2.cross(localVec21, localVec23);
    float f2 = Vec2.cross(localVec22, localVec24);
    float f7 = this.m_invMassA;
    float f8 = this.m_invIA;
    float f9 = this.m_invMassB;
    float f10 = this.m_invIB;
    float f11 = this.m_ratio;
    f2 = f7 + f8 * f1 * f1 + f11 * f11 * (f9 + f10 * f2 * f2);
    f1 = f2;
    if (f2 > 0.0F) {
      f1 = 1.0F / f2;
    }
    f5 = this.m_constant - f5 - this.m_ratio * f6;
    f2 = MathUtils.abs(f5);
    f1 = -f1 * f5;
    localVec26.set(localVec23).mulLocal(-f1);
    localVec27.set(localVec24).mulLocal(-this.m_ratio * f1);
    localVec28.x += this.m_invMassA * localVec26.x;
    localVec28.y += this.m_invMassA * localVec26.y;
    f1 = this.m_invIA;
    f5 = Vec2.cross(localVec21, localVec26);
    localVec29.x += this.m_invMassB * localVec27.x;
    localVec29.y += this.m_invMassB * localVec27.y;
    f6 = this.m_invIB;
    f7 = Vec2.cross(localVec22, localVec27);
    paramSolverData.positions[this.m_indexA].a = (f3 + f1 * f5);
    paramSolverData.positions[this.m_indexB].a = (f4 + f6 * f7);
    this.pool.pushRot(2);
    this.pool.pushVec2(7);
    return f2 < 0.005F;
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f1 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec26 = this.pool.popVec2();
    Vec2.crossToOutUnsafe(f1, this.m_rA, localVec23);
    localVec23.addLocal(localVec21);
    Vec2.crossToOutUnsafe(f2, this.m_rB, localVec24);
    localVec24.addLocal(localVec22);
    float f3 = -Vec2.dot(this.m_uA, localVec23);
    float f4 = this.m_ratio;
    float f5 = Vec2.dot(this.m_uB, localVec24);
    f3 = -this.m_mass * (f3 - f4 * f5);
    this.m_impulse += f3;
    localVec25.set(this.m_uA).mulLocal(-f3);
    localVec26.set(this.m_uB).mulLocal(-this.m_ratio * f3);
    localVec21.x += this.m_invMassA * localVec25.x;
    localVec21.y += this.m_invMassA * localVec25.y;
    f3 = this.m_invIA;
    f4 = Vec2.cross(this.m_rA, localVec25);
    localVec22.x += this.m_invMassB * localVec26.x;
    localVec22.y += this.m_invMassB * localVec26.y;
    f5 = this.m_invIB;
    float f6 = Vec2.cross(this.m_rB, localVec26);
    paramSolverData.velocities[this.m_indexA].w = (f1 + f3 * f4);
    paramSolverData.velocities[this.m_indexB].w = (f2 + f5 * f6);
    this.pool.pushVec2(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.PulleyJoint
 * JD-Core Version:    0.7.0.1
 */