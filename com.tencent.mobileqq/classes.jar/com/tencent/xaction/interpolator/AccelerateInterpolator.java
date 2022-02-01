package com.tencent.xaction.interpolator;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/interpolator/AccelerateInterpolator;", "Lcom/tencent/xaction/interpolator/BaseInterpolator;", "()V", "doubleFactor", "", "factor", "getInterpolation", "t", "setValueList", "", "valueList", "Ljava/util/ArrayList;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class AccelerateInterpolator
  extends BaseInterpolator
{
  private float a = 1.0F;
  private float b = 2.0F;
  
  protected void a(@NotNull ArrayList<Float> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "valueList");
    Object localObject = paramArrayList.get(0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "valueList[0]");
    this.a = ((Number)localObject).floatValue();
    if (paramArrayList.size() > 1)
    {
      paramArrayList = paramArrayList.get(1);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "valueList[1]");
      this.b = ((Number)paramArrayList).floatValue();
    }
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (1.0F == this.a) {
      return paramFloat * paramFloat;
    }
    return (float)Math.pow(paramFloat, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.interpolator.AccelerateInterpolator
 * JD-Core Version:    0.7.0.1
 */