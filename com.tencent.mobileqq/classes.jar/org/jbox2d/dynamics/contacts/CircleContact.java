package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Collision;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

public class CircleContact
  extends Contact
{
  public CircleContact(IWorldPool paramIWorldPool)
  {
    super(paramIWorldPool);
  }
  
  public void evaluate(Manifold paramManifold, Transform paramTransform1, Transform paramTransform2)
  {
    this.pool.getCollision().collideCircles(paramManifold, (CircleShape)this.m_fixtureA.getShape(), paramTransform1, (CircleShape)this.m_fixtureB.getShape(), paramTransform2);
  }
  
  public void init(Fixture paramFixture1, Fixture paramFixture2)
  {
    super.init(paramFixture1, 0, paramFixture2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.contacts.CircleContact
 * JD-Core Version:    0.7.0.1
 */