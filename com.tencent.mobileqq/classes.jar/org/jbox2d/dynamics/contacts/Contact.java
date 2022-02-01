package org.jbox2d.dynamics.contacts;

import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Collision;
import org.jbox2d.collision.ContactID;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.ManifoldPoint;
import org.jbox2d.collision.WorldManifold;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

public abstract class Contact
{
  public static final int BULLET_HIT_FLAG = 16;
  public static final int ENABLED_FLAG = 4;
  public static final int FILTER_FLAG = 8;
  public static final int ISLAND_FLAG = 1;
  public static final int TOI_FLAG = 32;
  public static final int TOUCHING_FLAG = 2;
  public Fixture m_fixtureA = null;
  public Fixture m_fixtureB = null;
  public int m_flags;
  public float m_friction;
  public int m_indexA;
  public int m_indexB;
  public final Manifold m_manifold = new Manifold();
  public Contact m_next;
  public ContactEdge m_nodeA = null;
  public ContactEdge m_nodeB = null;
  public Contact m_prev;
  public float m_restitution;
  public float m_tangentSpeed;
  public float m_toi;
  public float m_toiCount;
  private final Manifold oldManifold = new Manifold();
  protected final IWorldPool pool;
  
  protected Contact(IWorldPool paramIWorldPool)
  {
    this.pool = paramIWorldPool;
  }
  
  public static final float mixFriction(float paramFloat1, float paramFloat2)
  {
    return MathUtils.sqrt(paramFloat1 * paramFloat2);
  }
  
  public static final float mixRestitution(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat1;
    }
    return paramFloat2;
  }
  
  public abstract void evaluate(Manifold paramManifold, Transform paramTransform1, Transform paramTransform2);
  
  public void flagForFiltering()
  {
    this.m_flags |= 0x8;
  }
  
  public int getChildIndexA()
  {
    return this.m_indexA;
  }
  
  public int getChildIndexB()
  {
    return this.m_indexB;
  }
  
  public Fixture getFixtureA()
  {
    return this.m_fixtureA;
  }
  
  public Fixture getFixtureB()
  {
    return this.m_fixtureB;
  }
  
  public float getFriction()
  {
    return this.m_friction;
  }
  
  public Manifold getManifold()
  {
    return this.m_manifold;
  }
  
  public Contact getNext()
  {
    return this.m_next;
  }
  
  public float getRestitution()
  {
    return this.m_restitution;
  }
  
  public float getTangentSpeed()
  {
    return this.m_tangentSpeed;
  }
  
  public void getWorldManifold(WorldManifold paramWorldManifold)
  {
    Body localBody1 = this.m_fixtureA.getBody();
    Body localBody2 = this.m_fixtureB.getBody();
    Shape localShape1 = this.m_fixtureA.getShape();
    Shape localShape2 = this.m_fixtureB.getShape();
    paramWorldManifold.initialize(this.m_manifold, localBody1.getTransform(), localShape1.m_radius, localBody2.getTransform(), localShape2.m_radius);
  }
  
  public void init(Fixture paramFixture1, int paramInt1, Fixture paramFixture2, int paramInt2)
  {
    this.m_flags = 0;
    this.m_fixtureA = paramFixture1;
    this.m_fixtureB = paramFixture2;
    this.m_indexA = paramInt1;
    this.m_indexB = paramInt2;
    this.m_manifold.pointCount = 0;
    this.m_prev = null;
    this.m_next = null;
    ContactEdge localContactEdge = this.m_nodeA;
    localContactEdge.contact = null;
    localContactEdge.prev = null;
    localContactEdge.next = null;
    localContactEdge.other = null;
    localContactEdge = this.m_nodeB;
    localContactEdge.contact = null;
    localContactEdge.prev = null;
    localContactEdge.next = null;
    localContactEdge.other = null;
    this.m_toiCount = 0.0F;
    this.m_friction = mixFriction(paramFixture1.m_friction, paramFixture2.m_friction);
    this.m_restitution = mixRestitution(paramFixture1.m_restitution, paramFixture2.m_restitution);
    this.m_tangentSpeed = 0.0F;
  }
  
  public boolean isEnabled()
  {
    return (this.m_flags & 0x4) == 4;
  }
  
  public boolean isTouching()
  {
    return (this.m_flags & 0x2) == 2;
  }
  
  public void resetFriction()
  {
    this.m_friction = mixFriction(this.m_fixtureA.m_friction, this.m_fixtureB.m_friction);
  }
  
  public void resetRestitution()
  {
    this.m_restitution = mixRestitution(this.m_fixtureA.m_restitution, this.m_fixtureB.m_restitution);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m_flags |= 0x4;
      return;
    }
    this.m_flags &= 0xFFFFFFFB;
  }
  
  public void setFriction(float paramFloat)
  {
    this.m_friction = paramFloat;
  }
  
  public void setRestitution(float paramFloat)
  {
    this.m_restitution = paramFloat;
  }
  
  public void setTangentSpeed(float paramFloat)
  {
    this.m_tangentSpeed = paramFloat;
  }
  
  public void update(ContactListener paramContactListener)
  {
    this.oldManifold.set(this.m_manifold);
    this.m_flags |= 0x4;
    boolean bool2;
    if ((this.m_flags & 0x2) == 2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool1 = this.m_fixtureA.isSensor();
    boolean bool3 = this.m_fixtureB.isSensor();
    int i;
    if ((!bool1) && (!bool3)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject1 = this.m_fixtureA.getBody();
    Object localObject2 = this.m_fixtureB.getBody();
    Object localObject3 = ((Body)localObject1).getTransform();
    Object localObject4 = ((Body)localObject2).getTransform();
    if (i != 0)
    {
      localObject1 = this.m_fixtureA.getShape();
      localObject2 = this.m_fixtureB.getShape();
      bool1 = this.pool.getCollision().testOverlap((Shape)localObject1, this.m_indexA, (Shape)localObject2, this.m_indexB, (Transform)localObject3, (Transform)localObject4);
      this.m_manifold.pointCount = 0;
    }
    else
    {
      evaluate(this.m_manifold, (Transform)localObject3, (Transform)localObject4);
      if (this.m_manifold.pointCount > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int j = 0;
      while (j < this.m_manifold.pointCount)
      {
        localObject3 = this.m_manifold.points[j];
        ((ManifoldPoint)localObject3).normalImpulse = 0.0F;
        ((ManifoldPoint)localObject3).tangentImpulse = 0.0F;
        localObject4 = ((ManifoldPoint)localObject3).id;
        int k = 0;
        while (k < this.oldManifold.pointCount)
        {
          ManifoldPoint localManifoldPoint = this.oldManifold.points[k];
          if (localManifoldPoint.id.isEqual((ContactID)localObject4))
          {
            ((ManifoldPoint)localObject3).normalImpulse = localManifoldPoint.normalImpulse;
            ((ManifoldPoint)localObject3).tangentImpulse = localManifoldPoint.tangentImpulse;
            break;
          }
          k += 1;
        }
        j += 1;
      }
      if (bool1 != bool2)
      {
        ((Body)localObject1).setAwake(true);
        ((Body)localObject2).setAwake(true);
      }
    }
    if (bool1) {
      this.m_flags = (0x2 | this.m_flags);
    } else {
      this.m_flags &= 0xFFFFFFFD;
    }
    if (paramContactListener == null) {
      return;
    }
    if ((!bool2) && (bool1 == true)) {
      paramContactListener.beginContact(this);
    }
    if ((bool2 == true) && (!bool1)) {
      paramContactListener.endContact(this);
    }
    if ((i == 0) && (bool1)) {
      paramContactListener.preSolve(this, this.oldManifold);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.contacts.Contact
 * JD-Core Version:    0.7.0.1
 */