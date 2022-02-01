package com.tencent.mobileqq.shortvideo.dancemachine;

public class Vec4f
{
  public float w;
  public float x;
  public float y;
  public float z;
  
  public Vec4f() {}
  
  public Vec4f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
  }
  
  public Vec4f(Vec4f paramVec4f)
  {
    this.x = paramVec4f.x;
    this.y = paramVec4f.y;
    this.z = paramVec4f.z;
    this.w = paramVec4f.w;
  }
  
  public void set(Vec4f paramVec4f)
  {
    this.x = paramVec4f.x;
    this.y = paramVec4f.y;
    this.z = paramVec4f.z;
    this.w = paramVec4f.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.Vec4f
 * JD-Core Version:    0.7.0.1
 */