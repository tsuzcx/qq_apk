package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.HashMap;

public class SanHua
{
  static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
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
    localSanHua.jdField_a_of_type_Int = ((int)(AIOUtils.a(8.0F, paramResources) + (float)Math.random() * AIOUtils.a(3.0F, paramResources)));
    localSanHua.jdField_b_of_type_Int = ((int)(f * localSanHua.jdField_a_of_type_Int));
    localSanHua.jdField_a_of_type_ArrayOfFloat = new float[2];
    localSanHua.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localSanHua.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localSanHua.jdField_a_of_type_Float = ((float)Math.random() * AIOUtils.a(90.0F, paramResources) - AIOUtils.a(45.0F, paramResources));
    localSanHua.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localSanHua.jdField_a_of_type_Double >= 0.0D) {}
    for (localSanHua.jdField_b_of_type_Float = (AIOUtils.a(10.0F, paramResources) + (float)Math.random() * AIOUtils.a(200.0F, paramResources));; localSanHua.jdField_b_of_type_Float = (-AIOUtils.a(10.0F, paramResources) - (float)Math.random() * AIOUtils.a(200.0F, paramResources)))
    {
      localSanHua.c = ((float)(localSanHua.jdField_b_of_type_Float * Math.cos(localSanHua.jdField_a_of_type_Double)));
      localSanHua.d = ((float)(localSanHua.jdField_b_of_type_Float * Math.sin(localSanHua.jdField_a_of_type_Double)));
      localSanHua.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localSanHua.jdField_a_of_type_Int)));
      if (localSanHua.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localSanHua.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localSanHua.jdField_a_of_type_Int, localSanHua.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localSanHua.jdField_a_of_type_Int), localSanHua.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localSanHua;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SanHua
 * JD-Core Version:    0.7.0.1
 */