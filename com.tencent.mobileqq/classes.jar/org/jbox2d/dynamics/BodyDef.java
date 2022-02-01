package org.jbox2d.dynamics;

import org.jbox2d.common.Vec2;

public class BodyDef
{
  public boolean active = true;
  public boolean allowSleep = true;
  public float angle = 0.0F;
  public float angularDamping = 0.0F;
  public float angularVelocity = 0.0F;
  public boolean awake = true;
  public boolean bullet = false;
  public boolean fixedRotation = false;
  public float gravityScale = 1.0F;
  public float linearDamping = 0.0F;
  public Vec2 linearVelocity = new Vec2();
  public Vec2 position = new Vec2();
  public BodyType type = BodyType.STATIC;
  public Object userData = null;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.BodyDef
 * JD-Core Version:    0.7.0.1
 */