package org.jbox2d.common;

import java.io.Serializable;

public class Vec2
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public float x;
  public float y;
  
  public Vec2()
  {
    this(0.0F, 0.0F);
  }
  
  public Vec2(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public Vec2(Vec2 paramVec2)
  {
    this(paramVec2.x, paramVec2.y);
  }
  
  public static final Vec2 abs(Vec2 paramVec2)
  {
    return new Vec2(MathUtils.abs(paramVec2.x), MathUtils.abs(paramVec2.y));
  }
  
  public static final void absToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.x = MathUtils.abs(paramVec21.x);
    paramVec22.y = MathUtils.abs(paramVec21.y);
  }
  
  public static final float cross(Vec2 paramVec21, Vec2 paramVec22)
  {
    return paramVec21.x * paramVec22.y - paramVec21.y * paramVec22.x;
  }
  
  public static final Vec2 cross(float paramFloat, Vec2 paramVec2)
  {
    return new Vec2(-paramFloat * paramVec2.y, paramFloat * paramVec2.x);
  }
  
  public static final Vec2 cross(Vec2 paramVec2, float paramFloat)
  {
    return new Vec2(paramVec2.y * paramFloat, -paramFloat * paramVec2.x);
  }
  
  public static final void crossToOut(float paramFloat, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f = paramVec21.x;
    paramVec22.x = (-paramFloat * paramVec21.y);
    paramVec22.y = (f * paramFloat);
  }
  
  public static final void crossToOut(Vec2 paramVec21, float paramFloat, Vec2 paramVec22)
  {
    float f1 = -paramFloat;
    float f2 = paramVec21.x;
    paramVec22.x = (paramFloat * paramVec21.y);
    paramVec22.y = (f1 * f2);
  }
  
  public static final void crossToOutUnsafe(float paramFloat, Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.x = (-paramFloat * paramVec21.y);
    paramVec22.y = (paramFloat * paramVec21.x);
  }
  
  public static final void crossToOutUnsafe(Vec2 paramVec21, float paramFloat, Vec2 paramVec22)
  {
    paramVec22.x = (paramVec21.y * paramFloat);
    paramVec22.y = (-paramFloat * paramVec21.x);
  }
  
  public static final float dot(Vec2 paramVec21, Vec2 paramVec22)
  {
    return paramVec21.x * paramVec22.x + paramVec21.y * paramVec22.y;
  }
  
  public static final Vec2 max(Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramVec21.x;
    float f2 = paramVec22.x;
    if (f1 <= f2) {
      f1 = f2;
    }
    f2 = paramVec21.y;
    float f3 = paramVec22.y;
    if (f2 <= f3) {
      f2 = f3;
    }
    return new Vec2(f1, f2);
  }
  
  public static final void maxToOut(Vec2 paramVec21, Vec2 paramVec22, Vec2 paramVec23)
  {
    float f1 = paramVec21.x;
    float f2 = paramVec22.x;
    if (f1 <= f2) {
      f1 = f2;
    }
    paramVec23.x = f1;
    f1 = paramVec21.y;
    f2 = paramVec22.y;
    if (f1 <= f2) {
      f1 = f2;
    }
    paramVec23.y = f1;
  }
  
  public static final Vec2 min(Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramVec21.x;
    float f2 = paramVec22.x;
    if (f1 >= f2) {
      f1 = f2;
    }
    f2 = paramVec21.y;
    float f3 = paramVec22.y;
    if (f2 >= f3) {
      f2 = f3;
    }
    return new Vec2(f1, f2);
  }
  
  public static final void minToOut(Vec2 paramVec21, Vec2 paramVec22, Vec2 paramVec23)
  {
    float f1 = paramVec21.x;
    float f2 = paramVec22.x;
    if (f1 >= f2) {
      f1 = f2;
    }
    paramVec23.x = f1;
    f1 = paramVec21.y;
    f2 = paramVec22.y;
    if (f1 >= f2) {
      f1 = f2;
    }
    paramVec23.y = f1;
  }
  
  public static final void negateToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.x = (-paramVec21.x);
    paramVec22.y = (-paramVec21.y);
  }
  
  public final Vec2 abs()
  {
    return new Vec2(MathUtils.abs(this.x), MathUtils.abs(this.y));
  }
  
  public final void absLocal()
  {
    this.x = MathUtils.abs(this.x);
    this.y = MathUtils.abs(this.y);
  }
  
  public final Vec2 add(Vec2 paramVec2)
  {
    return new Vec2(this.x + paramVec2.x, this.y + paramVec2.y);
  }
  
  public final Vec2 addLocal(float paramFloat1, float paramFloat2)
  {
    this.x += paramFloat1;
    this.y += paramFloat2;
    return this;
  }
  
  public final Vec2 addLocal(Vec2 paramVec2)
  {
    this.x += paramVec2.x;
    this.y += paramVec2.y;
    return this;
  }
  
  public final Vec2 clone()
  {
    return new Vec2(this.x, this.y);
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
    paramObject = (Vec2)paramObject;
    if (Float.floatToIntBits(this.x) != Float.floatToIntBits(paramObject.x)) {
      return false;
    }
    return Float.floatToIntBits(this.y) == Float.floatToIntBits(paramObject.y);
  }
  
  public int hashCode()
  {
    return (Float.floatToIntBits(this.x) + 31) * 31 + Float.floatToIntBits(this.y);
  }
  
  public final boolean isValid()
  {
    return (!Float.isNaN(this.x)) && (!Float.isInfinite(this.x)) && (!Float.isNaN(this.y)) && (!Float.isInfinite(this.y));
  }
  
  public final float length()
  {
    float f1 = this.x;
    float f2 = this.y;
    return MathUtils.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final float lengthSquared()
  {
    float f1 = this.x;
    float f2 = this.y;
    return f1 * f1 + f2 * f2;
  }
  
  public final Vec2 mul(float paramFloat)
  {
    return new Vec2(this.x * paramFloat, this.y * paramFloat);
  }
  
  public final Vec2 mulLocal(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
    return this;
  }
  
  public final Vec2 negate()
  {
    return new Vec2(-this.x, -this.y);
  }
  
  public final Vec2 negateLocal()
  {
    this.x = (-this.x);
    this.y = (-this.y);
    return this;
  }
  
  public final float normalize()
  {
    float f1 = length();
    if (f1 < 1.192093E-007F) {
      return 0.0F;
    }
    float f2 = 1.0F / f1;
    this.x *= f2;
    this.y *= f2;
    return f1;
  }
  
  public final Vec2 set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    return this;
  }
  
  public final Vec2 set(Vec2 paramVec2)
  {
    this.x = paramVec2.x;
    this.y = paramVec2.y;
    return this;
  }
  
  public final void setZero()
  {
    this.x = 0.0F;
    this.y = 0.0F;
  }
  
  public final Vec2 skew()
  {
    return new Vec2(-this.y, this.x);
  }
  
  public final void skew(Vec2 paramVec2)
  {
    paramVec2.x = (-this.y);
    paramVec2.y = this.x;
  }
  
  public final Vec2 sub(Vec2 paramVec2)
  {
    return new Vec2(this.x - paramVec2.x, this.y - paramVec2.y);
  }
  
  public final Vec2 subLocal(Vec2 paramVec2)
  {
    this.x -= paramVec2.x;
    this.y -= paramVec2.y;
    return this;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(this.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.y);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Vec2
 * JD-Core Version:    0.7.0.1
 */