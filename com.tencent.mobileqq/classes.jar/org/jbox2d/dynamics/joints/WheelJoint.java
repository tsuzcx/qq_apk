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

public class WheelJoint
  extends Joint
{
  private final Vec2 d = new Vec2();
  private final Vec2 m_ax = new Vec2();
  private final Vec2 m_ay = new Vec2();
  private float m_bias;
  private float m_dampingRatio;
  private boolean m_enableMotor;
  private float m_frequencyHz;
  private float m_gamma;
  private float m_impulse;
  private int m_indexA;
  private int m_indexB;
  private float m_invIA;
  private float m_invIB;
  private float m_invMassA;
  private float m_invMassB;
  private final Vec2 m_localAnchorA = new Vec2();
  private final Vec2 m_localAnchorB = new Vec2();
  private final Vec2 m_localCenterA = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  private final Vec2 m_localXAxisA = new Vec2();
  private final Vec2 m_localYAxisA = new Vec2();
  private float m_mass;
  private float m_maxMotorTorque;
  private float m_motorImpulse;
  private float m_motorMass;
  private float m_motorSpeed;
  private float m_sAx;
  private float m_sAy;
  private float m_sBx;
  private float m_sBy;
  private float m_springImpulse;
  private float m_springMass;
  private final Vec2 rA = new Vec2();
  private final Vec2 rB = new Vec2();
  
  protected WheelJoint(IWorldPool paramIWorldPool, WheelJointDef paramWheelJointDef)
  {
    super(paramIWorldPool, paramWheelJointDef);
    this.m_localAnchorA.set(paramWheelJointDef.localAnchorA);
    this.m_localAnchorB.set(paramWheelJointDef.localAnchorB);
    this.m_localXAxisA.set(paramWheelJointDef.localAxisA);
    Vec2.crossToOutUnsafe(1.0F, this.m_localXAxisA, this.m_localYAxisA);
    this.m_motorMass = 0.0F;
    this.m_motorImpulse = 0.0F;
    this.m_maxMotorTorque = paramWheelJointDef.maxMotorTorque;
    this.m_motorSpeed = paramWheelJointDef.motorSpeed;
    this.m_enableMotor = paramWheelJointDef.enableMotor;
    this.m_frequencyHz = paramWheelJointDef.frequencyHz;
    this.m_dampingRatio = paramWheelJointDef.dampingRatio;
  }
  
  public void enableMotor(boolean paramBoolean)
  {
    this.m_bodyA.setAwake(true);
    this.m_bodyB.setAwake(true);
    this.m_enableMotor = paramBoolean;
  }
  
  public void getAnchorA(Vec2 paramVec2)
  {
    this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, paramVec2);
  }
  
  public void getAnchorB(Vec2 paramVec2)
  {
    this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, paramVec2);
  }
  
  public float getJointSpeed()
  {
    return this.m_bodyA.m_angularVelocity - this.m_bodyB.m_angularVelocity;
  }
  
  public float getJointTranslation()
  {
    Body localBody1 = this.m_bodyA;
    Body localBody2 = this.m_bodyB;
    Vec2 localVec21 = this.pool.popVec2();
    Vec2 localVec22 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    localBody1.getWorldPointToOut(this.m_localAnchorA, localVec21);
    localBody2.getWorldPointToOut(this.m_localAnchorA, localVec22);
    localVec22.subLocal(localVec21);
    localBody1.getWorldVectorToOut(this.m_localXAxisA, localVec23);
    float f = Vec2.dot(localVec22, localVec23);
    this.pool.pushVec2(3);
    return f;
  }
  
  public Vec2 getLocalAnchorA()
  {
    return this.m_localAnchorA;
  }
  
  public Vec2 getLocalAnchorB()
  {
    return this.m_localAnchorB;
  }
  
  public Vec2 getLocalAxisA()
  {
    return this.m_localXAxisA;
  }
  
  public float getMaxMotorTorque()
  {
    return this.m_maxMotorTorque;
  }
  
  public float getMotorSpeed()
  {
    return this.m_motorSpeed;
  }
  
  public float getMotorTorque(float paramFloat)
  {
    return this.m_motorImpulse * paramFloat;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2)
  {
    Vec2 localVec2 = this.pool.popVec2();
    localVec2.set(this.m_ay).mulLocal(this.m_impulse);
    paramVec2.set(this.m_ax).mulLocal(this.m_springImpulse).addLocal(localVec2).mulLocal(paramFloat);
    this.pool.pushVec2(1);
  }
  
  public float getReactionTorque(float paramFloat)
  {
    return paramFloat * this.m_motorImpulse;
  }
  
  public float getSpringDampingRatio()
  {
    return this.m_dampingRatio;
  }
  
  public float getSpringFrequencyHz()
  {
    return this.m_frequencyHz;
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
    float f5 = this.m_invMassA;
    float f6 = this.m_invMassB;
    float f3 = this.m_invIA;
    float f4 = this.m_invIB;
    Vec2 localVec23 = paramSolverData.positions[this.m_indexA].c;
    float f7 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f1 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec24 = paramSolverData.positions[this.m_indexB].c;
    float f8 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Rot localRot1 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    Vec2 localVec25 = this.pool.popVec2();
    localRot1.set(f7);
    localRot2.set(f8);
    Rot.mulToOutUnsafe(localRot1, localVec25.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.rA);
    Rot.mulToOutUnsafe(localRot2, localVec25.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.rB);
    this.d.set(localVec24).addLocal(this.rB).subLocal(localVec23).subLocal(this.rA);
    Rot.mulToOut(localRot1, this.m_localYAxisA, this.m_ay);
    this.m_sAy = Vec2.cross(localVec25.set(this.d).addLocal(this.rA), this.m_ay);
    this.m_sBy = Vec2.cross(this.rB, this.m_ay);
    f5 += f6;
    f6 = this.m_sAy;
    f7 = this.m_sBy;
    this.m_mass = (f3 * f6 * f6 + f5 + f4 * f7 * f7);
    f6 = this.m_mass;
    if (f6 > 0.0F) {
      this.m_mass = (1.0F / f6);
    }
    this.m_springMass = 0.0F;
    this.m_bias = 0.0F;
    this.m_gamma = 0.0F;
    float f9;
    if (this.m_frequencyHz > 0.0F)
    {
      Rot.mulToOut(localRot1, this.m_localXAxisA, this.m_ax);
      this.m_sAx = Vec2.cross(localVec25.set(this.d).addLocal(this.rA), this.m_ax);
      this.m_sBx = Vec2.cross(this.rB, this.m_ax);
      f6 = this.m_sAx;
      f7 = this.m_sBx;
      f5 = f5 + f3 * f6 * f6 + f4 * f7 * f7;
      if (f5 > 0.0F)
      {
        this.m_springMass = (1.0F / f5);
        f6 = Vec2.dot(this.d, this.m_ax);
        f9 = this.m_frequencyHz * 6.283186F;
        float f10 = this.m_springMass;
        float f11 = this.m_dampingRatio;
        f7 = f10 * f9 * f9;
        f8 = paramSolverData.step.dt;
        this.m_gamma = ((2.0F * f10 * f11 * f9 + f8 * f7) * f8);
        f9 = this.m_gamma;
        if (f9 > 0.0F) {
          this.m_gamma = (1.0F / f9);
        }
        f9 = this.m_gamma;
        this.m_bias = (f6 * f8 * f7 * f9);
        this.m_springMass = (f5 + f9);
        f5 = this.m_springMass;
        if (f5 > 0.0F) {
          this.m_springMass = (1.0F / f5);
        }
      }
    }
    else
    {
      this.m_springImpulse = 0.0F;
    }
    if (this.m_enableMotor)
    {
      this.m_motorMass = (f3 + f4);
      f3 = this.m_motorMass;
      if (f3 > 0.0F) {
        this.m_motorMass = (1.0F / f3);
      }
    }
    else
    {
      this.m_motorMass = 0.0F;
      this.m_motorImpulse = 0.0F;
    }
    if (paramSolverData.step.warmStarting)
    {
      localVec23 = this.pool.popVec2();
      this.m_impulse *= paramSolverData.step.dtRatio;
      this.m_springImpulse *= paramSolverData.step.dtRatio;
      this.m_motorImpulse *= paramSolverData.step.dtRatio;
      localVec23.x = (this.m_impulse * this.m_ay.x + this.m_springImpulse * this.m_ax.x);
      localVec23.y = (this.m_impulse * this.m_ay.y + this.m_springImpulse * this.m_ax.y);
      f3 = this.m_impulse;
      f8 = this.m_sAy;
      f4 = this.m_springImpulse;
      f9 = this.m_sAx;
      f5 = this.m_motorImpulse;
      f6 = this.m_sBy;
      f7 = this.m_sBx;
      localVec21.x -= this.m_invMassA * localVec23.x;
      localVec21.y -= this.m_invMassA * localVec23.y;
      f1 -= this.m_invIA * (f8 * f3 + f9 * f4 + f5);
      localVec22.x += this.m_invMassB * localVec23.x;
      localVec22.y += this.m_invMassB * localVec23.y;
      f2 += this.m_invIB * (f3 * f6 + f4 * f7 + f5);
      this.pool.pushVec2(1);
    }
    else
    {
      this.m_impulse = 0.0F;
      this.m_springImpulse = 0.0F;
      this.m_motorImpulse = 0.0F;
    }
    this.pool.pushRot(2);
    this.pool.pushVec2(1);
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
  }
  
  public boolean isMotorEnabled()
  {
    return this.m_enableMotor;
  }
  
  public void setMaxMotorTorque(float paramFloat)
  {
    this.m_bodyA.setAwake(true);
    this.m_bodyB.setAwake(true);
    this.m_maxMotorTorque = paramFloat;
  }
  
  public void setMotorSpeed(float paramFloat)
  {
    this.m_bodyA.setAwake(true);
    this.m_bodyB.setAwake(true);
    this.m_motorSpeed = paramFloat;
  }
  
  public void setSpringDampingRatio(float paramFloat)
  {
    this.m_dampingRatio = paramFloat;
  }
  
  public void setSpringFrequencyHz(float paramFloat)
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
    Vec2 localVec23 = this.pool.popVec2();
    ((Rot)localObject1).set(f2);
    ((Rot)localObject2).set(f3);
    Rot.mulToOut((Rot)localObject1, localVec23.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.rA);
    Rot.mulToOut((Rot)localObject2, localVec23.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.rB);
    this.d.set(localVec22).subLocal(localVec21).addLocal(this.rB).subLocal(this.rA);
    localObject2 = this.pool.popVec2();
    Rot.mulToOut((Rot)localObject1, this.m_localYAxisA, (Vec2)localObject2);
    float f4 = Vec2.cross(localVec23.set(this.d).addLocal(this.rA), (Vec2)localObject2);
    float f5 = Vec2.cross(this.rB, (Vec2)localObject2);
    float f6 = Vec2.dot(this.d, (Vec2)localObject2);
    float f1 = this.m_invMassA;
    float f7 = this.m_invMassB;
    float f8 = this.m_invIA;
    float f9 = this.m_sAy;
    float f10 = this.m_invIB;
    float f11 = this.m_sBy;
    f7 = f1 + f7 + f8 * f9 * f9 + f10 * f11 * f11;
    f1 = 0.0F;
    if (f7 != 0.0F) {
      f1 = -f6 / f7;
    }
    localObject1 = this.pool.popVec2();
    ((Vec2)localObject2).x *= f1;
    ((Vec2)localObject2).y *= f1;
    localVec21.x -= this.m_invMassA * ((Vec2)localObject1).x;
    localVec21.y -= this.m_invMassA * ((Vec2)localObject1).y;
    f7 = this.m_invIA;
    localVec22.x += this.m_invMassB * ((Vec2)localObject1).x;
    localVec22.y += this.m_invMassB * ((Vec2)localObject1).y;
    f8 = this.m_invIB;
    this.pool.pushVec2(3);
    this.pool.pushRot(2);
    paramSolverData.positions[this.m_indexA].a = (f2 - f7 * (f4 * f1));
    paramSolverData.positions[this.m_indexB].a = (f3 + f8 * (f1 * f5));
    return MathUtils.abs(f6) <= 0.005F;
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    float f1 = this.m_invMassA;
    float f2 = this.m_invMassB;
    float f3 = this.m_invIA;
    float f4 = this.m_invIB;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f6 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f5 = paramSolverData.velocities[this.m_indexB].w;
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    float f8 = Vec2.dot(this.m_ax, localVec23.set(localVec22).subLocal(localVec21));
    float f9 = this.m_sBx;
    float f10 = this.m_sAx;
    float f11 = -this.m_springMass;
    float f12 = this.m_bias;
    float f13 = this.m_gamma;
    float f7 = this.m_springImpulse;
    f8 = f11 * (f8 + f9 * f5 - f10 * f6 + f12 + f13 * f7);
    this.m_springImpulse = (f7 + f8);
    localVec24.x = (this.m_ax.x * f8);
    localVec24.y = (this.m_ax.y * f8);
    f9 = this.m_sAx;
    f7 = this.m_sBx;
    localVec21.x -= localVec24.x * f1;
    localVec21.y -= localVec24.y * f1;
    f6 -= f9 * f8 * f3;
    localVec22.x += localVec24.x * f2;
    localVec22.y += localVec24.y * f2;
    f7 = f5 + f8 * f7 * f4;
    f5 = this.m_motorSpeed;
    f8 = -this.m_motorMass;
    f9 = this.m_motorImpulse;
    f10 = paramSolverData.step.dt * this.m_maxMotorTorque;
    this.m_motorImpulse = MathUtils.clamp(this.m_motorImpulse + f8 * (f7 - f6 - f5), -f10, f10);
    f8 = this.m_motorImpulse - f9;
    f5 = f6 - f3 * f8;
    f6 = f7 + f8 * f4;
    f7 = Vec2.dot(this.m_ay, localVec23.set(localVec22).subLocal(localVec21));
    f8 = this.m_sBy;
    f9 = this.m_sAy;
    f7 = -this.m_mass * (f7 + f8 * f6 - f9 * f5);
    this.m_impulse += f7;
    localVec24.x = (this.m_ay.x * f7);
    localVec24.y = (this.m_ay.y * f7);
    f8 = this.m_sAy;
    f9 = this.m_sBy;
    localVec21.x -= localVec24.x * f1;
    localVec21.y -= f1 * localVec24.y;
    localVec22.x += localVec24.x * f2;
    localVec22.y += f2 * localVec24.y;
    this.pool.pushVec2(2);
    paramSolverData.velocities[this.m_indexA].w = (f5 - f3 * (f8 * f7));
    paramSolverData.velocities[this.m_indexB].w = (f6 + f4 * (f7 * f9));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.WheelJoint
 * JD-Core Version:    0.7.0.1
 */