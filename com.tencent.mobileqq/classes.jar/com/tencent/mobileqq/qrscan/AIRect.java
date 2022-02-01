package com.tencent.mobileqq.qrscan;

import android.graphics.Rect;

public class AIRect
{
  public int a;
  public Rect b = new Rect();
  public float c;
  
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
    return String.format("AIRect[%s,%.2f,%s]", new Object[] { a(this.a), Float.valueOf(this.c), this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.AIRect
 * JD-Core Version:    0.7.0.1
 */