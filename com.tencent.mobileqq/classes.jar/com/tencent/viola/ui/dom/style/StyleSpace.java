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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (FloatUtils.floatsEqual(get(0), paramStyleSpace.get(0)))
    {
      bool1 = bool2;
      if (FloatUtils.floatsEqual(get(1), paramStyleSpace.get(1)))
      {
        bool1 = bool2;
        if (FloatUtils.floatsEqual(get(2), paramStyleSpace.get(2)))
        {
          bool1 = bool2;
          if (FloatUtils.floatsEqual(get(3), paramStyleSpace.get(3))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public float get(int paramInt)
  {
    Object localObject = this.mDefaultSpacing;
    float f;
    if (localObject != null) {
      f = localObject[paramInt];
    } else if ((paramInt != 6) && (paramInt != 7)) {
      f = 0.0F;
    } else {
      f = (0.0F / 0.0F);
    }
    int i = this.mValueFlags;
    if (i == 0) {
      return f;
    }
    if ((i & sFlagsMap[paramInt]) != 0) {
      return this.mSpacing[paramInt];
    }
    if (this.mHasAliasesSet)
    {
      if ((paramInt != 1) && (paramInt != 3)) {
        paramInt = 5;
      } else {
        paramInt = 4;
      }
      i = this.mValueFlags;
      localObject = sFlagsMap;
      if ((localObject[paramInt] & i) != 0) {
        return this.mSpacing[paramInt];
      }
      if ((i & localObject[8]) != 0) {
        return this.mSpacing[8];
      }
    }
    return f;
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
    boolean bool2 = FloatUtils.floatsEqual(this.mSpacing[paramInt], paramFloat);
    boolean bool1 = false;
    if (!bool2)
    {
      this.mSpacing[paramInt] = paramFloat;
      int i;
      if (FlexConstants.isUndefined(paramFloat))
      {
        i = this.mValueFlags;
        this.mValueFlags = ((sFlagsMap[paramInt] ^ 0xFFFFFFFF) & i);
      }
      else
      {
        i = this.mValueFlags;
        this.mValueFlags = (sFlagsMap[paramInt] | i);
      }
      paramInt = this.mValueFlags;
      int[] arrayOfInt = sFlagsMap;
      if (((arrayOfInt[8] & paramInt) != 0) || ((arrayOfInt[4] & paramInt) != 0) || ((paramInt & arrayOfInt[5]) != 0)) {
        bool1 = true;
      }
      this.mHasAliasesSet = bool1;
      return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.StyleSpace
 * JD-Core Version:    0.7.0.1
 */