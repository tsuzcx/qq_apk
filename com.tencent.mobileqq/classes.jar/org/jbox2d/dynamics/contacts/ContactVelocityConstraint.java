package org.jbox2d.dynamics.contacts;

import org.jbox2d.common.Mat22;
import org.jbox2d.common.Vec2;

public class ContactVelocityConstraint
{
  public final Mat22 K = new Mat22();
  public int contactIndex;
  public float friction;
  public int indexA;
  public int indexB;
  public float invIA;
  public float invIB;
  public float invMassA;
  public float invMassB;
  public final Vec2 normal = new Vec2();
  public final Mat22 normalMass = new Mat22();
  public int pointCount;
  public ContactVelocityConstraint.VelocityConstraintPoint[] points = new ContactVelocityConstraint.VelocityConstraintPoint[2];
  public float restitution;
  public float tangentSpeed;
  
  public ContactVelocityConstraint()
  {
    int i = 0;
    for (;;)
    {
      ContactVelocityConstraint.VelocityConstraintPoint[] arrayOfVelocityConstraintPoint = this.points;
      if (i >= arrayOfVelocityConstraintPoint.length) {
        break;
      }
      arrayOfVelocityConstraintPoint[i] = new ContactVelocityConstraint.VelocityConstraintPoint();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.contacts.ContactVelocityConstraint
 * JD-Core Version:    0.7.0.1
 */