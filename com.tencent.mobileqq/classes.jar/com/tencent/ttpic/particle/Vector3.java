package com.tencent.ttpic.particle;

import android.support.annotation.NonNull;

public class Vector3
{
  public float x;
  public float y;
  public float z;
  
  Vector3() {}
  
  public Vector3(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public void copy(Vector3 paramVector3)
  {
    this.x = paramVector3.x;
    this.y = paramVector3.y;
    this.z = paramVector3.z;
  }
  
  @NonNull
  public String toString()
  {
    return "(" + this.x + ", " + this.y + ", " + this.z + ")";
  }
  
  public Vector2 xy()
  {
    return new Vector2(this.x, this.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.Vector3
 * JD-Core Version:    0.7.0.1
 */