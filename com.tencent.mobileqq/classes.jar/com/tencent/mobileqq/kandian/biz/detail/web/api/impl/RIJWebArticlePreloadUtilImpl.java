package com.tencent.mobileqq.kandian.biz.detail.web.api.impl;

import com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebArticlePreloadUtil;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticlePreloadUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/impl/RIJWebArticlePreloadUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IRIJWebArticlePreloadUtil;", "()V", "preloadImpInWebProcess", "", "url", "", "warmUpTemplateInWebProcess", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticlePreloadUtilImpl
  implements IRIJWebArticlePreloadUtil
{
  public void preloadImpInWebProcess(@Nullable String paramString)
  {
    RIJWebArticlePreloadUtil.a.a(paramString);
  }
  
  public void warmUpTemplateInWebProcess()
  {
    RIJWebArticlePreloadUtil.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.impl.RIJWebArticlePreloadUtilImpl
 * JD-Core Version:    0.7.0.1
 */