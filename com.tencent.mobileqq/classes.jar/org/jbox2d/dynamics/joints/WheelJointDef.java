package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class WheelJointDef
  extends JointDef
{
  public float dampingRatio;
  public boolean enableMotor;
  public float frequencyHz;
  public final Vec2 localAnchorA = new Vec2();
  public final Vec2 localAnchorB = new Vec2();
  public final Vec2 localAxisA = new Vec2();
  public float maxMotorTorque;
  public float motorSpeed;
  
  public WheelJointDef()
  {
    this.type = JointType.WHEEL;
    this.localAxisA.set(1.0F, 0.0F);
    this.enableMotor = false;
    this.maxMotorTorque = 0.0F;
    this.motorSpeed = 0.0F;
  }
  
  public void initialize(Body paramBody1, Body paramBody2, Vec2 paramVec21, Vec2 paramVec22)
  {
    this.bodyA = paramBody1;
    this.bodyB = paramBody2;
    paramBody1.getLocalPointToOut(paramVec21, this.localAnchorA);
    paramBody2.getLocalPointToOut(paramVec21, this.localAnchorB);
    this.bodyA.getLocalVectorToOut(paramVec22, this.localAxisA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.WheelJointDef
 * JD-Core Version:    0.7.0.1
 */