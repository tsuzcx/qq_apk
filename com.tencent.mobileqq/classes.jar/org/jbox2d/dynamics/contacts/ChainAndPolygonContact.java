package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Collision;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

public class ChainAndPolygonContact
  extends Contact
{
  private final EdgeShape edge = new EdgeShape();
  
  public ChainAndPolygonContact(IWorldPool paramIWorldPool)
  {
    super(paramIWorldPool);
  }
  
  public void evaluate(Manifold paramManifold, Transform paramTransform1, Transform paramTransform2)
  {
    ((ChainShape)this.m_fixtureA.getShape()).getChildEdge(this.edge, this.m_indexA);
    this.pool.getCollision().collideEdgeAndPolygon(paramManifold, this.edge, paramTransform1, (PolygonShape)this.m_fixtureB.getShape(), paramTransform2);
  }
  
  public void init(Fixture paramFixture1, int paramInt1, Fixture paramFixture2, int paramInt2)
  {
    super.init(paramFixture1, paramInt1, paramFixture2, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.contacts.ChainAndPolygonContact
 * JD-Core Version:    0.7.0.1
 */