package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Matrix;

public class State
{
  protected float a;
  protected float b;
  private final Matrix c = new Matrix();
  private final float[] d = new float[9];
  private float e = 1.0F;
  private float f;
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c.getValues(this.d);
    float[] arrayOfFloat = this.d;
    this.a = arrayOfFloat[2];
    this.b = arrayOfFloat[5];
    if (paramBoolean1) {
      this.e = ((float)Math.hypot(arrayOfFloat[1], arrayOfFloat[4]));
    }
    if (paramBoolean2)
    {
      arrayOfFloat = this.d;
      this.f = ((float)Math.toDegrees(Math.atan2(arrayOfFloat[3], arrayOfFloat[4])));
    }
  }
  
  public static boolean c(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= paramFloat2 - 0.001F) && (paramFloat1 <= paramFloat2 + 0.001F);
  }
  
  public static int d(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2 + 0.001F) {
      return 1;
    }
    if (paramFloat1 < paramFloat2 - 0.001F) {
      return -1;
    }
    return 0;
  }
  
  public Matrix a()
  {
    return this.c;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.c.postTranslate(paramFloat1, paramFloat2);
    a(false, false);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.c.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    a(true, false);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1;
    for (;;)
    {
      f1 = paramFloat4;
      if (paramFloat4 >= -180.0F) {
        break;
      }
      paramFloat4 += 360.0F;
    }
    while (f1 > 180.0F) {
      f1 -= 360.0F;
    }
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.e = paramFloat3;
    this.f = f1;
    this.c.reset();
    if (paramFloat3 != 1.0F) {
      this.c.postScale(paramFloat3, paramFloat3);
    }
    if (f1 != 0.0F) {
      this.c.postRotate(f1);
    }
    this.c.postTranslate(paramFloat1, paramFloat2);
  }
  
  public void a(Matrix paramMatrix)
  {
    paramMatrix.set(this.c);
  }
  
  public void a(State paramState)
  {
    this.a = paramState.a;
    this.b = paramState.b;
    this.e = paramState.e;
    this.f = paramState.f;
    this.c.set(paramState.c);
  }
  
  public float b()
  {
    return this.a;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.c.postTranslate(-this.a + paramFloat1, -this.b + paramFloat2);
    a(false, false);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix localMatrix = this.c;
    float f1 = this.e;
    localMatrix.postScale(paramFloat1 / f1, paramFloat1 / f1, paramFloat2, paramFloat3);
    a(true, false);
  }
  
  public float c()
  {
    return this.b;
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.c.postRotate(paramFloat1, paramFloat2, paramFloat3);
    a(false, true);
  }
  
  public float d()
  {
    return this.e;
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.c.postRotate(-this.f + paramFloat1, paramFloat2, paramFloat3);
    a(false, true);
  }
  
  public float e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (State)paramObject;
      return (c(paramObject.a, this.a)) && (c(paramObject.b, this.b)) && (c(paramObject.e, this.e)) && (c(paramObject.f, this.f));
    }
    return false;
  }
  
  public State f()
  {
    State localState = new State();
    localState.a(this);
    return localState;
  }
  
  public int hashCode()
  {
    float f1 = this.a;
    int m = 0;
    int i;
    if (f1 != 0.0F) {
      i = Float.floatToIntBits(f1);
    } else {
      i = 0;
    }
    f1 = this.b;
    int j;
    if (f1 != 0.0F) {
      j = Float.floatToIntBits(f1);
    } else {
      j = 0;
    }
    f1 = this.e;
    int k;
    if (f1 != 0.0F) {
      k = Float.floatToIntBits(f1);
    } else {
      k = 0;
    }
    f1 = this.f;
    if (f1 != 0.0F) {
      m = Float.floatToIntBits(f1);
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{x=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",y=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",zoom=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",rotation=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.state.State
 * JD-Core Version:    0.7.0.1
 */