package com.tencent.xaction.interpolator;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/interpolator/SpringInterpolator;", "Lcom/tencent/xaction/interpolator/BaseInterpolator;", "()V", "factor", "", "getFactor", "()F", "setFactor", "(F)V", "getInterpolation", "input", "setValueList", "", "valueList", "Ljava/util/ArrayList;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class SpringInterpolator
  extends BaseInterpolator
{
  private float a = 0.4F;
  
  protected void a(@NotNull ArrayList<Float> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "valueList");
    paramArrayList = paramArrayList.get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "valueList[0]");
    this.a = ((Number)paramArrayList).floatValue();
  }
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(2.0D, -10 * paramFloat) * Math.sin((paramFloat - this.a / 4) * 6.283185307179586D / this.a) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.interpolator.SpringInterpolator
 * JD-Core Version:    0.7.0.1
 */