package org.jbox2d.common;

import java.io.Serializable;

public class Mat33
  implements Serializable
{
  public static final Mat33 IDENTITY = new Mat33(new Vec3(1.0F, 0.0F, 0.0F), new Vec3(0.0F, 1.0F, 0.0F), new Vec3(0.0F, 0.0F, 1.0F));
  private static final long serialVersionUID = 2L;
  public final Vec3 ex;
  public final Vec3 ey;
  public final Vec3 ez;
  
  public Mat33()
  {
    this.ex = new Vec3();
    this.ey = new Vec3();
    this.ez = new Vec3();
  }
  
  public Mat33(Vec3 paramVec31, Vec3 paramVec32, Vec3 paramVec33)
  {
    this.ex = paramVec31.clone();
    this.ey = paramVec32.clone();
    this.ez = paramVec33.clone();
  }
  
  public static final Vec3 mul(Mat33 paramMat33, Vec3 paramVec3)
  {
    return new Vec3(paramVec3.x * paramMat33.ex.x + paramVec3.y * paramMat33.ey.x + paramVec3.z + paramMat33.ez.x, paramVec3.x * paramMat33.ex.y + paramVec3.y * paramMat33.ey.y + paramVec3.z * paramMat33.ez.y, paramVec3.x * paramMat33.ex.z + paramVec3.y * paramMat33.ey.z + paramVec3.z * paramMat33.ez.z);
  }
  
  public static final Vec2 mul22(Mat33 paramMat33, Vec2 paramVec2)
  {
    return new Vec2(paramMat33.ex.x * paramVec2.x + paramMat33.ey.x * paramVec2.y, paramMat33.ex.y * paramVec2.x + paramMat33.ey.y * paramVec2.y);
  }
  
  public static final void mul22ToOut(Mat33 paramMat33, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramMat33.ex.x;
    float f2 = paramVec21.x;
    float f3 = paramMat33.ey.x;
    float f4 = paramVec21.y;
    paramVec22.y = (paramMat33.ex.y * paramVec21.x + paramMat33.ey.y * paramVec21.y);
    paramVec22.x = (f1 * f2 + f3 * f4);
  }
  
  public static final void mul22ToOutUnsafe(Mat33 paramMat33, Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.y = (paramMat33.ex.y * paramVec21.x + paramMat33.ey.y * paramVec21.y);
    paramVec22.x = (paramMat33.ex.x * paramVec21.x + paramMat33.ey.x * paramVec21.y);
  }
  
  public static final void mulToOut(Mat33 paramMat33, Vec3 paramVec31, Vec3 paramVec32)
  {
    float f1 = paramVec31.x;
    float f2 = paramMat33.ex.y;
    float f3 = paramVec31.y;
    float f4 = paramMat33.ey.y;
    float f5 = paramVec31.z;
    float f6 = paramMat33.ez.y;
    float f7 = paramVec31.x;
    float f8 = paramMat33.ex.z;
    float f9 = paramVec31.y;
    float f10 = paramMat33.ey.z;
    float f11 = paramVec31.z;
    float f12 = paramMat33.ez.z;
    paramVec32.x = (paramVec31.x * paramMat33.ex.x + paramVec31.y * paramMat33.ey.x + paramVec31.z * paramMat33.ez.x);
    paramVec32.y = (f1 * f2 + f3 * f4 + f5 * f6);
    paramVec32.z = (f7 * f8 + f9 * f10 + f11 * f12);
  }
  
  public static final void mulToOutUnsafe(Mat33 paramMat33, Vec3 paramVec31, Vec3 paramVec32)
  {
    paramVec32.x = (paramVec31.x * paramMat33.ex.x + paramVec31.y * paramMat33.ey.x + paramVec31.z * paramMat33.ez.x);
    paramVec32.y = (paramVec31.x * paramMat33.ex.y + paramVec31.y * paramMat33.ey.y + paramVec31.z * paramMat33.ez.y);
    paramVec32.z = (paramVec31.x * paramMat33.ex.z + paramVec31.y * paramMat33.ey.z + paramVec31.z * paramMat33.ez.z);
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
    paramObject = (Mat33)paramObject;
    Vec3 localVec3 = this.ex;
    if (localVec3 == null)
    {
      if (paramObject.ex != null) {
        return false;
      }
    }
    else if (!localVec3.equals(paramObject.ex)) {
      return false;
    }
    localVec3 = this.ey;
    if (localVec3 == null)
    {
      if (paramObject.ey != null) {
        return false;
      }
    }
    else if (!localVec3.equals(paramObject.ey)) {
      return false;
    }
    localVec3 = this.ez;
    if (localVec3 == null)
    {
      if (paramObject.ez != null) {
        return false;
      }
    }
    else if (!localVec3.equals(paramObject.ez)) {
      return false;
    }
    return true;
  }
  
  public void getInverse22(Mat33 paramMat33)
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
    Vec3 localVec31 = paramMat33.ex;
    localVec31.x = (f6 * f1);
    Vec3 localVec32 = paramMat33.ey;
    f2 = -f1;
    localVec32.x = (f4 * f2);
    localVec31.z = 0.0F;
    localVec31.y = (f2 * f5);
    localVec32.y = (f1 * f3);
    localVec32.z = 0.0F;
    paramMat33 = paramMat33.ez;
    paramMat33.x = 0.0F;
    paramMat33.y = 0.0F;
    paramMat33.z = 0.0F;
  }
  
  public void getSymInverse33(Mat33 paramMat33)
  {
    float f1 = this.ey.y;
    float f2 = this.ez.z;
    float f3 = this.ey.z;
    float f4 = this.ez.y;
    float f5 = this.ey.z;
    float f6 = this.ez.x;
    float f7 = this.ey.x;
    float f8 = this.ez.z;
    float f9 = this.ey.x;
    float f10 = this.ez.y;
    float f11 = this.ey.y;
    float f12 = this.ez.x;
    f2 = this.ex.x * (f1 * f2 - f3 * f4) + this.ex.y * (f5 * f6 - f7 * f8) + this.ex.z * (f9 * f10 - f11 * f12);
    f1 = f2;
    if (f2 != 0.0F) {
      f1 = 1.0F / f2;
    }
    f2 = this.ex.x;
    f3 = this.ey.x;
    f4 = this.ez.x;
    f5 = this.ey.y;
    f6 = this.ez.y;
    f7 = this.ez.z;
    Vec3 localVec3 = paramMat33.ex;
    localVec3.x = ((f5 * f7 - f6 * f6) * f1);
    localVec3.y = ((f4 * f6 - f3 * f7) * f1);
    localVec3.z = ((f3 * f6 - f4 * f5) * f1);
    paramMat33.ey.x = localVec3.y;
    localVec3 = paramMat33.ey;
    localVec3.y = ((f7 * f2 - f4 * f4) * f1);
    localVec3.z = ((f4 * f3 - f6 * f2) * f1);
    paramMat33.ez.x = paramMat33.ex.z;
    paramMat33.ez.y = paramMat33.ey.z;
    paramMat33.ez.z = (f1 * (f2 * f5 - f3 * f3));
  }
  
  public int hashCode()
  {
    Vec3 localVec3 = this.ex;
    int k = 0;
    int i;
    if (localVec3 == null) {
      i = 0;
    } else {
      i = localVec3.hashCode();
    }
    localVec3 = this.ey;
    int j;
    if (localVec3 == null) {
      j = 0;
    } else {
      j = localVec3.hashCode();
    }
    localVec3 = this.ez;
    if (localVec3 != null) {
      k = localVec3.hashCode();
    }
    return ((i + 31) * 31 + j) * 31 + k;
  }
  
  public void setZero()
  {
    this.ex.setZero();
    this.ey.setZero();
    this.ez.setZero();
  }
  
  public final Vec2 solve22(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    solve22ToOut(paramVec2, localVec2);
    return localVec2;
  }
  
  public final void solve22ToOut(Vec2 paramVec21, Vec2 paramVec22)
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
    paramVec22.x = ((f6 * paramVec21.x - f4 * paramVec21.y) * f1);
    paramVec22.y = (f1 * (f3 * paramVec21.y - f5 * paramVec21.x));
  }
  
  public final Vec3 solve33(Vec3 paramVec3)
  {
    Vec3 localVec3 = new Vec3();
    solve33ToOut(paramVec3, localVec3);
    return localVec3;
  }
  
  public final void solve33ToOut(Vec3 paramVec31, Vec3 paramVec32)
  {
    Vec3.crossToOutUnsafe(this.ey, this.ez, paramVec32);
    float f2 = Vec3.dot(this.ex, paramVec32);
    float f1 = f2;
    if (f2 != 0.0F) {
      f1 = 1.0F / f2;
    }
    Vec3.crossToOutUnsafe(this.ey, this.ez, paramVec32);
    f2 = Vec3.dot(paramVec31, paramVec32);
    Vec3.crossToOutUnsafe(paramVec31, this.ez, paramVec32);
    float f3 = Vec3.dot(this.ex, paramVec32);
    Vec3.crossToOutUnsafe(this.ey, paramVec31, paramVec32);
    float f4 = Vec3.dot(this.ex, paramVec32);
    paramVec32.x = (f2 * f1);
    paramVec32.y = (f3 * f1);
    paramVec32.z = (f1 * f4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Mat33
 * JD-Core Version:    0.7.0.1
 */