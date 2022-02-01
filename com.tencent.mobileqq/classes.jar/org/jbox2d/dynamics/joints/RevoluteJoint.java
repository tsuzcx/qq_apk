package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat22;
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

public class RevoluteJoint
  extends Joint
{
  private boolean m_enableLimit;
  private boolean m_enableMotor;
  private final Vec3 m_impulse = new Vec3();
  private int m_indexA;
  private int m_indexB;
  private float m_invIA;
  private float m_invIB;
  private float m_invMassA;
  private float m_invMassB;
  private LimitState m_limitState;
  protected final Vec2 m_localAnchorA = new Vec2();
  protected final Vec2 m_localAnchorB = new Vec2();
  private final Vec2 m_localCenterA = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  private float m_lowerAngle;
  private final Mat33 m_mass = new Mat33();
  private float m_maxMotorTorque;
  private float m_motorImpulse;
  private float m_motorMass;
  private float m_motorSpeed;
  private final Vec2 m_rA = new Vec2();
  private final Vec2 m_rB = new Vec2();
  protected float m_referenceAngle;
  private float m_upperAngle;
  
  protected RevoluteJoint(IWorldPool paramIWorldPool, RevoluteJointDef paramRevoluteJointDef)
  {
    super(paramIWorldPool, paramRevoluteJointDef);
    this.m_localAnchorA.set(paramRevoluteJointDef.localAnchorA);
    this.m_localAnchorB.set(paramRevoluteJointDef.localAnchorB);
    this.m_referenceAngle = paramRevoluteJointDef.referenceAngle;
    this.m_motorImpulse = 0.0F;
    this.m_lowerAngle = paramRevoluteJointDef.lowerAngle;
    this.m_upperAngle = paramRevoluteJointDef.upperAngle;
    this.m_maxMotorTorque = paramRevoluteJointDef.maxMotorTorque;
    this.m_motorSpeed = paramRevoluteJointDef.motorSpeed;
    this.m_enableLimit = paramRevoluteJointDef.enableLimit;
    this.m_enableMotor = paramRevoluteJointDef.enableMotor;
    this.m_limitState = LimitState.INACTIVE;
  }
  
  public void enableLimit(boolean paramBoolean)
  {
    if (paramBoolean != this.m_enableLimit)
    {
      this.m_bodyA.setAwake(true);
      this.m_bodyB.setAwake(true);
      this.m_enableLimit = paramBoolean;
      this.m_impulse.z = 0.0F;
    }
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
  
  public float getJointAngle()
  {
    Body localBody = this.m_bodyA;
    return this.m_bodyB.m_sweep.a - localBody.m_sweep.a - this.m_referenceAngle;
  }
  
  public float getJointSpeed()
  {
    Body localBody = this.m_bodyA;
    return this.m_bodyB.m_angularVelocity - localBody.m_angularVelocity;
  }
  
  public Vec2 getLocalAnchorA()
  {
    return this.m_localAnchorA;
  }
  
  public Vec2 getLocalAnchorB()
  {
    return this.m_localAnchorB;
  }
  
  public float getLowerLimit()
  {
    return this.m_lowerAngle;
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
    paramVec2.set(this.m_impulse.x, this.m_impulse.y).mulLocal(paramFloat);
  }
  
  public float getReactionTorque(float paramFloat)
  {
    return paramFloat * this.m_impulse.z;
  }
  
  public float getReferenceAngle()
  {
    return this.m_referenceAngle;
  }
  
  public float getUpperLimit()
  {
    return this.m_upperAngle;
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
    float f7 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f1 = paramSolverData.velocities[this.m_indexA].w;
    float f8 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Object localObject1 = this.pool.popRot();
    Object localObject2 = this.pool.popRot();
    Vec2 localVec23 = this.pool.popVec2();
    ((Rot)localObject1).set(f7);
    ((Rot)localObject2).set(f8);
    Rot.mulToOutUnsafe((Rot)localObject1, localVec23.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
    Rot.mulToOutUnsafe((Rot)localObject2, localVec23.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
    float f5 = this.m_invMassA;
    float f3 = this.m_invMassB;
    float f6 = this.m_invIA;
    float f4 = this.m_invIB;
    float f9 = f6 + f4;
    int i;
    if (f9 == 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    localObject1 = this.m_mass.ex;
    float f10 = f5 + f3;
    ((Vec3)localObject1).x = (f10 + this.m_rA.y * this.m_rA.y * f6 + this.m_rB.y * this.m_rB.y * f4);
    this.m_mass.ey.x = (-this.m_rA.y * this.m_rA.x * f6 - this.m_rB.y * this.m_rB.x * f4);
    this.m_mass.ez.x = (-this.m_rA.y * f6 - this.m_rB.y * f4);
    this.m_mass.ex.y = this.m_mass.ey.x;
    this.m_mass.ey.y = (f10 + this.m_rA.x * this.m_rA.x * f6 + this.m_rB.x * this.m_rB.x * f4);
    this.m_mass.ez.y = (this.m_rA.x * f6 + this.m_rB.x * f4);
    this.m_mass.ex.z = this.m_mass.ez.x;
    this.m_mass.ey.z = this.m_mass.ez.y;
    this.m_mass.ez.z = f9;
    this.m_motorMass = f9;
    f9 = this.m_motorMass;
    if (f9 > 0.0F) {
      this.m_motorMass = (1.0F / f9);
    }
    if ((!this.m_enableMotor) || (i != 0)) {
      this.m_motorImpulse = 0.0F;
    }
    if ((this.m_enableLimit) && (i == 0))
    {
      f7 = f8 - f7 - this.m_referenceAngle;
      if (MathUtils.abs(this.m_upperAngle - this.m_lowerAngle) < 0.06981318F)
      {
        this.m_limitState = LimitState.EQUAL;
      }
      else if (f7 <= this.m_lowerAngle)
      {
        if (this.m_limitState != LimitState.AT_LOWER) {
          this.m_impulse.z = 0.0F;
        }
        this.m_limitState = LimitState.AT_LOWER;
      }
      else if (f7 >= this.m_upperAngle)
      {
        if (this.m_limitState != LimitState.AT_UPPER) {
          this.m_impulse.z = 0.0F;
        }
        this.m_limitState = LimitState.AT_UPPER;
      }
      else
      {
        this.m_limitState = LimitState.INACTIVE;
        this.m_impulse.z = 0.0F;
      }
    }
    else
    {
      this.m_limitState = LimitState.INACTIVE;
    }
    if (paramSolverData.step.warmStarting)
    {
      localObject1 = this.pool.popVec2();
      localObject2 = this.m_impulse;
      ((Vec3)localObject2).x *= paramSolverData.step.dtRatio;
      localObject2 = this.m_impulse;
      ((Vec3)localObject2).y *= paramSolverData.step.dtRatio;
      this.m_motorImpulse *= paramSolverData.step.dtRatio;
      ((Vec2)localObject1).x = this.m_impulse.x;
      ((Vec2)localObject1).y = this.m_impulse.y;
      localVec21.x -= ((Vec2)localObject1).x * f5;
      localVec21.y -= f5 * ((Vec2)localObject1).y;
      f1 -= f6 * (Vec2.cross(this.m_rA, (Vec2)localObject1) + this.m_motorImpulse + this.m_impulse.z);
      localVec22.x += f3 * ((Vec2)localObject1).x;
      localVec22.y += f3 * ((Vec2)localObject1).y;
      f2 += f4 * (Vec2.cross(this.m_rB, (Vec2)localObject1) + this.m_motorImpulse + this.m_impulse.z);
      this.pool.pushVec2(1);
    }
    else
    {
      this.m_impulse.setZero();
      this.m_motorImpulse = 0.0F;
    }
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
    this.pool.pushVec2(1);
    this.pool.pushRot(2);
  }
  
  public boolean isLimitEnabled()
  {
    return this.m_enableLimit;
  }
  
  public boolean isMotorEnabled()
  {
    return this.m_enableMotor;
  }
  
  public void setLimits(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != this.m_lowerAngle) || (paramFloat2 != this.m_upperAngle))
    {
      this.m_bodyA.setAwake(true);
      this.m_bodyB.setAwake(true);
      this.m_impulse.z = 0.0F;
      this.m_lowerAngle = paramFloat1;
      this.m_upperAngle = paramFloat2;
    }
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
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    Object localObject1 = this.pool.popRot();
    Object localObject2 = this.pool.popRot();
    Vec2 localVec21 = paramSolverData.positions[this.m_indexA].c;
    float f4 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec22 = paramSolverData.positions[this.m_indexB].c;
    float f3 = paramSolverData.positions[this.m_indexB].a;
    ((Rot)localObject1).set(f4);
    ((Rot)localObject2).set(f3);
    float f1 = this.m_invIA;
    float f5 = this.m_invIB;
    float f2 = 0.0F;
    int i;
    if (f1 + f5 == 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.m_enableLimit) && (this.m_limitState != LimitState.INACTIVE) && (i == 0))
    {
      f1 = f3 - f4 - this.m_referenceAngle;
      if (this.m_limitState == LimitState.EQUAL)
      {
        f1 = MathUtils.clamp(f1 - this.m_lowerAngle, -0.1396264F, 0.1396264F);
        f2 = -this.m_motorMass * f1;
        f1 = MathUtils.abs(f1);
      }
      else if (this.m_limitState == LimitState.AT_LOWER)
      {
        f2 = f1 - this.m_lowerAngle;
        f1 = -f2;
        f2 = MathUtils.clamp(f2 + 0.03490659F, -0.1396264F, 0.0F);
        f2 = -this.m_motorMass * f2;
      }
      else if (this.m_limitState == LimitState.AT_UPPER)
      {
        f1 -= this.m_upperAngle;
        f2 = MathUtils.clamp(f1 - 0.03490659F, 0.0F, 0.1396264F);
        f2 = -this.m_motorMass * f2;
      }
      else
      {
        f1 = 0.0F;
      }
      f4 -= this.m_invIA * f2;
      f3 += this.m_invIB * f2;
      f2 = f4;
    }
    else
    {
      f1 = 0.0F;
      f2 = f4;
    }
    ((Rot)localObject1).set(f2);
    ((Rot)localObject2).set(f3);
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec26 = this.pool.popVec2();
    Rot.mulToOutUnsafe((Rot)localObject1, localVec25.set(this.m_localAnchorA).subLocal(this.m_localCenterA), localVec23);
    Rot.mulToOutUnsafe((Rot)localObject2, localVec25.set(this.m_localAnchorB).subLocal(this.m_localCenterB), localVec24);
    localVec25.set(localVec22).addLocal(localVec24).subLocal(localVec21).subLocal(localVec23);
    f4 = localVec25.length();
    float f8 = this.m_invMassA;
    float f7 = this.m_invMassB;
    f5 = this.m_invIA;
    float f6 = this.m_invIB;
    localObject1 = this.pool.popMat22();
    localObject2 = ((Mat22)localObject1).ex;
    float f9 = f8 + f7;
    ((Vec2)localObject2).x = (f9 + localVec23.y * f5 * localVec23.y + localVec24.y * f6 * localVec24.y);
    ((Mat22)localObject1).ex.y = (-f5 * localVec23.x * localVec23.y - localVec24.x * f6 * localVec24.y);
    ((Mat22)localObject1).ey.x = ((Mat22)localObject1).ex.y;
    ((Mat22)localObject1).ey.y = (f9 + localVec23.x * f5 * localVec23.x + localVec24.x * f6 * localVec24.x);
    ((Mat22)localObject1).solveToOut(localVec25, localVec26);
    localVec26.negateLocal();
    localVec21.x -= localVec26.x * f8;
    localVec21.y -= f8 * localVec26.y;
    f8 = Vec2.cross(localVec23, localVec26);
    localVec22.x += localVec26.x * f7;
    localVec22.y += f7 * localVec26.y;
    f7 = Vec2.cross(localVec24, localVec26);
    this.pool.pushVec2(4);
    this.pool.pushMat22(1);
    paramSolverData.positions[this.m_indexA].a = (f2 - f5 * f8);
    paramSolverData.positions[this.m_indexB].a = (f3 + f6 * f7);
    this.pool.pushRot(2);
    return (f4 <= 0.005F) && (f1 <= 0.03490659F);
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f4 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f3 = paramSolverData.velocities[this.m_indexB].w;
    float f7 = this.m_invMassA;
    float f5 = this.m_invMassB;
    float f8 = this.m_invIA;
    float f6 = this.m_invIB;
    int i;
    if (f8 + f6 == 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    float f2 = f4;
    float f1 = f3;
    if (this.m_enableMotor)
    {
      f2 = f4;
      f1 = f3;
      if (this.m_limitState != LimitState.EQUAL)
      {
        f2 = f4;
        f1 = f3;
        if (i == 0)
        {
          f1 = this.m_motorSpeed;
          f2 = -this.m_motorMass;
          float f9 = this.m_motorImpulse;
          float f10 = paramSolverData.step.dt * this.m_maxMotorTorque;
          this.m_motorImpulse = MathUtils.clamp(this.m_motorImpulse + f2 * (f3 - f4 - f1), -f10, f10);
          f1 = this.m_motorImpulse - f9;
          f2 = f4 - f8 * f1;
          f1 = f3 + f1 * f6;
        }
      }
    }
    Object localObject1 = this.pool.popVec2();
    Object localObject3;
    Object localObject2;
    if ((this.m_enableLimit) && (this.m_limitState != LimitState.INACTIVE) && (i == 0))
    {
      localObject3 = this.pool.popVec2();
      Object localObject4 = this.pool.popVec3();
      Vec2.crossToOutUnsafe(f2, this.m_rA, (Vec2)localObject1);
      Vec2.crossToOutUnsafe(f1, this.m_rB, (Vec2)localObject3);
      ((Vec2)localObject3).addLocal(localVec22).subLocal(localVec21).subLocal((Vec2)localObject1);
      ((Vec3)localObject4).set(((Vec2)localObject3).x, ((Vec2)localObject3).y, f1 - f2);
      localObject2 = this.pool.popVec3();
      this.m_mass.solve33ToOut((Vec3)localObject4, (Vec3)localObject2);
      ((Vec3)localObject2).negateLocal();
      if (this.m_limitState == LimitState.EQUAL) {
        this.m_impulse.addLocal((Vec3)localObject2);
      } else if (this.m_limitState == LimitState.AT_LOWER)
      {
        if (this.m_impulse.z + ((Vec3)localObject2).z < 0.0F)
        {
          localObject4 = this.pool.popVec2();
          ((Vec2)localObject4).set(this.m_mass.ez.x, this.m_mass.ez.y).mulLocal(this.m_impulse.z).subLocal((Vec2)localObject3);
          this.m_mass.solve22ToOut((Vec2)localObject4, (Vec2)localObject1);
          ((Vec3)localObject2).x = ((Vec2)localObject1).x;
          ((Vec3)localObject2).y = ((Vec2)localObject1).y;
          ((Vec3)localObject2).z = (-this.m_impulse.z);
          localObject3 = this.m_impulse;
          ((Vec3)localObject3).x += ((Vec2)localObject1).x;
          localObject3 = this.m_impulse;
          ((Vec3)localObject3).y += ((Vec2)localObject1).y;
          this.m_impulse.z = 0.0F;
          this.pool.pushVec2(1);
        }
        else
        {
          this.m_impulse.addLocal((Vec3)localObject2);
        }
      }
      else if (this.m_limitState == LimitState.AT_UPPER) {
        if (this.m_impulse.z + ((Vec3)localObject2).z > 0.0F)
        {
          localObject4 = this.pool.popVec2();
          ((Vec2)localObject4).set(this.m_mass.ez.x, this.m_mass.ez.y).mulLocal(this.m_impulse.z).subLocal((Vec2)localObject3);
          this.m_mass.solve22ToOut((Vec2)localObject4, (Vec2)localObject1);
          ((Vec3)localObject2).x = ((Vec2)localObject1).x;
          ((Vec3)localObject2).y = ((Vec2)localObject1).y;
          ((Vec3)localObject2).z = (-this.m_impulse.z);
          localObject3 = this.m_impulse;
          ((Vec3)localObject3).x += ((Vec2)localObject1).x;
          localObject3 = this.m_impulse;
          ((Vec3)localObject3).y += ((Vec2)localObject1).y;
          this.m_impulse.z = 0.0F;
          this.pool.pushVec2(1);
        }
        else
        {
          this.m_impulse.addLocal((Vec3)localObject2);
        }
      }
      localObject1 = this.pool.popVec2();
      ((Vec2)localObject1).set(((Vec3)localObject2).x, ((Vec3)localObject2).y);
      localVec21.x -= ((Vec2)localObject1).x * f7;
      localVec21.y -= f7 * ((Vec2)localObject1).y;
      f2 -= f8 * (Vec2.cross(this.m_rA, (Vec2)localObject1) + ((Vec3)localObject2).z);
      localVec22.x += ((Vec2)localObject1).x * f5;
      localVec22.y += f5 * ((Vec2)localObject1).y;
      f3 = f1 + f6 * (Vec2.cross(this.m_rB, (Vec2)localObject1) + ((Vec3)localObject2).z);
      this.pool.pushVec2(2);
      this.pool.pushVec3(2);
      f1 = f2;
      f2 = f3;
    }
    else
    {
      localObject3 = this.pool.popVec2();
      localObject2 = this.pool.popVec2();
      Vec2.crossToOutUnsafe(f2, this.m_rA, (Vec2)localObject1);
      Vec2.crossToOutUnsafe(f1, this.m_rB, (Vec2)localObject3);
      ((Vec2)localObject3).addLocal(localVec22).subLocal(localVec21).subLocal((Vec2)localObject1);
      this.m_mass.solve22ToOut(((Vec2)localObject3).negateLocal(), (Vec2)localObject2);
      localObject1 = this.m_impulse;
      ((Vec3)localObject1).x += ((Vec2)localObject2).x;
      localObject1 = this.m_impulse;
      ((Vec3)localObject1).y += ((Vec2)localObject2).y;
      localVec21.x -= ((Vec2)localObject2).x * f7;
      localVec21.y -= f7 * ((Vec2)localObject2).y;
      f3 = f2 - f8 * Vec2.cross(this.m_rA, (Vec2)localObject2);
      localVec22.x += ((Vec2)localObject2).x * f5;
      localVec22.y += f5 * ((Vec2)localObject2).y;
      f2 = f1 + f6 * Vec2.cross(this.m_rB, (Vec2)localObject2);
      this.pool.pushVec2(2);
      f1 = f3;
    }
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
    this.pool.pushVec2(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.RevoluteJoint
 * JD-Core Version:    0.7.0.1
 */