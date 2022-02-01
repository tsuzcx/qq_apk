package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class DistanceJointDef
  extends JointDef
{
  public float dampingRatio = 0.0F;
  public float frequencyHz = 0.0F;
  public float length = 1.0F;
  public final Vec2 localAnchorA = new Vec2(0.0F, 0.0F);
  public final Vec2 localAnchorB = new Vec2(0.0F, 0.0F);
  
  public DistanceJointDef()
  {
    this.type = JointType.DISTANCE;
  }
  
  public void initialize(Body paramBody1, Body paramBody2, Vec2 paramVec21, Vec2 paramVec22)
  {
    this.bodyA = paramBody1;
    this.bodyB = paramBody2;
    this.localAnchorA.set(this.bodyA.getLocalPoint(paramVec21));
    this.localAnchorB.set(this.bodyB.getLocalPoint(paramVec22));
    this.length = paramVec22.sub(paramVec21).length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.DistanceJointDef
 * JD-Core Version:    0.7.0.1
 */