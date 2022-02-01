package org.jbox2d.common;

import java.io.Serializable;

public class Vec3
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public float x;
  public float y;
  public float z;
  
  public Vec3()
  {
    this.z = 0.0F;
    this.y = 0.0F;
    this.x = 0.0F;
  }
  
  public Vec3(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public Vec3(Vec3 paramVec3)
  {
    this.x = paramVec3.x;
    this.y = paramVec3.y;
    this.z = paramVec3.z;
  }
  
  public static final Vec3 cross(Vec3 paramVec31, Vec3 paramVec32)
  {
    float f1 = paramVec31.y;
    float f2 = paramVec32.z;
    float f3 = paramVec31.z;
    float f4 = paramVec32.y;
    float f5 = paramVec32.x;
    float f6 = paramVec31.x;
    return new Vec3(f1 * f2 - f3 * f4, f3 * f5 - f2 * f6, f6 * f4 - f1 * f5);
  }
  
  public static final void crossToOut(Vec3 paramVec31, Vec3 paramVec32, Vec3 paramVec33)
  {
    float f1 = paramVec31.z;
    float f2 = paramVec32.x;
    float f3 = paramVec31.x;
    float f4 = paramVec32.z;
    float f5 = paramVec32.y;
    float f6 = paramVec31.y;
    paramVec33.x = (f6 * f4 - f1 * f5);
    paramVec33.y = (f1 * f2 - f3 * f4);
    paramVec33.z = (f3 * f5 - f2 * f6);
  }
  
  public static final void crossToOutUnsafe(Vec3 paramVec31, Vec3 paramVec32, Vec3 paramVec33)
  {
    float f3 = paramVec31.y;
    float f1 = paramVec32.z;
    float f2 = paramVec31.z;
    paramVec33.x = (f3 * f1 - paramVec32.y * f2);
    f3 = paramVec32.x;
    float f4 = paramVec31.x;
    paramVec33.y = (f2 * f3 - f1 * f4);
    paramVec33.z = (f4 * paramVec32.y - paramVec31.y * f3);
  }
  
  public static final float dot(Vec3 paramVec31, Vec3 paramVec32)
  {
    return paramVec31.x * paramVec32.x + paramVec31.y * paramVec32.y + paramVec31.z * paramVec32.z;
  }
  
  public Vec3 add(Vec3 paramVec3)
  {
    return new Vec3(this.x + paramVec3.x, this.y + paramVec3.y, this.z + paramVec3.z);
  }
  
  public Vec3 addLocal(Vec3 paramVec3)
  {
    this.x += paramVec3.x;
    this.y += paramVec3.y;
    this.z += paramVec3.z;
    return this;
  }
  
  public Vec3 clone()
  {
    return new Vec3(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (Vec3)paramObject;
    if (Float.floatToIntBits(this.x) != Float.floatToIntBits(paramObject.x)) {
      return false;
    }
    if (Float.floatToIntBits(this.y) != Float.floatToIntBits(paramObject.y)) {
      return false;
    }
    return Float.floatToIntBits(this.z) == Float.floatToIntBits(paramObject.z);
  }
  
  public int hashCode()
  {
    return ((Float.floatToIntBits(this.x) + 31) * 31 + Float.floatToIntBits(this.y)) * 31 + Float.floatToIntBits(this.z);
  }
  
  public Vec3 mul(float paramFloat)
  {
    return new Vec3(this.x * paramFloat, this.y * paramFloat, this.z * paramFloat);
  }
  
  public Vec3 mulLocal(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
    this.z *= paramFloat;
    return this;
  }
  
  public Vec3 negate()
  {
    return new Vec3(-this.x, -this.y, -this.z);
  }
  
  public Vec3 negateLocal()
  {
    this.x = (-this.x);
    this.y = (-this.y);
    this.z = (-this.z);
    return this;
  }
  
  public Vec3 set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    return this;
  }
  
  public Vec3 set(Vec3 paramVec3)
  {
    this.x = paramVec3.x;
    this.y = paramVec3.y;
    this.z = paramVec3.z;
    return this;
  }
  
  public void setZero()
  {
    this.x = 0.0F;
    this.y = 0.0F;
    this.z = 0.0F;
  }
  
  public Vec3 sub(Vec3 paramVec3)
  {
    return new Vec3(this.x - paramVec3.x, this.y - paramVec3.y, this.z - paramVec3.z);
  }
  
  public Vec3 subLocal(Vec3 paramVec3)
  {
    this.x -= paramVec3.x;
    this.y -= paramVec3.y;
    this.z -= paramVec3.z;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(this.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.y);
    localStringBuilder.append(",");
    localStringBuilder.append(this.z);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Vec3
 * JD-Core Version:    0.7.0.1
 */