package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class PrismaticJointDef
  extends JointDef
{
  public boolean enableLimit = false;
  public boolean enableMotor = false;
  public final Vec2 localAnchorA = new Vec2();
  public final Vec2 localAnchorB = new Vec2();
  public final Vec2 localAxisA = new Vec2(1.0F, 0.0F);
  public float lowerTranslation = 0.0F;
  public float maxMotorForce = 0.0F;
  public float motorSpeed = 0.0F;
  public float referenceAngle = 0.0F;
  public float upperTranslation = 0.0F;
  
  public PrismaticJointDef()
  {
    this.type = JointType.PRISMATIC;
  }
  
  public void initialize(Body paramBody1, Body paramBody2, Vec2 paramVec21, Vec2 paramVec22)
  {
    this.bodyA = paramBody1;
    this.bodyB = paramBody2;
    this.bodyA.getLocalPointToOut(paramVec21, this.localAnchorA);
    this.bodyB.getLocalPointToOut(paramVec21, this.localAnchorB);
    this.bodyA.getLocalVectorToOut(paramVec22, this.localAxisA);
    this.referenceAngle = (this.bodyB.getAngle() - this.bodyA.getAngle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.PrismaticJointDef
 * JD-Core Version:    0.7.0.1
 */