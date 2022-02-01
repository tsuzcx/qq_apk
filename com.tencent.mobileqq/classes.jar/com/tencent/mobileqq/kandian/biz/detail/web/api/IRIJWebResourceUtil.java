package com.tencent.mobileqq.kandian.biz.detail.web.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IRIJWebResourceUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getWebResourceResponse", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "url", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJWebResourceUtil
  extends QRouteApi
{
  @Nullable
  public abstract WebResourceResponse getWebResourceResponse(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebResourceUtil
 * JD-Core Version:    0.7.0.1
 */