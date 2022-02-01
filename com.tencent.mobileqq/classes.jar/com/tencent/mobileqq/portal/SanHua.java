package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.HashMap;

public class SanHua
{
  static HashMap<Integer, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  double jdField_a_of_type_Double;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  float[] jdField_a_of_type_ArrayOfFloat;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float c;
  float d;
  
  static SanHua a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    SanHua localSanHua = new SanHua();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localSanHua.jdField_a_of_type_Int = ((int)(AIOUtils.b(8.0F, paramResources) + (float)Math.random() * AIOUtils.b(3.0F, paramResources)));
    localSanHua.jdField_b_of_type_Int = ((int)(f * localSanHua.jdField_a_of_type_Int));
    localSanHua.jdField_a_of_type_ArrayOfFloat = new float[2];
    float[] arrayOfFloat = localSanHua.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localSanHua.jdField_a_of_type_Float = ((float)Math.random() * AIOUtils.b(90.0F, paramResources) - AIOUtils.b(45.0F, paramResources));
    localSanHua.jdField_a_of_type_Double = (Math.random() * 2.0D * 3.141592653589793D - 3.141592653589793D);
    if (localSanHua.jdField_a_of_type_Double >= 0.0D) {
      localSanHua.jdField_b_of_type_Float = (AIOUtils.b(10.0F, paramResources) + (float)Math.random() * AIOUtils.b(200.0F, paramResources));
    } else {
      localSanHua.jdField_b_of_type_Float = (-AIOUtils.b(10.0F, paramResources) - (float)Math.random() * AIOUtils.b(200.0F, paramResources));
    }
    double d1 = localSanHua.jdField_b_of_type_Float;
    double d2 = Math.cos(localSanHua.jdField_a_of_type_Double);
    Double.isNaN(d1);
    localSanHua.c = ((float)(d1 * d2));
    d1 = localSanHua.jdField_b_of_type_Float;
    d2 = Math.sin(localSanHua.jdField_a_of_type_Double);
    Double.isNaN(d1);
    localSanHua.d = ((float)(d1 * d2));
    localSanHua.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localSanHua.jdField_a_of_type_Int)));
    if (localSanHua.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      localSanHua.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localSanHua.jdField_a_of_type_Int, localSanHua.jdField_b_of_type_Int, true);
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localSanHua.jdField_a_of_type_Int), localSanHua.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    return localSanHua;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SanHua
 * JD-Core Version:    0.7.0.1
 */