package com.tencent.xaction.interpolator;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/interpolator/SpringInterpolator;", "Lcom/tencent/xaction/interpolator/BaseInterpolator;", "()V", "factor", "", "getFactor", "()F", "setFactor", "(F)V", "getInterpolation", "input", "setValueList", "", "valueList", "Ljava/util/ArrayList;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class SpringInterpolator
  extends BaseInterpolator
{
  private float a = 0.4F;
  
  public final void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  protected void a(@NotNull ArrayList<Float> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "valueList");
    paramArrayList = paramArrayList.get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "valueList[0]");
    this.a = ((Number)paramArrayList).floatValue();
  }
  
  public float getInterpolation(float paramFloat)
  {
    double d1 = Math.pow(2.0D, -10 * paramFloat);
    float f = this.a;
    double d2 = paramFloat - f / 4;
    Double.isNaN(d2);
    double d3 = f;
    Double.isNaN(d3);
    d2 = Math.sin(d2 * 6.283185307179586D / d3);
    d3 = 1;
    Double.isNaN(d3);
    return (float)(d1 * d2 + d3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.interpolator.SpringInterpolator
 * JD-Core Version:    0.7.0.1
 */