package org.jbox2d.dynamics.joints;

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

public class GearJoint
  extends Joint
{
  private final Vec2 m_JvAC = new Vec2();
  private final Vec2 m_JvBD = new Vec2();
  private float m_JwA;
  private float m_JwB;
  private float m_JwC;
  private float m_JwD;
  private final Body m_bodyC;
  private final Body m_bodyD;
  private float m_constant;
  private float m_iA;
  private float m_iB;
  private float m_iC;
  private float m_iD;
  private float m_impulse;
  private int m_indexA;
  private int m_indexB;
  private int m_indexC;
  private int m_indexD;
  private final Joint m_joint1;
  private final Joint m_joint2;
  private final Vec2 m_lcA = new Vec2();
  private final Vec2 m_lcB = new Vec2();
  private final Vec2 m_lcC = new Vec2();
  private final Vec2 m_lcD = new Vec2();
  private final Vec2 m_localAnchorA = new Vec2();
  private final Vec2 m_localAnchorB = new Vec2();
  private final Vec2 m_localAnchorC = new Vec2();
  private final Vec2 m_localAnchorD = new Vec2();
  private final Vec2 m_localAxisC = new Vec2();
  private final Vec2 m_localAxisD = new Vec2();
  private float m_mA;
  private float m_mB;
  private float m_mC;
  private float m_mD;
  private float m_mass;
  private float m_ratio;
  private float m_referenceAngleA;
  private float m_referenceAngleB;
  private final JointType m_typeA;
  private final JointType m_typeB;
  
  protected GearJoint(IWorldPool paramIWorldPool, GearJointDef paramGearJointDef)
  {
    super(paramIWorldPool, paramGearJointDef);
    this.m_joint1 = paramGearJointDef.joint1;
    this.m_joint2 = paramGearJointDef.joint2;
    this.m_typeA = this.m_joint1.getType();
    this.m_typeB = this.m_joint2.getType();
    this.m_bodyC = this.m_joint1.getBodyA();
    this.m_bodyA = this.m_joint1.getBodyB();
    paramIWorldPool = this.m_bodyA.m_xf;
    float f1 = this.m_bodyA.m_sweep.a;
    Transform localTransform = this.m_bodyC.m_xf;
    float f2 = this.m_bodyC.m_sweep.a;
    Vec2 localVec21;
    Vec2 localVec22;
    Object localObject;
    if (this.m_typeA == JointType.REVOLUTE)
    {
      paramIWorldPool = (RevoluteJoint)paramGearJointDef.joint1;
      this.m_localAnchorC.set(paramIWorldPool.m_localAnchorA);
      this.m_localAnchorA.set(paramIWorldPool.m_localAnchorB);
      this.m_referenceAngleA = paramIWorldPool.m_referenceAngle;
      this.m_localAxisC.setZero();
      f1 = f1 - f2 - this.m_referenceAngleA;
    }
    else
    {
      localVec21 = this.pool.popVec2();
      localVec22 = this.pool.popVec2();
      localObject = (PrismaticJoint)paramGearJointDef.joint1;
      this.m_localAnchorC.set(((PrismaticJoint)localObject).m_localAnchorA);
      this.m_localAnchorA.set(((PrismaticJoint)localObject).m_localAnchorB);
      this.m_referenceAngleA = ((PrismaticJoint)localObject).m_referenceAngle;
      this.m_localAxisC.set(((PrismaticJoint)localObject).m_localXAxisA);
      localObject = this.m_localAnchorC;
      Rot.mulToOutUnsafe(paramIWorldPool.q, this.m_localAnchorA, localVec22);
      localVec22.addLocal(paramIWorldPool.p).subLocal(localTransform.p);
      Rot.mulTransUnsafe(localTransform.q, localVec22, localVec21);
      f1 = Vec2.dot(localVec21.subLocal((Vec2)localObject), this.m_localAxisC);
      this.pool.pushVec2(2);
    }
    this.m_bodyD = this.m_joint2.getBodyA();
    this.m_bodyB = this.m_joint2.getBodyB();
    paramIWorldPool = this.m_bodyB.m_xf;
    f2 = this.m_bodyB.m_sweep.a;
    localTransform = this.m_bodyD.m_xf;
    float f3 = this.m_bodyD.m_sweep.a;
    if (this.m_typeB == JointType.REVOLUTE)
    {
      paramIWorldPool = (RevoluteJoint)paramGearJointDef.joint2;
      this.m_localAnchorD.set(paramIWorldPool.m_localAnchorA);
      this.m_localAnchorB.set(paramIWorldPool.m_localAnchorB);
      this.m_referenceAngleB = paramIWorldPool.m_referenceAngle;
      this.m_localAxisD.setZero();
      f2 = f2 - f3 - this.m_referenceAngleB;
    }
    else
    {
      localVec21 = this.pool.popVec2();
      localVec22 = this.pool.popVec2();
      localObject = (PrismaticJoint)paramGearJointDef.joint2;
      this.m_localAnchorD.set(((PrismaticJoint)localObject).m_localAnchorA);
      this.m_localAnchorB.set(((PrismaticJoint)localObject).m_localAnchorB);
      this.m_referenceAngleB = ((PrismaticJoint)localObject).m_referenceAngle;
      this.m_localAxisD.set(((PrismaticJoint)localObject).m_localXAxisA);
      localObject = this.m_localAnchorD;
      Rot.mulToOutUnsafe(paramIWorldPool.q, this.m_localAnchorB, localVec22);
      localVec22.addLocal(paramIWorldPool.p).subLocal(localTransform.p);
      Rot.mulTransUnsafe(localTransform.q, localVec22, localVec21);
      f2 = Vec2.dot(localVec21.subLocal((Vec2)localObject), this.m_localAxisD);
      this.pool.pushVec2(2);
    }
    this.m_ratio = paramGearJointDef.ratio;
    this.m_constant = (f1 + this.m_ratio * f2);
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
  
  public Joint getJoint1()
  {
    return this.m_joint1;
  }
  
  public Joint getJoint2()
  {
    return this.m_joint2;
  }
  
  public float getRatio()
  {
    return this.m_ratio;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2)
  {
    paramVec2.set(this.m_JvAC).mulLocal(this.m_impulse);
    paramVec2.mulLocal(paramFloat);
  }
  
  public float getReactionTorque(float paramFloat)
  {
    return paramFloat * (this.m_impulse * this.m_JwA);
  }
  
  public void initVelocityConstraints(SolverData paramSolverData)
  {
    this.m_indexA = this.m_bodyA.m_islandIndex;
    this.m_indexB = this.m_bodyB.m_islandIndex;
    this.m_indexC = this.m_bodyC.m_islandIndex;
    this.m_indexD = this.m_bodyD.m_islandIndex;
    this.m_lcA.set(this.m_bodyA.m_sweep.localCenter);
    this.m_lcB.set(this.m_bodyB.m_sweep.localCenter);
    this.m_lcC.set(this.m_bodyC.m_sweep.localCenter);
    this.m_lcD.set(this.m_bodyD.m_sweep.localCenter);
    this.m_mA = this.m_bodyA.m_invMass;
    this.m_mB = this.m_bodyB.m_invMass;
    this.m_mC = this.m_bodyC.m_invMass;
    this.m_mD = this.m_bodyD.m_invMass;
    this.m_iA = this.m_bodyA.m_invI;
    this.m_iB = this.m_bodyB.m_invI;
    this.m_iC = this.m_bodyC.m_invI;
    this.m_iD = this.m_bodyD.m_invI;
    float f2 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f5 = paramSolverData.velocities[this.m_indexA].w;
    float f3 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f6 = paramSolverData.velocities[this.m_indexB].w;
    float f7 = paramSolverData.positions[this.m_indexC].a;
    Vec2 localVec23 = paramSolverData.velocities[this.m_indexC].v;
    float f1 = paramSolverData.velocities[this.m_indexC].w;
    float f8 = paramSolverData.positions[this.m_indexD].a;
    Vec2 localVec24 = paramSolverData.velocities[this.m_indexD].v;
    float f4 = paramSolverData.velocities[this.m_indexD].w;
    Object localObject1 = this.pool.popRot();
    Rot localRot1 = this.pool.popRot();
    Object localObject2 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    ((Rot)localObject1).set(f2);
    localRot1.set(f3);
    ((Rot)localObject2).set(f7);
    localRot2.set(f8);
    this.m_mass = 0.0F;
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec26;
    float f9;
    float f10;
    float f11;
    if (this.m_typeA == JointType.REVOLUTE)
    {
      this.m_JvAC.setZero();
      this.m_JwA = 1.0F;
      this.m_JwC = 1.0F;
      this.m_mass += this.m_iA + this.m_iC;
    }
    else
    {
      localVec26 = this.pool.popVec2();
      Vec2 localVec27 = this.pool.popVec2();
      Rot.mulToOutUnsafe((Rot)localObject2, this.m_localAxisC, this.m_JvAC);
      Rot.mulToOutUnsafe((Rot)localObject2, localVec25.set(this.m_localAnchorC).subLocal(this.m_lcC), localVec26);
      Rot.mulToOutUnsafe((Rot)localObject1, localVec25.set(this.m_localAnchorA).subLocal(this.m_lcA), localVec27);
      this.m_JwC = Vec2.cross(localVec26, this.m_JvAC);
      this.m_JwA = Vec2.cross(localVec27, this.m_JvAC);
      f2 = this.m_mass;
      f3 = this.m_mC;
      f7 = this.m_mA;
      f8 = this.m_iC;
      f9 = this.m_JwC;
      f10 = this.m_iA;
      f11 = this.m_JwA;
      this.m_mass = (f2 + (f3 + f7 + f8 * f9 * f9 + f10 * f11 * f11));
      this.pool.pushVec2(2);
    }
    if (this.m_typeB == JointType.REVOLUTE)
    {
      this.m_JvBD.setZero();
      f2 = this.m_ratio;
      this.m_JwB = f2;
      this.m_JwD = f2;
      this.m_mass += f2 * f2 * (this.m_iB + this.m_iD);
    }
    else
    {
      localObject1 = this.pool.popVec2();
      localObject2 = this.pool.popVec2();
      localVec26 = this.pool.popVec2();
      Rot.mulToOutUnsafe(localRot2, this.m_localAxisD, (Vec2)localObject1);
      Rot.mulToOutUnsafe(localRot2, localVec25.set(this.m_localAnchorD).subLocal(this.m_lcD), (Vec2)localObject2);
      Rot.mulToOutUnsafe(localRot1, localVec25.set(this.m_localAnchorB).subLocal(this.m_lcB), localVec26);
      this.m_JvBD.set((Vec2)localObject1).mulLocal(this.m_ratio);
      this.m_JwD = (this.m_ratio * Vec2.cross((Vec2)localObject2, (Vec2)localObject1));
      this.m_JwB = (this.m_ratio * Vec2.cross(localVec26, (Vec2)localObject1));
      f2 = this.m_mass;
      f3 = this.m_ratio;
      f7 = this.m_mD;
      f8 = this.m_mB;
      f9 = this.m_iD;
      f10 = this.m_JwD;
      f11 = this.m_iB;
      float f12 = this.m_JwB;
      this.m_mass = (f2 + (f3 * f3 * (f7 + f8) + f9 * f10 * f10 + f11 * f12 * f12));
      this.pool.pushVec2(3);
    }
    f2 = this.m_mass;
    if (f2 > 0.0F) {
      f2 = 1.0F / f2;
    } else {
      f2 = 0.0F;
    }
    this.m_mass = f2;
    if (paramSolverData.step.warmStarting)
    {
      localVec21.x += this.m_mA * this.m_impulse * this.m_JvAC.x;
      localVec21.y += this.m_mA * this.m_impulse * this.m_JvAC.y;
      f2 = f5 + this.m_iA * this.m_impulse * this.m_JwA;
      localVec22.x += this.m_mB * this.m_impulse * this.m_JvBD.x;
      localVec22.y += this.m_mB * this.m_impulse * this.m_JvBD.y;
      f3 = f6 + this.m_iB * this.m_impulse * this.m_JwB;
      localVec23.x -= this.m_mC * this.m_impulse * this.m_JvAC.x;
      localVec23.y -= this.m_mC * this.m_impulse * this.m_JvAC.y;
      f5 = f1 - this.m_iC * this.m_impulse * this.m_JwC;
      localVec24.x -= this.m_mD * this.m_impulse * this.m_JvBD.x;
      localVec24.y -= this.m_mD * this.m_impulse * this.m_JvBD.y;
      f4 -= this.m_iD * this.m_impulse * this.m_JwD;
      f1 = f2;
      f2 = f3;
      f3 = f5;
    }
    else
    {
      this.m_impulse = 0.0F;
      f3 = f1;
      f2 = f6;
      f1 = f5;
    }
    this.pool.pushVec2(1);
    this.pool.pushRot(4);
    paramSolverData.velocities[this.m_indexA].w = f1;
    paramSolverData.velocities[this.m_indexB].w = f2;
    paramSolverData.velocities[this.m_indexC].w = f3;
    paramSolverData.velocities[this.m_indexD].w = f4;
  }
  
  public void setRatio(float paramFloat)
  {
    this.m_ratio = paramFloat;
  }
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    Vec2 localVec25 = paramSolverData.positions[this.m_indexA].c;
    float f10 = paramSolverData.positions[this.m_indexA].a;
    Vec2 localVec21 = paramSolverData.positions[this.m_indexB].c;
    float f11 = paramSolverData.positions[this.m_indexB].a;
    Vec2 localVec24 = paramSolverData.positions[this.m_indexC].c;
    float f12 = paramSolverData.positions[this.m_indexC].a;
    Vec2 localVec22 = paramSolverData.positions[this.m_indexD].c;
    float f13 = paramSolverData.positions[this.m_indexD].a;
    Object localObject2 = this.pool.popRot();
    Rot localRot2 = this.pool.popRot();
    Object localObject1 = this.pool.popRot();
    Rot localRot1 = this.pool.popRot();
    ((Rot)localObject2).set(f10);
    localRot2.set(f11);
    ((Rot)localObject1).set(f12);
    localRot1.set(f13);
    Vec2 localVec27 = this.pool.popVec2();
    Vec2 localVec26 = this.pool.popVec2();
    Vec2 localVec23 = this.pool.popVec2();
    Object localObject3 = this.m_typeA;
    Object localObject4 = JointType.REVOLUTE;
    float f8 = 0.0F;
    float f4;
    float f1;
    float f2;
    Vec2 localVec28;
    float f5;
    if (localObject3 == localObject4)
    {
      localVec26.setZero();
      f4 = this.m_iA + this.m_iC + 0.0F;
      f3 = f10 - f12 - this.m_referenceAngleA;
      f1 = 1.0F;
      f2 = 1.0F;
    }
    else
    {
      Vec2 localVec29 = this.pool.popVec2();
      localObject3 = this.pool.popVec2();
      localObject4 = this.pool.popVec2();
      localVec28 = this.pool.popVec2();
      Rot.mulToOutUnsafe((Rot)localObject1, this.m_localAxisC, localVec26);
      Rot.mulToOutUnsafe((Rot)localObject1, localVec27.set(this.m_localAnchorC).subLocal(this.m_lcC), localVec29);
      Rot.mulToOutUnsafe((Rot)localObject2, localVec27.set(this.m_localAnchorA).subLocal(this.m_lcA), (Vec2)localObject3);
      f4 = Vec2.cross(localVec29, localVec26);
      f5 = Vec2.cross((Vec2)localObject3, localVec26);
      f6 = this.m_mC;
      f7 = this.m_mA;
      f9 = this.m_iC;
      f14 = this.m_iA;
      localObject2 = ((Vec2)localObject4).set(this.m_localAnchorC);
      f2 = f4;
      ((Vec2)localObject2).subLocal(this.m_lcC);
      Rot.mulTransUnsafe((Rot)localObject1, localVec27.set((Vec2)localObject3).addLocal(localVec25).subLocal(localVec24), localVec28);
      f3 = Vec2.dot(localVec28.subLocal((Vec2)localObject4), this.m_localAxisC);
      this.pool.pushVec2(4);
      f1 = f5;
      f4 = f6 + f7 + f9 * f4 * f4 + f14 * f5 * f5 + 0.0F;
    }
    if (this.m_typeB == JointType.REVOLUTE)
    {
      localVec23.setZero();
      f5 = this.m_ratio;
      f7 = f4 + f5 * f5 * (this.m_iB + this.m_iD);
      f6 = this.m_referenceAngleB;
      f4 = f5;
      f6 = f11 - f13 - f6;
    }
    else
    {
      localObject1 = this.pool.popVec2();
      localObject2 = this.pool.popVec2();
      localObject3 = this.pool.popVec2();
      localObject4 = this.pool.popVec2();
      localVec28 = this.pool.popVec2();
      Rot.mulToOutUnsafe(localRot1, this.m_localAxisD, (Vec2)localObject1);
      Rot.mulToOutUnsafe(localRot1, localVec27.set(this.m_localAnchorD).subLocal(this.m_lcD), (Vec2)localObject2);
      Rot.mulToOutUnsafe(localRot2, localVec27.set(this.m_localAnchorB).subLocal(this.m_lcB), (Vec2)localObject3);
      localVec23.set((Vec2)localObject1).mulLocal(this.m_ratio);
      f6 = Vec2.cross((Vec2)localObject2, (Vec2)localObject1);
      f5 = Vec2.cross((Vec2)localObject3, (Vec2)localObject1);
      f7 = this.m_ratio;
      f7 = f4 + (f7 * f7 * (this.m_mD + this.m_mB) + this.m_iD * f6 * f6 + this.m_iB * f5 * f5);
      ((Vec2)localObject4).set(this.m_localAnchorD).subLocal(this.m_lcD);
      Rot.mulTransUnsafe(localRot1, localVec27.set((Vec2)localObject3).addLocal(localVec21).subLocal(localVec22), localVec28);
      f9 = Vec2.dot(localVec28.subLocal((Vec2)localObject4), this.m_localAxisD);
      this.pool.pushVec2(5);
      f4 = f6;
      f6 = f9;
    }
    float f9 = this.m_ratio;
    float f14 = this.m_constant;
    if (f7 > 0.0F) {
      f8 = -(f3 + f9 * f6 - f14) / f7;
    }
    this.pool.pushVec2(3);
    this.pool.pushRot(4);
    localVec25.x += this.m_mA * f8 * localVec26.x;
    localVec25.y += this.m_mA * f8 * localVec26.y;
    float f3 = this.m_iA;
    localVec21.x += this.m_mB * f8 * localVec23.x;
    localVec21.y += this.m_mB * f8 * localVec23.y;
    float f6 = this.m_iB;
    localVec24.x -= this.m_mC * f8 * localVec26.x;
    localVec24.y -= this.m_mC * f8 * localVec26.y;
    float f7 = this.m_iC;
    localVec22.x -= this.m_mD * f8 * localVec23.x;
    localVec22.y -= this.m_mD * f8 * localVec23.y;
    f9 = this.m_iD;
    paramSolverData.positions[this.m_indexA].a = (f10 + f3 * f8 * f1);
    paramSolverData.positions[this.m_indexB].a = (f11 + f6 * f8 * f5);
    paramSolverData.positions[this.m_indexC].a = (f12 - f7 * f8 * f2);
    paramSolverData.positions[this.m_indexD].a = (f13 - f9 * f8 * f4);
    return true;
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Vec2 localVec21 = paramSolverData.velocities[this.m_indexA].v;
    float f1 = paramSolverData.velocities[this.m_indexA].w;
    Vec2 localVec22 = paramSolverData.velocities[this.m_indexB].v;
    float f2 = paramSolverData.velocities[this.m_indexB].w;
    Vec2 localVec23 = paramSolverData.velocities[this.m_indexC].v;
    float f3 = paramSolverData.velocities[this.m_indexC].w;
    Vec2 localVec24 = paramSolverData.velocities[this.m_indexD].v;
    float f4 = paramSolverData.velocities[this.m_indexD].w;
    Vec2 localVec25 = this.pool.popVec2();
    Vec2 localVec26 = this.pool.popVec2();
    float f5 = Vec2.dot(this.m_JvAC, localVec25.set(localVec21).subLocal(localVec23));
    float f6 = Vec2.dot(this.m_JvBD, localVec26.set(localVec22).subLocal(localVec24));
    float f7 = this.m_JwA;
    float f8 = this.m_JwC;
    float f9 = this.m_JwB;
    float f10 = this.m_JwD;
    this.pool.pushVec2(2);
    f5 = -this.m_mass * (f5 + f6 + (f7 * f1 - f8 * f3 + (f9 * f2 - f10 * f4)));
    this.m_impulse += f5;
    localVec21.x += this.m_mA * f5 * this.m_JvAC.x;
    localVec21.y += this.m_mA * f5 * this.m_JvAC.y;
    f6 = this.m_iA;
    f7 = this.m_JwA;
    localVec22.x += this.m_mB * f5 * this.m_JvBD.x;
    localVec22.y += this.m_mB * f5 * this.m_JvBD.y;
    f8 = this.m_iB;
    f9 = this.m_JwB;
    localVec23.x -= this.m_mC * f5 * this.m_JvAC.x;
    localVec23.y -= this.m_mC * f5 * this.m_JvAC.y;
    f10 = this.m_iC;
    float f11 = this.m_JwC;
    localVec24.x -= this.m_mD * f5 * this.m_JvBD.x;
    localVec24.y -= this.m_mD * f5 * this.m_JvBD.y;
    float f12 = this.m_iD;
    float f13 = this.m_JwD;
    paramSolverData.velocities[this.m_indexA].w = (f1 + f6 * f5 * f7);
    paramSolverData.velocities[this.m_indexB].w = (f2 + f8 * f5 * f9);
    paramSolverData.velocities[this.m_indexC].w = (f3 - f10 * f5 * f11);
    paramSolverData.velocities[this.m_indexD].w = (f4 - f12 * f5 * f13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.GearJoint
 * JD-Core Version:    0.7.0.1
 */