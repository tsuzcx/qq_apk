package org.jbox2d.dynamics;

import org.jbox2d.collision.AABB;

public class FixtureProxy
{
  final AABB aabb = new AABB();
  int childIndex;
  Fixture fixture;
  int proxyId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.FixtureProxy
 * JD-Core Version:    0.7.0.1
 */