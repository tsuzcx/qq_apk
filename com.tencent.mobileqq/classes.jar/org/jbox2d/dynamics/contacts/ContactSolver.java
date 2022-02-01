package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.ManifoldPoint;
import org.jbox2d.collision.WorldManifold;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Mat22;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.TimeStep;

public class ContactSolver
{
  public static final boolean DEBUG_SOLVER = false;
  public static final int INITIAL_NUM_CONSTRAINTS = 256;
  public static final float k_errorTol = 0.001F;
  public static final float k_maxConditionNumber = 100.0F;
  private final Vec2 P = new Vec2();
  private final Vec2 P1 = new Vec2();
  private final Vec2 P2 = new Vec2();
  private final Vec2 a = new Vec2();
  private final Vec2 b = new Vec2();
  private final Vec2 d = new Vec2();
  private final Vec2 dv1 = new Vec2();
  private final Vec2 dv2 = new Vec2();
  public Contact[] m_contacts;
  public int m_count;
  public ContactPositionConstraint[] m_positionConstraints = new ContactPositionConstraint[256];
  public Position[] m_positions;
  public TimeStep m_step;
  public Velocity[] m_velocities;
  public ContactVelocityConstraint[] m_velocityConstraints = new ContactVelocityConstraint[256];
  private final PositionSolverManifold psolver = new PositionSolverManifold();
  private final Vec2 rA = new Vec2();
  private final Vec2 rB = new Vec2();
  private final Vec2 tangent = new Vec2();
  private final Vec2 temp = new Vec2();
  private final Vec2 temp1 = new Vec2();
  private final Vec2 temp2 = new Vec2();
  private final WorldManifold worldManifold = new WorldManifold();
  private final Vec2 x = new Vec2();
  private final Transform xfA = new Transform();
  private final Transform xfB = new Transform();
  
  public ContactSolver()
  {
    int i = 0;
    while (i < 256)
    {
      this.m_positionConstraints[i] = new ContactPositionConstraint();
      this.m_velocityConstraints[i] = new ContactVelocityConstraint();
      i += 1;
    }
  }
  
  public final void init(ContactSolver.ContactSolverDef paramContactSolverDef)
  {
    this.m_step = paramContactSolverDef.step;
    this.m_count = paramContactSolverDef.count;
    Object localObject1 = this.m_positionConstraints;
    int i = localObject1.length;
    int j = this.m_count;
    if (i < j)
    {
      this.m_positionConstraints = new ContactPositionConstraint[MathUtils.max(localObject1.length * 2, j)];
      System.arraycopy(localObject1, 0, this.m_positionConstraints, 0, localObject1.length);
      i = localObject1.length;
      for (;;)
      {
        localObject1 = this.m_positionConstraints;
        if (i >= localObject1.length) {
          break;
        }
        localObject1[i] = new ContactPositionConstraint();
        i += 1;
      }
    }
    localObject1 = this.m_velocityConstraints;
    i = localObject1.length;
    j = this.m_count;
    if (i < j)
    {
      this.m_velocityConstraints = new ContactVelocityConstraint[MathUtils.max(localObject1.length * 2, j)];
      System.arraycopy(localObject1, 0, this.m_velocityConstraints, 0, localObject1.length);
      i = localObject1.length;
      for (;;)
      {
        localObject1 = this.m_velocityConstraints;
        if (i >= localObject1.length) {
          break;
        }
        localObject1[i] = new ContactVelocityConstraint();
        i += 1;
      }
    }
    this.m_positions = paramContactSolverDef.positions;
    this.m_velocities = paramContactSolverDef.velocities;
    this.m_contacts = paramContactSolverDef.contacts;
    i = 0;
    while (i < this.m_count)
    {
      paramContactSolverDef = this.m_contacts[i];
      Object localObject2 = paramContactSolverDef.m_fixtureA;
      localObject1 = paramContactSolverDef.m_fixtureB;
      Object localObject3 = ((Fixture)localObject2).getShape();
      Object localObject4 = ((Fixture)localObject1).getShape();
      float f1 = ((Shape)localObject3).m_radius;
      float f2 = ((Shape)localObject4).m_radius;
      localObject3 = ((Fixture)localObject2).getBody();
      localObject4 = ((Fixture)localObject1).getBody();
      localObject1 = paramContactSolverDef.getManifold();
      int k = ((Manifold)localObject1).pointCount;
      localObject2 = this.m_velocityConstraints[i];
      ((ContactVelocityConstraint)localObject2).friction = paramContactSolverDef.m_friction;
      ((ContactVelocityConstraint)localObject2).restitution = paramContactSolverDef.m_restitution;
      ((ContactVelocityConstraint)localObject2).tangentSpeed = paramContactSolverDef.m_tangentSpeed;
      ((ContactVelocityConstraint)localObject2).indexA = ((Body)localObject3).m_islandIndex;
      ((ContactVelocityConstraint)localObject2).indexB = ((Body)localObject4).m_islandIndex;
      ((ContactVelocityConstraint)localObject2).invMassA = ((Body)localObject3).m_invMass;
      ((ContactVelocityConstraint)localObject2).invMassB = ((Body)localObject4).m_invMass;
      ((ContactVelocityConstraint)localObject2).invIA = ((Body)localObject3).m_invI;
      ((ContactVelocityConstraint)localObject2).invIB = ((Body)localObject4).m_invI;
      ((ContactVelocityConstraint)localObject2).contactIndex = i;
      ((ContactVelocityConstraint)localObject2).pointCount = k;
      ((ContactVelocityConstraint)localObject2).K.setZero();
      ((ContactVelocityConstraint)localObject2).normalMass.setZero();
      paramContactSolverDef = this.m_positionConstraints[i];
      paramContactSolverDef.indexA = ((Body)localObject3).m_islandIndex;
      paramContactSolverDef.indexB = ((Body)localObject4).m_islandIndex;
      paramContactSolverDef.invMassA = ((Body)localObject3).m_invMass;
      paramContactSolverDef.invMassB = ((Body)localObject4).m_invMass;
      paramContactSolverDef.localCenterA.set(((Body)localObject3).m_sweep.localCenter);
      paramContactSolverDef.localCenterB.set(((Body)localObject4).m_sweep.localCenter);
      paramContactSolverDef.invIA = ((Body)localObject3).m_invI;
      paramContactSolverDef.invIB = ((Body)localObject4).m_invI;
      paramContactSolverDef.localNormal.set(((Manifold)localObject1).localNormal);
      paramContactSolverDef.localPoint.set(((Manifold)localObject1).localPoint);
      paramContactSolverDef.pointCount = k;
      paramContactSolverDef.radiusA = f1;
      paramContactSolverDef.radiusB = f2;
      paramContactSolverDef.type = ((Manifold)localObject1).type;
      j = 0;
      while (j < k)
      {
        localObject3 = localObject1.points[j];
        localObject4 = localObject2.points[j];
        if (this.m_step.warmStarting)
        {
          ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalImpulse = (this.m_step.dtRatio * ((ManifoldPoint)localObject3).normalImpulse);
          ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).tangentImpulse = (this.m_step.dtRatio * ((ManifoldPoint)localObject3).tangentImpulse);
        }
        else
        {
          ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalImpulse = 0.0F;
          ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).tangentImpulse = 0.0F;
        }
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rA.setZero();
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rB.setZero();
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalMass = 0.0F;
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).tangentMass = 0.0F;
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).velocityBias = 0.0F;
        paramContactSolverDef.localPoints[j].x = ((ManifoldPoint)localObject3).localPoint.x;
        paramContactSolverDef.localPoints[j].y = ((ManifoldPoint)localObject3).localPoint.y;
        j += 1;
      }
      i += 1;
    }
  }
  
  public final void initializeVelocityConstraints()
  {
    int i = 0;
    while (i < this.m_count)
    {
      ContactVelocityConstraint localContactVelocityConstraint = this.m_velocityConstraints[i];
      Object localObject1 = this.m_positionConstraints[i];
      float f3 = ((ContactPositionConstraint)localObject1).radiusA;
      float f8 = ((ContactPositionConstraint)localObject1).radiusB;
      Object localObject3 = this.m_contacts[localContactVelocityConstraint.contactIndex].getManifold();
      int j = localContactVelocityConstraint.indexA;
      int k = localContactVelocityConstraint.indexB;
      float f6 = localContactVelocityConstraint.invMassA;
      float f7 = localContactVelocityConstraint.invMassB;
      float f4 = localContactVelocityConstraint.invIA;
      float f5 = localContactVelocityConstraint.invIB;
      Vec2 localVec23 = ((ContactPositionConstraint)localObject1).localCenterA;
      Vec2 localVec24 = ((ContactPositionConstraint)localObject1).localCenterB;
      Vec2 localVec21 = this.m_positions[j].c;
      float f9 = this.m_positions[j].a;
      localObject1 = this.m_velocities[j].v;
      float f1 = this.m_velocities[j].w;
      Vec2 localVec22 = this.m_positions[k].c;
      float f10 = this.m_positions[k].a;
      Object localObject2 = this.m_velocities[k].v;
      float f2 = this.m_velocities[k].w;
      this.xfA.q.set(f9);
      this.xfB.q.set(f10);
      Vec2 localVec25 = this.xfA.p;
      f9 = localVec21.x;
      f10 = this.xfA.q.c;
      localVec25.x = (f9 - (f10 * localVec23.x - this.xfA.q.s * localVec23.y));
      this.xfA.p.y = (localVec21.y - (this.xfA.q.s * localVec23.x + this.xfA.q.c * localVec23.y));
      this.xfB.p.x = (localVec22.x - (this.xfB.q.c * localVec24.x - this.xfB.q.s * localVec24.y));
      this.xfB.p.y = (localVec22.y - (this.xfB.q.s * localVec24.x + this.xfB.q.c * localVec24.y));
      this.worldManifold.initialize((Manifold)localObject3, this.xfA, f3, this.xfB, f8);
      localContactVelocityConstraint.normal.set(this.worldManifold.normal);
      k = localContactVelocityConstraint.pointCount;
      j = 0;
      while (j < k)
      {
        localObject3 = localContactVelocityConstraint.points[j];
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.set(this.worldManifold.points[j]).subLocal(localVec21);
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.set(this.worldManifold.points[j]).subLocal(localVec22);
        f3 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.x * localContactVelocityConstraint.normal.y - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.y * localContactVelocityConstraint.normal.x;
        f9 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.x * localContactVelocityConstraint.normal.y - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.y * localContactVelocityConstraint.normal.x;
        f8 = f6 + f7;
        f3 = f4 * f3 * f3 + f8 + f5 * f9 * f9;
        if (f3 > 0.0F) {
          f3 = 1.0F / f3;
        } else {
          f3 = 0.0F;
        }
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).normalMass = f3;
        f9 = localContactVelocityConstraint.normal.y * 1.0F;
        f10 = localContactVelocityConstraint.normal.x * -1.0F;
        f3 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.x * f10 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.y * f9;
        f9 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.x * f10 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.y * f9;
        f3 = f8 + f4 * f3 * f3 + f5 * f9 * f9;
        if (f3 > 0.0F) {
          f3 = 1.0F / f3;
        } else {
          f3 = 0.0F;
        }
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).tangentMass = f3;
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).velocityBias = 0.0F;
        f3 = ((Vec2)localObject2).x;
        f8 = -f2;
        f9 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.y;
        f10 = ((Vec2)localObject1).x;
        float f11 = -f1;
        float f12 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.y;
        float f13 = ((Vec2)localObject2).y;
        float f14 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.x;
        float f15 = ((Vec2)localObject1).y;
        float f16 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.x;
        f3 = localContactVelocityConstraint.normal.x * (f3 + f8 * f9 - f10 - f11 * f12) + localContactVelocityConstraint.normal.y * (f13 + f14 * f2 - f15 - f16 * f1);
        if (f3 < -1.0F) {
          ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).velocityBias = (-localContactVelocityConstraint.restitution * f3);
        }
        j += 1;
      }
      if (localContactVelocityConstraint.pointCount == 2)
      {
        localObject1 = localContactVelocityConstraint.points[0];
        localObject2 = localContactVelocityConstraint.points[1];
        f3 = Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject1).rA, localContactVelocityConstraint.normal);
        f8 = Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject1).rB, localContactVelocityConstraint.normal);
        f1 = Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rA, localContactVelocityConstraint.normal);
        f2 = Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rB, localContactVelocityConstraint.normal);
        f6 += f7;
        f7 = f4 * f3;
        f9 = f5 * f8;
        f3 = f3 * f7 + f6 + f8 * f9;
        f4 = f4 * f1 * f1 + f6 + f5 * f2 * f2;
        f1 = f6 + f7 * f1 + f9 * f2;
        if (f3 * f3 < (f3 * f4 - f1 * f1) * 100.0F)
        {
          localContactVelocityConstraint.K.ex.set(f3, f1);
          localContactVelocityConstraint.K.ey.set(f1, f4);
          localContactVelocityConstraint.K.invertToOut(localContactVelocityConstraint.normalMass);
        }
        else
        {
          localContactVelocityConstraint.pointCount = 1;
        }
      }
      i += 1;
    }
  }
  
  public final boolean solvePositionConstraints()
  {
    int i = 0;
    float f1 = 0.0F;
    while (i < this.m_count)
    {
      Object localObject = this.m_positionConstraints[i];
      int j = ((ContactPositionConstraint)localObject).indexA;
      int n = ((ContactPositionConstraint)localObject).indexB;
      float f5 = ((ContactPositionConstraint)localObject).invMassA;
      float f6 = ((ContactPositionConstraint)localObject).invIA;
      Vec2 localVec21 = ((ContactPositionConstraint)localObject).localCenterA;
      float f7 = ((ContactPositionConstraint)localObject).invMassB;
      float f8 = ((ContactPositionConstraint)localObject).invIB;
      Vec2 localVec22 = ((ContactPositionConstraint)localObject).localCenterB;
      int k = ((ContactPositionConstraint)localObject).pointCount;
      Vec2 localVec23 = this.m_positions[j].c;
      float f3 = this.m_positions[j].a;
      Vec2 localVec24 = this.m_positions[n].c;
      float f2 = this.m_positions[n].a;
      int m = 0;
      while (m < k)
      {
        this.xfA.q.set(f3);
        this.xfB.q.set(f2);
        Rot.mulToOutUnsafe(this.xfA.q, localVec21, this.xfA.p);
        this.xfA.p.negateLocal().addLocal(localVec23);
        Rot.mulToOutUnsafe(this.xfB.q, localVec22, this.xfB.p);
        this.xfB.p.negateLocal().addLocal(localVec24);
        PositionSolverManifold localPositionSolverManifold = this.psolver;
        localPositionSolverManifold.initialize((ContactPositionConstraint)localObject, this.xfA, this.xfB, m);
        Vec2 localVec25 = localPositionSolverManifold.normal;
        Vec2 localVec26 = localPositionSolverManifold.point;
        float f9 = localPositionSolverManifold.separation;
        this.rA.set(localVec26).subLocal(localVec23);
        this.rB.set(localVec26).subLocal(localVec24);
        float f4 = MathUtils.min(f1, f9);
        f1 = MathUtils.clamp((f9 + 0.005F) * 0.2F, -0.2F, 0.0F);
        f9 = Vec2.cross(this.rA, localVec25);
        float f10 = Vec2.cross(this.rB, localVec25);
        f9 = f5 + f7 + f6 * f9 * f9 + f8 * f10 * f10;
        if (f9 > 0.0F) {
          f1 = -f1 / f9;
        } else {
          f1 = 0.0F;
        }
        this.P.set(localVec25).mulLocal(f1);
        localVec23.subLocal(this.temp.set(this.P).mulLocal(f5));
        f3 -= Vec2.cross(this.rA, this.P) * f6;
        localVec24.addLocal(this.temp.set(this.P).mulLocal(f7));
        f2 += Vec2.cross(this.rB, this.P) * f8;
        m += 1;
        f1 = f4;
      }
      localObject = this.m_positions;
      localObject[j].a = f3;
      localObject[n].a = f2;
      i += 1;
    }
    return f1 >= -0.015F;
  }
  
  public boolean solveTOIPositionConstraints(int paramInt1, int paramInt2)
  {
    int i = 0;
    float f1 = 0.0F;
    for (;;)
    {
      int n = paramInt2;
      int m = paramInt1;
      if (i >= this.m_count) {
        break;
      }
      Object localObject = this.m_positionConstraints[i];
      int j = ((ContactPositionConstraint)localObject).indexA;
      int i1 = ((ContactPositionConstraint)localObject).indexB;
      Vec2 localVec21 = ((ContactPositionConstraint)localObject).localCenterA;
      Vec2 localVec22 = ((ContactPositionConstraint)localObject).localCenterB;
      int k = ((ContactPositionConstraint)localObject).pointCount;
      float f2;
      float f3;
      if ((j != m) && (j != n))
      {
        f2 = 0.0F;
        f3 = 0.0F;
      }
      else
      {
        f2 = ((ContactPositionConstraint)localObject).invMassA;
        f3 = ((ContactPositionConstraint)localObject).invIA;
      }
      float f4;
      float f5;
      if ((i1 != m) && (i1 != n))
      {
        f4 = 0.0F;
        f5 = 0.0F;
      }
      else
      {
        f5 = ((ContactPositionConstraint)localObject).invMassB;
        f4 = ((ContactPositionConstraint)localObject).invIB;
      }
      Vec2 localVec23 = this.m_positions[j].c;
      float f7 = this.m_positions[j].a;
      Vec2 localVec24 = this.m_positions[i1].c;
      float f6 = this.m_positions[i1].a;
      m = 0;
      while (m < k)
      {
        this.xfA.q.set(f7);
        this.xfB.q.set(f6);
        Rot.mulToOutUnsafe(this.xfA.q, localVec21, this.xfA.p);
        this.xfA.p.negateLocal().addLocal(localVec23);
        Rot.mulToOutUnsafe(this.xfB.q, localVec22, this.xfB.p);
        this.xfB.p.negateLocal().addLocal(localVec24);
        PositionSolverManifold localPositionSolverManifold = this.psolver;
        localPositionSolverManifold.initialize((ContactPositionConstraint)localObject, this.xfA, this.xfB, m);
        Vec2 localVec25 = localPositionSolverManifold.normal;
        Vec2 localVec26 = localPositionSolverManifold.point;
        float f9 = localPositionSolverManifold.separation;
        this.rA.set(localVec26).subLocal(localVec23);
        this.rB.set(localVec26).subLocal(localVec24);
        float f8 = MathUtils.min(f1, f9);
        f1 = MathUtils.clamp((f9 + 0.005F) * 0.75F, -0.2F, 0.0F);
        f9 = Vec2.cross(this.rA, localVec25);
        float f10 = Vec2.cross(this.rB, localVec25);
        f9 = f2 + f5 + f3 * f9 * f9 + f4 * f10 * f10;
        if (f9 > 0.0F) {
          f1 = -f1 / f9;
        } else {
          f1 = 0.0F;
        }
        this.P.set(localVec25).mulLocal(f1);
        localVec23.subLocal(this.temp.set(this.P).mulLocal(f2));
        f7 -= Vec2.cross(this.rA, this.P) * f3;
        localVec24.addLocal(this.temp.set(this.P).mulLocal(f5));
        f6 += Vec2.cross(this.rB, this.P) * f4;
        m += 1;
        f1 = f8;
      }
      localObject = this.m_positions;
      localObject[j].a = f7;
      localObject[i1].a = f6;
      i += 1;
    }
    return f1 >= -0.0075F;
  }
  
  public final void solveVelocityConstraints()
  {
    int i = 0;
    while (i < this.m_count)
    {
      Object localObject2 = this.m_velocityConstraints[i];
      int j = ((ContactVelocityConstraint)localObject2).indexA;
      int k = ((ContactVelocityConstraint)localObject2).indexB;
      float f6 = ((ContactVelocityConstraint)localObject2).invMassA;
      float f5 = ((ContactVelocityConstraint)localObject2).invMassB;
      float f7 = ((ContactVelocityConstraint)localObject2).invIA;
      float f4 = ((ContactVelocityConstraint)localObject2).invIB;
      int m = ((ContactVelocityConstraint)localObject2).pointCount;
      Vec2 localVec21 = this.m_velocities[j].v;
      float f2 = this.m_velocities[j].w;
      Vec2 localVec22 = this.m_velocities[k].v;
      float f1 = this.m_velocities[k].w;
      Object localObject1 = ((ContactVelocityConstraint)localObject2).normal;
      Object localObject3 = this.tangent;
      ((Vec2)localObject3).x = (((ContactVelocityConstraint)localObject2).normal.y * 1.0F);
      this.tangent.y = (((ContactVelocityConstraint)localObject2).normal.x * -1.0F);
      float f3 = ((ContactVelocityConstraint)localObject2).friction;
      int n = 0;
      Object localObject4;
      float f9;
      float f10;
      float f11;
      float f12;
      float f13;
      float f14;
      float f15;
      float f16;
      float f17;
      float f18;
      float f19;
      float f8;
      while (n < m)
      {
        localObject3 = localObject2.points[n];
        localObject4 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA;
        f9 = -f1;
        f10 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.y;
        f11 = localVec22.x;
        f12 = localVec21.x;
        f13 = ((Vec2)localObject4).y;
        f14 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.x;
        f15 = localVec22.y;
        f16 = localVec21.y;
        f17 = ((Vec2)localObject4).x;
        f18 = this.tangent.x;
        f19 = this.tangent.y;
        float f20 = ((ContactVelocityConstraint)localObject2).tangentSpeed;
        f8 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).tangentMass;
        f9 = -((f9 * f10 + f11 - f12 + f13 * f2) * f18 + (f14 * f1 + f15 - f16 - f17 * f2) * f19 - f20);
        f10 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).normalImpulse * f3;
        f8 = MathUtils.clamp(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).tangentImpulse + f8 * f9, -f10, f10);
        f9 = f8 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).tangentImpulse;
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).tangentImpulse = f8;
        f8 = this.tangent.x * f9;
        f9 = this.tangent.y * f9;
        localVec21.x -= f8 * f6;
        localVec21.y -= f9 * f6;
        f2 -= (((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.x * f9 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.y * f8) * f7;
        localVec22.x += f8 * f5;
        localVec22.y += f9 * f5;
        f1 += (((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.x * f9 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.y * f8) * f4;
        n += 1;
      }
      if (((ContactVelocityConstraint)localObject2).pointCount == 1)
      {
        localObject2 = localObject2.points[0];
        f3 = -f1;
        f8 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rB.y;
        f9 = localVec22.x;
        f10 = localVec21.x;
        f11 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rA.y;
        f12 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rB.x;
        f13 = localVec22.y;
        f14 = localVec21.y;
        f15 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rA.x;
        f16 = ((Vec2)localObject1).x;
        f17 = ((Vec2)localObject1).y;
        f18 = -((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).normalMass;
        f19 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).velocityBias;
        f3 = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).normalImpulse + f18 * ((f3 * f8 + f9 - f10 + f11 * f2) * f16 + (f12 * f1 + f13 - f14 - f15 * f2) * f17 - f19);
        if (f3 <= 0.0F) {
          f3 = 0.0F;
        }
        f8 = f3 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).normalImpulse;
        ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).normalImpulse = f3;
        f3 = ((Vec2)localObject1).x * f8;
        f8 = ((Vec2)localObject1).y * f8;
        localVec21.x -= f3 * f6;
        localVec21.y -= f6 * f8;
        f2 -= f7 * (((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rA.x * f8 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rA.y * f3);
        localVec22.x += f3 * f5;
        localVec22.y += f5 * f8;
        f1 += f4 * (((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rB.x * f8 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject2).rB.y * f3);
      }
      for (;;)
      {
        break;
        localObject3 = localObject2.points[0];
        localObject4 = localObject2.points[1];
        this.a.x = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).normalImpulse;
        this.a.y = ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalImpulse;
        Object localObject5 = this.dv1;
        f3 = -f1;
        ((Vec2)localObject5).x = (((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.y * f3 + localVec22.x - localVec21.x + ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.y * f2);
        this.dv1.y = (((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB.x * f1 + localVec22.y - localVec21.y - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA.x * f2);
        this.dv2.x = (f3 * ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rB.y + localVec22.x - localVec21.x + ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rA.y * f2);
        this.dv2.y = (((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rB.x * f1 + localVec22.y - localVec21.y - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rA.x * f2);
        f3 = this.dv1.x;
        f8 = ((Vec2)localObject1).x;
        f9 = this.dv1.y;
        f10 = ((Vec2)localObject1).y;
        f11 = this.dv2.x;
        f12 = ((Vec2)localObject1).x;
        f13 = this.dv2.y;
        f14 = ((Vec2)localObject1).y;
        this.b.x = (f3 * f8 + f9 * f10 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).velocityBias);
        this.b.y = (f11 * f12 + f13 * f14 - ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).velocityBias);
        localObject5 = ((ContactVelocityConstraint)localObject2).K;
        Vec2 localVec23 = this.b;
        localVec23.x -= ((Mat22)localObject5).ex.x * this.a.x + ((Mat22)localObject5).ey.x * this.a.y;
        localVec23 = this.b;
        localVec23.y -= ((Mat22)localObject5).ex.y * this.a.x + ((Mat22)localObject5).ey.y * this.a.y;
        Mat22.mulToOutUnsafe(((ContactVelocityConstraint)localObject2).normalMass, this.b, this.x);
        localObject5 = this.x;
        ((Vec2)localObject5).x *= -1.0F;
        localObject5 = this.x;
        ((Vec2)localObject5).y *= -1.0F;
        if ((this.x.x >= 0.0F) && (this.x.y >= 0.0F))
        {
          this.d.set(this.x).subLocal(this.a);
          this.P1.set((Vec2)localObject1).mulLocal(this.d.x);
          this.P2.set((Vec2)localObject1).mulLocal(this.d.y);
          this.temp1.set(this.P1).addLocal(this.P2);
          this.temp2.set(this.temp1).mulLocal(f6);
          localVec21.subLocal(this.temp2);
          this.temp2.set(this.temp1).mulLocal(f5);
          localVec22.addLocal(this.temp2);
          f2 -= f7 * (Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA, this.P1) + Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rA, this.P2));
          f1 += f4 * (Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB, this.P1) + Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rB, this.P2));
          ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).normalImpulse = this.x.x;
          ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalImpulse = this.x.y;
        }
        else
        {
          this.x.x = (-((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).normalMass * this.b.x);
          this.x.y = 0.0F;
          f3 = ((ContactVelocityConstraint)localObject2).K.ex.y;
          f8 = this.x.x;
          f9 = this.b.y;
          if ((this.x.x >= 0.0F) && (f3 * f8 + f9 >= 0.0F))
          {
            this.d.set(this.x).subLocal(this.a);
            this.P1.set((Vec2)localObject1).mulLocal(this.d.x);
            this.P2.set((Vec2)localObject1).mulLocal(this.d.y);
            this.temp1.set(this.P1).addLocal(this.P2);
            this.temp2.set(this.temp1).mulLocal(f6);
            localVec21.subLocal(this.temp2);
            this.temp2.set(this.temp1).mulLocal(f5);
            localVec22.addLocal(this.temp2);
            f2 -= f7 * (Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA, this.P1) + Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rA, this.P2));
            f1 += f4 * (Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB, this.P1) + Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rB, this.P2));
            ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).normalImpulse = this.x.x;
            ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalImpulse = this.x.y;
          }
          else
          {
            localObject5 = this.x;
            ((Vec2)localObject5).x = 0.0F;
            ((Vec2)localObject5).y = (-((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalMass * this.b.y);
            f3 = ((ContactVelocityConstraint)localObject2).K.ey.x;
            f8 = this.x.y;
            f9 = this.b.x;
            if ((this.x.y >= 0.0F) && (f3 * f8 + f9 >= 0.0F))
            {
              this.d.set(this.x).subLocal(this.a);
              this.P1.set((Vec2)localObject1).mulLocal(this.d.x);
              this.P2.set((Vec2)localObject1).mulLocal(this.d.y);
              this.temp1.set(this.P1).addLocal(this.P2);
              this.temp2.set(this.temp1).mulLocal(f6);
              localVec21.subLocal(this.temp2);
              this.temp2.set(this.temp1).mulLocal(f5);
              localVec22.addLocal(this.temp2);
              f2 -= f7 * (Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA, this.P1) + Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rA, this.P2));
              f1 += f4 * (Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB, this.P1) + Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rB, this.P2));
              ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).normalImpulse = this.x.x;
              ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalImpulse = this.x.y;
            }
            else
            {
              localObject2 = this.x;
              ((Vec2)localObject2).x = 0.0F;
              ((Vec2)localObject2).y = 0.0F;
              f3 = this.b.x;
              f8 = this.b.y;
              if ((f3 < 0.0F) || (f8 < 0.0F)) {
                break;
              }
              this.d.set(this.x).subLocal(this.a);
              this.P1.set((Vec2)localObject1).mulLocal(this.d.x);
              this.P2.set((Vec2)localObject1).mulLocal(this.d.y);
              this.temp1.set(this.P1).addLocal(this.P2);
              this.temp2.set(this.temp1).mulLocal(f6);
              localVec21.subLocal(this.temp2);
              this.temp2.set(this.temp1).mulLocal(f5);
              localVec22.addLocal(this.temp2);
              f2 -= f7 * (Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rA, this.P1) + Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rA, this.P2));
              f1 += f4 * (Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).rB, this.P1) + Vec2.cross(((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).rB, this.P2));
              ((ContactVelocityConstraint.VelocityConstraintPoint)localObject3).normalImpulse = this.x.x;
              ((ContactVelocityConstraint.VelocityConstraintPoint)localObject4).normalImpulse = this.x.y;
            }
          }
        }
      }
      localObject1 = this.m_velocities;
      localObject1[j].w = f2;
      localObject1[k].w = f1;
      i += 1;
    }
  }
  
  public void storeImpulses()
  {
    int i = 0;
    while (i < this.m_count)
    {
      ContactVelocityConstraint localContactVelocityConstraint = this.m_velocityConstraints[i];
      Manifold localManifold = this.m_contacts[localContactVelocityConstraint.contactIndex].getManifold();
      int j = 0;
      while (j < localContactVelocityConstraint.pointCount)
      {
        localManifold.points[j].normalImpulse = localContactVelocityConstraint.points[j].normalImpulse;
        localManifold.points[j].tangentImpulse = localContactVelocityConstraint.points[j].tangentImpulse;
        j += 1;
      }
      i += 1;
    }
  }
  
  public void warmStart()
  {
    int i = 0;
    while (i < this.m_count)
    {
      Object localObject = this.m_velocityConstraints[i];
      int j = ((ContactVelocityConstraint)localObject).indexA;
      int n = ((ContactVelocityConstraint)localObject).indexB;
      float f5 = ((ContactVelocityConstraint)localObject).invMassA;
      float f6 = ((ContactVelocityConstraint)localObject).invIA;
      float f7 = ((ContactVelocityConstraint)localObject).invMassB;
      float f8 = ((ContactVelocityConstraint)localObject).invIB;
      int k = ((ContactVelocityConstraint)localObject).pointCount;
      Vec2 localVec21 = this.m_velocities[j].v;
      float f4 = this.m_velocities[j].w;
      Vec2 localVec22 = this.m_velocities[n].v;
      float f2 = this.m_velocities[n].w;
      Vec2 localVec23 = ((ContactVelocityConstraint)localObject).normal;
      float f3 = localVec23.y * 1.0F;
      float f1 = localVec23.x * -1.0F;
      int m = 0;
      while (m < k)
      {
        ContactVelocityConstraint.VelocityConstraintPoint localVelocityConstraintPoint = localObject.points[m];
        float f9 = localVelocityConstraintPoint.tangentImpulse * f3 + localVec23.x * localVelocityConstraintPoint.normalImpulse;
        float f10 = localVelocityConstraintPoint.tangentImpulse * f1 + localVec23.y * localVelocityConstraintPoint.normalImpulse;
        f4 -= (localVelocityConstraintPoint.rA.x * f10 - localVelocityConstraintPoint.rA.y * f9) * f6;
        localVec21.x -= f9 * f5;
        localVec21.y -= f10 * f5;
        f2 += (localVelocityConstraintPoint.rB.x * f10 - localVelocityConstraintPoint.rB.y * f9) * f8;
        localVec22.x += f9 * f7;
        localVec22.y += f10 * f7;
        m += 1;
      }
      localObject = this.m_velocities;
      localObject[j].w = f4;
      localObject[n].w = f2;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.contacts.ContactSolver
 * JD-Core Version:    0.7.0.1
 */