package com.tencent.mobileqq.kandian.biz.framework.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJSmartCropUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSmartCropURL", "", "url", "width", "", "height", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJSmartCropUtils
  extends QRouteApi
{
  @Nullable
  public abstract String getSmartCropURL(@Nullable String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.IRIJSmartCropUtils
 * JD-Core Version:    0.7.0.1
 */