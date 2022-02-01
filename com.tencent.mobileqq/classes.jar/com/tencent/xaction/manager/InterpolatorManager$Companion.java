package com.tencent.xaction.manager;

import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.tencent.xaction.api.data.InterpolatorData;
import com.tencent.xaction.interpolator.BaseInterpolator;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/manager/InterpolatorManager$Companion;", "", "()V", "map", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "getMap", "()Ljava/util/HashMap;", "setMap", "(Ljava/util/HashMap;)V", "getInterpolator", "Landroid/view/animation/Interpolator;", "interpolatorData", "Lcom/tencent/xaction/api/data/InterpolatorData;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class InterpolatorManager$Companion
{
  @Nullable
  public final Interpolator a(@NotNull InterpolatorData paramInterpolatorData)
  {
    Intrinsics.checkParameterIsNotNull(paramInterpolatorData, "interpolatorData");
    Object localObject1 = paramInterpolatorData.getType();
    Object localObject2 = (Class)((Companion)this).a().get(localObject1);
    if (localObject2 == null)
    {
      if (StringsKt.contains$default((CharSequence)localObject1, (CharSequence)"bezier", false, 2, null))
      {
        localObject1 = new float[4];
        Object tmp60_58 = localObject1;
        tmp60_58[0] = 0.25F;
        Object tmp65_60 = tmp60_58;
        tmp65_60[1] = 0.1F;
        Object tmp70_65 = tmp65_60;
        tmp70_65[2] = 0.25F;
        Object tmp75_70 = tmp70_65;
        tmp75_70[3] = 1.0F;
        tmp75_70;
        paramInterpolatorData = paramInterpolatorData.getValue();
        if (paramInterpolatorData != null)
        {
          paramInterpolatorData = ((Iterable)paramInterpolatorData).iterator();
          int i = 0;
          while (paramInterpolatorData.hasNext())
          {
            localObject2 = paramInterpolatorData.next();
            if (i < 0) {
              CollectionsKt.throwIndexOverflow();
            }
            float f = ((Number)localObject2).floatValue();
            if (i < localObject1.length) {
              localObject1[i] = f;
            }
            i += 1;
          }
        }
        if (Build.VERSION.SDK_INT >= 21) {
          return (Interpolator)new PathInterpolator(localObject1[0], localObject1[1], localObject1[2], localObject1[3]);
        }
      }
      return null;
    }
    localObject1 = ((Class)localObject2).newInstance();
    if (localObject1 != null)
    {
      localObject1 = (BaseInterpolator)localObject1;
      ((BaseInterpolator)localObject1).a(paramInterpolatorData);
      return (Interpolator)localObject1;
    }
    paramInterpolatorData = new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.interpolator.BaseInterpolator");
    for (;;)
    {
      throw paramInterpolatorData;
    }
  }
  
  @NotNull
  public final HashMap<String, Class<?>> a()
  {
    return InterpolatorManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.manager.InterpolatorManager.Companion
 * JD-Core Version:    0.7.0.1
 */