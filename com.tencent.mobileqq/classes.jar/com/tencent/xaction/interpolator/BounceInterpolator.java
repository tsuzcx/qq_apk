package com.tencent.xaction.interpolator;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/interpolator/BounceInterpolator;", "Lcom/tencent/xaction/interpolator/BaseInterpolator;", "()V", "bounce", "", "t", "getInterpolation", "input", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class BounceInterpolator
  extends BaseInterpolator
{
  private final float a(float paramFloat)
  {
    return paramFloat * paramFloat * 8.0F;
  }
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat = 1.1226F * paramFloat;
    if (paramFloat < 0.3535F) {
      return a(paramFloat);
    }
    if (paramFloat < 0.7408F) {
      return a(paramFloat - 0.54719F) + 0.7F;
    }
    if (paramFloat < 0.9644F) {
      return a(paramFloat - 0.8526F) + 0.9F;
    }
    return a(paramFloat - 1.0435F) + 0.95F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.interpolator.BounceInterpolator
 * JD-Core Version:    0.7.0.1
 */