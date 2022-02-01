package org.jbox2d.dynamics.joints;

import java.util.ArrayList;
import org.jbox2d.dynamics.Body;

public class ConstantVolumeJointDef
  extends JointDef
{
  ArrayList<Body> bodies = new ArrayList();
  public float dampingRatio = 0.0F;
  public float frequencyHz = 0.0F;
  ArrayList<DistanceJoint> joints = null;
  
  public ConstantVolumeJointDef()
  {
    this.type = JointType.CONSTANT_VOLUME;
    this.collideConnected = false;
  }
  
  public void addBody(Body paramBody)
  {
    this.bodies.add(paramBody);
    if (this.bodies.size() == 1) {
      this.bodyA = paramBody;
    }
    if (this.bodies.size() == 2) {
      this.bodyB = paramBody;
    }
  }
  
  public void addBodyAndJoint(Body paramBody, DistanceJoint paramDistanceJoint)
  {
    addBody(paramBody);
    if (this.joints == null) {
      this.joints = new ArrayList();
    }
    this.joints.add(paramDistanceJoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.ConstantVolumeJointDef
 * JD-Core Version:    0.7.0.1
 */