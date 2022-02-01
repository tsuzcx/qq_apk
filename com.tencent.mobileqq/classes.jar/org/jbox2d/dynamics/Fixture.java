package org.jbox2d.dynamics;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.collision.shapes.MassData;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactEdge;

public class Fixture
{
  private final Vec2 displacement = new Vec2();
  public Body m_body = null;
  public float m_density;
  public final Filter m_filter = new Filter();
  public float m_friction;
  public boolean m_isSensor;
  public Fixture m_next = null;
  public FixtureProxy[] m_proxies = null;
  public int m_proxyCount = 0;
  public float m_restitution;
  public Shape m_shape = null;
  public Object m_userData = null;
  private final AABB pool1 = new AABB();
  private final AABB pool2 = new AABB();
  
  public void create(Body paramBody, FixtureDef paramFixtureDef)
  {
    this.m_userData = paramFixtureDef.userData;
    this.m_friction = paramFixtureDef.friction;
    this.m_restitution = paramFixtureDef.restitution;
    this.m_body = paramBody;
    this.m_next = null;
    this.m_filter.set(paramFixtureDef.filter);
    this.m_isSensor = paramFixtureDef.isSensor;
    this.m_shape = paramFixtureDef.shape.clone();
    int j = this.m_shape.getChildCount();
    int i;
    if (this.m_proxies == null)
    {
      this.m_proxies = new FixtureProxy[j];
      i = 0;
      while (i < j)
      {
        this.m_proxies[i] = new FixtureProxy();
        paramBody = this.m_proxies;
        paramBody[i].fixture = null;
        paramBody[i].proxyId = -1;
        i += 1;
      }
    }
    paramBody = this.m_proxies;
    if (paramBody.length < j)
    {
      j = MathUtils.max(paramBody.length * 2, j);
      this.m_proxies = new FixtureProxy[j];
      System.arraycopy(paramBody, 0, this.m_proxies, 0, paramBody.length);
      i = 0;
      while (i < j)
      {
        if (i >= paramBody.length) {
          this.m_proxies[i] = new FixtureProxy();
        }
        FixtureProxy[] arrayOfFixtureProxy = this.m_proxies;
        arrayOfFixtureProxy[i].fixture = null;
        arrayOfFixtureProxy[i].proxyId = -1;
        i += 1;
      }
    }
    this.m_proxyCount = 0;
    this.m_density = paramFixtureDef.density;
  }
  
  public void createProxies(BroadPhase paramBroadPhase, Transform paramTransform)
  {
    this.m_proxyCount = this.m_shape.getChildCount();
    int i = 0;
    while (i < this.m_proxyCount)
    {
      FixtureProxy localFixtureProxy = this.m_proxies[i];
      this.m_shape.computeAABB(localFixtureProxy.aabb, paramTransform, i);
      localFixtureProxy.proxyId = paramBroadPhase.createProxy(localFixtureProxy.aabb, localFixtureProxy);
      localFixtureProxy.fixture = this;
      localFixtureProxy.childIndex = i;
      i += 1;
    }
  }
  
  public void destroy()
  {
    this.m_shape = null;
    this.m_proxies = null;
    this.m_next = null;
  }
  
  public void destroyProxies(BroadPhase paramBroadPhase)
  {
    int i = 0;
    while (i < this.m_proxyCount)
    {
      FixtureProxy localFixtureProxy = this.m_proxies[i];
      paramBroadPhase.destroyProxy(localFixtureProxy.proxyId);
      localFixtureProxy.proxyId = -1;
      i += 1;
    }
    this.m_proxyCount = 0;
  }
  
  public void dump(int paramInt) {}
  
  public AABB getAABB(int paramInt)
  {
    return this.m_proxies[paramInt].aabb;
  }
  
  public Body getBody()
  {
    return this.m_body;
  }
  
  public float getDensity()
  {
    return this.m_density;
  }
  
  public Filter getFilterData()
  {
    return this.m_filter;
  }
  
  public float getFriction()
  {
    return this.m_friction;
  }
  
  public void getMassData(MassData paramMassData)
  {
    this.m_shape.computeMass(paramMassData, this.m_density);
  }
  
  public Fixture getNext()
  {
    return this.m_next;
  }
  
  public float getRestitution()
  {
    return this.m_restitution;
  }
  
  public Shape getShape()
  {
    return this.m_shape;
  }
  
  public ShapeType getType()
  {
    return this.m_shape.getType();
  }
  
  public Object getUserData()
  {
    return this.m_userData;
  }
  
  public boolean isSensor()
  {
    return this.m_isSensor;
  }
  
  public boolean raycast(RayCastOutput paramRayCastOutput, RayCastInput paramRayCastInput, int paramInt)
  {
    return this.m_shape.raycast(paramRayCastOutput, paramRayCastInput, this.m_body.m_xf, paramInt);
  }
  
  public void refilter()
  {
    Object localObject = this.m_body;
    if (localObject == null) {
      return;
    }
    for (localObject = ((Body)localObject).getContactList(); localObject != null; localObject = ((ContactEdge)localObject).next)
    {
      Contact localContact = ((ContactEdge)localObject).contact;
      Fixture localFixture1 = localContact.getFixtureA();
      Fixture localFixture2 = localContact.getFixtureB();
      if ((localFixture1 == this) || (localFixture2 == this)) {
        localContact.flagForFiltering();
      }
    }
    localObject = this.m_body.getWorld();
    if (localObject == null) {
      return;
    }
    localObject = ((World)localObject).m_contactManager.m_broadPhase;
    int i = 0;
    while (i < this.m_proxyCount)
    {
      ((BroadPhase)localObject).touchProxy(this.m_proxies[i].proxyId);
      i += 1;
    }
  }
  
  public void setDensity(float paramFloat)
  {
    this.m_density = paramFloat;
  }
  
  public void setFilterData(Filter paramFilter)
  {
    this.m_filter.set(paramFilter);
    refilter();
  }
  
  public void setFriction(float paramFloat)
  {
    this.m_friction = paramFloat;
  }
  
  public void setRestitution(float paramFloat)
  {
    this.m_restitution = paramFloat;
  }
  
  public void setSensor(boolean paramBoolean)
  {
    if (paramBoolean != this.m_isSensor)
    {
      this.m_body.setAwake(true);
      this.m_isSensor = paramBoolean;
    }
  }
  
  public void setUserData(Object paramObject)
  {
    this.m_userData = paramObject;
  }
  
  protected void synchronize(BroadPhase paramBroadPhase, Transform paramTransform1, Transform paramTransform2)
  {
    if (this.m_proxyCount == 0) {
      return;
    }
    int i = 0;
    while (i < this.m_proxyCount)
    {
      FixtureProxy localFixtureProxy = this.m_proxies[i];
      AABB localAABB1 = this.pool1;
      AABB localAABB2 = this.pool2;
      this.m_shape.computeAABB(localAABB1, paramTransform1, localFixtureProxy.childIndex);
      this.m_shape.computeAABB(localAABB2, paramTransform2, localFixtureProxy.childIndex);
      Vec2 localVec22 = localFixtureProxy.aabb.lowerBound;
      Vec2 localVec21;
      if (localAABB1.lowerBound.x < localAABB2.lowerBound.x) {
        localVec21 = localAABB1.lowerBound;
      } else {
        localVec21 = localAABB2.lowerBound;
      }
      localVec22.x = localVec21.x;
      localVec22 = localFixtureProxy.aabb.lowerBound;
      if (localAABB1.lowerBound.y < localAABB2.lowerBound.y) {
        localVec21 = localAABB1.lowerBound;
      } else {
        localVec21 = localAABB2.lowerBound;
      }
      localVec22.y = localVec21.y;
      localVec22 = localFixtureProxy.aabb.upperBound;
      if (localAABB1.upperBound.x > localAABB2.upperBound.x) {
        localVec21 = localAABB1.upperBound;
      } else {
        localVec21 = localAABB2.upperBound;
      }
      localVec22.x = localVec21.x;
      localVec22 = localFixtureProxy.aabb.upperBound;
      if (localAABB1.upperBound.y > localAABB2.upperBound.y) {
        localVec21 = localAABB1.upperBound;
      } else {
        localVec21 = localAABB2.upperBound;
      }
      localVec22.y = localVec21.y;
      this.displacement.x = (paramTransform2.p.x - paramTransform1.p.x);
      this.displacement.y = (paramTransform2.p.y - paramTransform1.p.y);
      paramBroadPhase.moveProxy(localFixtureProxy.proxyId, localFixtureProxy.aabb, this.displacement);
      i += 1;
    }
  }
  
  public boolean testPoint(Vec2 paramVec2)
  {
    return this.m_shape.testPoint(this.m_body.m_xf, paramVec2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.Fixture
 * JD-Core Version:    0.7.0.1
 */