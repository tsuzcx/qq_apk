package com.tencent.mobileqq.utils.palette;

import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;

public final class Target
{
  @NonNull
  public static final Target a;
  @NonNull
  public static final Target b;
  @NonNull
  public static final Target c;
  @NonNull
  public static final Target d;
  @NonNull
  public static final Target e;
  @NonNull
  public static final Target f;
  boolean jdField_a_of_type_Boolean = true;
  final float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  final float[] b;
  final float[] c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqUtilsPaletteTarget = new Target();
    c(jdField_a_of_type_ComTencentMobileqqUtilsPaletteTarget);
    d(jdField_a_of_type_ComTencentMobileqqUtilsPaletteTarget);
    jdField_b_of_type_ComTencentMobileqqUtilsPaletteTarget = new Target();
    b(jdField_b_of_type_ComTencentMobileqqUtilsPaletteTarget);
    d(jdField_b_of_type_ComTencentMobileqqUtilsPaletteTarget);
    jdField_c_of_type_ComTencentMobileqqUtilsPaletteTarget = new Target();
    a(jdField_c_of_type_ComTencentMobileqqUtilsPaletteTarget);
    d(jdField_c_of_type_ComTencentMobileqqUtilsPaletteTarget);
    d = new Target();
    c(d);
    e(d);
    e = new Target();
    b(e);
    e(e);
    f = new Target();
    a(f);
    e(f);
  }
  
  Target()
  {
    this.jdField_b_of_type_ArrayOfFloat = new float[3];
    this.jdField_c_of_type_ArrayOfFloat = new float[3];
    a(this.jdField_a_of_type_ArrayOfFloat);
    a(this.jdField_b_of_type_ArrayOfFloat);
    b();
  }
  
  private static void a(Target paramTarget)
  {
    paramTarget = paramTarget.jdField_b_of_type_ArrayOfFloat;
    paramTarget[1] = 0.26F;
    paramTarget[2] = 0.45F;
  }
  
  private static void a(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
  
  private void b()
  {
    float[] arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
    arrayOfFloat[0] = 0.24F;
    arrayOfFloat[1] = 0.52F;
    arrayOfFloat[2] = 0.24F;
  }
  
  private static void b(Target paramTarget)
  {
    paramTarget = paramTarget.jdField_b_of_type_ArrayOfFloat;
    paramTarget[0] = 0.3F;
    paramTarget[1] = 0.5F;
    paramTarget[2] = 0.7F;
  }
  
  private static void c(Target paramTarget)
  {
    paramTarget = paramTarget.jdField_b_of_type_ArrayOfFloat;
    paramTarget[0] = 0.55F;
    paramTarget[1] = 0.74F;
  }
  
  private static void d(Target paramTarget)
  {
    paramTarget = paramTarget.jdField_a_of_type_ArrayOfFloat;
    paramTarget[0] = 0.35F;
    paramTarget[1] = 1.0F;
  }
  
  private static void e(Target paramTarget)
  {
    paramTarget = paramTarget.jdField_a_of_type_ArrayOfFloat;
    paramTarget[1] = 0.3F;
    paramTarget[2] = 0.4F;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float a()
  {
    return this.jdField_a_of_type_ArrayOfFloat[0];
  }
  
  void a()
  {
    int k = this.jdField_c_of_type_ArrayOfFloat.length;
    int j = 0;
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < k; f1 = f2)
    {
      float f3 = this.jdField_c_of_type_ArrayOfFloat[i];
      f2 = f1;
      if (f3 > 0.0F) {
        f2 = f1 + f3;
      }
      i += 1;
    }
    if (f1 != 0.0F)
    {
      k = this.jdField_c_of_type_ArrayOfFloat.length;
      i = j;
      while (i < k)
      {
        float[] arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
        if (arrayOfFloat[i] > 0.0F) {
          arrayOfFloat[i] /= f1;
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float b()
  {
    return this.jdField_a_of_type_ArrayOfFloat[1];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float c()
  {
    return this.jdField_a_of_type_ArrayOfFloat[2];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float d()
  {
    return this.jdField_b_of_type_ArrayOfFloat[0];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float e()
  {
    return this.jdField_b_of_type_ArrayOfFloat[1];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float f()
  {
    return this.jdField_b_of_type_ArrayOfFloat[2];
  }
  
  public float g()
  {
    return this.jdField_c_of_type_ArrayOfFloat[0];
  }
  
  public float h()
  {
    return this.jdField_c_of_type_ArrayOfFloat[1];
  }
  
  public float i()
  {
    return this.jdField_c_of_type_ArrayOfFloat[2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Target
 * JD-Core Version:    0.7.0.1
 */