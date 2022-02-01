package org.jbox2d.common;

import java.io.Serializable;

public class Mat22
  implements Serializable
{
  private static final long serialVersionUID = 2L;
  public final Vec2 ex;
  public final Vec2 ey;
  
  public Mat22()
  {
    this.ex = new Vec2();
    this.ey = new Vec2();
  }
  
  public Mat22(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.ex = new Vec2(paramFloat1, paramFloat3);
    this.ey = new Vec2(paramFloat2, paramFloat4);
  }
  
  public Mat22(Vec2 paramVec21, Vec2 paramVec22)
  {
    this.ex = paramVec21.clone();
    this.ey = paramVec22.clone();
  }
  
  public static final Mat22 abs(Mat22 paramMat22)
  {
    return paramMat22.abs();
  }
  
  public static void absToOut(Mat22 paramMat221, Mat22 paramMat222)
  {
    paramMat222.ex.x = MathUtils.abs(paramMat221.ex.x);
    paramMat222.ex.y = MathUtils.abs(paramMat221.ex.y);
    paramMat222.ey.x = MathUtils.abs(paramMat221.ey.x);
    paramMat222.ey.y = MathUtils.abs(paramMat221.ey.y);
  }
  
  public static final Mat22 createRotationalTransform(float paramFloat)
  {
    Mat22 localMat22 = new Mat22();
    float f = MathUtils.cos(paramFloat);
    paramFloat = MathUtils.sin(paramFloat);
    Vec2 localVec21 = localMat22.ex;
    localVec21.x = f;
    Vec2 localVec22 = localMat22.ey;
    localVec22.x = (-paramFloat);
    localVec21.y = paramFloat;
    localVec22.y = f;
    return localMat22;
  }
  
  public static final void createRotationalTransform(float paramFloat, Mat22 paramMat22)
  {
    float f = MathUtils.cos(paramFloat);
    paramFloat = MathUtils.sin(paramFloat);
    Vec2 localVec2 = paramMat22.ex;
    localVec2.x = f;
    paramMat22 = paramMat22.ey;
    paramMat22.x = (-paramFloat);
    localVec2.y = paramFloat;
    paramMat22.y = f;
  }
  
  public static final Mat22 createScaleTransform(float paramFloat)
  {
    Mat22 localMat22 = new Mat22();
    localMat22.ex.x = paramFloat;
    localMat22.ey.y = paramFloat;
    return localMat22;
  }
  
  public static final void createScaleTransform(float paramFloat, Mat22 paramMat22)
  {
    paramMat22.ex.x = paramFloat;
    paramMat22.ey.y = paramFloat;
  }
  
  public static final Mat22 mul(Mat22 paramMat221, Mat22 paramMat222)
  {
    Mat22 localMat22 = new Mat22();
    localMat22.ex.x = (paramMat221.ex.x * paramMat222.ex.x + paramMat221.ey.x * paramMat222.ex.y);
    localMat22.ex.y = (paramMat221.ex.y * paramMat222.ex.x + paramMat221.ey.y * paramMat222.ex.y);
    localMat22.ey.x = (paramMat221.ex.x * paramMat222.ey.x + paramMat221.ey.x * paramMat222.ey.y);
    localMat22.ey.y = (paramMat221.ex.y * paramMat222.ey.x + paramMat221.ey.y * paramMat222.ey.y);
    return localMat22;
  }
  
  public static final Vec2 mul(Mat22 paramMat22, Vec2 paramVec2)
  {
    return new Vec2(paramMat22.ex.x * paramVec2.x + paramMat22.ey.x * paramVec2.y, paramMat22.ex.y * paramVec2.x + paramMat22.ey.y * paramVec2.y);
  }
  
  public static final void mulToOut(Mat22 paramMat221, Mat22 paramMat222, Mat22 paramMat223)
  {
    float f1 = paramMat221.ex.y;
    float f2 = paramMat222.ex.x;
    float f3 = paramMat221.ey.y;
    float f4 = paramMat222.ex.y;
    float f5 = paramMat221.ex.x;
    float f6 = paramMat222.ex.x;
    float f7 = paramMat221.ey.x;
    float f8 = paramMat222.ex.y;
    float f9 = paramMat221.ex.y;
    float f10 = paramMat222.ey.x;
    float f11 = paramMat221.ey.y;
    float f12 = paramMat222.ey.y;
    float f13 = paramMat221.ex.x;
    float f14 = paramMat222.ey.x;
    float f15 = paramMat221.ey.x;
    float f16 = paramMat222.ey.y;
    paramMat221 = paramMat223.ex;
    paramMat221.x = (f5 * f6 + f7 * f8);
    paramMat221.y = (f1 * f2 + f3 * f4);
    paramMat221 = paramMat223.ey;
    paramMat221.x = (f13 * f14 + f15 * f16);
    paramMat221.y = (f9 * f10 + f11 * f12);
  }
  
  public static final void mulToOut(Mat22 paramMat22, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramMat22.ex.y;
    float f2 = paramVec21.x;
    float f3 = paramMat22.ey.y;
    float f4 = paramVec21.y;
    paramVec22.x = (paramMat22.ex.x * paramVec21.x + paramMat22.ey.x * paramVec21.y);
    paramVec22.y = (f1 * f2 + f3 * f4);
  }
  
  public static final void mulToOutUnsafe(Mat22 paramMat221, Mat22 paramMat222, Mat22 paramMat223)
  {
    paramMat223.ex.x = (paramMat221.ex.x * paramMat222.ex.x + paramMat221.ey.x * paramMat222.ex.y);
    paramMat223.ex.y = (paramMat221.ex.y * paramMat222.ex.x + paramMat221.ey.y * paramMat222.ex.y);
    paramMat223.ey.x = (paramMat221.ex.x * paramMat222.ey.x + paramMat221.ey.x * paramMat222.ey.y);
    paramMat223.ey.y = (paramMat221.ex.y * paramMat222.ey.x + paramMat221.ey.y * paramMat222.ey.y);
  }
  
  public static final void mulToOutUnsafe(Mat22 paramMat22, Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.x = (paramMat22.ex.x * paramVec21.x + paramMat22.ey.x * paramVec21.y);
    paramVec22.y = (paramMat22.ex.y * paramVec21.x + paramMat22.ey.y * paramVec21.y);
  }
  
  public static final Mat22 mulTrans(Mat22 paramMat221, Mat22 paramMat222)
  {
    Mat22 localMat22 = new Mat22();
    localMat22.ex.x = (paramMat221.ex.x * paramMat222.ex.x + paramMat221.ex.y * paramMat222.ex.y);
    localMat22.ex.y = (paramMat221.ey.x * paramMat222.ex.x + paramMat221.ey.y * paramMat222.ex.y);
    localMat22.ey.x = (paramMat221.ex.x * paramMat222.ey.x + paramMat221.ex.y * paramMat222.ey.y);
    localMat22.ey.y = (paramMat221.ey.x * paramMat222.ey.x + paramMat221.ey.y * paramMat222.ey.y);
    return localMat22;
  }
  
  public static final Vec2 mulTrans(Mat22 paramMat22, Vec2 paramVec2)
  {
    return new Vec2(paramVec2.x * paramMat22.ex.x + paramVec2.y * paramMat22.ex.y, paramVec2.x * paramMat22.ey.x + paramVec2.y * paramMat22.ey.y);
  }
  
  public static final void mulTransToOut(Mat22 paramMat221, Mat22 paramMat222, Mat22 paramMat223)
  {
    float f1 = paramMat221.ex.x;
    float f2 = paramMat222.ex.x;
    float f3 = paramMat221.ex.y;
    float f4 = paramMat222.ex.y;
    float f5 = paramMat221.ey.x;
    float f6 = paramMat222.ex.x;
    float f7 = paramMat221.ey.y;
    float f8 = paramMat222.ex.y;
    float f9 = paramMat221.ex.x;
    float f10 = paramMat222.ey.x;
    float f11 = paramMat221.ex.y;
    float f12 = paramMat222.ey.y;
    float f13 = paramMat221.ey.x;
    float f14 = paramMat222.ey.x;
    float f15 = paramMat221.ey.y;
    float f16 = paramMat222.ey.y;
    paramMat221 = paramMat223.ex;
    paramMat221.x = (f1 * f2 + f3 * f4);
    paramMat221.y = (f5 * f6 + f7 * f8);
    paramMat221 = paramMat223.ey;
    paramMat221.x = (f9 * f10 + f11 * f12);
    paramMat221.y = (f13 * f14 + f15 * f16);
  }
  
  public static final void mulTransToOut(Mat22 paramMat22, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramVec21.x;
    float f2 = paramMat22.ex.x;
    float f3 = paramVec21.y;
    float f4 = paramMat22.ex.y;
    paramVec22.y = (paramVec21.x * paramMat22.ey.x + paramVec21.y * paramMat22.ey.y);
    paramVec22.x = (f1 * f2 + f3 * f4);
  }
  
  public static final void mulTransToOutUnsafe(Mat22 paramMat221, Mat22 paramMat222, Mat22 paramMat223)
  {
    paramMat223.ex.x = (paramMat221.ex.x * paramMat222.ex.x + paramMat221.ex.y * paramMat222.ex.y);
    paramMat223.ex.y = (paramMat221.ey.x * paramMat222.ex.x + paramMat221.ey.y * paramMat222.ex.y);
    paramMat223.ey.x = (paramMat221.ex.x * paramMat222.ey.x + paramMat221.ex.y * paramMat222.ey.y);
    paramMat223.ey.y = (paramMat221.ey.x * paramMat222.ey.x + paramMat221.ey.y * paramMat222.ey.y);
  }
  
  public static final void mulTransToOutUnsafe(Mat22 paramMat22, Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.y = (paramVec21.x * paramMat22.ey.x + paramVec21.y * paramMat22.ey.y);
    paramVec22.x = (paramVec21.x * paramMat22.ex.x + paramVec21.y * paramMat22.ex.y);
  }
  
  public final Mat22 abs()
  {
    return new Mat22(MathUtils.abs(this.ex.x), MathUtils.abs(this.ey.x), MathUtils.abs(this.ex.y), MathUtils.abs(this.ey.y));
  }
  
  public final void absLocal()
  {
    this.ex.absLocal();
    this.ey.absLocal();
  }
  
  public final Mat22 add(Mat22 paramMat22)
  {
    Mat22 localMat22 = new Mat22();
    this.ex.x += paramMat22.ex.x;
    this.ex.y += paramMat22.ex.y;
    this.ey.x += paramMat22.ey.x;
    this.ey.y += paramMat22.ey.y;
    return localMat22;
  }
  
  public final Mat22 addLocal(Mat22 paramMat22)
  {
    Vec2 localVec2 = this.ex;
    localVec2.x += paramMat22.ex.x;
    localVec2 = this.ex;
    localVec2.y += paramMat22.ex.y;
    localVec2 = this.ey;
    localVec2.x += paramMat22.ey.x;
    localVec2 = this.ey;
    localVec2.y += paramMat22.ey.y;
    return this;
  }
  
  public final Mat22 clone()
  {
    return new Mat22(this.ex, this.ey);
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
    paramObject = (Mat22)paramObject;
    Vec2 localVec2 = this.ex;
    if (localVec2 == null)
    {
      if (paramObject.ex != null) {
        return false;
      }
    }
    else if (!localVec2.equals(paramObject.ex)) {
      return false;
    }
    localVec2 = this.ey;
    if (localVec2 == null)
    {
      if (paramObject.ey != null) {
        return false;
      }
    }
    else if (!localVec2.equals(paramObject.ey)) {
      return false;
    }
    return true;
  }
  
  public final float getAngle()
  {
    return MathUtils.atan2(this.ex.y, this.ex.x);
  }
  
  public int hashCode()
  {
    Vec2 localVec2 = this.ex;
    int j = 0;
    int i;
    if (localVec2 == null) {
      i = 0;
    } else {
      i = localVec2.hashCode();
    }
    localVec2 = this.ey;
    if (localVec2 != null) {
      j = localVec2.hashCode();
    }
    return (i + 31) * 31 + j;
  }
  
  public final Mat22 invert()
  {
    float f3 = this.ex.x;
    float f4 = this.ey.x;
    float f5 = this.ex.y;
    float f6 = this.ey.y;
    Mat22 localMat22 = new Mat22();
    float f2 = f3 * f6 - f4 * f5;
    float f1 = f2;
    if (f2 != 0.0F) {
      f1 = 1.0F / f2;
    }
    Vec2 localVec21 = localMat22.ex;
    localVec21.x = (f6 * f1);
    Vec2 localVec22 = localMat22.ey;
    f2 = -f1;
    localVec22.x = (f4 * f2);
    localVec21.y = (f2 * f5);
    localVec22.y = (f1 * f3);
    return localMat22;
  }
  
  public final Mat22 invertLocal()
  {
    float f3 = this.ex.x;
    float f4 = this.ey.x;
    float f5 = this.ex.y;
    float f6 = this.ey.y;
    float f2 = f3 * f6 - f4 * f5;
    float f1 = f2;
    if (f2 != 0.0F) {
      f1 = 1.0F / f2;
    }
    Vec2 localVec21 = this.ex;
    localVec21.x = (f6 * f1);
    Vec2 localVec22 = this.ey;
    f2 = -f1;
    localVec22.x = (f4 * f2);
    localVec21.y = (f2 * f5);
    localVec22.y = (f1 * f3);
    return this;
  }
  
  public final void invertToOut(Mat22 paramMat22)
  {
    float f1 = this.ex.x;
    float f2 = this.ey.x;
    float f3 = this.ex.y;
    float f5 = this.ey.y;
    float f4 = 1.0F / (f1 * f5 - f2 * f3);
    Vec2 localVec2 = paramMat22.ex;
    localVec2.x = (f5 * f4);
    paramMat22 = paramMat22.ey;
    f5 = -f4;
    paramMat22.x = (f2 * f5);
    localVec2.y = (f5 * f3);
    paramMat22.y = (f4 * f1);
  }
  
  public final Mat22 mul(Mat22 paramMat22)
  {
    Mat22 localMat22 = new Mat22();
    localMat22.ex.x = (this.ex.x * paramMat22.ex.x + this.ey.x * paramMat22.ex.y);
    localMat22.ex.y = (this.ex.y * paramMat22.ex.x + this.ey.y * paramMat22.ex.y);
    localMat22.ey.x = (this.ex.x * paramMat22.ey.x + this.ey.x * paramMat22.ey.y);
    localMat22.ey.y = (this.ex.y * paramMat22.ey.x + this.ey.y * paramMat22.ey.y);
    return localMat22;
  }
  
  public final Vec2 mul(Vec2 paramVec2)
  {
    return new Vec2(this.ex.x * paramVec2.x + this.ey.x * paramVec2.y, this.ex.y * paramVec2.x + this.ey.y * paramVec2.y);
  }
  
  public final Mat22 mulLocal(Mat22 paramMat22)
  {
    mulToOut(paramMat22, this);
    return this;
  }
  
  public final void mulToOut(Mat22 paramMat221, Mat22 paramMat222)
  {
    float f1 = this.ex.y;
    float f2 = paramMat221.ex.x;
    float f3 = this.ey.y;
    float f4 = paramMat221.ex.y;
    float f5 = this.ex.x;
    float f6 = paramMat221.ex.x;
    float f7 = this.ey.x;
    float f8 = paramMat221.ex.y;
    Vec2 localVec2 = paramMat222.ex;
    localVec2.x = (f5 * f6 + f7 * f8);
    localVec2.y = (f1 * f2 + f3 * f4);
    f1 = this.ex.y;
    f2 = paramMat221.ey.x;
    f3 = this.ey.y;
    f4 = paramMat221.ey.y;
    f5 = this.ex.x;
    f6 = paramMat221.ey.x;
    f7 = this.ey.x;
    f8 = paramMat221.ey.y;
    paramMat221 = paramMat222.ey;
    paramMat221.x = (f5 * f6 + f7 * f8);
    paramMat221.y = (f1 * f2 + f3 * f4);
  }
  
  public final void mulToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = this.ex.y;
    float f2 = paramVec21.x;
    float f3 = this.ey.y;
    float f4 = paramVec21.y;
    paramVec22.x = (this.ex.x * paramVec21.x + this.ey.x * paramVec21.y);
    paramVec22.y = (f1 * f2 + f3 * f4);
  }
  
  public final void mulToOutUnsafe(Mat22 paramMat221, Mat22 paramMat222)
  {
    paramMat222.ex.x = (this.ex.x * paramMat221.ex.x + this.ey.x * paramMat221.ex.y);
    paramMat222.ex.y = (this.ex.y * paramMat221.ex.x + this.ey.y * paramMat221.ex.y);
    paramMat222.ey.x = (this.ex.x * paramMat221.ey.x + this.ey.x * paramMat221.ey.y);
    paramMat222.ey.y = (this.ex.y * paramMat221.ey.x + this.ey.y * paramMat221.ey.y);
  }
  
  public final void mulToOutUnsafe(Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.x = (this.ex.x * paramVec21.x + this.ey.x * paramVec21.y);
    paramVec22.y = (this.ex.y * paramVec21.x + this.ey.y * paramVec21.y);
  }
  
  public final Mat22 mulTrans(Mat22 paramMat22)
  {
    Mat22 localMat22 = new Mat22();
    localMat22.ex.x = Vec2.dot(this.ex, paramMat22.ex);
    localMat22.ex.y = Vec2.dot(this.ey, paramMat22.ex);
    localMat22.ey.x = Vec2.dot(this.ex, paramMat22.ey);
    localMat22.ey.y = Vec2.dot(this.ey, paramMat22.ey);
    return localMat22;
  }
  
  public final Vec2 mulTrans(Vec2 paramVec2)
  {
    return new Vec2(paramVec2.x * this.ex.x + paramVec2.y * this.ex.y, paramVec2.x * this.ey.x + paramVec2.y * this.ey.y);
  }
  
  public final Mat22 mulTransLocal(Mat22 paramMat22)
  {
    mulTransToOut(paramMat22, this);
    return this;
  }
  
  public final void mulTransToOut(Mat22 paramMat221, Mat22 paramMat222)
  {
    float f1 = this.ex.x;
    float f2 = paramMat221.ex.x;
    float f3 = this.ex.y;
    float f4 = paramMat221.ex.y;
    float f5 = this.ey.x;
    float f6 = paramMat221.ex.x;
    float f7 = this.ey.y;
    float f8 = paramMat221.ex.y;
    float f9 = this.ex.x;
    float f10 = paramMat221.ey.x;
    float f11 = this.ex.y;
    float f12 = paramMat221.ey.y;
    float f13 = this.ey.x;
    float f14 = paramMat221.ey.x;
    float f15 = this.ey.y;
    float f16 = paramMat221.ey.y;
    paramMat221 = paramMat222.ex;
    paramMat221.x = (f1 * f2 + f3 * f4);
    paramMat222 = paramMat222.ey;
    paramMat222.x = (f9 * f10 + f11 * f12);
    paramMat221.y = (f5 * f6 + f7 * f8);
    paramMat222.y = (f13 * f14 + f15 * f16);
  }
  
  public final void mulTransToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramVec21.x;
    float f2 = this.ex.x;
    float f3 = paramVec21.y;
    float f4 = this.ex.y;
    paramVec22.y = (paramVec21.x * this.ey.x + paramVec21.y * this.ey.y);
    paramVec22.x = (f1 * f2 + f3 * f4);
  }
  
  public final void mulTransToOutUnsafe(Mat22 paramMat221, Mat22 paramMat222)
  {
    paramMat222.ex.x = (this.ex.x * paramMat221.ex.x + this.ex.y * paramMat221.ex.y);
    paramMat222.ey.x = (this.ex.x * paramMat221.ey.x + this.ex.y * paramMat221.ey.y);
    paramMat222.ex.y = (this.ey.x * paramMat221.ex.x + this.ey.y * paramMat221.ex.y);
    paramMat222.ey.y = (this.ey.x * paramMat221.ey.x + this.ey.y * paramMat221.ey.y);
  }
  
  public final Mat22 set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Vec2 localVec2 = this.ex;
    localVec2.x = paramFloat1;
    localVec2.y = paramFloat3;
    localVec2 = this.ey;
    localVec2.x = paramFloat2;
    localVec2.y = paramFloat4;
    return this;
  }
  
  public final Mat22 set(Mat22 paramMat22)
  {
    this.ex.x = paramMat22.ex.x;
    this.ex.y = paramMat22.ex.y;
    this.ey.x = paramMat22.ey.x;
    this.ey.y = paramMat22.ey.y;
    return this;
  }
  
  public final void set(float paramFloat)
  {
    float f = MathUtils.cos(paramFloat);
    paramFloat = MathUtils.sin(paramFloat);
    Vec2 localVec21 = this.ex;
    localVec21.x = f;
    Vec2 localVec22 = this.ey;
    localVec22.x = (-paramFloat);
    localVec21.y = paramFloat;
    localVec22.y = f;
  }
  
  public final void set(Vec2 paramVec21, Vec2 paramVec22)
  {
    this.ex.x = paramVec21.x;
    this.ey.x = paramVec22.x;
    this.ex.y = paramVec21.y;
    this.ey.y = paramVec22.y;
  }
  
  public final void setIdentity()
  {
    Vec2 localVec21 = this.ex;
    localVec21.x = 1.0F;
    Vec2 localVec22 = this.ey;
    localVec22.x = 0.0F;
    localVec21.y = 0.0F;
    localVec22.y = 1.0F;
  }
  
  public final void setZero()
  {
    Vec2 localVec21 = this.ex;
    localVec21.x = 0.0F;
    Vec2 localVec22 = this.ey;
    localVec22.x = 0.0F;
    localVec21.y = 0.0F;
    localVec22.y = 0.0F;
  }
  
  public final Vec2 solve(Vec2 paramVec2)
  {
    float f3 = this.ex.x;
    float f4 = this.ey.x;
    float f5 = this.ex.y;
    float f6 = this.ey.y;
    float f2 = f3 * f6 - f4 * f5;
    float f1 = f2;
    if (f2 != 0.0F) {
      f1 = 1.0F / f2;
    }
    return new Vec2((f6 * paramVec2.x - f4 * paramVec2.y) * f1, f1 * (f3 * paramVec2.y - f5 * paramVec2.x));
  }
  
  public final void solveToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    float f3 = this.ex.x;
    float f4 = this.ey.x;
    float f5 = this.ex.y;
    float f6 = this.ey.y;
    float f2 = f3 * f6 - f4 * f5;
    float f1 = f2;
    if (f2 != 0.0F) {
      f1 = 1.0F / f2;
    }
    f2 = paramVec21.y;
    float f7 = paramVec21.x;
    paramVec22.x = (f1 * (f6 * paramVec21.x - f4 * paramVec21.y));
    paramVec22.y = ((f3 * f2 - f5 * f7) * f1);
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.ex.x);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.ey.x);
    ((StringBuilder)localObject).append("]\n");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("[");
    localStringBuilder.append(this.ex.y);
    localStringBuilder.append(",");
    localStringBuilder.append(this.ey.y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Mat22
 * JD-Core Version:    0.7.0.1
 */