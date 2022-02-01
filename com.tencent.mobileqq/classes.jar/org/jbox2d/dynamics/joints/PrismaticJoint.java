package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat22;
import org.jbox2d.common.Mat33;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

public class PrismaticJoint
  extends Joint
{
  private final Mat33 m_K;
  private float m_a1;
  private float m_a2;
  private final Vec2 m_axis;
  private boolean m_enableLimit;
  private boolean m_enableMotor;
  private final Vec3 m_impulse;
  private int m_indexA;
  private int m_indexB;
  private float m_invIA;
  private float m_invIB;
  private float m_invMassA;
  private float m_invMassB;
  private LimitState m_limitState;
  protected final Vec2 m_localAnchorA;
  protected final Vec2 m_localAnchorB;
  private final Vec2 m_localCenterA = new Vec2();
  private final Vec2 m_localCenterB = new Vec2();
  protected final Vec2 m_localXAxisA;
  protected final Vec2 m_localYAxisA;
  private float m_lowerTranslation;
  private float m_maxMotorForce;
  private float m_motorImpulse;
  private float m_motorMass;
  private float m_motorSpeed;
  private final Vec2 m_perp;
  protected float m_referenceAngle;
  private float m_s1;
  private float m_s2;
  private float m_upperTranslation;
  
  protected PrismaticJoint(IWorldPool paramIWorldPool, PrismaticJointDef paramPrismaticJointDef)
  {
    super(paramIWorldPool, paramPrismaticJointDef);
    this.m_localAnchorA = new Vec2(paramPrismaticJointDef.localAnchorA);
    this.m_localAnchorB = new Vec2(paramPrismaticJointDef.localAnchorB);
    this.m_localXAxisA = new Vec2(paramPrismaticJointDef.localAxisA);
    this.m_localXAxisA.normalize();
    this.m_localYAxisA = new Vec2();
    Vec2.crossToOutUnsafe(1.0F, this.m_localXAxisA, this.m_localYAxisA);
    this.m_referenceAngle = paramPrismaticJointDef.referenceAngle;
    this.m_impulse = new Vec3();
    this.m_motorMass = 0.0F;
    this.m_motorImpulse = 0.0F;
    this.m_lowerTranslation = paramPrismaticJointDef.lowerTranslation;
    this.m_upperTranslation = paramPrismaticJointDef.upperTranslation;
    this.m_maxMotorForce = paramPrismaticJointDef.maxMotorForce;
    this.m_motorSpeed = paramPrismaticJointDef.motorSpeed;
    this.m_enableLimit = paramPrismaticJointDef.enableLimit;
    this.m_enableMotor = paramPrismaticJointDef.enableMotor;
    this.m_limitState = LimitState.INACTIVE;
    this.m_K = new Mat33();
    this.m_axis = new Vec2();
    this.m_perp = new Vec2();
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
  
  public float getJointSpeed()
  {
    Body localBody1 = this.m_bodyA;
    Body localBody2 = this.m_bodyB;
    Vec2 localVec21 = this.pool.popVec2();
    Vec2 localVec22 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec28 = this.pool.popVec2();
    Vec2 localVec29 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec26 = this.pool.popVec2();
    Vec2 localVec27 = this.pool.popVec2();
    localVec21.set(this.m_localAnchorA).subLocal(localBody1.m_sweep.localCenter);
    Rot.mulToOutUnsafe(localBody1.m_xf.q, localVec21, localVec22);
    localVec21.set(this.m_localAnchorB).subLocal(localBody2.m_sweep.localCenter);
    Rot.mulToOutUnsafe(localBody2.m_xf.q, localVec21, localVec23);
    localVec28.set(localBody1.m_sweep.c).addLocal(localVec22);
    localVec29.set(localBody2.m_sweep.c).addLocal(localVec23);
    localVec24.set(localVec29).subLocal(localVec28);
    Rot.mulToOutUnsafe(localBody1.m_xf.q, this.m_localXAxisA, localVec25);
    localVec28 = localBody1.m_linearVelocity;
    localVec29 = localBody2.m_linearVelocity;
    float f1 = localBody1.m_angularVelocity;
    float f2 = localBody2.m_angularVelocity;
    Vec2.crossToOutUnsafe(f1, localVec25, localVec21);
    Vec2.crossToOutUnsafe(f2, localVec23, localVec26);
    Vec2.crossToOutUnsafe(f1, localVec22, localVec27);
    localVec26.addLocal(localVec29).subLocal(localVec28).subLocal(localVec27);
    f1 = Vec2.dot(localVec24, localVec21);
    f2 = Vec2.dot(localVec25, localVec26);
    this.pool.pushVec2(9);
    return f1 + f2;
  }
  
  public float getJointTranslation()
  {
    Vec2 localVec21 = this.pool.popVec2();
    Vec2 localVec22 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, localVec21);
    this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, localVec22);
    this.m_bodyA.getWorldVectorToOutUnsafe(this.m_localXAxisA, localVec23);
    localVec22.subLocal(localVec21);
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
  
  public float getLowerLimit()
  {
    return this.m_lowerTranslation;
  }
  
  public float getMaxMotorForce()
  {
    return this.m_maxMotorForce;
  }
  
  public float getMotorForce(float paramFloat)
  {
    return this.m_motorImpulse * paramFloat;
  }
  
  public float getMotorSpeed()
  {
    return this.m_motorSpeed;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2)
  {
    Vec2 localVec2 = this.pool.popVec2();
    localVec2.set(this.m_axis).mulLocal(this.m_motorImpulse + this.m_impulse.z);
    paramVec2.set(this.m_perp).mulLocal(this.m_impulse.x).addLocal(localVec2).mulLocal(paramFloat);
    this.pool.pushVec2(1);
  }
  
  public float getReactionTorque(float paramFloat)
  {
    return paramFloat * this.m_impulse.y;
  }
  
  public float getReferenceAngle()
  {
    return this.m_referenceAngle;
  }
  
  public float getUpperLimit()
  {
    return this.m_upperTranslation;
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
    Vec2 localVec24 = paramSolverData.positions[this.m_indexA].c;
    float f1 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f2 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec25 = paramSolverData.positions[this.m_indexB].c;
    float f4 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f3 = paramSolverData.velocities[this.m_indexB].w;
    Rot localRot1 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    Vec2 localVec26 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec27 = this.pool.popVec2();
    Vec2 localVec28 = this.pool.popVec2();
    localRot1.set(f1);
    localRot2.set(f4);
    Rot.mulToOutUnsafe(localRot1, localVec26.set(this.m_localAnchorA).subLocal(this.m_localCenterA), localVec27);
    Rot.mulToOutUnsafe(localRot2, localVec26.set(this.m_localAnchorB).subLocal(this.m_localCenterB), localVec28);
    localVec26.set(localVec25).subLocal(localVec24).addLocal(localVec28).subLocal(localVec27);
    float f7 = this.m_invMassA;
    float f5 = this.m_invMassB;
    float f8 = this.m_invIA;
    float f6 = this.m_invIB;
    Rot.mulToOutUnsafe(localRot1, this.m_localXAxisA, this.m_axis);
    localVec23.set(localVec26).addLocal(localVec27);
    this.m_a1 = Vec2.cross(localVec23, this.m_axis);
    this.m_a2 = Vec2.cross(localVec28, this.m_axis);
    float f9 = f7 + f5;
    f1 = this.m_a1;
    f4 = this.m_a2;
    this.m_motorMass = (f9 + f8 * f1 * f1 + f6 * f4 * f4);
    f1 = this.m_motorMass;
    if (f1 > 0.0F) {
      this.m_motorMass = (1.0F / f1);
    }
    Rot.mulToOutUnsafe(localRot1, this.m_localYAxisA, this.m_perp);
    localVec23.set(localVec26).addLocal(localVec27);
    this.m_s1 = Vec2.cross(localVec23, this.m_perp);
    this.m_s2 = Vec2.cross(localVec28, this.m_perp);
    float f10 = this.m_s1;
    float f11 = this.m_s2;
    float f12 = f8 * f10 + f6 * f11;
    float f13 = f10 * f8 * this.m_a1 + f11 * f6 * this.m_a2;
    f4 = f8 + f6;
    f1 = f4;
    if (f4 == 0.0F) {
      f1 = 1.0F;
    }
    f4 = this.m_a1;
    float f14 = this.m_a2;
    float f15 = f8 * f4 + f6 * f14;
    this.m_K.ex.set(f8 * f10 * f10 + f9 + f6 * f11 * f11, f12, f13);
    this.m_K.ey.set(f12, f1, f15);
    this.m_K.ez.set(f13, f15, f9 + f8 * f4 * f4 + f6 * f14 * f14);
    if (this.m_enableLimit)
    {
      f1 = Vec2.dot(this.m_axis, localVec26);
      if (MathUtils.abs(this.m_upperTranslation - this.m_lowerTranslation) < 0.01F) {
        this.m_limitState = LimitState.EQUAL;
      }
      do
      {
        do
        {
          break label879;
          if (f1 > this.m_lowerTranslation) {
            break;
          }
        } while (this.m_limitState == LimitState.AT_LOWER);
        this.m_limitState = LimitState.AT_LOWER;
        this.m_impulse.z = 0.0F;
        break label879;
        if (f1 < this.m_upperTranslation) {
          break;
        }
      } while (this.m_limitState == LimitState.AT_UPPER);
      this.m_limitState = LimitState.AT_UPPER;
      this.m_impulse.z = 0.0F;
      break label879;
      this.m_limitState = LimitState.INACTIVE;
      this.m_impulse.z = 0.0F;
    }
    else
    {
      this.m_limitState = LimitState.INACTIVE;
      this.m_impulse.z = 0.0F;
    }
    label879:
    if (!this.m_enableMotor) {
      this.m_motorImpulse = 0.0F;
    }
    if (paramSolverData.step.warmStarting)
    {
      this.m_impulse.mulLocal(paramSolverData.step.dtRatio);
      this.m_motorImpulse *= paramSolverData.step.dtRatio;
      localVec24 = this.pool.popVec2();
      localVec23.set(this.m_axis).mulLocal(this.m_motorImpulse + this.m_impulse.z);
      localVec24.set(this.m_perp).mulLocal(this.m_impulse.x).addLocal(localVec23);
      f13 = this.m_impulse.x;
      f14 = this.m_s1;
      f15 = this.m_impulse.y;
      float f16 = this.m_motorImpulse;
      float f17 = this.m_impulse.z;
      float f18 = this.m_a1;
      f1 = this.m_impulse.x;
      f4 = this.m_s2;
      f9 = this.m_impulse.y;
      f10 = this.m_motorImpulse;
      f11 = this.m_impulse.z;
      f12 = this.m_a2;
      localVec21.x -= localVec24.x * f7;
      localVec21.y -= f7 * localVec24.y;
      f2 -= f8 * (f13 * f14 + f15 + (f16 + f17) * f18);
      localVec22.x += localVec24.x * f5;
      localVec22.y += localVec24.y * f5;
      f1 = f3 + f6 * (f1 * f4 + f9 + (f10 + f11) * f12);
      this.pool.pushVec2(1);
    }
    else
    {
      this.m_impulse.setZero();
      this.m_motorImpulse = 0.0F;
      f1 = f3;
    }
    paramSolverData.velocities[this.m_indexA].w = f2;
    paramSolverData.velocities[this.m_indexB].w = f1;
    this.pool.pushRot(2);
    this.pool.pushVec2(4);
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
    if ((paramFloat1 != this.m_lowerTranslation) || (paramFloat2 != this.m_upperTranslation))
    {
      this.m_bodyA.setAwake(true);
      this.m_bodyB.setAwake(true);
      this.m_lowerTranslation = paramFloat1;
      this.m_upperTranslation = paramFloat2;
      this.m_impulse.z = 0.0F;
    }
  }
  
  public void setMaxMotorForce(float paramFloat)
  {
    this.m_bodyA.setAwake(true);
    this.m_bodyB.setAwake(true);
    this.m_maxMotorForce = paramFloat;
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
    Object localObject3 = this.pool.popRot();
    Vec2 localVec26 = this.pool.popVec2();
    Vec2 localVec27 = this.pool.popVec2();
    Vec2 localVec28 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Vec2 localVec24 = this.pool.popVec2();
    Object localObject2 = this.pool.popVec2();
    Vec2 localVec25 = this.pool.popVec2();
    Vec3 localVec3 = this.pool.popVec3();
    Vec2 localVec21 = paramSolverData.positions[this.m_indexA].c;
    float f4 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec22 = paramSolverData.positions[this.m_indexB].c;
    float f5 = paramSolverData.positions[this.m_indexB].a;
    ((Rot)localObject1).set(f4);
    ((Rot)localObject3).set(f5);
    float f6 = this.m_invMassA;
    float f7 = this.m_invMassB;
    float f8 = this.m_invIA;
    float f9 = this.m_invIB;
    Rot.mulToOutUnsafe((Rot)localObject1, ((Vec2)localObject2).set(this.m_localAnchorA).subLocal(this.m_localCenterA), localVec26);
    Rot.mulToOutUnsafe((Rot)localObject3, ((Vec2)localObject2).set(this.m_localAnchorB).subLocal(this.m_localCenterB), localVec27);
    localVec28.set(localVec22).addLocal(localVec27).subLocal(localVec21).subLocal(localVec26);
    Rot.mulToOutUnsafe((Rot)localObject1, this.m_localXAxisA, localVec23);
    float f10 = Vec2.cross(((Vec2)localObject2).set(localVec28).addLocal(localVec26), localVec23);
    float f11 = Vec2.cross(localVec27, localVec23);
    Rot.mulToOutUnsafe((Rot)localObject1, this.m_localYAxisA, localVec24);
    float f12 = Vec2.cross(((Vec2)localObject2).set(localVec28).addLocal(localVec26), localVec24);
    float f13 = Vec2.cross(localVec27, localVec24);
    localVec25.x = Vec2.dot(localVec24, localVec28);
    localVec25.y = (f5 - f4 - this.m_referenceAngle);
    float f1 = MathUtils.abs(localVec25.x);
    float f14 = MathUtils.abs(localVec25.y);
    boolean bool1 = this.m_enableLimit;
    boolean bool2 = false;
    if (bool1)
    {
      f15 = Vec2.dot(localVec23, localVec28);
      if (MathUtils.abs(this.m_upperTranslation - this.m_lowerTranslation) < 0.01F)
      {
        f3 = MathUtils.clamp(f15, -0.2F, 0.2F);
        f2 = MathUtils.max(f1, MathUtils.abs(f15));
        f1 = f3;
      }
      for (;;)
      {
        f3 = f2;
        i = 1;
        f2 = f1;
        f1 = f3;
        break label584;
        f2 = this.m_lowerTranslation;
        if (f15 <= f2)
        {
          f2 = MathUtils.clamp(f15 - f2 + 0.005F, -0.2F, 0.0F);
          f3 = MathUtils.max(f1, this.m_lowerTranslation - f15);
          f1 = f2;
          f2 = f3;
        }
        else
        {
          f2 = this.m_upperTranslation;
          if (f15 < f2) {
            break;
          }
          f2 = MathUtils.clamp(f15 - f2 - 0.005F, 0.0F, 0.2F);
          f3 = MathUtils.max(f1, f15 - this.m_upperTranslation);
          f1 = f2;
          f2 = f3;
        }
      }
    }
    int i = 0;
    float f2 = 0.0F;
    label584:
    if (i != 0)
    {
      f15 = f6 + f7;
      f16 = f8 * f12;
      f17 = f9 * f13;
      f18 = f16 + f17;
      f19 = f16 * f10 + f17 * f11;
      f3 = f8 + f9;
      if (f3 == 0.0F) {
        f3 = 1.0F;
      }
      f20 = f8 * f10;
      float f21 = f9 * f11;
      float f22 = f20 + f21;
      localObject1 = this.pool.popMat33();
      ((Mat33)localObject1).ex.set(f16 * f12 + f15 + f17 * f13, f18, f19);
      ((Mat33)localObject1).ey.set(f18, f3, f22);
      ((Mat33)localObject1).ez.set(f19, f22, f15 + f20 * f10 + f21 * f11);
      localObject2 = this.pool.popVec3();
      ((Vec3)localObject2).x = localVec25.x;
      ((Vec3)localObject2).y = localVec25.y;
      ((Vec3)localObject2).z = f2;
      ((Mat33)localObject1).solve33ToOut(((Vec3)localObject2).negateLocal(), localVec3);
      this.pool.pushVec3(1);
      this.pool.pushMat33(1);
    }
    else
    {
      localObject1 = localVec3;
      f15 = f8 * f12;
      f16 = f9 * f13;
      f17 = f15 + f16;
      f3 = f8 + f9;
      f2 = f3;
      if (f3 == 0.0F) {
        f2 = 1.0F;
      }
      localObject3 = this.pool.popMat22();
      ((Mat22)localObject3).ex.set(f6 + f7 + f15 * f12 + f16 * f13, f17);
      ((Mat22)localObject3).ey.set(f17, f2);
      ((Mat22)localObject3).solveToOut(localVec25.negateLocal(), (Vec2)localObject2);
      localVec25.negateLocal();
      ((Vec3)localObject1).x = ((Vec2)localObject2).x;
      ((Vec3)localObject1).y = ((Vec2)localObject2).y;
      ((Vec3)localObject1).z = 0.0F;
      this.pool.pushMat22(1);
    }
    f2 = localVec3.x * localVec24.x + localVec3.z * localVec23.x;
    float f3 = localVec3.x * localVec24.y + localVec3.z * localVec23.y;
    float f15 = localVec3.x;
    float f16 = localVec3.y;
    float f17 = localVec3.z;
    float f18 = localVec3.x;
    float f19 = localVec3.y;
    float f20 = localVec3.z;
    localVec21.x -= f6 * f2;
    localVec21.y -= f6 * f3;
    localVec22.x += f7 * f2;
    localVec22.y += f7 * f3;
    paramSolverData.positions[this.m_indexA].a = (f4 - f8 * (f15 * f12 + f16 + f17 * f10));
    paramSolverData.positions[this.m_indexB].a = (f5 + f9 * (f18 * f13 + f19 + f20 * f11));
    this.pool.pushVec2(7);
    this.pool.pushVec3(1);
    this.pool.pushRot(2);
    bool1 = bool2;
    if (f1 <= 0.005F)
    {
      bool1 = bool2;
      if (f14 <= 0.03490659F) {
        bool1 = true;
      }
    }
    return bool1;
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
    Vec2 localVec23 = this.pool.popVec2();
    float f2 = f4;
    float f1 = f3;
    float f9;
    float f10;
    float f11;
    float f12;
    float f13;
    if (this.m_enableMotor)
    {
      f2 = f4;
      f1 = f3;
      if (this.m_limitState != LimitState.EQUAL)
      {
        localVec23.set(localVec22).subLocal(localVec21);
        f1 = Vec2.dot(this.m_axis, localVec23);
        f2 = this.m_a2;
        f9 = this.m_a1;
        f10 = this.m_motorMass;
        f11 = this.m_motorSpeed;
        f12 = this.m_motorImpulse;
        f13 = paramSolverData.step.dt * this.m_maxMotorForce;
        this.m_motorImpulse = MathUtils.clamp(this.m_motorImpulse + f10 * (f11 - (f1 + f2 * f3 - f9 * f4)), -f13, f13);
        f1 = this.m_motorImpulse - f12;
        localObject1 = this.pool.popVec2();
        ((Vec2)localObject1).set(this.m_axis).mulLocal(f1);
        f2 = this.m_a1;
        f9 = this.m_a2;
        localVec21.x -= ((Vec2)localObject1).x * f7;
        localVec21.y -= ((Vec2)localObject1).y * f7;
        f2 = f4 - f2 * f1 * f8;
        localVec22.x += ((Vec2)localObject1).x * f5;
        localVec22.y += ((Vec2)localObject1).y * f5;
        f1 = f3 + f1 * f9 * f6;
        this.pool.pushVec2(1);
      }
    }
    Object localObject1 = this.pool.popVec2();
    localVec23.set(localVec22).subLocal(localVec21);
    ((Vec2)localObject1).x = (Vec2.dot(this.m_perp, localVec23) + this.m_s2 * f1 - this.m_s1 * f2);
    ((Vec2)localObject1).y = (f1 - f2);
    if ((this.m_enableLimit) && (this.m_limitState != LimitState.INACTIVE))
    {
      localVec23.set(localVec22).subLocal(localVec21);
      f3 = Vec2.dot(this.m_axis, localVec23);
      f4 = this.m_a2;
      f9 = this.m_a1;
      Object localObject2 = this.pool.popVec3();
      ((Vec3)localObject2).set(((Vec2)localObject1).x, ((Vec2)localObject1).y, f3 + f4 * f1 - f9 * f2);
      Vec3 localVec32 = this.pool.popVec3();
      Vec3 localVec31 = this.pool.popVec3();
      localVec32.set(this.m_impulse);
      this.m_K.solve33ToOut(((Vec3)localObject2).negateLocal(), localVec31);
      this.m_impulse.addLocal(localVec31);
      if (this.m_limitState == LimitState.AT_LOWER)
      {
        localObject2 = this.m_impulse;
        ((Vec3)localObject2).z = MathUtils.max(((Vec3)localObject2).z, 0.0F);
      }
      else if (this.m_limitState == LimitState.AT_UPPER)
      {
        localObject2 = this.m_impulse;
        ((Vec3)localObject2).z = MathUtils.min(((Vec3)localObject2).z, 0.0F);
      }
      localObject2 = this.pool.popVec2();
      Vec2 localVec24 = this.pool.popVec2();
      localVec23.set(this.m_K.ez.x, this.m_K.ez.y).mulLocal(this.m_impulse.z - localVec32.z);
      ((Vec2)localObject2).set((Vec2)localObject1).negateLocal().subLocal(localVec23);
      this.m_K.solve22ToOut((Vec2)localObject2, localVec24);
      localVec24.addLocal(localVec32.x, localVec32.y);
      this.m_impulse.x = localVec24.x;
      this.m_impulse.y = localVec24.y;
      localVec31.set(this.m_impulse).subLocal(localVec32);
      localObject1 = this.pool.popVec2();
      localVec23.set(this.m_axis).mulLocal(localVec31.z);
      ((Vec2)localObject1).set(this.m_perp).mulLocal(localVec31.x).addLocal(localVec23);
      f12 = localVec31.x;
      f13 = this.m_s1;
      float f14 = localVec31.y;
      float f15 = localVec31.z;
      float f16 = this.m_a1;
      f3 = localVec31.x;
      f4 = this.m_s2;
      f9 = localVec31.y;
      f10 = localVec31.z;
      f11 = this.m_a2;
      localVec21.x -= ((Vec2)localObject1).x * f7;
      localVec21.y -= f7 * ((Vec2)localObject1).y;
      f2 -= f8 * (f12 * f13 + f14 + f15 * f16);
      localVec22.x += ((Vec2)localObject1).x * f5;
      localVec22.y += f5 * ((Vec2)localObject1).y;
      f3 = f1 + (f3 * f4 + f9 + f10 * f11) * f6;
      this.pool.pushVec2(3);
      this.pool.pushVec3(3);
      f1 = f2;
      f2 = f3;
    }
    else
    {
      localVec23 = this.pool.popVec2();
      this.m_K.solve22ToOut(((Vec2)localObject1).negateLocal(), localVec23);
      ((Vec2)localObject1).negateLocal();
      localObject1 = this.m_impulse;
      ((Vec3)localObject1).x += localVec23.x;
      localObject1 = this.m_impulse;
      ((Vec3)localObject1).y += localVec23.y;
      localObject1 = this.pool.popVec2();
      ((Vec2)localObject1).set(this.m_perp).mulLocal(localVec23.x);
      f3 = localVec23.x;
      f11 = this.m_s1;
      f12 = localVec23.y;
      f4 = localVec23.x;
      f9 = this.m_s2;
      f10 = localVec23.y;
      localVec21.x -= ((Vec2)localObject1).x * f7;
      localVec21.y -= f7 * ((Vec2)localObject1).y;
      f3 = f2 - f8 * (f3 * f11 + f12);
      localVec22.x += ((Vec2)localObject1).x * f5;
      localVec22.y += f5 * ((Vec2)localObject1).y;
      f2 = f1 + f6 * (f4 * f9 + f10);
      this.pool.pushVec2(2);
      f1 = f3;
    }
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
    this.pool.pushVec2(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.PrismaticJoint
 * JD-Core Version:    0.7.0.1
 */