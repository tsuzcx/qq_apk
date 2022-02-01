package org.jbox2d.dynamics;

import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.collision.shapes.MassData;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactEdge;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.JointEdge;
import org.jbox2d.pooling.IWorldPool;

public class Body
{
  public static final int e_activeFlag = 32;
  public static final int e_autoSleepFlag = 4;
  public static final int e_awakeFlag = 2;
  public static final int e_bulletFlag = 8;
  public static final int e_fixedRotationFlag = 16;
  public static final int e_islandFlag = 1;
  public static final int e_toiFlag = 64;
  private final FixtureDef fixDef = new FixtureDef();
  public float m_I;
  public float m_angularDamping;
  public float m_angularVelocity = 0.0F;
  public ContactEdge m_contactList;
  public int m_fixtureCount;
  public Fixture m_fixtureList;
  public int m_flags = 0;
  public final Vec2 m_force = new Vec2();
  public float m_gravityScale;
  public float m_invI;
  public float m_invMass;
  public int m_islandIndex;
  public JointEdge m_jointList;
  public float m_linearDamping;
  public final Vec2 m_linearVelocity = new Vec2();
  public float m_mass;
  public Body m_next;
  public Body m_prev;
  public float m_sleepTime;
  public final Sweep m_sweep = new Sweep();
  public float m_torque = 0.0F;
  public BodyType m_type;
  public Object m_userData;
  public World m_world;
  public final Transform m_xf = new Transform();
  private final MassData pmd = new MassData();
  private final Transform pxf = new Transform();
  
  public Body(BodyDef paramBodyDef, World paramWorld)
  {
    if (paramBodyDef.bullet) {
      this.m_flags |= 0x8;
    }
    if (paramBodyDef.fixedRotation) {
      this.m_flags |= 0x10;
    }
    if (paramBodyDef.allowSleep) {
      this.m_flags |= 0x4;
    }
    if (paramBodyDef.awake) {
      this.m_flags |= 0x2;
    }
    if (paramBodyDef.active) {
      this.m_flags |= 0x20;
    }
    this.m_world = paramWorld;
    this.m_xf.p.set(paramBodyDef.position);
    this.m_xf.q.set(paramBodyDef.angle);
    this.m_sweep.localCenter.setZero();
    this.m_sweep.c0.set(this.m_xf.p);
    this.m_sweep.c.set(this.m_xf.p);
    this.m_sweep.a0 = paramBodyDef.angle;
    this.m_sweep.a = paramBodyDef.angle;
    this.m_sweep.alpha0 = 0.0F;
    this.m_jointList = null;
    this.m_contactList = null;
    this.m_prev = null;
    this.m_next = null;
    this.m_linearVelocity.set(paramBodyDef.linearVelocity);
    this.m_angularVelocity = paramBodyDef.angularVelocity;
    this.m_linearDamping = paramBodyDef.linearDamping;
    this.m_angularDamping = paramBodyDef.angularDamping;
    this.m_gravityScale = paramBodyDef.gravityScale;
    this.m_force.setZero();
    this.m_torque = 0.0F;
    this.m_sleepTime = 0.0F;
    this.m_type = paramBodyDef.type;
    if (this.m_type == BodyType.DYNAMIC)
    {
      this.m_mass = 1.0F;
      this.m_invMass = 1.0F;
    }
    else
    {
      this.m_mass = 0.0F;
      this.m_invMass = 0.0F;
    }
    this.m_I = 0.0F;
    this.m_invI = 0.0F;
    this.m_userData = paramBodyDef.userData;
    this.m_fixtureList = null;
    this.m_fixtureCount = 0;
  }
  
  protected final void advance(float paramFloat)
  {
    this.m_sweep.advance(paramFloat);
    this.m_sweep.c.set(this.m_sweep.c0);
    Sweep localSweep = this.m_sweep;
    localSweep.a = localSweep.a0;
    this.m_xf.q.set(this.m_sweep.a);
    Rot.mulToOutUnsafe(this.m_xf.q, this.m_sweep.localCenter, this.m_xf.p);
    this.m_xf.p.mulLocal(-1.0F).addLocal(this.m_sweep.c);
  }
  
  public void applyAngularImpulse(float paramFloat)
  {
    if (this.m_type != BodyType.DYNAMIC) {
      return;
    }
    if (!isAwake()) {
      setAwake(true);
    }
    this.m_angularVelocity += this.m_invI * paramFloat;
  }
  
  public final void applyForce(Vec2 paramVec21, Vec2 paramVec22)
  {
    if (this.m_type != BodyType.DYNAMIC) {
      return;
    }
    if (!isAwake()) {
      setAwake(true);
    }
    Vec2 localVec2 = this.m_force;
    localVec2.x += paramVec21.x;
    localVec2 = this.m_force;
    localVec2.y += paramVec21.y;
    this.m_torque += (paramVec22.x - this.m_sweep.c.x) * paramVec21.y - (paramVec22.y - this.m_sweep.c.y) * paramVec21.x;
  }
  
  public final void applyForceToCenter(Vec2 paramVec2)
  {
    if (this.m_type != BodyType.DYNAMIC) {
      return;
    }
    if (!isAwake()) {
      setAwake(true);
    }
    Vec2 localVec2 = this.m_force;
    localVec2.x += paramVec2.x;
    localVec2 = this.m_force;
    localVec2.y += paramVec2.y;
  }
  
  public final void applyLinearImpulse(Vec2 paramVec21, Vec2 paramVec22)
  {
    if (this.m_type != BodyType.DYNAMIC) {
      return;
    }
    if (!isAwake()) {
      setAwake(true);
    }
    Vec2 localVec2 = this.m_linearVelocity;
    localVec2.x += paramVec21.x * this.m_invMass;
    localVec2 = this.m_linearVelocity;
    localVec2.y += paramVec21.y * this.m_invMass;
    this.m_angularVelocity += this.m_invI * ((paramVec22.x - this.m_sweep.c.x) * paramVec21.y - (paramVec22.y - this.m_sweep.c.y) * paramVec21.x);
  }
  
  public final void applyTorque(float paramFloat)
  {
    if (this.m_type != BodyType.DYNAMIC) {
      return;
    }
    if (!isAwake()) {
      setAwake(true);
    }
    this.m_torque += paramFloat;
  }
  
  public final Fixture createFixture(Shape paramShape, float paramFloat)
  {
    FixtureDef localFixtureDef = this.fixDef;
    localFixtureDef.shape = paramShape;
    localFixtureDef.density = paramFloat;
    return createFixture(localFixtureDef);
  }
  
  public final Fixture createFixture(FixtureDef paramFixtureDef)
  {
    if (this.m_world.isLocked() == true) {
      return null;
    }
    Fixture localFixture = new Fixture();
    localFixture.create(this, paramFixtureDef);
    if ((this.m_flags & 0x20) == 32) {
      localFixture.createProxies(this.m_world.m_contactManager.m_broadPhase, this.m_xf);
    }
    localFixture.m_next = this.m_fixtureList;
    this.m_fixtureList = localFixture;
    this.m_fixtureCount += 1;
    localFixture.m_body = this;
    if (localFixture.m_density > 0.0F) {
      resetMassData();
    }
    paramFixtureDef = this.m_world;
    paramFixtureDef.m_flags = (0x1 | paramFixtureDef.m_flags);
    return localFixture;
  }
  
  public final void destroyFixture(Fixture paramFixture)
  {
    if (this.m_world.isLocked() == true) {
      return;
    }
    Object localObject1 = this.m_fixtureList;
    Object localObject2 = null;
    Object localObject3;
    while (localObject1 != null)
    {
      if (localObject1 == paramFixture)
      {
        localObject1 = paramFixture.m_next;
        break;
      }
      localObject3 = ((Fixture)localObject1).m_next;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    if (localObject2 == null) {
      this.m_fixtureList = paramFixture.m_next;
    } else {
      ((Fixture)localObject2).m_next = paramFixture.m_next;
    }
    localObject1 = this.m_contactList;
    while (localObject1 != null)
    {
      localObject3 = ((ContactEdge)localObject1).contact;
      localObject2 = ((ContactEdge)localObject1).next;
      localObject1 = ((Contact)localObject3).getFixtureA();
      Fixture localFixture = ((Contact)localObject3).getFixtureB();
      if (paramFixture != localObject1)
      {
        localObject1 = localObject2;
        if (paramFixture != localFixture) {}
      }
      else
      {
        this.m_world.m_contactManager.destroy((Contact)localObject3);
        localObject1 = localObject2;
      }
    }
    if ((this.m_flags & 0x20) == 32) {
      paramFixture.destroyProxies(this.m_world.m_contactManager.m_broadPhase);
    }
    paramFixture.destroy();
    paramFixture.m_body = null;
    paramFixture.m_next = null;
    this.m_fixtureCount -= 1;
    resetMassData();
  }
  
  public final float getAngle()
  {
    return this.m_sweep.a;
  }
  
  public final float getAngularDamping()
  {
    return this.m_angularDamping;
  }
  
  public final float getAngularVelocity()
  {
    return this.m_angularVelocity;
  }
  
  public final ContactEdge getContactList()
  {
    return this.m_contactList;
  }
  
  public final Fixture getFixtureList()
  {
    return this.m_fixtureList;
  }
  
  public float getGravityScale()
  {
    return this.m_gravityScale;
  }
  
  public final float getInertia()
  {
    return this.m_I + this.m_mass * (this.m_sweep.localCenter.x * this.m_sweep.localCenter.x + this.m_sweep.localCenter.y * this.m_sweep.localCenter.y);
  }
  
  public final JointEdge getJointList()
  {
    return this.m_jointList;
  }
  
  public final float getLinearDamping()
  {
    return this.m_linearDamping;
  }
  
  public final Vec2 getLinearVelocity()
  {
    return this.m_linearVelocity;
  }
  
  public final Vec2 getLinearVelocityFromLocalPoint(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    getLinearVelocityFromLocalPointToOut(paramVec2, localVec2);
    return localVec2;
  }
  
  public final void getLinearVelocityFromLocalPointToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    getWorldPointToOut(paramVec21, paramVec22);
    getLinearVelocityFromWorldPointToOut(paramVec22, paramVec22);
  }
  
  public final Vec2 getLinearVelocityFromWorldPoint(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    getLinearVelocityFromWorldPointToOut(paramVec2, localVec2);
    return localVec2;
  }
  
  public final void getLinearVelocityFromWorldPointToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.set(paramVec21).subLocal(this.m_sweep.c);
    Vec2.crossToOut(this.m_angularVelocity, paramVec22, paramVec22);
    paramVec22.addLocal(this.m_linearVelocity);
  }
  
  public final Vec2 getLocalCenter()
  {
    return this.m_sweep.localCenter;
  }
  
  public final Vec2 getLocalPoint(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    getLocalPointToOut(paramVec2, localVec2);
    return localVec2;
  }
  
  public final void getLocalPointToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    Transform.mulTransToOut(this.m_xf, paramVec21, paramVec22);
  }
  
  public final Vec2 getLocalVector(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    getLocalVectorToOut(paramVec2, localVec2);
    return localVec2;
  }
  
  public final void getLocalVectorToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    Rot.mulTrans(this.m_xf.q, paramVec21, paramVec22);
  }
  
  public final void getLocalVectorToOutUnsafe(Vec2 paramVec21, Vec2 paramVec22)
  {
    Rot.mulTransUnsafe(this.m_xf.q, paramVec21, paramVec22);
  }
  
  public final float getMass()
  {
    return this.m_mass;
  }
  
  public final void getMassData(MassData paramMassData)
  {
    float f = this.m_mass;
    paramMassData.mass = f;
    paramMassData.I = (this.m_I + f * (this.m_sweep.localCenter.x * this.m_sweep.localCenter.x + this.m_sweep.localCenter.y * this.m_sweep.localCenter.y));
    paramMassData.center.x = this.m_sweep.localCenter.x;
    paramMassData.center.y = this.m_sweep.localCenter.y;
  }
  
  public final Body getNext()
  {
    return this.m_next;
  }
  
  public final Vec2 getPosition()
  {
    return this.m_xf.p;
  }
  
  public final Transform getTransform()
  {
    return this.m_xf;
  }
  
  public BodyType getType()
  {
    return this.m_type;
  }
  
  public final Object getUserData()
  {
    return this.m_userData;
  }
  
  public final World getWorld()
  {
    return this.m_world;
  }
  
  public final Vec2 getWorldCenter()
  {
    return this.m_sweep.c;
  }
  
  public final Vec2 getWorldPoint(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    getWorldPointToOut(paramVec2, localVec2);
    return localVec2;
  }
  
  public final void getWorldPointToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    Transform.mulToOut(this.m_xf, paramVec21, paramVec22);
  }
  
  public final Vec2 getWorldVector(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    getWorldVectorToOut(paramVec2, localVec2);
    return localVec2;
  }
  
  public final void getWorldVectorToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    Rot.mulToOut(this.m_xf.q, paramVec21, paramVec22);
  }
  
  public final void getWorldVectorToOutUnsafe(Vec2 paramVec21, Vec2 paramVec22)
  {
    Rot.mulToOutUnsafe(this.m_xf.q, paramVec21, paramVec22);
  }
  
  public boolean isActive()
  {
    return (this.m_flags & 0x20) == 32;
  }
  
  public boolean isAwake()
  {
    return (this.m_flags & 0x2) == 2;
  }
  
  public final boolean isBullet()
  {
    return (this.m_flags & 0x8) == 8;
  }
  
  public boolean isFixedRotation()
  {
    return (this.m_flags & 0x10) == 16;
  }
  
  public boolean isSleepingAllowed()
  {
    return (this.m_flags & 0x4) == 4;
  }
  
  public final void resetMassData()
  {
    this.m_mass = 0.0F;
    this.m_invMass = 0.0F;
    this.m_I = 0.0F;
    this.m_invI = 0.0F;
    this.m_sweep.localCenter.setZero();
    if ((this.m_type != BodyType.STATIC) && (this.m_type != BodyType.KINEMATIC))
    {
      Vec2 localVec21 = this.m_world.getPool().popVec2();
      localVec21.setZero();
      Vec2 localVec22 = this.m_world.getPool().popVec2();
      MassData localMassData = this.pmd;
      for (localObject = this.m_fixtureList; localObject != null; localObject = ((Fixture)localObject).m_next) {
        if (((Fixture)localObject).m_density != 0.0F)
        {
          ((Fixture)localObject).getMassData(localMassData);
          this.m_mass += localMassData.mass;
          localVec22.set(localMassData.center).mulLocal(localMassData.mass);
          localVec21.addLocal(localVec22);
          this.m_I += localMassData.I;
        }
      }
      float f = this.m_mass;
      if (f > 0.0F)
      {
        this.m_invMass = (1.0F / f);
        localVec21.mulLocal(this.m_invMass);
      }
      else
      {
        this.m_mass = 1.0F;
        this.m_invMass = 1.0F;
      }
      f = this.m_I;
      if ((f > 0.0F) && ((this.m_flags & 0x10) == 0))
      {
        this.m_I = (f - this.m_mass * Vec2.dot(localVec21, localVec21));
        this.m_invI = (1.0F / this.m_I);
      }
      else
      {
        this.m_I = 0.0F;
        this.m_invI = 0.0F;
      }
      localObject = this.m_world.getPool().popVec2();
      ((Vec2)localObject).set(this.m_sweep.c);
      this.m_sweep.localCenter.set(localVec21);
      Transform.mulToOutUnsafe(this.m_xf, this.m_sweep.localCenter, this.m_sweep.c0);
      this.m_sweep.c.set(this.m_sweep.c0);
      localVec22.set(this.m_sweep.c).subLocal((Vec2)localObject);
      Vec2.crossToOutUnsafe(this.m_angularVelocity, localVec22, (Vec2)localObject);
      this.m_linearVelocity.addLocal((Vec2)localObject);
      this.m_world.getPool().pushVec2(3);
      return;
    }
    this.m_sweep.c0.set(this.m_xf.p);
    this.m_sweep.c.set(this.m_xf.p);
    Object localObject = this.m_sweep;
    ((Sweep)localObject).a0 = ((Sweep)localObject).a;
  }
  
  public void setActive(boolean paramBoolean)
  {
    if (paramBoolean == isActive()) {
      return;
    }
    if (paramBoolean)
    {
      this.m_flags |= 0x20;
      localObject2 = this.m_world.m_contactManager.m_broadPhase;
      for (localObject1 = this.m_fixtureList; localObject1 != null; localObject1 = ((Fixture)localObject1).m_next) {
        ((Fixture)localObject1).createProxies((BroadPhase)localObject2, this.m_xf);
      }
    }
    this.m_flags &= 0xFFFFFFDF;
    Object localObject2 = this.m_world.m_contactManager.m_broadPhase;
    for (Object localObject1 = this.m_fixtureList; localObject1 != null; localObject1 = ((Fixture)localObject1).m_next) {
      ((Fixture)localObject1).destroyProxies((BroadPhase)localObject2);
    }
    for (localObject1 = this.m_contactList; localObject1 != null; localObject1 = localObject2)
    {
      localObject2 = ((ContactEdge)localObject1).next;
      this.m_world.m_contactManager.destroy(((ContactEdge)localObject1).contact);
    }
    this.m_contactList = null;
  }
  
  public final void setAngularDamping(float paramFloat)
  {
    this.m_angularDamping = paramFloat;
  }
  
  public final void setAngularVelocity(float paramFloat)
  {
    if (this.m_type == BodyType.STATIC) {
      return;
    }
    if (paramFloat * paramFloat > 0.0F) {
      setAwake(true);
    }
    this.m_angularVelocity = paramFloat;
  }
  
  public void setAwake(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = this.m_flags;
      if ((i & 0x2) == 0)
      {
        this.m_flags = (i | 0x2);
        this.m_sleepTime = 0.0F;
      }
    }
    else
    {
      this.m_flags &= 0xFFFFFFFD;
      this.m_sleepTime = 0.0F;
      this.m_linearVelocity.setZero();
      this.m_angularVelocity = 0.0F;
      this.m_force.setZero();
      this.m_torque = 0.0F;
    }
  }
  
  public final void setBullet(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m_flags |= 0x8;
      return;
    }
    this.m_flags &= 0xFFFFFFF7;
  }
  
  public void setFixedRotation(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.m_flags |= 0x10;
    } else {
      this.m_flags &= 0xFFFFFFEF;
    }
    resetMassData();
  }
  
  public void setGravityScale(float paramFloat)
  {
    this.m_gravityScale = paramFloat;
  }
  
  public final void setLinearDamping(float paramFloat)
  {
    this.m_linearDamping = paramFloat;
  }
  
  public final void setLinearVelocity(Vec2 paramVec2)
  {
    if (this.m_type == BodyType.STATIC) {
      return;
    }
    if (Vec2.dot(paramVec2, paramVec2) > 0.0F) {
      setAwake(true);
    }
    this.m_linearVelocity.set(paramVec2);
  }
  
  public final void setMassData(MassData paramMassData)
  {
    if (this.m_world.isLocked() == true) {
      return;
    }
    if (this.m_type != BodyType.DYNAMIC) {
      return;
    }
    this.m_invMass = 0.0F;
    this.m_I = 0.0F;
    this.m_invI = 0.0F;
    this.m_mass = paramMassData.mass;
    if (this.m_mass <= 0.0F) {
      this.m_mass = 1.0F;
    }
    this.m_invMass = (1.0F / this.m_mass);
    if ((paramMassData.I > 0.0F) && ((this.m_flags & 0x10) == 0))
    {
      this.m_I = (paramMassData.I - this.m_mass * Vec2.dot(paramMassData.center, paramMassData.center));
      this.m_invI = (1.0F / this.m_I);
    }
    Vec2 localVec2 = this.m_world.getPool().popVec2();
    localVec2.set(this.m_sweep.c);
    this.m_sweep.localCenter.set(paramMassData.center);
    Transform.mulToOutUnsafe(this.m_xf, this.m_sweep.localCenter, this.m_sweep.c0);
    this.m_sweep.c.set(this.m_sweep.c0);
    paramMassData = this.m_world.getPool().popVec2();
    paramMassData.set(this.m_sweep.c).subLocal(localVec2);
    Vec2.crossToOut(this.m_angularVelocity, paramMassData, paramMassData);
    this.m_linearVelocity.addLocal(paramMassData);
    this.m_world.getPool().pushVec2(2);
  }
  
  public void setSleepingAllowed(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m_flags |= 0x4;
      return;
    }
    this.m_flags &= 0xFFFFFFFB;
    setAwake(true);
  }
  
  public final void setTransform(Vec2 paramVec2, float paramFloat)
  {
    if (this.m_world.isLocked() == true) {
      return;
    }
    this.m_xf.q.set(paramFloat);
    this.m_xf.p.set(paramVec2);
    Transform.mulToOutUnsafe(this.m_xf, this.m_sweep.localCenter, this.m_sweep.c);
    paramVec2 = this.m_sweep;
    paramVec2.a = paramFloat;
    paramVec2.c0.set(this.m_sweep.c);
    paramVec2 = this.m_sweep;
    paramVec2.a0 = paramVec2.a;
    BroadPhase localBroadPhase = this.m_world.m_contactManager.m_broadPhase;
    for (paramVec2 = this.m_fixtureList; paramVec2 != null; paramVec2 = paramVec2.m_next)
    {
      Transform localTransform = this.m_xf;
      paramVec2.synchronize(localBroadPhase, localTransform, localTransform);
    }
    this.m_world.m_contactManager.findNewContacts();
  }
  
  public void setType(BodyType paramBodyType)
  {
    if (this.m_world.isLocked() == true) {
      return;
    }
    if (this.m_type == paramBodyType) {
      return;
    }
    this.m_type = paramBodyType;
    resetMassData();
    if (this.m_type == BodyType.STATIC)
    {
      this.m_linearVelocity.setZero();
      this.m_angularVelocity = 0.0F;
      paramBodyType = this.m_sweep;
      paramBodyType.a0 = paramBodyType.a;
      this.m_sweep.c0.set(this.m_sweep.c);
      synchronizeFixtures();
    }
    setAwake(true);
    this.m_force.setZero();
    this.m_torque = 0.0F;
    for (paramBodyType = this.m_contactList; paramBodyType != null; paramBodyType = (BodyType)localObject)
    {
      localObject = paramBodyType.next;
      this.m_world.m_contactManager.destroy(paramBodyType.contact);
    }
    this.m_contactList = null;
    Object localObject = this.m_world.m_contactManager.m_broadPhase;
    for (paramBodyType = this.m_fixtureList; paramBodyType != null; paramBodyType = paramBodyType.m_next)
    {
      int j = paramBodyType.m_proxyCount;
      int i = 0;
      while (i < j)
      {
        ((BroadPhase)localObject).touchProxy(paramBodyType.m_proxies[i].proxyId);
        i += 1;
      }
    }
  }
  
  public final void setUserData(Object paramObject)
  {
    this.m_userData = paramObject;
  }
  
  public boolean shouldCollide(Body paramBody)
  {
    if ((this.m_type != BodyType.DYNAMIC) && (paramBody.m_type != BodyType.DYNAMIC)) {
      return false;
    }
    for (JointEdge localJointEdge = this.m_jointList; localJointEdge != null; localJointEdge = localJointEdge.next) {
      if ((localJointEdge.other == paramBody) && (!localJointEdge.joint.getCollideConnected())) {
        return false;
      }
    }
    return true;
  }
  
  protected final void synchronizeFixtures()
  {
    Transform localTransform = this.pxf;
    localTransform.q.s = MathUtils.sin(this.m_sweep.a0);
    localTransform.q.c = MathUtils.cos(this.m_sweep.a0);
    localTransform.p.x = (this.m_sweep.c0.x - localTransform.q.c * this.m_sweep.localCenter.x + localTransform.q.s * this.m_sweep.localCenter.y);
    localTransform.p.y = (this.m_sweep.c0.y - localTransform.q.s * this.m_sweep.localCenter.x - localTransform.q.c * this.m_sweep.localCenter.y);
    for (Fixture localFixture = this.m_fixtureList; localFixture != null; localFixture = localFixture.m_next) {
      localFixture.synchronize(this.m_world.m_contactManager.m_broadPhase, localTransform, this.m_xf);
    }
  }
  
  public final void synchronizeTransform()
  {
    this.m_xf.q.s = MathUtils.sin(this.m_sweep.a);
    this.m_xf.q.c = MathUtils.cos(this.m_sweep.a);
    Rot localRot = this.m_xf.q;
    Vec2 localVec2 = this.m_sweep.localCenter;
    this.m_xf.p.x = (this.m_sweep.c.x - localRot.c * localVec2.x + localRot.s * localVec2.y);
    this.m_xf.p.y = (this.m_sweep.c.y - localRot.s * localVec2.x - localRot.c * localVec2.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.Body
 * JD-Core Version:    0.7.0.1
 */