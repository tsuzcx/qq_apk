package com.tencent.ttpic.particle;

public class Vector2
{
  public float x;
  public float y;
  
  Vector2() {}
  
  public Vector2(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public void copy(Vector2 paramVector2)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.particle.Vector2
 * JD-Core Version:    0.7.0.1
 */