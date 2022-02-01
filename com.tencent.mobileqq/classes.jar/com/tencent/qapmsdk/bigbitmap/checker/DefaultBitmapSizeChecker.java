package com.tencent.qapmsdk.bigbitmap.checker;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;

public class DefaultBitmapSizeChecker
  implements IBitmapSizeChecker
{
  private static float DEFAULT_MIN_EXCEED_FACTOR = 1.5F;
  
  public Boolean check(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool;
    if ((paramInt1 <= paramInt3 * getThreshold()) && (paramInt2 <= paramInt4 * getThreshold())) {
      bool = false;
    } else {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public float getThreshold()
  {
    float f2 = PluginCombination.bigBitmapPlugin.threshold / 100.0F;
    float f3 = DEFAULT_MIN_EXCEED_FACTOR;
    float f1 = f2;
    if (f2 < f3) {
      f1 = f3;
    }
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.checker.DefaultBitmapSizeChecker
 * JD-Core Version:    0.7.0.1
 */