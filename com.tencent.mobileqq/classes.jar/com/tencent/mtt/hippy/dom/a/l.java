package com.tencent.mtt.hippy.dom.a;

public class l
{
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    if ((!Float.isNaN(paramFloat1)) && (!Float.isNaN(paramFloat2))) {
      return Math.abs(paramFloat2 - paramFloat1) < 1.0E-005F;
    }
    return (Float.isNaN(paramFloat1)) && (Float.isNaN(paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.a.l
 * JD-Core Version:    0.7.0.1
 */