package com.tencent.viola.ui.dom.style;

public class FloatUtils
{
  private static final float EPSILON = 1.0E-005F;
  
  public static boolean floatsEqual(float paramFloat1, float paramFloat2)
  {
    if ((Float.isNaN(paramFloat1)) || (Float.isNaN(paramFloat2))) {
      if ((!Float.isNaN(paramFloat1)) || (!Float.isNaN(paramFloat2))) {}
    }
    while (Math.abs(paramFloat2 - paramFloat1) < 1.0E-005F)
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.FloatUtils
 * JD-Core Version:    0.7.0.1
 */