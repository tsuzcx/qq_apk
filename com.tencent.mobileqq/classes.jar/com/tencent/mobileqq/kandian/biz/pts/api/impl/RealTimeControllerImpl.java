package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.mobileqq.kandian.biz.pts.api.IRealTimeController;
import com.tencent.mobileqq.kandian.glue.pts.RealTimeController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/RealTimeControllerImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IRealTimeController;", "()V", "getRealTimeLocalVersion", "", "serviceKey", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RealTimeControllerImpl
  implements IRealTimeController
{
  @NotNull
  public String getRealTimeLocalVersion(@Nullable String paramString)
  {
    paramString = RealTimeController.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "RealTimeController.getRe…eLocalVersion(serviceKey)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.RealTimeControllerImpl
 * JD-Core Version:    0.7.0.1
 */