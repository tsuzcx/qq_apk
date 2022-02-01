package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Random;

public class Flake
{
  private static Random a;
  public float a;
  public int a;
  public Bitmap a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d = 0.0F;
  public float e;
  public float f;
  public float g;
  
  static
  {
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public Flake()
  {
    this.jdField_c_of_type_Float = 0.0F;
  }
  
  public static Flake a(float paramFloat, Bitmap paramBitmap, int paramInt, Resources paramResources)
  {
    Flake localFlake = new Flake();
    float f1 = paramBitmap.getHeight() / paramBitmap.getWidth();
    localFlake.jdField_c_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      localFlake.jdField_c_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * 30.0F - 15.0F);
      localFlake.jdField_a_of_type_Int = ((int)(AIOUtils.b(25.0F, paramResources) + jdField_a_of_type_JavaUtilRandom.nextFloat() * AIOUtils.b(15.0F, paramResources)));
      localFlake.jdField_b_of_type_Int = ((int)(localFlake.jdField_a_of_type_Int * f1));
      localFlake.f = (AIOUtils.b(240.0F, paramResources) + jdField_a_of_type_JavaUtilRandom.nextFloat() * AIOUtils.b(100.0F, paramResources));
      localFlake.jdField_b_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * -4.0F * localFlake.jdField_b_of_type_Int);
    }
    else if (paramInt == 2)
    {
      localFlake.jdField_c_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * 60.0F - 30.0F);
      localFlake.d = (jdField_a_of_type_JavaUtilRandom.nextFloat() * 120.0F - 60.0F);
      localFlake.jdField_a_of_type_Int = ((int)(AIOUtils.b(25.0F, paramResources) + jdField_a_of_type_JavaUtilRandom.nextFloat() * AIOUtils.b(15.0F, paramResources)));
      localFlake.jdField_b_of_type_Int = ((int)(localFlake.jdField_a_of_type_Int * f1));
      localFlake.f = (AIOUtils.b(240.0F, paramResources) + jdField_a_of_type_JavaUtilRandom.nextFloat() * AIOUtils.b(100.0F, paramResources));
      localFlake.jdField_b_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * -4.0F * localFlake.jdField_b_of_type_Int);
    }
    else if (paramInt == 3)
    {
      localFlake.jdField_c_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * 90.0F - 45.0F);
      localFlake.d = ((float)jdField_a_of_type_JavaUtilRandom.nextGaussian() * AIOUtils.b(300.0F, paramResources));
      localFlake.jdField_a_of_type_Int = ((int)(AIOUtils.b(25.0F, paramResources) + jdField_a_of_type_JavaUtilRandom.nextFloat() * AIOUtils.b(15.0F, paramResources)));
      localFlake.jdField_b_of_type_Int = ((int)(localFlake.jdField_a_of_type_Int * f1));
      localFlake.jdField_b_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * -4.0F * localFlake.jdField_b_of_type_Int);
      localFlake.f = (AIOUtils.b(180.0F, paramResources) * (float)jdField_a_of_type_JavaUtilRandom.nextGaussian());
      localFlake.e = (AIOUtils.b(150.0F, paramResources) * (float)jdField_a_of_type_JavaUtilRandom.nextGaussian());
      localFlake.g = AIOUtils.b(300.0F, paramResources);
    }
    else
    {
      localFlake.jdField_c_of_type_Float = 0.0F;
      localFlake.f = (AIOUtils.b(85.0F, paramResources) + jdField_a_of_type_JavaUtilRandom.nextFloat() * AIOUtils.b(55.0F, paramResources));
      localFlake.jdField_a_of_type_Int = ((int)(AIOUtils.b(30.0F, paramResources) + jdField_a_of_type_JavaUtilRandom.nextFloat() * AIOUtils.b(6.0F, paramResources)));
      localFlake.jdField_b_of_type_Int = ((int)(localFlake.jdField_a_of_type_Int * f1));
      localFlake.jdField_b_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * -6.0F * localFlake.jdField_b_of_type_Int);
    }
    localFlake.jdField_a_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * (paramFloat - localFlake.jdField_a_of_type_Int));
    localFlake.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return localFlake;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.Flake
 * JD-Core Version:    0.7.0.1
 */