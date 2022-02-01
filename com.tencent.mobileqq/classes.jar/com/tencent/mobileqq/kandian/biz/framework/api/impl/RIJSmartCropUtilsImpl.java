package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import com.tencent.mobileqq.kandian.biz.framework.api.IRIJSmartCropUtils;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/RIJSmartCropUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJSmartCropUtils;", "()V", "getSmartCropURL", "", "url", "width", "", "height", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJSmartCropUtilsImpl
  implements IRIJSmartCropUtils
{
  @Nullable
  public String getSmartCropURL(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    return RIJSmartCropUtils.a(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.RIJSmartCropUtilsImpl
 * JD-Core Version:    0.7.0.1
 */