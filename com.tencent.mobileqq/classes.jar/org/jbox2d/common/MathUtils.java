package org.jbox2d.common;

import java.util.Random;

public class MathUtils
  extends PlatformMathUtils
{
  public static final float DEG2RAD = 0.01745329F;
  public static final float HALF_PI = 1.570796F;
  public static final float INV_PI = 0.3183099F;
  public static final float PI = 3.141593F;
  public static final float QUARTER_PI = 0.7853982F;
  public static final float RAD2DEG = 57.295776F;
  public static final float THREE_HALVES_PI = 4.712389F;
  public static final float TWOPI = 6.283186F;
  public static final float[] sinLUT = new float[Settings.SINCOS_LUT_LENGTH];
  
  static
  {
    int i = 0;
    while (i < Settings.SINCOS_LUT_LENGTH)
    {
      sinLUT[i] = ((float)Math.sin(i * 0.00011F));
      i += 1;
    }
  }
  
  public static final float abs(float paramFloat)
  {
    if (Settings.FAST_ABS)
    {
      if (paramFloat > 0.0F) {
        return paramFloat;
      }
      return -paramFloat;
    }
    return Math.abs(paramFloat);
  }
  
  public static final int abs(int paramInt)
  {
    int i = paramInt >> 31;
    return (paramInt ^ i) - i;
  }
  
  public static final float atan2(float paramFloat1, float paramFloat2)
  {
    if (Settings.FAST_ATAN2) {
      return fastAtan2(paramFloat1, paramFloat2);
    }
    return (float)StrictMath.atan2(paramFloat1, paramFloat2);
  }
  
  public static final int ceil(float paramFloat)
  {
    if (Settings.FAST_CEIL)
    {
      int j = (int)paramFloat;
      int i = j;
      if (paramFloat > 0.0F)
      {
        i = j;
        if (paramFloat != j) {
          i = j + 1;
        }
      }
      return i;
    }
    return (int)Math.ceil(paramFloat);
  }
  
  public static final int ceilPowerOf2(int paramInt)
  {
    int i = 1;
    while (i < paramInt) {
      i <<= 1;
    }
    return i;
  }
  
  public static final float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return max(paramFloat2, min(paramFloat1, paramFloat3));
  }
  
  public static final Vec2 clamp(Vec2 paramVec21, Vec2 paramVec22, Vec2 paramVec23)
  {
    Vec2 localVec2 = new Vec2();
    float f;
    if (paramVec21.x < paramVec23.x) {
      f = paramVec21.x;
    } else {
      f = paramVec23.x;
    }
    localVec2.x = f;
    if (paramVec21.y < paramVec23.y) {
      f = paramVec21.y;
    } else {
      f = paramVec23.y;
    }
    localVec2.y = f;
    if (paramVec22.x > localVec2.x) {
      f = paramVec22.x;
    } else {
      f = localVec2.x;
    }
    localVec2.x = f;
    if (paramVec22.y > localVec2.y) {
      f = paramVec22.y;
    } else {
      f = localVec2.y;
    }
    localVec2.y = f;
    return localVec2;
  }
  
  public static final void clampToOut(Vec2 paramVec21, Vec2 paramVec22, Vec2 paramVec23, Vec2 paramVec24)
  {
    float f;
    if (paramVec21.x < paramVec23.x) {
      f = paramVec21.x;
    } else {
      f = paramVec23.x;
    }
    paramVec24.x = f;
    if (paramVec21.y < paramVec23.y) {
      f = paramVec21.y;
    } else {
      f = paramVec23.y;
    }
    paramVec24.y = f;
    if (paramVec22.x > paramVec24.x) {
      f = paramVec22.x;
    } else {
      f = paramVec24.x;
    }
    paramVec24.x = f;
    if (paramVec22.y > paramVec24.y) {
      f = paramVec22.y;
    } else {
      f = paramVec24.y;
    }
    paramVec24.y = f;
  }
  
  public static final float cos(float paramFloat)
  {
    if (Settings.SINCOS_LUT_ENABLED) {
      return sinLUT(1.570796F - paramFloat);
    }
    return (float)StrictMath.cos(paramFloat);
  }
  
  public static final float distance(Vec2 paramVec21, Vec2 paramVec22)
  {
    return sqrt(distanceSquared(paramVec21, paramVec22));
  }
  
  public static final float distanceSquared(Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramVec21.x - paramVec22.x;
    float f2 = paramVec21.y - paramVec22.y;
    return f1 * f1 + f2 * f2;
  }
  
  public static final float fastAtan2(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F)
    {
      if (paramFloat1 > 0.0F) {
        return 1.570796F;
      }
      if (paramFloat1 == 0.0F) {
        return 0.0F;
      }
      return -1.570796F;
    }
    float f1 = paramFloat1 / paramFloat2;
    if (abs(f1) < 1.0F)
    {
      float f2 = f1 / (0.28F * f1 * f1 + 1.0F);
      f1 = f2;
      if (paramFloat2 < 0.0F)
      {
        if (paramFloat1 < 0.0F) {
          return f2 - 3.141593F;
        }
        return f2 + 3.141593F;
      }
    }
    else
    {
      paramFloat2 = 1.570796F - f1 / (f1 * f1 + 0.28F);
      f1 = paramFloat2;
      if (paramFloat1 < 0.0F) {
        f1 = paramFloat2 - 3.141593F;
      }
    }
    return f1;
  }
  
  public static final int floor(float paramFloat)
  {
    if (Settings.FAST_FLOOR)
    {
      int j = (int)paramFloat;
      int i = j;
      if (paramFloat < 0.0F)
      {
        i = j;
        if (paramFloat != j) {
          i = j - 1;
        }
      }
      return i;
    }
    return (int)Math.floor(paramFloat);
  }
  
  public static final boolean isPowerOfTwo(int paramInt)
  {
    return (paramInt > 0) && ((paramInt & paramInt - 1) == 0);
  }
  
  public static final float map(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return paramFloat4 + (paramFloat1 - paramFloat2) / (paramFloat3 - paramFloat2) * (paramFloat5 - paramFloat4);
  }
  
  public static final float max(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat1;
    }
    return paramFloat2;
  }
  
  public static final int max(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static final float min(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat1;
    }
    return paramFloat2;
  }
  
  public static final int min(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static final int nextPowerOfTwo(int paramInt)
  {
    paramInt |= paramInt >> 1;
    paramInt |= paramInt >> 2;
    paramInt |= paramInt >> 4;
    paramInt |= paramInt >> 8;
    return (paramInt | paramInt >> 16) + 1;
  }
  
  public static final float randomFloat(float paramFloat1, float paramFloat2)
  {
    return (float)Math.random() * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  public static final float randomFloat(Random paramRandom, float paramFloat1, float paramFloat2)
  {
    return paramRandom.nextFloat() * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  public static final float reduceAngle(float paramFloat)
  {
    float f = paramFloat % 6.283186F;
    paramFloat = f;
    if (abs(f) > 3.141593F) {
      paramFloat = f - 6.283186F;
    }
    f = paramFloat;
    if (abs(paramFloat) > 1.570796F) {
      f = 3.141593F - paramFloat;
    }
    return f;
  }
  
  public static final int round(float paramFloat)
  {
    if (Settings.FAST_ROUND) {
      return floor(paramFloat + 0.5F);
    }
    return StrictMath.round(paramFloat);
  }
  
  public static final float sin(float paramFloat)
  {
    if (Settings.SINCOS_LUT_ENABLED) {
      return sinLUT(paramFloat);
    }
    return (float)StrictMath.sin(paramFloat);
  }
  
  public static final float sinLUT(float paramFloat)
  {
    float f1 = paramFloat % 6.283186F;
    paramFloat = f1;
    if (f1 < 0.0F) {
      paramFloat = f1 + 6.283186F;
    }
    if (Settings.SINCOS_LUT_LERP)
    {
      f1 = paramFloat / 0.00011F;
      int i = (int)f1;
      paramFloat = f1;
      if (i != 0) {
        paramFloat = f1 % i;
      }
      float[] arrayOfFloat;
      float f2;
      if (i == Settings.SINCOS_LUT_LENGTH - 1)
      {
        arrayOfFloat = sinLUT;
        f2 = (1.0F - paramFloat) * arrayOfFloat[i];
      }
      for (f1 = arrayOfFloat[0];; f1 = arrayOfFloat[(i + 1)])
      {
        return f2 + paramFloat * f1;
        arrayOfFloat = sinLUT;
        f2 = (1.0F - paramFloat) * arrayOfFloat[i];
      }
    }
    return sinLUT[(round(paramFloat / 0.00011F) % Settings.SINCOS_LUT_LENGTH)];
  }
  
  public static final float sqrt(float paramFloat)
  {
    return (float)StrictMath.sqrt(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.MathUtils
 * JD-Core Version:    0.7.0.1
 */