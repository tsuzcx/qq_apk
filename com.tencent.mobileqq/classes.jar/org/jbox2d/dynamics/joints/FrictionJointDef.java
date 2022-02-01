package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class FrictionJointDef
  extends JointDef
{
  public final Vec2 localAnchorA = new Vec2();
  public final Vec2 localAnchorB = new Vec2();
  public float maxForce = 0.0F;
  public float maxTorque = 0.0F;
  
  public FrictionJointDef()
  {
    this.type = JointType.FRICTION;
  }
  
  public void initialize(Body paramBody1, Body paramBody2, Vec2 paramVec2)
  {
    this.bodyA = paramBody1;
    this.bodyB = paramBody2;
    paramBody1.getLocalPointToOut(paramVec2, this.localAnchorA);
    paramBody2.getLocalPointToOut(paramVec2, this.localAnchorB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.FrictionJointDef
 * JD-Core Version:    0.7.0.1
 */