package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold.ManifoldType;
import org.jbox2d.common.Vec2;

public class ContactPositionConstraint
{
  int indexA;
  int indexB;
  float invIA;
  float invIB;
  float invMassA;
  float invMassB;
  final Vec2 localCenterA = new Vec2();
  final Vec2 localCenterB = new Vec2();
  final Vec2 localNormal = new Vec2();
  final Vec2 localPoint = new Vec2();
  Vec2[] localPoints = new Vec2[2];
  int pointCount;
  float radiusA;
  float radiusB;
  Manifold.ManifoldType type;
  
  public ContactPositionConstraint()
  {
    int i = 0;
    for (;;)
    {
      Vec2[] arrayOfVec2 = this.localPoints;
      if (i >= arrayOfVec2.length) {
        break;
      }
      arrayOfVec2[i] = new Vec2();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.contacts.ContactPositionConstraint
 * JD-Core Version:    0.7.0.1
 */