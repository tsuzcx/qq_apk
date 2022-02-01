package com.tencent.mobileqq.cmshow.brickengine;

import android.util.Pair;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKRenderService$Companion;", "", "()V", "TAG_PRE", "", "correctOffscreenSizeIfNeed", "Landroid/util/Pair;", "", "originSize", "adapterToBrickSize", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class BKRenderService$Companion
{
  private final int a(int paramInt)
  {
    int i = paramInt;
    if (CmShowWnsUtils.aa())
    {
      float f = DeviceInfoUtil.A();
      i = (int)((float)Math.ceil(paramInt / f) * f);
    }
    return i;
  }
  
  @NotNull
  public final Pair<Integer, Integer> a(@Nullable Pair<Integer, Integer> paramPair)
  {
    Object localObject1;
    if (paramPair != null)
    {
      localObject1 = (Companion)this;
      localObject2 = paramPair.first;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "originSize.first");
      localObject1 = new Pair(Integer.valueOf(((Companion)localObject1).a(((Number)localObject2).intValue())), paramPair.second);
    }
    else
    {
      localObject1 = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("correctOffscreenSizeIfNeed from:");
    ((StringBuilder)localObject2).append(paramPair);
    ((StringBuilder)localObject2).append(" to ");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.w("[cmshow][BKCMShowEngine][BKRenderService]", 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKRenderService.Companion
 * JD-Core Version:    0.7.0.1
 */