package com.tencent.mobileqq.shortvideo.dancemachine.utils;

public class Vec3f
{
  public float x;
  public float y;
  public float z;
  
  public Vec3f() {}
  
  public Vec3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public Vec3f(Vec3f paramVec3f)
  {
    this.x = paramVec3f.x;
    this.y = paramVec3f.y;
    this.z = paramVec3f.z;
  }
  
  public void add(Vec3f paramVec3f)
  {
    this.x += paramVec3f.x;
    this.y += paramVec3f.y;
    this.z += paramVec3f.z;
  }
  
  public void add(Vec3f paramVec3f1, Vec3f paramVec3f2)
  {
    paramVec3f1.x += paramVec3f2.x;
    paramVec3f1.y += paramVec3f2.y;
    paramVec3f1.z += paramVec3f2.z;
  }
  
  public void cross(Vec3f paramVec3f1, Vec3f paramVec3f2)
  {
    float f1 = paramVec3f1.y;
    float f2 = paramVec3f2.z;
    float f3 = paramVec3f1.z;
    float f4 = paramVec3f2.y;
    float f5 = paramVec3f2.x;
    float f6 = paramVec3f1.z;
    float f7 = paramVec3f2.z;
    float f8 = paramVec3f1.x;
    this.z = (paramVec3f1.x * paramVec3f2.y - paramVec3f1.y * paramVec3f2.x);
    this.x = (f1 * f2 - f3 * f4);
    this.y = (f5 * f6 - f7 * f8);
  }
  
  public float dot(Vec3f paramVec3f)
  {
    return this.x * paramVec3f.x + this.y * paramVec3f.y + this.z * paramVec3f.z;
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
    } while ((this.x == paramObject.x) && (this.y == paramObject.y) && (this.z == paramObject.z));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return ((Float.floatToIntBits(this.x) + 217) * 31 + Float.floatToIntBits(this.y)) * 31 + Float.floatToIntBits(this.z);
  }
  
  public float length()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }
  
  public final void mul(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
    this.z *= paramFloat;
  }
  
  public void normalize()
  {
    float f = 1.0F / length();
    this.x *= f;
    this.y *= f;
    this.z = (f * this.z);
  }
  
  public void set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public void set(Vec3f paramVec3f)
  {
    this.x = paramVec3f.x;
    this.y = paramVec3f.y;
    this.z = paramVec3f.z;
  }
  
  public void sub(Vec3f paramVec3f)
  {
    this.x -= paramVec3f.x;
    this.y -= paramVec3f.y;
    this.z -= paramVec3f.z;
  }
  
  public void sub(Vec3f paramVec3f1, Vec3f paramVec3f2)
  {
    paramVec3f1.x -= paramVec3f2.x;
    paramVec3f1.y -= paramVec3f2.y;
    paramVec3f1.z -= paramVec3f2.z;
  }
  
  public String toString()
  {
    return "Vec3f[" + this.x + ", " + this.y + ", " + this.z + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f
 * JD-Core Version:    0.7.0.1
 */