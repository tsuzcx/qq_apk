package com.tencent.mobileqq.portal;

import android.opengl.GLES20;
import java.util.HashMap;

public class HongbaoFilter
{
  public static int a;
  public static int b = 2;
  public static int c = 3;
  public HashMap a;
  private int[] a;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public HongbaoFilter()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[1];
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    a(paramFloat1, "percent1");
    a(paramFloat2, "percent2");
    a(paramFloat3, "percent3");
    a(paramFloat4, "percent4");
    a(paramFloat5, "percent5");
    a(paramFloat6, "percent6");
    a(paramFloat7, "percent7");
  }
  
  private void a(float paramFloat, String paramString)
  {
    int i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
    if (i >= 0) {
      GLES20.glUniform1f(i, paramFloat);
    }
  }
  
  private void b(int paramInt)
  {
    float f = new float[] { 1.0F, 1.0F, 0.95F, 0.9F }[paramInt];
    if (paramInt == c) {
      f = 1.1F;
    }
    for (;;)
    {
      a(f, "quality");
      a(0.0F, "add_red");
      a(0.0F, "red_m");
      a(0.0F, "green_m");
      a(0.0F, "blue_m");
      return;
      if (paramInt == b) {
        f = 1.0F;
      }
    }
  }
  
  public void a(int paramInt)
  {
    float f5 = 0.2F;
    float f1;
    float f2;
    float f3;
    float f4;
    if (paramInt == jdField_a_of_type_Int)
    {
      f1 = 0.455F;
      f2 = 0.17F;
      f3 = 0.177F;
      f4 = 0.0F;
    }
    for (;;)
    {
      a(0.0F, f1, f2, f3, 0.0F, f5, f4);
      b(paramInt);
      return;
      if (paramInt == b)
      {
        f1 = 0.62F;
        f2 = 0.375F;
        f3 = 0.07F;
        f5 = 0.125F;
        f4 = 0.26F;
      }
      else if (paramInt == c)
      {
        f1 = 0.824F;
        f2 = 0.461F;
        f3 = 0.152F;
        f4 = 0.0F;
      }
      else
      {
        f4 = 0.0F;
        f5 = 0.0F;
        f3 = 0.0F;
        f2 = 0.0F;
        f1 = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoFilter
 * JD-Core Version:    0.7.0.1
 */