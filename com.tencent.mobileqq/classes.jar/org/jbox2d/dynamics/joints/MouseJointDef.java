package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;

public class MouseJointDef
  extends JointDef
{
  public float dampingRatio;
  public float frequencyHz;
  public float maxForce;
  public final Vec2 target = new Vec2();
  
  public MouseJointDef()
  {
    this.type = JointType.MOUSE;
    this.target.set(0.0F, 0.0F);
    this.maxForce = 0.0F;
    this.frequencyHz = 5.0F;
    this.dampingRatio = 0.7F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.MouseJointDef
 * JD-Core Version:    0.7.0.1
 */