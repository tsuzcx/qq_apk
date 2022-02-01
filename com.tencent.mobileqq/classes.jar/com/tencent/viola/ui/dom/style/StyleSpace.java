package com.tencent.viola.ui.dom.style;

import java.util.Arrays;

public class StyleSpace
{
  public static final int ALL = 8;
  public static final int BOTTOM = 3;
  public static final int END = 7;
  public static final int HORIZONTAL = 5;
  public static final int LEFT = 0;
  public static final int RIGHT = 2;
  public static final int START = 6;
  public static final int TOP = 1;
  public static final int VERTICAL = 4;
  private static final int[] sFlagsMap = { 1, 2, 4, 8, 16, 32, 64, 128, 256 };
  private float[] mDefaultSpacing = null;
  private boolean mHasAliasesSet;
  private final float[] mSpacing = newSpaceValue();
  private int mValueFlags = 0;
  
  private float[] newSpaceValue()
  {
    return new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
  }
  
  private static float[] newSpacingResultArray()
  {
    return newSpacingResultArray(0.0F);
  }
  
  private static float[] newSpacingResultArray(float paramFloat)
  {
    return new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, (0.0F / 0.0F), (0.0F / 0.0F), paramFloat };
  }
  
  public boolean equal(StyleSpace paramStyleSpace)
  {
    return (FloatUtils.floatsEqual(get(0), paramStyleSpace.get(0))) && (FloatUtils.floatsEqual(get(1), paramStyleSpace.get(1))) && (FloatUtils.floatsEqual(get(2), paramStyleSpace.get(2))) && (FloatUtils.floatsEqual(get(3), paramStyleSpace.get(3)));
  }
  
  public float get(int paramInt)
  {
    float f;
    if (this.mDefaultSpacing != null)
    {
      f = this.mDefaultSpacing[paramInt];
      if (this.mValueFlags != 0) {
        break label46;
      }
    }
    label46:
    do
    {
      do
      {
        return f;
        if ((paramInt == 6) || (paramInt == 7))
        {
          f = (0.0F / 0.0F);
          break;
        }
        f = 0.0F;
        break;
        if ((this.mValueFlags & sFlagsMap[paramInt]) != 0) {
          return this.mSpacing[paramInt];
        }
      } while (!this.mHasAliasesSet);
      if ((paramInt == 1) || (paramInt == 3)) {}
      for (paramInt = 4; (this.mValueFlags & sFlagsMap[paramInt]) != 0; paramInt = 5) {
        return this.mSpacing[paramInt];
      }
    } while ((this.mValueFlags & sFlagsMap[8]) == 0);
    return this.mSpacing[8];
  }
  
  public float getRaw(int paramInt)
  {
    return this.mSpacing[paramInt];
  }
  
  float getWithFallback(int paramInt1, int paramInt2)
  {
    if ((this.mValueFlags & sFlagsMap[paramInt1]) != 0) {
      return this.mSpacing[paramInt1];
    }
    return get(paramInt2);
  }
  
  void reset()
  {
    Arrays.fill(this.mSpacing, (0.0F / 0.0F));
    this.mDefaultSpacing = null;
    this.mHasAliasesSet = false;
    this.mValueFlags = 0;
  }
  
  public boolean set(int paramInt, float paramFloat)
  {
    boolean bool = false;
    if (!FloatUtils.floatsEqual(this.mSpacing[paramInt], paramFloat))
    {
      this.mSpacing[paramInt] = paramFloat;
      if (FlexConstants.isUndefined(paramFloat)) {}
      for (this.mValueFlags &= (sFlagsMap[paramInt] ^ 0xFFFFFFFF);; this.mValueFlags |= sFlagsMap[paramInt])
      {
        if (((this.mValueFlags & sFlagsMap[8]) != 0) || ((this.mValueFlags & sFlagsMap[4]) != 0) || ((this.mValueFlags & sFlagsMap[5]) != 0)) {
          bool = true;
        }
        this.mHasAliasesSet = bool;
        return true;
      }
    }
    return false;
  }
  
  public boolean setDefault(int paramInt, float paramFloat)
  {
    if (this.mDefaultSpacing == null) {
      this.mDefaultSpacing = newSpacingResultArray();
    }
    if (!FloatUtils.floatsEqual(this.mDefaultSpacing[paramInt], paramFloat))
    {
      this.mDefaultSpacing[paramInt] = paramFloat;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.StyleSpace
 * JD-Core Version:    0.7.0.1
 */