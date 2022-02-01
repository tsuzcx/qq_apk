package com.tencent.mobileqq.kandian.biz.detail.web.api.impl;

import com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebResourceUtil;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebResourceUtil;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/impl/RIJWebResourceUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IRIJWebResourceUtil;", "()V", "getWebResourceResponse", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "url", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebResourceUtilImpl
  implements IRIJWebResourceUtil
{
  @Nullable
  public WebResourceResponse getWebResourceResponse(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    return RIJWebResourceUtil.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.impl.RIJWebResourceUtilImpl
 * JD-Core Version:    0.7.0.1
 */