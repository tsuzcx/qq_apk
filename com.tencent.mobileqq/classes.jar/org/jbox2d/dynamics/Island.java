package org.jbox2d.dynamics;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Settings;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactSolver;
import org.jbox2d.dynamics.contacts.ContactSolver.ContactSolverDef;
import org.jbox2d.dynamics.contacts.ContactVelocityConstraint;
import org.jbox2d.dynamics.contacts.ContactVelocityConstraint.VelocityConstraintPoint;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.dynamics.joints.Joint;

public class Island
{
  private final ContactSolver contactSolver = new ContactSolver();
  private final ContactImpulse impulse = new ContactImpulse();
  public Body[] m_bodies;
  public int m_bodyCapacity;
  public int m_bodyCount;
  public int m_contactCapacity;
  public int m_contactCount;
  public Contact[] m_contacts;
  public int m_jointCapacity;
  public int m_jointCount;
  public Joint[] m_joints;
  public ContactListener m_listener;
  public Position[] m_positions;
  public Velocity[] m_velocities;
  private final SolverData solverData = new SolverData();
  private final ContactSolver.ContactSolverDef solverDef = new ContactSolver.ContactSolverDef();
  private final Timer timer = new Timer();
  private final ContactSolver toiContactSolver = new ContactSolver();
  private final ContactSolver.ContactSolverDef toiSolverDef = new ContactSolver.ContactSolverDef();
  
  public void add(Body paramBody)
  {
    int i = this.m_bodyCount;
    paramBody.m_islandIndex = i;
    this.m_bodies[i] = paramBody;
    this.m_bodyCount = (i + 1);
  }
  
  public void add(Contact paramContact)
  {
    Contact[] arrayOfContact = this.m_contacts;
    int i = this.m_contactCount;
    this.m_contactCount = (i + 1);
    arrayOfContact[i] = paramContact;
  }
  
  public void add(Joint paramJoint)
  {
    Joint[] arrayOfJoint = this.m_joints;
    int i = this.m_jointCount;
    this.m_jointCount = (i + 1);
    arrayOfJoint[i] = paramJoint;
  }
  
  public void clear()
  {
    this.m_bodyCount = 0;
    this.m_contactCount = 0;
    this.m_jointCount = 0;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, ContactListener paramContactListener)
  {
    this.m_bodyCapacity = paramInt1;
    this.m_contactCapacity = paramInt2;
    this.m_jointCapacity = paramInt3;
    this.m_bodyCount = 0;
    this.m_contactCount = 0;
    this.m_jointCount = 0;
    this.m_listener = paramContactListener;
    paramContactListener = this.m_bodies;
    if ((paramContactListener == null) || (this.m_bodyCapacity > paramContactListener.length)) {
      this.m_bodies = new Body[this.m_bodyCapacity];
    }
    paramContactListener = this.m_joints;
    if ((paramContactListener == null) || (this.m_jointCapacity > paramContactListener.length)) {
      this.m_joints = new Joint[this.m_jointCapacity];
    }
    paramContactListener = this.m_contacts;
    if ((paramContactListener == null) || (this.m_contactCapacity > paramContactListener.length)) {
      this.m_contacts = new Contact[this.m_contactCapacity];
    }
    paramContactListener = this.m_velocities;
    Object localObject;
    if ((paramContactListener == null) || (this.m_bodyCapacity > paramContactListener.length))
    {
      localObject = this.m_velocities;
      paramContactListener = (ContactListener)localObject;
      if (localObject == null) {
        paramContactListener = new Velocity[0];
      }
      this.m_velocities = new Velocity[this.m_bodyCapacity];
      System.arraycopy(paramContactListener, 0, this.m_velocities, 0, paramContactListener.length);
      paramInt1 = paramContactListener.length;
      for (;;)
      {
        paramContactListener = this.m_velocities;
        if (paramInt1 >= paramContactListener.length) {
          break;
        }
        paramContactListener[paramInt1] = new Velocity();
        paramInt1 += 1;
      }
    }
    paramContactListener = this.m_positions;
    if ((paramContactListener == null) || (this.m_bodyCapacity > paramContactListener.length))
    {
      localObject = this.m_positions;
      paramContactListener = (ContactListener)localObject;
      if (localObject == null) {
        paramContactListener = new Position[0];
      }
      this.m_positions = new Position[this.m_bodyCapacity];
      System.arraycopy(paramContactListener, 0, this.m_positions, 0, paramContactListener.length);
      paramInt1 = paramContactListener.length;
      for (;;)
      {
        paramContactListener = this.m_positions;
        if (paramInt1 >= paramContactListener.length) {
          break;
        }
        paramContactListener[paramInt1] = new Position();
        paramInt1 += 1;
      }
    }
  }
  
  public void report(ContactVelocityConstraint[] paramArrayOfContactVelocityConstraint)
  {
    if (this.m_listener == null) {
      return;
    }
    int i = 0;
    while (i < this.m_contactCount)
    {
      Contact localContact = this.m_contacts[i];
      ContactVelocityConstraint localContactVelocityConstraint = paramArrayOfContactVelocityConstraint[i];
      this.impulse.count = localContactVelocityConstraint.pointCount;
      int j = 0;
      while (j < localContactVelocityConstraint.pointCount)
      {
        this.impulse.normalImpulses[j] = localContactVelocityConstraint.points[j].normalImpulse;
        this.impulse.tangentImpulses[j] = localContactVelocityConstraint.points[j].tangentImpulse;
        j += 1;
      }
      this.m_listener.postSolve(localContact, this.impulse);
      i += 1;
    }
  }
  
  public void solve(Profile paramProfile, TimeStep paramTimeStep, Vec2 paramVec2, boolean paramBoolean)
  {
    float f3 = paramTimeStep.dt;
    int i = 0;
    float f4;
    float f2;
    float f1;
    float f5;
    while (i < this.m_bodyCount)
    {
      localObject1 = this.m_bodies[i];
      localObject2 = ((Body)localObject1).m_sweep.c;
      f4 = ((Body)localObject1).m_sweep.a;
      Vec2 localVec2 = ((Body)localObject1).m_linearVelocity;
      f2 = ((Body)localObject1).m_angularVelocity;
      ((Body)localObject1).m_sweep.c0.set(((Body)localObject1).m_sweep.c);
      ((Body)localObject1).m_sweep.a0 = ((Body)localObject1).m_sweep.a;
      f1 = f2;
      if (((Body)localObject1).m_type == BodyType.DYNAMIC)
      {
        localVec2.x += (((Body)localObject1).m_gravityScale * paramVec2.x + ((Body)localObject1).m_invMass * ((Body)localObject1).m_force.x) * f3;
        localVec2.y += (((Body)localObject1).m_gravityScale * paramVec2.y + ((Body)localObject1).m_invMass * ((Body)localObject1).m_force.y) * f3;
        f1 = ((Body)localObject1).m_invI;
        f5 = ((Body)localObject1).m_torque;
        float f6 = MathUtils.clamp(1.0F - ((Body)localObject1).m_linearDamping * f3, 0.0F, 1.0F);
        localVec2.x *= f6;
        localVec2.y *= f6;
        f1 = (f2 + f1 * f3 * f5) * MathUtils.clamp(1.0F - ((Body)localObject1).m_angularDamping * f3, 0.0F, 1.0F);
      }
      this.m_positions[i].c.x = ((Vec2)localObject2).x;
      this.m_positions[i].c.y = ((Vec2)localObject2).y;
      this.m_positions[i].a = f4;
      this.m_velocities[i].v.x = localVec2.x;
      this.m_velocities[i].v.y = localVec2.y;
      this.m_velocities[i].w = f1;
      i += 1;
    }
    this.timer.reset();
    Object localObject2 = this.solverData;
    ((SolverData)localObject2).step = paramTimeStep;
    paramVec2 = this.m_positions;
    ((SolverData)localObject2).positions = paramVec2;
    Object localObject1 = this.m_velocities;
    ((SolverData)localObject2).velocities = ((Velocity[])localObject1);
    localObject2 = this.solverDef;
    ((ContactSolver.ContactSolverDef)localObject2).step = paramTimeStep;
    ((ContactSolver.ContactSolverDef)localObject2).contacts = this.m_contacts;
    ((ContactSolver.ContactSolverDef)localObject2).count = this.m_contactCount;
    ((ContactSolver.ContactSolverDef)localObject2).positions = paramVec2;
    ((ContactSolver.ContactSolverDef)localObject2).velocities = ((Velocity[])localObject1);
    this.contactSolver.init((ContactSolver.ContactSolverDef)localObject2);
    this.contactSolver.initializeVelocityConstraints();
    if (paramTimeStep.warmStarting) {
      this.contactSolver.warmStart();
    }
    i = 0;
    while (i < this.m_jointCount)
    {
      this.m_joints[i].initVelocityConstraints(this.solverData);
      i += 1;
    }
    paramProfile.solveInit = this.timer.getMilliseconds();
    this.timer.reset();
    i = 0;
    while (i < paramTimeStep.velocityIterations)
    {
      j = 0;
      while (j < this.m_jointCount)
      {
        this.m_joints[j].solveVelocityConstraints(this.solverData);
        j += 1;
      }
      this.contactSolver.solveVelocityConstraints();
      i += 1;
    }
    this.contactSolver.storeImpulses();
    paramProfile.solveVelocity = this.timer.getMilliseconds();
    i = 0;
    while (i < this.m_bodyCount)
    {
      paramVec2 = this.m_positions[i].c;
      f4 = this.m_positions[i].a;
      localObject1 = this.m_velocities[i].v;
      f2 = this.m_velocities[i].w;
      f1 = ((Vec2)localObject1).x * f3;
      f5 = ((Vec2)localObject1).y * f3;
      f1 = f1 * f1 + f5 * f5;
      if (f1 > 4.0F)
      {
        f1 = 2.0F / MathUtils.sqrt(f1);
        ((Vec2)localObject1).x *= f1;
        ((Vec2)localObject1).y *= f1;
      }
      f5 = f3 * f2;
      f1 = f2;
      if (f5 * f5 > Settings.maxRotationSquared) {
        f1 = f2 * (1.570796F / MathUtils.abs(f5));
      }
      paramVec2.x += ((Vec2)localObject1).x * f3;
      paramVec2.y += ((Vec2)localObject1).y * f3;
      this.m_positions[i].a = (f4 + f3 * f1);
      this.m_velocities[i].w = f1;
      i += 1;
    }
    this.timer.reset();
    int j = 0;
    for (;;)
    {
      i = paramTimeStep.positionIterations;
      int m = 1;
      if (j >= i) {
        break;
      }
      boolean bool1 = this.contactSolver.solvePositionConstraints();
      int k = 0;
      i = 1;
      while (k < this.m_jointCount)
      {
        boolean bool2 = this.m_joints[k].solvePositionConstraints(this.solverData);
        if ((i != 0) && (bool2)) {
          i = 1;
        } else {
          i = 0;
        }
        k += 1;
      }
      if ((bool1) && (i != 0))
      {
        i = m;
        break label1000;
      }
      j += 1;
    }
    i = 0;
    label1000:
    j = 0;
    while (j < this.m_bodyCount)
    {
      paramTimeStep = this.m_bodies[j];
      paramTimeStep.m_sweep.c.x = this.m_positions[j].c.x;
      paramTimeStep.m_sweep.c.y = this.m_positions[j].c.y;
      paramTimeStep.m_sweep.a = this.m_positions[j].a;
      paramTimeStep.m_linearVelocity.x = this.m_velocities[j].v.x;
      paramTimeStep.m_linearVelocity.y = this.m_velocities[j].v.y;
      paramTimeStep.m_angularVelocity = this.m_velocities[j].w;
      paramTimeStep.synchronizeTransform();
      j += 1;
    }
    paramProfile.solvePosition = this.timer.getMilliseconds();
    report(this.contactSolver.m_velocityConstraints);
    if (paramBoolean)
    {
      j = 0;
      f1 = 3.4028235E+38F;
      while (j < this.m_bodyCount)
      {
        paramProfile = this.m_bodies[j];
        if (paramProfile.getType() != BodyType.STATIC) {
          if (((paramProfile.m_flags & 0x4) != 0) && (paramProfile.m_angularVelocity * paramProfile.m_angularVelocity <= 0.00121847F) && (Vec2.dot(paramProfile.m_linearVelocity, paramProfile.m_linearVelocity) <= 1.0E-004F))
          {
            paramProfile.m_sleepTime += f3;
            f1 = MathUtils.min(f1, paramProfile.m_sleepTime);
          }
          else
          {
            paramProfile.m_sleepTime = 0.0F;
            f1 = 0.0F;
          }
        }
        j += 1;
      }
      if ((f1 >= 0.5F) && (i != 0))
      {
        i = 0;
        while (i < this.m_bodyCount)
        {
          this.m_bodies[i].setAwake(false);
          i += 1;
        }
      }
    }
  }
  
  public void solveTOI(TimeStep paramTimeStep, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    while (i < this.m_bodyCount)
    {
      this.m_positions[i].c.x = this.m_bodies[i].m_sweep.c.x;
      this.m_positions[i].c.y = this.m_bodies[i].m_sweep.c.y;
      this.m_positions[i].a = this.m_bodies[i].m_sweep.a;
      this.m_velocities[i].v.x = this.m_bodies[i].m_linearVelocity.x;
      this.m_velocities[i].v.y = this.m_bodies[i].m_linearVelocity.y;
      this.m_velocities[i].w = this.m_bodies[i].m_angularVelocity;
      i += 1;
    }
    Object localObject = this.toiSolverDef;
    ((ContactSolver.ContactSolverDef)localObject).contacts = this.m_contacts;
    ((ContactSolver.ContactSolverDef)localObject).count = this.m_contactCount;
    ((ContactSolver.ContactSolverDef)localObject).step = paramTimeStep;
    ((ContactSolver.ContactSolverDef)localObject).positions = this.m_positions;
    ((ContactSolver.ContactSolverDef)localObject).velocities = this.m_velocities;
    this.toiContactSolver.init((ContactSolver.ContactSolverDef)localObject);
    i = 0;
    while ((i < paramTimeStep.positionIterations) && (!this.toiContactSolver.solveTOIPositionConstraints(paramInt1, paramInt2))) {
      i += 1;
    }
    this.m_bodies[paramInt1].m_sweep.c0.x = this.m_positions[paramInt1].c.x;
    this.m_bodies[paramInt1].m_sweep.c0.y = this.m_positions[paramInt1].c.y;
    this.m_bodies[paramInt1].m_sweep.a0 = this.m_positions[paramInt1].a;
    this.m_bodies[paramInt2].m_sweep.c0.set(this.m_positions[paramInt2].c);
    this.m_bodies[paramInt2].m_sweep.a0 = this.m_positions[paramInt2].a;
    this.toiContactSolver.initializeVelocityConstraints();
    paramInt1 = 0;
    while (paramInt1 < paramTimeStep.velocityIterations)
    {
      this.toiContactSolver.solveVelocityConstraints();
      paramInt1 += 1;
    }
    float f3 = paramTimeStep.dt;
    paramInt1 = j;
    while (paramInt1 < this.m_bodyCount)
    {
      paramTimeStep = this.m_positions[paramInt1].c;
      float f4 = this.m_positions[paramInt1].a;
      localObject = this.m_velocities[paramInt1].v;
      float f2 = this.m_velocities[paramInt1].w;
      float f1 = ((Vec2)localObject).x * f3;
      float f5 = ((Vec2)localObject).y * f3;
      f1 = f1 * f1 + f5 * f5;
      if (f1 > 4.0F) {
        ((Vec2)localObject).mulLocal(2.0F / MathUtils.sqrt(f1));
      }
      f5 = f3 * f2;
      f1 = f2;
      if (f5 * f5 > Settings.maxRotationSquared) {
        f1 = f2 * (1.570796F / MathUtils.abs(f5));
      }
      paramTimeStep.x += ((Vec2)localObject).x * f3;
      paramTimeStep.y += ((Vec2)localObject).y * f3;
      f2 = f4 + f3 * f1;
      this.m_positions[paramInt1].c.x = paramTimeStep.x;
      this.m_positions[paramInt1].c.y = paramTimeStep.y;
      this.m_positions[paramInt1].a = f2;
      this.m_velocities[paramInt1].v.x = ((Vec2)localObject).x;
      this.m_velocities[paramInt1].v.y = ((Vec2)localObject).y;
      this.m_velocities[paramInt1].w = f1;
      Body localBody = this.m_bodies[paramInt1];
      localBody.m_sweep.c.x = paramTimeStep.x;
      localBody.m_sweep.c.y = paramTimeStep.y;
      localBody.m_sweep.a = f2;
      localBody.m_linearVelocity.x = ((Vec2)localObject).x;
      localBody.m_linearVelocity.y = ((Vec2)localObject).y;
      localBody.m_angularVelocity = f1;
      localBody.synchronizeTransform();
      paramInt1 += 1;
    }
    report(this.toiContactSolver.m_velocityConstraints);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.Island
 * JD-Core Version:    0.7.0.1
 */