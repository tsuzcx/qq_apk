package org.jbox2d.dynamics;

import org.jbox2d.collision.shapes.Shape;

public class FixtureDef
{
  public float density = 0.0F;
  public Filter filter = new Filter();
  public float friction = 0.2F;
  public boolean isSensor = false;
  public float restitution = 0.0F;
  public Shape shape = null;
  public Object userData = null;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.FixtureDef
 * JD-Core Version:    0.7.0.1
 */