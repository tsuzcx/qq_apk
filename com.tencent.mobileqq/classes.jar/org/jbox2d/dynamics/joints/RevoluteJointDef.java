package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class RevoluteJointDef
  extends JointDef
{
  public boolean enableLimit = false;
  public boolean enableMotor = false;
  public Vec2 localAnchorA = new Vec2(0.0F, 0.0F);
  public Vec2 localAnchorB = new Vec2(0.0F, 0.0F);
  public float lowerAngle = 0.0F;
  public float maxMotorTorque = 0.0F;
  public float motorSpeed = 0.0F;
  public float referenceAngle = 0.0F;
  public float upperAngle = 0.0F;
  
  public RevoluteJointDef()
  {
    this.type = JointType.REVOLUTE;
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
 * Qualified Name:     org.jbox2d.dynamics.joints.RevoluteJointDef
 * JD-Core Version:    0.7.0.1
 */