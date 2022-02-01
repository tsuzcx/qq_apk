package com.tencent.mobileqq.qrscan;

import android.graphics.Rect;

public class AIRect
{
  public float a;
  public int a;
  public Rect a;
  
  public AIRect()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "";
        }
        return "CLASS_FOR_WEIXINCODE";
      }
      return "CLASS_FOR_MINICODE";
    }
    return "CLASS_FOR_QRCODE";
  }
  
  public String toString()
  {
    return String.format("AIRect[%s,%.2f,%s]", new Object[] { a(this.jdField_a_of_type_Int), Float.valueOf(this.jdField_a_of_type_Float), this.jdField_a_of_type_AndroidGraphicsRect });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.AIRect
 * JD-Core Version:    0.7.0.1
 */