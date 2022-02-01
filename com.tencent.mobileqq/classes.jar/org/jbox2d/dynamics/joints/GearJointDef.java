package org.jbox2d.dynamics.joints;

public class GearJointDef
  extends JointDef
{
  public Joint joint1 = null;
  public Joint joint2 = null;
  public float ratio;
  
  public GearJointDef()
  {
    this.type = JointType.GEAR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.GearJointDef
 * JD-Core Version:    0.7.0.1
 */