package com.tencent.ttpic.particle;

public class Vector4
{
  public float a;
  public float b;
  public float g;
  public float r;
  
  public Vector4() {}
  
  public Vector4(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r = paramFloat1;
    this.g = paramFloat2;
    this.b = paramFloat3;
    this.a = paramFloat4;
  }
  
  public void copy(Vector4 paramVector4)
  {
    this.r = paramVector4.r;
    this.g = paramVector4.g;
    this.b = paramVector4.b;
    this.a = paramVector4.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.Vector4
 * JD-Core Version:    0.7.0.1
 */