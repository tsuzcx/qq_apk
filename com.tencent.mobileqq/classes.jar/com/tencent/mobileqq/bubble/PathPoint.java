package com.tencent.mobileqq.bubble;

import android.annotation.TargetApi;

@TargetApi(11)
public class PathPoint
{
  public float a;
  public float b;
  public float c = 0.0F;
  public float d = 1.0F;
  public float e;
  public float f;
  public float g;
  public float h;
  public int i;
  
  public PathPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.a = paramFloat5;
    this.b = paramFloat6;
    this.i = 2;
  }
  
  public PathPoint(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.i = paramInt;
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public static PathPoint a(float paramFloat1, float paramFloat2)
  {
    return new PathPoint(1, paramFloat1, paramFloat2);
  }
  
  public static PathPoint a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return new PathPoint(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public static PathPoint b(float paramFloat1, float paramFloat2)
  {
    return new PathPoint(0, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.PathPoint
 * JD-Core Version:    0.7.0.1
 */