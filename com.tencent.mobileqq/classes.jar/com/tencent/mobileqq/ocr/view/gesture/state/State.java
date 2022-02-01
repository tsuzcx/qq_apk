package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Matrix;

public class State
{
  protected float a;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  protected float b;
  private float c = 1.0F;
  private float d;
  
  public static int a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2 + 0.001F) {
      return 1;
    }
    if (paramFloat1 < paramFloat2 - 0.001F) {
      return -1;
    }
    return 0;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    this.jdField_a_of_type_Float = arrayOfFloat[2];
    this.b = arrayOfFloat[5];
    if (paramBoolean1) {
      this.c = ((float)Math.hypot(arrayOfFloat[1], arrayOfFloat[4]));
    }
    if (paramBoolean2)
    {
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      this.d = ((float)Math.toDegrees(Math.atan2(arrayOfFloat[3], arrayOfFloat[4])));
    }
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= paramFloat2 - 0.001F) && (paramFloat1 <= paramFloat2 + 0.001F);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Matrix a()
  {
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public State a()
  {
    State localState = new State();
    localState.a(this);
    return localState;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, paramFloat2);
    a(false, false);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    a(true, false);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f;
    for (;;)
    {
      f = paramFloat4;
      if (paramFloat4 >= -180.0F) {
        break;
      }
      paramFloat4 += 360.0F;
    }
    while (f > 180.0F) {
      f -= 360.0F;
    }
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = f;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (paramFloat3 != 1.0F) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat3, paramFloat3);
    }
    if (f != 0.0F) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(f);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, paramFloat2);
  }
  
  public void a(Matrix paramMatrix)
  {
    paramMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public void a(State paramState)
  {
    this.jdField_a_of_type_Float = paramState.jdField_a_of_type_Float;
    this.b = paramState.b;
    this.c = paramState.c;
    this.d = paramState.d;
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramState.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_Float + paramFloat1, -this.b + paramFloat2);
    a(false, false);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    float f = this.c;
    localMatrix.postScale(paramFloat1 / f, paramFloat1 / f, paramFloat2, paramFloat3);
    a(true, false);
  }
  
  public float c()
  {
    return this.c;
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramFloat1, paramFloat2, paramFloat3);
    a(false, true);
  }
  
  public float d()
  {
    return this.d;
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(-this.d + paramFloat1, paramFloat2, paramFloat3);
    a(false, true);
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
      return (a(paramObject.jdField_a_of_type_Float, this.jdField_a_of_type_Float)) && (a(paramObject.b, this.b)) && (a(paramObject.c, this.c)) && (a(paramObject.d, this.d));
    }
    return false;
  }
  
  public int hashCode()
  {
    float f = this.jdField_a_of_type_Float;
    int m = 0;
    int i;
    if (f != 0.0F) {
      i = Float.floatToIntBits(f);
    } else {
      i = 0;
    }
    f = this.b;
    int j;
    if (f != 0.0F) {
      j = Float.floatToIntBits(f);
    } else {
      j = 0;
    }
    f = this.c;
    int k;
    if (f != 0.0F) {
      k = Float.floatToIntBits(f);
    } else {
      k = 0;
    }
    f = this.d;
    if (f != 0.0F) {
      m = Float.floatToIntBits(f);
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{x=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(",y=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",zoom=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",rotation=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.state.State
 * JD-Core Version:    0.7.0.1
 */