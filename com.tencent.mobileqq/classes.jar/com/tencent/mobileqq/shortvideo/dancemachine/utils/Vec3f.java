package com.tencent.mobileqq.shortvideo.dancemachine.utils;

public class Vec3f
{
  public float a;
  public float b;
  public float c;
  
  public Vec3f() {}
  
  public Vec3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Vec3f)) {
        break;
      }
      paramObject = (Vec3f)paramObject;
    } while ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return ((Float.floatToIntBits(this.a) + 217) * 31 + Float.floatToIntBits(this.b)) * 31 + Float.floatToIntBits(this.c);
  }
  
  public String toString()
  {
    return "Vec3f[" + this.a + ", " + this.b + ", " + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f
 * JD-Core Version:    0.7.0.1
 */