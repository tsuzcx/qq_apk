package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class PulleyJointDef
  extends JointDef
{
  public Vec2 groundAnchorA = new Vec2(-1.0F, 1.0F);
  public Vec2 groundAnchorB = new Vec2(1.0F, 1.0F);
  public float lengthA = 0.0F;
  public float lengthB = 0.0F;
  public Vec2 localAnchorA = new Vec2(-1.0F, 0.0F);
  public Vec2 localAnchorB = new Vec2(1.0F, 0.0F);
  public float ratio = 1.0F;
  
  public PulleyJointDef()
  {
    this.type = JointType.PULLEY;
    this.collideConnected = true;
  }
  
  public void initialize(Body paramBody1, Body paramBody2, Vec2 paramVec21, Vec2 paramVec22, Vec2 paramVec23, Vec2 paramVec24, float paramFloat)
  {
    this.bodyA = paramBody1;
    this.bodyB = paramBody2;
    this.groundAnchorA = paramVec21;
    this.groundAnchorB = paramVec22;
    this.localAnchorA = this.bodyA.getLocalPoint(paramVec23);
    this.localAnchorB = this.bodyB.getLocalPoint(paramVec24);
    this.lengthA = paramVec23.sub(paramVec21).length();
    this.lengthB = paramVec24.sub(paramVec22).length();
    this.ratio = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.PulleyJointDef
 * JD-Core Version:    0.7.0.1
 */