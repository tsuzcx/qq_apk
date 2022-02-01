package com.tencent.xaction.interpolator;

import android.view.animation.Interpolator;
import com.tencent.xaction.api.data.InterpolatorData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/interpolator/BaseInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "value", "Lcom/tencent/xaction/api/data/InterpolatorData;", "interpolatorData", "getInterpolatorData", "()Lcom/tencent/xaction/api/data/InterpolatorData;", "setInterpolatorData", "(Lcom/tencent/xaction/api/data/InterpolatorData;)V", "setValueList", "", "valueList", "Ljava/util/ArrayList;", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public abstract class BaseInterpolator
  implements Interpolator
{
  @Nullable
  private InterpolatorData a;
  
  public final void a(@Nullable InterpolatorData paramInterpolatorData)
  {
    this.a = paramInterpolatorData;
    paramInterpolatorData = this.a;
    if (paramInterpolatorData != null)
    {
      paramInterpolatorData = paramInterpolatorData.getValue();
      if ((paramInterpolatorData != null) && (paramInterpolatorData.size() > 0)) {
        a(paramInterpolatorData);
      }
    }
  }
  
  protected void a(@NotNull ArrayList<Float> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "valueList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.interpolator.BaseInterpolator
 * JD-Core Version:    0.7.0.1
 */