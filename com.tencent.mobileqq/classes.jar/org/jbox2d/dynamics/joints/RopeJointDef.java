package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;

public class RopeJointDef
  extends JointDef
{
  public final Vec2 localAnchorA = new Vec2();
  public final Vec2 localAnchorB = new Vec2();
  public float maxLength;
  
  public RopeJointDef()
  {
    this.type = JointType.ROPE;
    this.localAnchorA.set(-1.0F, 0.0F);
    this.localAnchorB.set(1.0F, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.RopeJointDef
 * JD-Core Version:    0.7.0.1
 */