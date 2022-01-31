package com.tencent.mobileqq.businessCard.views;

import android.graphics.Rect;
import com.tencent.mobileqq.businessCard.helpers.BusinessCardChildViewTransform;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.HashMap;

public class BusinessCardViewLayoutAlgorithm
{
  static float[] jdField_a_of_type_ArrayOfFloat;
  static float[] jdField_b_of_type_ArrayOfFloat;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  public Rect a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  float jdField_c_of_type_Float;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  Rect d = new Rect();
  
  public BusinessCardViewLayoutAlgorithm()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    a();
  }
  
  static float a(float paramFloat)
  {
    return -paramFloat * 1.75F + 1.0F;
  }
  
  public static void a()
  {
    int j = 0;
    if ((jdField_a_of_type_ArrayOfFloat != null) && (jdField_b_of_type_ArrayOfFloat != null)) {
      return;
    }
    jdField_a_of_type_ArrayOfFloat = new float['û'];
    jdField_b_of_type_ArrayOfFloat = new float['û'];
    float[] arrayOfFloat1 = new float['û'];
    int i = 0;
    float f1 = 0.0F;
    while (i <= 250)
    {
      arrayOfFloat1[i] = b(f1);
      f1 += 0.004F;
      i += 1;
    }
    float[] arrayOfFloat2 = new float['û'];
    arrayOfFloat2[0] = 0.0F;
    i = 1;
    for (f1 = 0.0F; i < 250; f1 = f2 + f1)
    {
      arrayOfFloat2[i] = ((float)Math.sqrt(Math.pow(arrayOfFloat1[i] - arrayOfFloat1[(i - 1)], 2.0D) + Math.pow(0.004F, 2.0D)));
      f2 = arrayOfFloat2[i];
      i += 1;
    }
    jdField_b_of_type_ArrayOfFloat[0] = 0.0F;
    jdField_b_of_type_ArrayOfFloat['ú'] = 1.0F;
    i = 1;
    float f2 = 0.0F;
    while (i <= 250)
    {
      f2 += Math.abs(arrayOfFloat2[i] / f1);
      jdField_b_of_type_ArrayOfFloat[i] = f2;
      i += 1;
    }
    jdField_a_of_type_ArrayOfFloat[0] = 0.0F;
    jdField_a_of_type_ArrayOfFloat['ú'] = 1.0F;
    i = 0;
    f1 = 0.0F;
    label213:
    if (i < 250)
    {
      label220:
      if ((j < 250) && (jdField_b_of_type_ArrayOfFloat[j] <= f1)) {
        break label262;
      }
      if (j != 0) {
        break label271;
      }
      jdField_a_of_type_ArrayOfFloat[i] = 0.0F;
    }
    for (;;)
    {
      f1 += 0.004F;
      i += 1;
      break label213;
      break;
      label262:
      j += 1;
      break label220;
      label271:
      f2 = (f1 - jdField_b_of_type_ArrayOfFloat[(j - 1)]) / (jdField_b_of_type_ArrayOfFloat[j] - jdField_b_of_type_ArrayOfFloat[(j - 1)]);
      float f3 = j - 1;
      jdField_a_of_type_ArrayOfFloat[i] = ((f2 + f3) * 0.004F);
    }
  }
  
  static float b(float paramFloat)
  {
    return 1.0F - (float)Math.pow(3000.0D, a(paramFloat)) / 3000.0F;
  }
  
  float a(int paramInt)
  {
    float f2 = 0.0F;
    float f1 = (paramInt - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height();
    if ((f1 < 0.0F) || (f1 > 1.0F)) {
      return f1;
    }
    float f3 = f1 * 250.0F;
    paramInt = (int)Math.floor(f3);
    int i = (int)Math.ceil(f3);
    f1 = f2;
    if (paramInt < 250)
    {
      f1 = f2;
      if (i != paramInt) {
        f1 = (f3 - paramInt) / (i - paramInt) * (jdField_b_of_type_ArrayOfFloat[i] - jdField_b_of_type_ArrayOfFloat[paramInt]);
      }
    }
    return f1 + jdField_b_of_type_ArrayOfFloat[paramInt];
  }
  
  public float a(Object paramObject)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramObject)) {
      return 0.0F;
    }
    return ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject)).floatValue();
  }
  
  int a(float paramFloat)
  {
    float f1 = 0.0F;
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F)) {
      return this.jdField_b_of_type_AndroidGraphicsRect.top + (int)(this.jdField_b_of_type_AndroidGraphicsRect.height() * paramFloat);
    }
    float f2 = 250.0F * paramFloat;
    int i = (int)Math.floor(f2);
    int j = (int)Math.ceil(f2);
    paramFloat = f1;
    if (i < 250)
    {
      paramFloat = f1;
      if (j != i) {
        paramFloat = (f2 - i) / (j - i) * (jdField_a_of_type_ArrayOfFloat[j] - jdField_a_of_type_ArrayOfFloat[i]);
      }
    }
    f1 = jdField_a_of_type_ArrayOfFloat[i];
    i = this.jdField_b_of_type_AndroidGraphicsRect.top;
    return (int)((paramFloat + f1) * this.jdField_b_of_type_AndroidGraphicsRect.height()) + i;
  }
  
  public BusinessCardChildViewTransform a(float paramFloat1, float paramFloat2, BusinessCardChildViewTransform paramBusinessCardChildViewTransform1, BusinessCardChildViewTransform paramBusinessCardChildViewTransform2)
  {
    paramFloat1 -= paramFloat2;
    paramFloat2 = Math.max(0.0F, Math.min(paramFloat1, 1.0F));
    if (paramFloat1 > 1.0F)
    {
      paramBusinessCardChildViewTransform1.a();
      i = (int)((1.0F - c(paramFloat1)) * this.d.height() / 2.0F);
      paramBusinessCardChildViewTransform1.jdField_b_of_type_Int = (a(paramFloat1) - this.jdField_b_of_type_AndroidGraphicsRect.top - i);
      paramBusinessCardChildViewTransform1.jdField_a_of_type_AndroidGraphicsRect.set(this.d);
      return paramBusinessCardChildViewTransform1;
    }
    if ((paramFloat1 < 0.0F) && (paramBusinessCardChildViewTransform2 != null) && (Float.compare(paramBusinessCardChildViewTransform2.jdField_c_of_type_Float, 0.0F) <= 0))
    {
      paramBusinessCardChildViewTransform1.a();
      paramBusinessCardChildViewTransform1.jdField_a_of_type_AndroidGraphicsRect.set(this.d);
      return paramBusinessCardChildViewTransform1;
    }
    float f = c(paramFloat2);
    int i = (int)((1.0F - f) * this.d.height() / 2.0F);
    paramBusinessCardChildViewTransform1.jdField_a_of_type_Float = f;
    paramBusinessCardChildViewTransform1.jdField_b_of_type_Int = (a(paramFloat2) - this.jdField_b_of_type_AndroidGraphicsRect.top - i);
    paramBusinessCardChildViewTransform1.jdField_a_of_type_AndroidGraphicsRect.set(this.d);
    paramBusinessCardChildViewTransform1.jdField_a_of_type_AndroidGraphicsRect.offset(0, paramBusinessCardChildViewTransform1.jdField_b_of_type_Int);
    BusinessCardUtils.a(paramBusinessCardChildViewTransform1.jdField_a_of_type_AndroidGraphicsRect, paramBusinessCardChildViewTransform1.jdField_a_of_type_Float);
    paramBusinessCardChildViewTransform1.jdField_a_of_type_Boolean = true;
    paramBusinessCardChildViewTransform1.jdField_c_of_type_Float = paramFloat1;
    paramBusinessCardChildViewTransform1.jdField_b_of_type_Float = d(paramFloat2);
    return paramBusinessCardChildViewTransform1;
  }
  
  public BusinessCardChildViewTransform a(Object paramObject, float paramFloat, BusinessCardChildViewTransform paramBusinessCardChildViewTransform1, BusinessCardChildViewTransform paramBusinessCardChildViewTransform2)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramObject))
    {
      paramBusinessCardChildViewTransform1.a();
      return paramBusinessCardChildViewTransform1;
    }
    return a(((Float)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject)).floatValue(), paramFloat, paramBusinessCardChildViewTransform1, paramBusinessCardChildViewTransform2);
  }
  
  public void a(int paramInt1, int paramInt2, Rect paramRect, int paramInt3)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
    this.jdField_c_of_type_AndroidGraphicsRect.set(paramRect);
    this.jdField_b_of_type_AndroidGraphicsRect.set(paramRect);
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    paramInt1 = (int)(0.01F * this.jdField_c_of_type_AndroidGraphicsRect.width());
    paramInt2 = (int)(16.0F * DeviceInfoUtil.a());
    this.jdField_c_of_type_AndroidGraphicsRect.inset(paramInt1, paramInt2);
    paramInt1 = this.jdField_c_of_type_AndroidGraphicsRect.width();
    paramInt2 = this.jdField_c_of_type_AndroidGraphicsRect.left;
    int i = paramInt1 * 600 / 1000;
    int j = (int)(97.0F * DeviceInfoUtil.a());
    this.d.set(paramInt2, this.jdField_c_of_type_AndroidGraphicsRect.top, paramInt1 + paramInt2, i + j + this.jdField_c_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_b_of_type_Int = ((int)(0.75F * this.d.height()));
  }
  
  void a(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    if (paramArrayList.isEmpty())
    {
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_Float = 0.0F;
    }
    float f3;
    float f4;
    do
    {
      return;
      i = this.d.height();
      f3 = a(this.jdField_b_of_type_AndroidGraphicsRect.bottom);
      f4 = f3 - a(this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_b_of_type_Int);
    } while (f4 == 0.0F);
    float f5 = a(this.jdField_b_of_type_AndroidGraphicsRect.bottom - i);
    float f6 = a(this.jdField_b_of_type_AndroidGraphicsRect.bottom - (this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_c_of_type_AndroidGraphicsRect.bottom));
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    float f1 = 0.5F;
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramArrayList.get(i), Float.valueOf(f1));
      localArrayList.add(Float.valueOf(f1));
      float f2 = f1;
      if (i < j - 1) {
        f2 = f1 + f4;
      }
      i += 1;
      f1 = f2;
    }
    this.jdField_b_of_type_Float = (f1 - (1.0F - (f3 - f5) - (f3 - f6)));
    if (paramArrayList.size() == 1) {}
    for (f1 = Math.max(this.jdField_b_of_type_Float, 0.0F);; f1 = 0.0F)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_c_of_type_Float = 0.0F;
      return;
    }
  }
  
  float c(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return 0.8F;
    }
    if (paramFloat > 1.0F) {
      return 1.0F;
    }
    return 0.8F + 0.2F * paramFloat;
  }
  
  float d(float paramFloat)
  {
    if (paramFloat < 0.0F) {}
    while (paramFloat > 1.0F) {
      return 0.0F;
    }
    return 0.8F + (1.0F - 0.8F) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.BusinessCardViewLayoutAlgorithm
 * JD-Core Version:    0.7.0.1
 */