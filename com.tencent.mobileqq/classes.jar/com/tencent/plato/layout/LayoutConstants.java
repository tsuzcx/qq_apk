package com.tencent.plato.layout;

public class LayoutConstants
{
  public static final float UNDEFINED = (0.0F / 0.0F);
  
  public static boolean isUndefined(float paramFloat)
  {
    return Float.compare(paramFloat, (0.0F / 0.0F)) == 0;
  }
  
  public static boolean isUndefined(PValue paramPValue)
  {
    return paramPValue.unit == PUnit.UNDEFINED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.layout.LayoutConstants
 * JD-Core Version:    0.7.0.1
 */