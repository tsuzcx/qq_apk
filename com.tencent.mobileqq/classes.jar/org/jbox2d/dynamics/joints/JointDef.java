package org.jbox2d.dynamics.joints;

import org.jbox2d.dynamics.Body;

public class JointDef
{
  public Body bodyA = null;
  public Body bodyB = null;
  public boolean collideConnected = false;
  public JointType type = JointType.UNKNOWN;
  public Object userData = null;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.JointDef
 * JD-Core Version:    0.7.0.1
 */