package com.tencent.mobileqq.dinifly.model.content;

import com.tencent.mobileqq.dinifly.utils.GammaEvaluator;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;

public class GradientColor
{
  private final int[] colors;
  private final float[] positions;
  
  public GradientColor(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    this.positions = paramArrayOfFloat;
    this.colors = paramArrayOfInt;
  }
  
  public int[] getColors()
  {
    return this.colors;
  }
  
  public float[] getPositions()
  {
    return this.positions;
  }
  
  public int getSize()
  {
    return this.colors.length;
  }
  
  public void lerp(GradientColor paramGradientColor1, GradientColor paramGradientColor2, float paramFloat)
  {
    if (paramGradientColor1.colors.length != paramGradientColor2.colors.length) {
      throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + paramGradientColor1.colors.length + " vs " + paramGradientColor2.colors.length + ")");
    }
    int i = 0;
    while (i < paramGradientColor1.colors.length)
    {
      this.positions[i] = MiscUtils.lerp(paramGradientColor1.positions[i], paramGradientColor2.positions[i], paramFloat);
      this.colors[i] = GammaEvaluator.evaluate(paramFloat, paramGradientColor1.colors[i], paramGradientColor2.colors[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.GradientColor
 * JD-Core Version:    0.7.0.1
 */