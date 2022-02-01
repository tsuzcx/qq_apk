package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.content.Context;
import com.tencent.biz.qqstory.utils.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageFactory;", "", "()V", "createBarrageItemView", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView;", "context", "Landroid/content/Context;", "barrageParam", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BarrageFactory
{
  public static final BarrageFactory a = new BarrageFactory();
  
  @NotNull
  public final BarrageItemView a(@NotNull Context paramContext, @NotNull BarrageInfo paramBarrageInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramBarrageInfo, "barrageParam");
    paramBarrageInfo = new BarrageItemView(paramContext, null, 0, 6, null);
    paramBarrageInfo.setX(UIUtils.b(paramContext));
    paramBarrageInfo.setY(0.0F);
    return paramBarrageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageFactory
 * JD-Core Version:    0.7.0.1
 */