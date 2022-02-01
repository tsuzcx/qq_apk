package com.tencent.timi.game.float_window.impl.animate;

public class Vector3D
{
  public float a;
  public float b;
  public float c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Vector3D{x=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", z=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.animate.Vector3D
 * JD-Core Version:    0.7.0.1
 */