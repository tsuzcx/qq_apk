package org.jbox2d.callbacks;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Fixture;

public abstract interface RayCastCallback
{
  public abstract float reportFixture(Fixture paramFixture, Vec2 paramVec21, Vec2 paramVec22, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.callbacks.RayCastCallback
 * JD-Core Version:    0.7.0.1
 */