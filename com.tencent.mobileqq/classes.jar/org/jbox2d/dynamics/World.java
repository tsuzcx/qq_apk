package org.jbox2d.dynamics;

import java.lang.reflect.Array;
import org.jbox2d.callbacks.ContactFilter;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.callbacks.DestructionListener;
import org.jbox2d.callbacks.QueryCallback;
import org.jbox2d.callbacks.RayCastCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.Distance.DistanceProxy;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.TimeOfImpact;
import org.jbox2d.collision.TimeOfImpact.TOIInput;
import org.jbox2d.collision.TimeOfImpact.TOIOutput;
import org.jbox2d.collision.TimeOfImpact.TOIOutputState;
import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.collision.broadphase.BroadPhaseStrategy;
import org.jbox2d.collision.broadphase.DynamicTree;
import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.Color3f;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactEdge;
import org.jbox2d.dynamics.contacts.ContactRegister;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.JointDef;
import org.jbox2d.dynamics.joints.JointEdge;
import org.jbox2d.dynamics.joints.PulleyJoint;
import org.jbox2d.pooling.IDynamicStack;
import org.jbox2d.pooling.IWorldPool;
import org.jbox2d.pooling.arrays.Vec2Array;
import org.jbox2d.pooling.normal.DefaultWorldPool;

public class World
{
  public static final int CLEAR_FORCES = 4;
  private static Integer LIQUID_INT = new Integer(1234598372);
  public static final int LOCKED = 2;
  public static final int NEW_FIXTURE = 1;
  public static final int WORLD_POOL_CONTAINER_SIZE = 10;
  public static final int WORLD_POOL_SIZE = 100;
  public int activeContacts = 0;
  private float averageLinearVel = -1.0F;
  private final Vec2Array avs = new Vec2Array();
  private final Vec2 axis = new Vec2();
  private final Sweep backup1 = new Sweep();
  private final Sweep backup2 = new Sweep();
  private final Timer broadphaseTimer = new Timer();
  private final Vec2 cA = new Vec2();
  private final Vec2 cB = new Vec2();
  private final Vec2 center = new Vec2();
  private final Vec2 circCenterMoved = new Vec2();
  private final Color3f color = new Color3f();
  public int contactPoolCount = 0;
  private ContactRegister[][] contactStacks = (ContactRegister[][])Array.newInstance(ContactRegister.class, new int[] { ShapeType.values().length, ShapeType.values().length });
  private final RayCastInput input = new RayCastInput();
  private final Island island = new Island();
  private final Profile islandProfile = new Profile();
  private final Color3f liquidColor = new Color3f(0.4F, 0.4F, 1.0F);
  private float liquidLength = 0.12F;
  private final Vec2 liquidOffset = new Vec2();
  private boolean m_allowSleep;
  private int m_bodyCount;
  private Body m_bodyList;
  protected ContactManager m_contactManager;
  private boolean m_continuousPhysics;
  private DebugDraw m_debugDraw;
  private DestructionListener m_destructionListener;
  protected int m_flags;
  private final Vec2 m_gravity = new Vec2();
  private float m_inv_dt0;
  private int m_jointCount;
  private Joint m_jointList;
  private Profile m_profile;
  private boolean m_stepComplete;
  private boolean m_subStepping;
  private boolean m_warmStarting;
  private final IWorldPool pool;
  private Body[] stack = new Body[10];
  private final TimeStep step = new TimeStep();
  private final Timer stepTimer = new Timer();
  private final TimeStep subStep = new TimeStep();
  private final Body[] tempBodies = new Body[2];
  private final Timer tempTimer = new Timer();
  private final Vec2Array tlvertices = new Vec2Array();
  private final TimeOfImpact.TOIInput toiInput = new TimeOfImpact.TOIInput();
  private final Island toiIsland = new Island();
  private final TimeOfImpact.TOIOutput toiOutput = new TimeOfImpact.TOIOutput();
  private final Vec2 v1 = new Vec2();
  private final Vec2 v2 = new Vec2();
  private final WorldQueryWrapper wqwrapper = new WorldQueryWrapper();
  private final WorldRayCastWrapper wrcwrapper = new WorldRayCastWrapper();
  private final Transform xf = new Transform();
  
  public World(Vec2 paramVec2)
  {
    this(paramVec2, new DefaultWorldPool(100, 10));
  }
  
  public World(Vec2 paramVec2, IWorldPool paramIWorldPool)
  {
    this(paramVec2, paramIWorldPool, new DynamicTree());
  }
  
  public World(Vec2 paramVec2, IWorldPool paramIWorldPool, BroadPhaseStrategy paramBroadPhaseStrategy)
  {
    this.pool = paramIWorldPool;
    this.m_destructionListener = null;
    this.m_debugDraw = null;
    this.m_bodyList = null;
    this.m_jointList = null;
    this.m_bodyCount = 0;
    this.m_jointCount = 0;
    this.m_warmStarting = true;
    this.m_continuousPhysics = true;
    this.m_subStepping = false;
    this.m_stepComplete = true;
    this.m_allowSleep = true;
    this.m_gravity.set(paramVec2);
    this.m_flags = 4;
    this.m_inv_dt0 = 0.0F;
    this.m_contactManager = new ContactManager(this, paramBroadPhaseStrategy);
    this.m_profile = new Profile();
    initializeRegisters();
  }
  
  private void addType(IDynamicStack<Contact> paramIDynamicStack, ShapeType paramShapeType1, ShapeType paramShapeType2)
  {
    ContactRegister localContactRegister = new ContactRegister();
    localContactRegister.creator = paramIDynamicStack;
    localContactRegister.primary = true;
    this.contactStacks[paramShapeType1.ordinal()][paramShapeType2.ordinal()] = localContactRegister;
    if (paramShapeType1 != paramShapeType2)
    {
      localContactRegister = new ContactRegister();
      localContactRegister.creator = paramIDynamicStack;
      localContactRegister.primary = false;
      this.contactStacks[paramShapeType2.ordinal()][paramShapeType1.ordinal()] = localContactRegister;
    }
  }
  
  private void drawJoint(Joint paramJoint)
  {
    Object localObject2 = paramJoint.getBodyA();
    Object localObject1 = paramJoint.getBodyB();
    localObject2 = ((Body)localObject2).getTransform();
    localObject1 = ((Body)localObject1).getTransform();
    Object localObject3 = ((Transform)localObject2).p;
    Vec2 localVec2 = ((Transform)localObject1).p;
    localObject1 = this.pool.popVec2();
    localObject2 = this.pool.popVec2();
    paramJoint.getAnchorA((Vec2)localObject1);
    paramJoint.getAnchorB((Vec2)localObject2);
    this.color.set(0.5F, 0.8F, 0.8F);
    int i = World.1.$SwitchMap$org$jbox2d$dynamics$joints$JointType[paramJoint.getType().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          this.m_debugDraw.drawSegment((Vec2)localObject3, (Vec2)localObject1, this.color);
          this.m_debugDraw.drawSegment((Vec2)localObject1, (Vec2)localObject2, this.color);
          this.m_debugDraw.drawSegment(localVec2, (Vec2)localObject2, this.color);
        }
      }
      else
      {
        localObject3 = (PulleyJoint)paramJoint;
        paramJoint = ((PulleyJoint)localObject3).getGroundAnchorA();
        localObject3 = ((PulleyJoint)localObject3).getGroundAnchorB();
        this.m_debugDraw.drawSegment(paramJoint, (Vec2)localObject1, this.color);
        this.m_debugDraw.drawSegment((Vec2)localObject3, (Vec2)localObject2, this.color);
        this.m_debugDraw.drawSegment(paramJoint, (Vec2)localObject3, this.color);
      }
    }
    else {
      this.m_debugDraw.drawSegment((Vec2)localObject1, (Vec2)localObject2, this.color);
    }
    this.pool.pushVec2(2);
  }
  
  private void drawShape(Fixture paramFixture, Transform paramTransform, Color3f paramColor3f)
  {
    int k = World.1.$SwitchMap$org$jbox2d$collision$shapes$ShapeType[paramFixture.getType().ordinal()];
    int i = 1;
    if (k != 1)
    {
      int j = 0;
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            return;
          }
          paramFixture = (ChainShape)paramFixture.getShape();
          j = paramFixture.m_count;
          paramFixture = paramFixture.m_vertices;
          Transform.mulToOutUnsafe(paramTransform, paramFixture[0], this.v1);
          while (i < j)
          {
            Transform.mulToOutUnsafe(paramTransform, paramFixture[i], this.v2);
            this.m_debugDraw.drawSegment(this.v1, this.v2, paramColor3f);
            this.m_debugDraw.drawCircle(this.v1, 0.05F, paramColor3f);
            this.v1.set(this.v2);
            i += 1;
          }
        }
        paramFixture = (EdgeShape)paramFixture.getShape();
        Transform.mulToOutUnsafe(paramTransform, paramFixture.m_vertex1, this.v1);
        Transform.mulToOutUnsafe(paramTransform, paramFixture.m_vertex2, this.v2);
        this.m_debugDraw.drawSegment(this.v1, this.v2, paramColor3f);
        return;
      }
      paramFixture = (PolygonShape)paramFixture.getShape();
      k = paramFixture.m_count;
      localObject = this.tlvertices.get(8);
      i = j;
      while (i < k)
      {
        Transform.mulToOutUnsafe(paramTransform, paramFixture.m_vertices[i], localObject[i]);
        i += 1;
      }
      this.m_debugDraw.drawSolidPolygon((Vec2[])localObject, k, paramColor3f);
      return;
    }
    Object localObject = (CircleShape)paramFixture.getShape();
    Transform.mulToOutUnsafe(paramTransform, ((CircleShape)localObject).m_p, this.center);
    float f1 = ((CircleShape)localObject).m_radius;
    paramTransform.q.getXAxis(this.axis);
    if ((paramFixture.getUserData() != null) && (paramFixture.getUserData().equals(LIQUID_INT)))
    {
      paramFixture = paramFixture.getBody();
      this.liquidOffset.set(paramFixture.m_linearVelocity);
      f1 = paramFixture.m_linearVelocity.length();
      float f2 = this.averageLinearVel;
      if (f2 == -1.0F) {
        this.averageLinearVel = f1;
      } else {
        this.averageLinearVel = (f2 * 0.98F + f1 * 0.02F);
      }
      this.liquidOffset.mulLocal(this.liquidLength / this.averageLinearVel / 2.0F);
      this.circCenterMoved.set(this.center).addLocal(this.liquidOffset);
      this.center.subLocal(this.liquidOffset);
      this.m_debugDraw.drawSegment(this.center, this.circCenterMoved, this.liquidColor);
      return;
    }
    this.m_debugDraw.drawSolidCircle(this.center, f1, this.axis, paramColor3f);
  }
  
  private void initializeRegisters()
  {
    addType(this.pool.getCircleContactStack(), ShapeType.CIRCLE, ShapeType.CIRCLE);
    addType(this.pool.getPolyCircleContactStack(), ShapeType.POLYGON, ShapeType.CIRCLE);
    addType(this.pool.getPolyContactStack(), ShapeType.POLYGON, ShapeType.POLYGON);
    addType(this.pool.getEdgeCircleContactStack(), ShapeType.EDGE, ShapeType.CIRCLE);
    addType(this.pool.getEdgePolyContactStack(), ShapeType.EDGE, ShapeType.POLYGON);
    addType(this.pool.getChainCircleContactStack(), ShapeType.CHAIN, ShapeType.CIRCLE);
    addType(this.pool.getChainPolyContactStack(), ShapeType.CHAIN, ShapeType.POLYGON);
  }
  
  private void solve(TimeStep paramTimeStep)
  {
    Object localObject1 = this.m_profile;
    ((Profile)localObject1).solveInit = 0.0F;
    ((Profile)localObject1).solveVelocity = 0.0F;
    ((Profile)localObject1).solvePosition = 0.0F;
    this.island.init(this.m_bodyCount, this.m_contactManager.m_contactCount, this.m_jointCount, this.m_contactManager.m_contactListener);
    for (localObject1 = this.m_bodyList; localObject1 != null; localObject1 = ((Body)localObject1).m_next) {
      ((Body)localObject1).m_flags &= 0xFFFFFFFE;
    }
    for (localObject1 = this.m_contactManager.m_contactList; localObject1 != null; localObject1 = ((Contact)localObject1).m_next) {
      ((Contact)localObject1).m_flags &= 0xFFFFFFFE;
    }
    for (localObject1 = this.m_jointList; localObject1 != null; localObject1 = ((Joint)localObject1).m_next) {
      ((Joint)localObject1).m_islandFlag = false;
    }
    int i = this.m_bodyCount;
    if (this.stack.length < i) {
      this.stack = new Body[i];
    }
    for (localObject1 = this.m_bodyList; localObject1 != null; localObject1 = ((Body)localObject1).m_next) {
      if (((((Body)localObject1).m_flags & 0x1) != 1) && (((Body)localObject1).isAwake()) && (((Body)localObject1).isActive()) && (((Body)localObject1).getType() != BodyType.STATIC))
      {
        this.island.clear();
        this.stack[0] = localObject1;
        ((Body)localObject1).m_flags |= 0x1;
        i = 1;
        while (i > 0)
        {
          localObject2 = this.stack;
          i -= 1;
          Body localBody = localObject2[i];
          this.island.add(localBody);
          localBody.setAwake(true);
          if (localBody.getType() != BodyType.STATIC)
          {
            localObject2 = localBody.m_contactList;
            while (localObject2 != null)
            {
              Object localObject3 = ((ContactEdge)localObject2).contact;
              if ((((Contact)localObject3).m_flags & 0x1) == 1)
              {
                j = i;
              }
              else
              {
                j = i;
                if (((Contact)localObject3).isEnabled()) {
                  if (!((Contact)localObject3).isTouching())
                  {
                    j = i;
                  }
                  else
                  {
                    boolean bool1 = ((Contact)localObject3).m_fixtureA.m_isSensor;
                    boolean bool2 = ((Contact)localObject3).m_fixtureB.m_isSensor;
                    j = i;
                    if (!bool1) {
                      if (bool2)
                      {
                        j = i;
                      }
                      else
                      {
                        this.island.add((Contact)localObject3);
                        ((Contact)localObject3).m_flags |= 0x1;
                        localObject3 = ((ContactEdge)localObject2).other;
                        if ((((Body)localObject3).m_flags & 0x1) == 1)
                        {
                          j = i;
                        }
                        else
                        {
                          this.stack[i] = localObject3;
                          ((Body)localObject3).m_flags |= 0x1;
                          j = i + 1;
                        }
                      }
                    }
                  }
                }
              }
              localObject2 = ((ContactEdge)localObject2).next;
              i = j;
            }
            localObject2 = localBody.m_jointList;
            int j = i;
            for (;;)
            {
              i = j;
              if (localObject2 == null) {
                break;
              }
              if (((JointEdge)localObject2).joint.m_islandFlag != true)
              {
                localBody = ((JointEdge)localObject2).other;
                if (localBody.isActive())
                {
                  this.island.add(((JointEdge)localObject2).joint);
                  ((JointEdge)localObject2).joint.m_islandFlag = true;
                  if ((localBody.m_flags & 0x1) != 1)
                  {
                    this.stack[j] = localBody;
                    localBody.m_flags |= 0x1;
                    j += 1;
                  }
                }
              }
              localObject2 = ((JointEdge)localObject2).next;
            }
          }
        }
        this.island.solve(this.islandProfile, paramTimeStep, this.m_gravity, this.m_allowSleep);
        Object localObject2 = this.m_profile;
        ((Profile)localObject2).solveInit += this.islandProfile.solveInit;
        localObject2 = this.m_profile;
        ((Profile)localObject2).solveVelocity += this.islandProfile.solveVelocity;
        localObject2 = this.m_profile;
        ((Profile)localObject2).solvePosition += this.islandProfile.solvePosition;
        i = 0;
        while (i < this.island.m_bodyCount)
        {
          localObject2 = this.island.m_bodies[i];
          if (((Body)localObject2).getType() == BodyType.STATIC) {
            ((Body)localObject2).m_flags &= 0xFFFFFFFE;
          }
          i += 1;
        }
      }
    }
    this.broadphaseTimer.reset();
    for (paramTimeStep = this.m_bodyList; paramTimeStep != null; paramTimeStep = paramTimeStep.getNext()) {
      if (((paramTimeStep.m_flags & 0x1) != 0) && (paramTimeStep.getType() != BodyType.STATIC)) {
        paramTimeStep.synchronizeFixtures();
      }
    }
    this.m_contactManager.findNewContacts();
    this.m_profile.broadphase = this.broadphaseTimer.getMilliseconds();
  }
  
  private void solveTOI(TimeStep paramTimeStep)
  {
    Island localIsland = this.toiIsland;
    localIsland.init(64, 32, 0, this.m_contactManager.m_contactListener);
    Object localObject1;
    if (this.m_stepComplete)
    {
      for (localObject1 = this.m_bodyList; localObject1 != null; localObject1 = ((Body)localObject1).m_next)
      {
        ((Body)localObject1).m_flags &= 0xFFFFFFFE;
        ((Body)localObject1).m_sweep.alpha0 = 0.0F;
      }
      for (localObject1 = this.m_contactManager.m_contactList; localObject1 != null; localObject1 = ((Contact)localObject1).m_next)
      {
        ((Contact)localObject1).m_flags &= 0xFFFFFFDE;
        ((Contact)localObject1).m_toiCount = 0.0F;
        ((Contact)localObject1).m_toi = 1.0F;
      }
    }
    for (;;)
    {
      Object localObject2 = null;
      localObject1 = this.m_contactManager.m_contactList;
      float f3;
      Object localObject5;
      Body localBody;
      int i;
      for (float f2 = 1.0F; localObject1 != null; f2 = f3)
      {
        if (!((Contact)localObject1).isEnabled()) {}
        do
        {
          BodyType localBodyType;
          do
          {
            do
            {
              do
              {
                f3 = f2;
                break;
              } while (((Contact)localObject1).m_toiCount > 8.0F);
              if ((((Contact)localObject1).m_flags & 0x20) != 0)
              {
                f1 = ((Contact)localObject1).m_toi;
                break;
              }
              localObject3 = ((Contact)localObject1).getFixtureA();
              localObject4 = ((Contact)localObject1).getFixtureB();
            } while ((((Fixture)localObject3).isSensor()) || (((Fixture)localObject4).isSensor()));
            localObject5 = ((Fixture)localObject3).getBody();
            localBody = ((Fixture)localObject4).getBody();
            localObject6 = ((Body)localObject5).m_type;
            localBodyType = localBody.m_type;
            if ((((Body)localObject5).isAwake()) && (localObject6 != BodyType.STATIC)) {
              i = 1;
            } else {
              i = 0;
            }
            if ((localBody.isAwake()) && (localBodyType != BodyType.STATIC)) {
              j = 1;
            } else {
              j = 0;
            }
          } while ((i == 0) && (j == 0));
          if ((!((Body)localObject5).isBullet()) && (localObject6 == BodyType.DYNAMIC)) {
            i = 0;
          } else {
            i = 1;
          }
          if ((!localBody.isBullet()) && (localBodyType == BodyType.DYNAMIC)) {
            j = 0;
          } else {
            j = 1;
          }
        } while ((i == 0) && (j == 0));
        float f1 = ((Body)localObject5).m_sweep.alpha0;
        if (((Body)localObject5).m_sweep.alpha0 < localBody.m_sweep.alpha0)
        {
          f1 = localBody.m_sweep.alpha0;
          ((Body)localObject5).m_sweep.advance(f1);
        }
        else if (localBody.m_sweep.alpha0 < ((Body)localObject5).m_sweep.alpha0)
        {
          f1 = ((Body)localObject5).m_sweep.alpha0;
          localBody.m_sweep.advance(f1);
        }
        i = ((Contact)localObject1).getChildIndexA();
        int j = ((Contact)localObject1).getChildIndexB();
        Object localObject6 = this.toiInput;
        ((TimeOfImpact.TOIInput)localObject6).proxyA.set(((Fixture)localObject3).getShape(), i);
        ((TimeOfImpact.TOIInput)localObject6).proxyB.set(((Fixture)localObject4).getShape(), j);
        ((TimeOfImpact.TOIInput)localObject6).sweepA.set(((Body)localObject5).m_sweep);
        ((TimeOfImpact.TOIInput)localObject6).sweepB.set(localBody.m_sweep);
        ((TimeOfImpact.TOIInput)localObject6).tMax = 1.0F;
        this.pool.getTimeOfImpact().timeOfImpact(this.toiOutput, (TimeOfImpact.TOIInput)localObject6);
        f3 = this.toiOutput.t;
        if (this.toiOutput.state == TimeOfImpact.TOIOutputState.TOUCHING) {
          f1 = MathUtils.min(f1 + (1.0F - f1) * f3, 1.0F);
        } else {
          f1 = 1.0F;
        }
        ((Contact)localObject1).m_toi = f1;
        ((Contact)localObject1).m_flags |= 0x20;
        f3 = f2;
        if (f1 < f2)
        {
          localObject2 = localObject1;
          f3 = f1;
        }
        localObject1 = ((Contact)localObject1).m_next;
      }
      if ((localObject2 == null) || (0.9999988F < f2)) {
        break;
      }
      Object localObject3 = ((Contact)localObject2).getFixtureA();
      localObject1 = ((Contact)localObject2).getFixtureB();
      localObject3 = ((Fixture)localObject3).getBody();
      Object localObject4 = ((Fixture)localObject1).getBody();
      this.backup1.set(((Body)localObject3).m_sweep);
      this.backup2.set(((Body)localObject4).m_sweep);
      ((Body)localObject3).advance(f2);
      ((Body)localObject4).advance(f2);
      ((Contact)localObject2).update(this.m_contactManager.m_contactListener);
      ((Contact)localObject2).m_flags &= 0xFFFFFFDF;
      ((Contact)localObject2).m_toiCount += 1.0F;
      if ((((Contact)localObject2).isEnabled()) && (((Contact)localObject2).isTouching()))
      {
        ((Body)localObject3).setAwake(true);
        ((Body)localObject4).setAwake(true);
        localIsland.clear();
        localIsland.add((Body)localObject3);
        localIsland.add((Body)localObject4);
        localIsland.add((Contact)localObject2);
        ((Body)localObject3).m_flags |= 0x1;
        ((Body)localObject4).m_flags |= 0x1;
        ((Contact)localObject2).m_flags |= 0x1;
        localObject1 = this.tempBodies;
        localObject1[0] = localObject3;
        localObject1[1] = localObject4;
        i = 0;
        while (i < 2)
        {
          localObject2 = this.tempBodies[i];
          if (((Body)localObject2).m_type == BodyType.DYNAMIC) {
            for (localObject1 = ((Body)localObject2).m_contactList; (localObject1 != null) && (localIsland.m_bodyCount != localIsland.m_bodyCapacity) && (localIsland.m_contactCount != localIsland.m_contactCapacity); localObject1 = ((ContactEdge)localObject1).next)
            {
              localObject5 = ((ContactEdge)localObject1).contact;
              if ((((Contact)localObject5).m_flags & 0x1) == 0)
              {
                localBody = ((ContactEdge)localObject1).other;
                if ((localBody.m_type != BodyType.DYNAMIC) || (((Body)localObject2).isBullet()) || (localBody.isBullet()))
                {
                  boolean bool1 = ((Contact)localObject5).m_fixtureA.m_isSensor;
                  boolean bool2 = ((Contact)localObject5).m_fixtureB.m_isSensor;
                  if ((!bool1) && (!bool2))
                  {
                    this.backup1.set(localBody.m_sweep);
                    if ((localBody.m_flags & 0x1) == 0) {
                      localBody.advance(f2);
                    }
                    ((Contact)localObject5).update(this.m_contactManager.m_contactListener);
                    if (!((Contact)localObject5).isEnabled())
                    {
                      localBody.m_sweep.set(this.backup1);
                      localBody.synchronizeTransform();
                    }
                    else if (!((Contact)localObject5).isTouching())
                    {
                      localBody.m_sweep.set(this.backup1);
                      localBody.synchronizeTransform();
                    }
                    else
                    {
                      ((Contact)localObject5).m_flags |= 0x1;
                      localIsland.add((Contact)localObject5);
                      if ((localBody.m_flags & 0x1) == 0)
                      {
                        localBody.m_flags |= 0x1;
                        if (localBody.m_type != BodyType.STATIC) {
                          localBody.setAwake(true);
                        }
                        localIsland.add(localBody);
                      }
                    }
                  }
                }
              }
            }
          }
          i += 1;
        }
        this.subStep.dt = ((1.0F - f2) * paramTimeStep.dt);
        localObject1 = this.subStep;
        ((TimeStep)localObject1).inv_dt = (1.0F / ((TimeStep)localObject1).dt);
        localObject1 = this.subStep;
        ((TimeStep)localObject1).dtRatio = 1.0F;
        ((TimeStep)localObject1).positionIterations = 20;
        ((TimeStep)localObject1).velocityIterations = paramTimeStep.velocityIterations;
        localObject1 = this.subStep;
        ((TimeStep)localObject1).warmStarting = false;
        localIsland.solveTOI((TimeStep)localObject1, ((Body)localObject3).m_islandIndex, ((Body)localObject4).m_islandIndex);
        i = 0;
        while (i < localIsland.m_bodyCount)
        {
          localObject1 = localIsland.m_bodies[i];
          ((Body)localObject1).m_flags &= 0xFFFFFFFE;
          if (((Body)localObject1).m_type == BodyType.DYNAMIC)
          {
            ((Body)localObject1).synchronizeFixtures();
            for (localObject1 = ((Body)localObject1).m_contactList; localObject1 != null; localObject1 = ((ContactEdge)localObject1).next)
            {
              localObject2 = ((ContactEdge)localObject1).contact;
              ((Contact)localObject2).m_flags &= 0xFFFFFFDE;
            }
          }
          i += 1;
        }
        this.m_contactManager.findNewContacts();
        if (this.m_subStepping) {
          this.m_stepComplete = false;
        }
      }
      else
      {
        ((Contact)localObject2).setEnabled(false);
        ((Body)localObject3).m_sweep.set(this.backup1);
        ((Body)localObject4).m_sweep.set(this.backup2);
        ((Body)localObject3).synchronizeTransform();
        ((Body)localObject4).synchronizeTransform();
      }
    }
    this.m_stepComplete = true;
  }
  
  public void clearForces()
  {
    for (Body localBody = this.m_bodyList; localBody != null; localBody = localBody.getNext())
    {
      localBody.m_force.setZero();
      localBody.m_torque = 0.0F;
    }
  }
  
  public Body createBody(BodyDef paramBodyDef)
  {
    if (isLocked()) {
      return null;
    }
    paramBodyDef = new Body(paramBodyDef, this);
    paramBodyDef.m_prev = null;
    Body localBody = this.m_bodyList;
    paramBodyDef.m_next = localBody;
    if (localBody != null) {
      localBody.m_prev = paramBodyDef;
    }
    this.m_bodyList = paramBodyDef;
    this.m_bodyCount += 1;
    return paramBodyDef;
  }
  
  public Joint createJoint(JointDef paramJointDef)
  {
    if (isLocked()) {
      return null;
    }
    Joint localJoint = Joint.create(this, paramJointDef);
    localJoint.m_prev = null;
    Object localObject = this.m_jointList;
    localJoint.m_next = ((Joint)localObject);
    if (localObject != null) {
      ((Joint)localObject).m_prev = localJoint;
    }
    this.m_jointList = localJoint;
    this.m_jointCount += 1;
    localJoint.m_edgeA.joint = localJoint;
    localJoint.m_edgeA.other = localJoint.getBodyB();
    localJoint.m_edgeA.prev = null;
    localJoint.m_edgeA.next = localJoint.getBodyA().m_jointList;
    if (localJoint.getBodyA().m_jointList != null) {
      localJoint.getBodyA().m_jointList.prev = localJoint.m_edgeA;
    }
    localJoint.getBodyA().m_jointList = localJoint.m_edgeA;
    localJoint.m_edgeB.joint = localJoint;
    localJoint.m_edgeB.other = localJoint.getBodyA();
    localJoint.m_edgeB.prev = null;
    localJoint.m_edgeB.next = localJoint.getBodyB().m_jointList;
    if (localJoint.getBodyB().m_jointList != null) {
      localJoint.getBodyB().m_jointList.prev = localJoint.m_edgeB;
    }
    localJoint.getBodyB().m_jointList = localJoint.m_edgeB;
    localObject = paramJointDef.bodyA;
    Body localBody = paramJointDef.bodyB;
    if (!paramJointDef.collideConnected) {
      for (paramJointDef = localBody.getContactList(); paramJointDef != null; paramJointDef = paramJointDef.next) {
        if (paramJointDef.other == localObject) {
          paramJointDef.contact.flagForFiltering();
        }
      }
    }
    return localJoint;
  }
  
  public void destroyBody(Body paramBody)
  {
    if (isLocked()) {
      return;
    }
    Object localObject2;
    DestructionListener localDestructionListener;
    for (Object localObject1 = paramBody.m_jointList; localObject1 != null; localObject1 = localObject2)
    {
      localObject2 = ((JointEdge)localObject1).next;
      localDestructionListener = this.m_destructionListener;
      if (localDestructionListener != null) {
        localDestructionListener.sayGoodbye(((JointEdge)localObject1).joint);
      }
      destroyJoint(((JointEdge)localObject1).joint);
      paramBody.m_jointList = ((JointEdge)localObject2);
    }
    paramBody.m_jointList = null;
    for (localObject1 = paramBody.m_contactList; localObject1 != null; localObject1 = localObject2)
    {
      localObject2 = ((ContactEdge)localObject1).next;
      this.m_contactManager.destroy(((ContactEdge)localObject1).contact);
    }
    paramBody.m_contactList = null;
    for (localObject1 = paramBody.m_fixtureList; localObject1 != null; localObject1 = localObject2)
    {
      localObject2 = ((Fixture)localObject1).m_next;
      localDestructionListener = this.m_destructionListener;
      if (localDestructionListener != null) {
        localDestructionListener.sayGoodbye((Fixture)localObject1);
      }
      ((Fixture)localObject1).destroyProxies(this.m_contactManager.m_broadPhase);
      ((Fixture)localObject1).destroy();
      paramBody.m_fixtureList = ((Fixture)localObject2);
      paramBody.m_fixtureCount -= 1;
    }
    paramBody.m_fixtureList = null;
    paramBody.m_fixtureCount = 0;
    if (paramBody.m_prev != null) {
      paramBody.m_prev.m_next = paramBody.m_next;
    }
    if (paramBody.m_next != null) {
      paramBody.m_next.m_prev = paramBody.m_prev;
    }
    if (paramBody == this.m_bodyList) {
      this.m_bodyList = paramBody.m_next;
    }
    this.m_bodyCount -= 1;
  }
  
  public void destroyJoint(Joint paramJoint)
  {
    if (isLocked()) {
      return;
    }
    boolean bool = paramJoint.getCollideConnected();
    if (paramJoint.m_prev != null) {
      paramJoint.m_prev.m_next = paramJoint.m_next;
    }
    if (paramJoint.m_next != null) {
      paramJoint.m_next.m_prev = paramJoint.m_prev;
    }
    if (paramJoint == this.m_jointList) {
      this.m_jointList = paramJoint.m_next;
    }
    Body localBody1 = paramJoint.getBodyA();
    Body localBody2 = paramJoint.getBodyB();
    localBody1.setAwake(true);
    localBody2.setAwake(true);
    if (paramJoint.m_edgeA.prev != null) {
      paramJoint.m_edgeA.prev.next = paramJoint.m_edgeA.next;
    }
    if (paramJoint.m_edgeA.next != null) {
      paramJoint.m_edgeA.next.prev = paramJoint.m_edgeA.prev;
    }
    if (paramJoint.m_edgeA == localBody1.m_jointList) {
      localBody1.m_jointList = paramJoint.m_edgeA.next;
    }
    paramJoint.m_edgeA.prev = null;
    paramJoint.m_edgeA.next = null;
    if (paramJoint.m_edgeB.prev != null) {
      paramJoint.m_edgeB.prev.next = paramJoint.m_edgeB.next;
    }
    if (paramJoint.m_edgeB.next != null) {
      paramJoint.m_edgeB.next.prev = paramJoint.m_edgeB.prev;
    }
    if (paramJoint.m_edgeB == localBody2.m_jointList) {
      localBody2.m_jointList = paramJoint.m_edgeB.next;
    }
    paramJoint.m_edgeB.prev = null;
    paramJoint.m_edgeB.next = null;
    Joint.destroy(paramJoint);
    this.m_jointCount -= 1;
    if (!bool) {
      for (paramJoint = localBody2.getContactList(); paramJoint != null; paramJoint = paramJoint.next) {
        if (paramJoint.other == localBody1) {
          paramJoint.contact.flagForFiltering();
        }
      }
    }
  }
  
  public void drawDebugData()
  {
    Object localObject1 = this.m_debugDraw;
    if (localObject1 == null) {
      return;
    }
    int j = ((DebugDraw)localObject1).getFlags();
    Fixture localFixture;
    if ((j & 0x1) == 1) {
      for (localObject1 = this.m_bodyList; localObject1 != null; localObject1 = ((Body)localObject1).getNext())
      {
        this.xf.set(((Body)localObject1).getTransform());
        for (localFixture = ((Body)localObject1).getFixtureList(); localFixture != null; localFixture = localFixture.getNext()) {
          if (!((Body)localObject1).isActive())
          {
            this.color.set(0.5F, 0.5F, 0.3F);
            drawShape(localFixture, this.xf, this.color);
          }
          else if (((Body)localObject1).getType() == BodyType.STATIC)
          {
            this.color.set(0.5F, 0.9F, 0.3F);
            drawShape(localFixture, this.xf, this.color);
          }
          else if (((Body)localObject1).getType() == BodyType.KINEMATIC)
          {
            this.color.set(0.5F, 0.5F, 0.9F);
            drawShape(localFixture, this.xf, this.color);
          }
          else if (!((Body)localObject1).isAwake())
          {
            this.color.set(0.5F, 0.5F, 0.5F);
            drawShape(localFixture, this.xf, this.color);
          }
          else
          {
            this.color.set(0.9F, 0.7F, 0.7F);
            drawShape(localFixture, this.xf, this.color);
          }
        }
      }
    }
    if ((j & 0x2) == 2) {
      for (localObject1 = this.m_jointList; localObject1 != null; localObject1 = ((Joint)localObject1).getNext()) {
        drawJoint((Joint)localObject1);
      }
    }
    Object localObject2;
    if ((j & 0x8) == 8)
    {
      this.color.set(0.3F, 0.9F, 0.9F);
      for (localObject1 = this.m_contactManager.m_contactList; localObject1 != null; localObject1 = ((Contact)localObject1).getNext())
      {
        localFixture = ((Contact)localObject1).getFixtureA();
        localObject2 = ((Contact)localObject1).getFixtureB();
        localFixture.getAABB(((Contact)localObject1).getChildIndexA()).getCenterToOut(this.cA);
        ((Fixture)localObject2).getAABB(((Contact)localObject1).getChildIndexB()).getCenterToOut(this.cB);
        this.m_debugDraw.drawSegment(this.cA, this.cB, this.color);
      }
    }
    if ((j & 0x4) == 4)
    {
      this.color.set(0.9F, 0.3F, 0.9F);
      for (localObject1 = this.m_bodyList; localObject1 != null; localObject1 = ((Body)localObject1).getNext()) {
        if (((Body)localObject1).isActive()) {
          for (localFixture = ((Body)localObject1).getFixtureList(); localFixture != null; localFixture = localFixture.getNext())
          {
            int i = 0;
            while (i < localFixture.m_proxyCount)
            {
              localObject2 = localFixture.m_proxies[i];
              localObject2 = this.m_contactManager.m_broadPhase.getFatAABB(((FixtureProxy)localObject2).proxyId);
              Vec2[] arrayOfVec2 = this.avs.get(4);
              arrayOfVec2[0].set(((AABB)localObject2).lowerBound.x, ((AABB)localObject2).lowerBound.y);
              arrayOfVec2[1].set(((AABB)localObject2).upperBound.x, ((AABB)localObject2).lowerBound.y);
              arrayOfVec2[2].set(((AABB)localObject2).upperBound.x, ((AABB)localObject2).upperBound.y);
              arrayOfVec2[3].set(((AABB)localObject2).lowerBound.x, ((AABB)localObject2).upperBound.y);
              this.m_debugDraw.drawPolygon(arrayOfVec2, 4, this.color);
              i += 1;
            }
          }
        }
      }
    }
    if ((j & 0x10) == 16) {
      for (localObject1 = this.m_bodyList; localObject1 != null; localObject1 = ((Body)localObject1).getNext())
      {
        this.xf.set(((Body)localObject1).getTransform());
        this.xf.p.set(((Body)localObject1).getWorldCenter());
        this.m_debugDraw.drawTransform(this.xf);
      }
    }
    if ((j & 0x20) == 32) {
      this.m_contactManager.m_broadPhase.drawTree(this.m_debugDraw);
    }
  }
  
  public boolean getAutoClearForces()
  {
    return (this.m_flags & 0x4) == 4;
  }
  
  public int getBodyCount()
  {
    return this.m_bodyCount;
  }
  
  public Body getBodyList()
  {
    return this.m_bodyList;
  }
  
  public int getContactCount()
  {
    return this.m_contactManager.m_contactCount;
  }
  
  public Contact getContactList()
  {
    return this.m_contactManager.m_contactList;
  }
  
  public ContactManager getContactManager()
  {
    return this.m_contactManager;
  }
  
  public Vec2 getGravity()
  {
    return this.m_gravity;
  }
  
  public int getJointCount()
  {
    return this.m_jointCount;
  }
  
  public Joint getJointList()
  {
    return this.m_jointList;
  }
  
  public IWorldPool getPool()
  {
    return this.pool;
  }
  
  public Profile getProfile()
  {
    return this.m_profile;
  }
  
  public int getProxyCount()
  {
    return this.m_contactManager.m_broadPhase.getProxyCount();
  }
  
  public int getTreeBalance()
  {
    return this.m_contactManager.m_broadPhase.getTreeBalance();
  }
  
  public int getTreeHeight()
  {
    return this.m_contactManager.m_broadPhase.getTreeHeight();
  }
  
  public float getTreeQuality()
  {
    return this.m_contactManager.m_broadPhase.getTreeQuality();
  }
  
  public boolean isAllowSleep()
  {
    return this.m_allowSleep;
  }
  
  public boolean isContinuousPhysics()
  {
    return this.m_continuousPhysics;
  }
  
  public boolean isLocked()
  {
    return (this.m_flags & 0x2) == 2;
  }
  
  public boolean isSleepingAllowed()
  {
    return this.m_allowSleep;
  }
  
  public boolean isSubStepping()
  {
    return this.m_subStepping;
  }
  
  public boolean isWarmStarting()
  {
    return this.m_warmStarting;
  }
  
  public Contact popContact(Fixture paramFixture1, int paramInt1, Fixture paramFixture2, int paramInt2)
  {
    Object localObject1 = paramFixture1.getType();
    Object localObject2 = paramFixture2.getType();
    localObject1 = this.contactStacks[localObject1.ordinal()][localObject2.ordinal()];
    localObject2 = ((ContactRegister)localObject1).creator;
    if (localObject2 != null)
    {
      if (((ContactRegister)localObject1).primary)
      {
        localObject1 = (Contact)((IDynamicStack)localObject2).pop();
        ((Contact)localObject1).init(paramFixture1, paramInt1, paramFixture2, paramInt2);
        return localObject1;
      }
      localObject1 = (Contact)((IDynamicStack)localObject2).pop();
      ((Contact)localObject1).init(paramFixture2, paramInt2, paramFixture1, paramInt1);
      return localObject1;
    }
    return null;
  }
  
  public void pushContact(Contact paramContact)
  {
    Object localObject2 = paramContact.getFixtureA();
    Object localObject1 = paramContact.getFixtureB();
    if ((paramContact.m_manifold.pointCount > 0) && (!((Fixture)localObject2).isSensor()) && (!((Fixture)localObject1).isSensor()))
    {
      ((Fixture)localObject2).getBody().setAwake(true);
      ((Fixture)localObject1).getBody().setAwake(true);
    }
    localObject2 = ((Fixture)localObject2).getType();
    localObject1 = ((Fixture)localObject1).getType();
    this.contactStacks[localObject2.ordinal()][localObject1.ordinal()].creator.push(paramContact);
  }
  
  public void queryAABB(QueryCallback paramQueryCallback, AABB paramAABB)
  {
    this.wqwrapper.broadPhase = this.m_contactManager.m_broadPhase;
    this.wqwrapper.callback = paramQueryCallback;
    this.m_contactManager.m_broadPhase.query(this.wqwrapper, paramAABB);
  }
  
  public void raycast(RayCastCallback paramRayCastCallback, Vec2 paramVec21, Vec2 paramVec22)
  {
    this.wrcwrapper.broadPhase = this.m_contactManager.m_broadPhase;
    this.wrcwrapper.callback = paramRayCastCallback;
    paramRayCastCallback = this.input;
    paramRayCastCallback.maxFraction = 1.0F;
    paramRayCastCallback.p1.set(paramVec21);
    this.input.p2.set(paramVec22);
    this.m_contactManager.m_broadPhase.raycast(this.wrcwrapper, this.input);
  }
  
  public void setAllowSleep(boolean paramBoolean)
  {
    if (paramBoolean == this.m_allowSleep) {
      return;
    }
    this.m_allowSleep = paramBoolean;
    if (!this.m_allowSleep) {
      for (Body localBody = this.m_bodyList; localBody != null; localBody = localBody.m_next) {
        localBody.setAwake(true);
      }
    }
  }
  
  public void setAutoClearForces(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m_flags |= 0x4;
      return;
    }
    this.m_flags &= 0xFFFFFFFB;
  }
  
  public void setContactFilter(ContactFilter paramContactFilter)
  {
    this.m_contactManager.m_contactFilter = paramContactFilter;
  }
  
  public void setContactListener(ContactListener paramContactListener)
  {
    this.m_contactManager.m_contactListener = paramContactListener;
  }
  
  public void setContinuousPhysics(boolean paramBoolean)
  {
    this.m_continuousPhysics = paramBoolean;
  }
  
  public void setDebugDraw(DebugDraw paramDebugDraw)
  {
    this.m_debugDraw = paramDebugDraw;
  }
  
  public void setDestructionListener(DestructionListener paramDestructionListener)
  {
    this.m_destructionListener = paramDestructionListener;
  }
  
  public void setGravity(Vec2 paramVec2)
  {
    this.m_gravity.set(paramVec2);
  }
  
  public void setSleepingAllowed(boolean paramBoolean)
  {
    this.m_allowSleep = paramBoolean;
  }
  
  public void setSubStepping(boolean paramBoolean)
  {
    this.m_subStepping = paramBoolean;
  }
  
  public void setWarmStarting(boolean paramBoolean)
  {
    this.m_warmStarting = paramBoolean;
  }
  
  public void step(float paramFloat, int paramInt1, int paramInt2)
  {
    this.stepTimer.reset();
    if ((this.m_flags & 0x1) == 1)
    {
      this.m_contactManager.findNewContacts();
      this.m_flags &= 0xFFFFFFFE;
    }
    this.m_flags |= 0x2;
    TimeStep localTimeStep = this.step;
    localTimeStep.dt = paramFloat;
    localTimeStep.velocityIterations = paramInt1;
    localTimeStep.positionIterations = paramInt2;
    if (paramFloat > 0.0F) {
      localTimeStep.inv_dt = (1.0F / paramFloat);
    } else {
      localTimeStep.inv_dt = 0.0F;
    }
    localTimeStep = this.step;
    localTimeStep.dtRatio = (this.m_inv_dt0 * paramFloat);
    localTimeStep.warmStarting = this.m_warmStarting;
    this.tempTimer.reset();
    this.m_contactManager.collide();
    this.m_profile.collide = this.tempTimer.getMilliseconds();
    if ((this.m_stepComplete) && (this.step.dt > 0.0F))
    {
      this.tempTimer.reset();
      solve(this.step);
      this.m_profile.solve = this.tempTimer.getMilliseconds();
    }
    if ((this.m_continuousPhysics) && (this.step.dt > 0.0F))
    {
      this.tempTimer.reset();
      solveTOI(this.step);
      this.m_profile.solveTOI = this.tempTimer.getMilliseconds();
    }
    if (this.step.dt > 0.0F) {
      this.m_inv_dt0 = this.step.inv_dt;
    }
    if ((this.m_flags & 0x4) == 4) {
      clearForces();
    }
    this.m_flags &= 0xFFFFFFFD;
    this.m_profile.step = this.stepTimer.getMilliseconds();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.World
 * JD-Core Version:    0.7.0.1
 */