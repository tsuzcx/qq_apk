package org.jbox2d.collision.shapes;

import org.jbox2d.common.Vec2;

public class MassData
{
  public float I;
  public final Vec2 center;
  public float mass;
  
  public MassData()
  {
    this.I = 0.0F;
    this.mass = 0.0F;
    this.center = new Vec2();
  }
  
  public MassData(MassData paramMassData)
  {
    this.mass = paramMassData.mass;
    this.I = paramMassData.I;
    this.center = paramMassData.center.clone();
  }
  
  public MassData clone()
  {
    return new MassData(this);
  }
  
  public void set(MassData paramMassData)
  {
    this.mass = paramMassData.mass;
    this.I = paramMassData.I;
    this.center.set(paramMassData.center);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.shapes.MassData
 * JD-Core Version:    0.7.0.1
 */