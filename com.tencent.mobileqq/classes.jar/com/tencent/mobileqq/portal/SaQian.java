package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class SaQian
{
  public double a;
  public float a;
  public int a;
  public long a;
  public Bitmap a;
  public float[] a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d;
  public int d;
  public float e;
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    return paramBitmap;
  }
  
  public static SaQian a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt, Resources paramResources)
  {
    SaQian localSaQian = new SaQian();
    localSaQian.jdField_d_of_type_Int = paramInt;
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    if (paramInt == 0) {}
    for (localSaQian.jdField_a_of_type_Int = AIOUtils.a(30.0F, paramResources);; localSaQian.jdField_a_of_type_Int = AIOUtils.a(22.0F, paramResources))
    {
      localSaQian.jdField_b_of_type_Int = ((int)(f * localSaQian.jdField_a_of_type_Int));
      localSaQian.jdField_a_of_type_ArrayOfFloat = new float[2];
      localSaQian.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
      localSaQian.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
      localSaQian.jdField_a_of_type_Float = ((float)Math.random() * AIOUtils.a(18.0F, paramResources) - AIOUtils.a(9.0F, paramResources));
      localSaQian.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
      localSaQian.jdField_b_of_type_Float = (AIOUtils.a(150.0F, paramResources) + (float)Math.random() * AIOUtils.a(50.0F, paramResources));
      localSaQian.jdField_c_of_type_Float = ((float)(localSaQian.jdField_b_of_type_Float * Math.cos(localSaQian.jdField_a_of_type_Double)));
      localSaQian.jdField_d_of_type_Float = ((float)(localSaQian.jdField_b_of_type_Float * Math.sin(localSaQian.jdField_a_of_type_Double)));
      localSaQian.jdField_c_of_type_Int = 256;
      localSaQian.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return localSaQian;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SaQian
 * JD-Core Version:    0.7.0.1
 */