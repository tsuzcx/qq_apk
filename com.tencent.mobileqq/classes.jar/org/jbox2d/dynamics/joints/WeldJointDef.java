package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class WeldJointDef
  extends JointDef
{
  public float dampingRatio;
  public float frequencyHz;
  public final Vec2 localAnchorA = new Vec2();
  public final Vec2 localAnchorB = new Vec2();
  public float referenceAngle = 0.0F;
  
  public WeldJointDef()
  {
    this.type = JointType.WELD;
  }
  
  public void initialize(Body paramBody1, Body paramBody2, Vec2 paramVec2)
  {
    this.bodyA = paramBody1;
    this.bodyB = paramBody2;
    this.bodyA.getLocalPointToOut(paramVec2, this.localAnchorA);
    this.bodyB.getLocalPointToOut(paramVec2, this.localAnchorB);
    this.referenceAngle = (this.bodyB.getAngle() - this.bodyA.getAngle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.WeldJointDef
 * JD-Core Version:    0.7.0.1
 */