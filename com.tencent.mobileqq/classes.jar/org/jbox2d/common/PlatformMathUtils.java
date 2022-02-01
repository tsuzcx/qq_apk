package org.jbox2d.common;

class PlatformMathUtils
{
  private static final float INV_SHIFT23 = 1.192093E-007F;
  private static final float SHIFT23 = 8388608.0F;
  
  public static final float fastPow(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = Float.floatToRawIntBits(paramFloat1) * 1.192093E-007F - 127.0F;
    int i;
    if (paramFloat1 >= 0.0F) {
      i = (int)paramFloat1;
    } else {
      i = (int)paramFloat1 - 1;
    }
    float f = paramFloat1 - i;
    paramFloat1 = paramFloat2 * (paramFloat1 + (f - f * f) * 0.346607F);
    if (paramFloat1 >= 0.0F) {
      i = (int)paramFloat1;
    } else {
      i = (int)paramFloat1 - 1;
    }
    paramFloat2 = paramFloat1 - i;
    return Float.intBitsToFloat((int)((paramFloat1 + 127.0F - (paramFloat2 - paramFloat2 * paramFloat2) * 0.33971F) * 8388608.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.PlatformMathUtils
 * JD-Core Version:    0.7.0.1
 */