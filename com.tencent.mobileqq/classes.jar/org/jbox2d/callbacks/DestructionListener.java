package org.jbox2d.callbacks;

import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.joints.Joint;

public abstract interface DestructionListener
{
  public abstract void sayGoodbye(Fixture paramFixture);
  
  public abstract void sayGoodbye(Joint paramJoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.callbacks.DestructionListener
 * JD-Core Version:    0.7.0.1
 */