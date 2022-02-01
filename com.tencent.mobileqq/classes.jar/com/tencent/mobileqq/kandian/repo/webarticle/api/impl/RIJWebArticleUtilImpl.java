package com.tencent.mobileqq.kandian.repo.webarticle.api.impl;

import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.kandian.repo.webarticle.api.IRIJWebArticleUtil;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/api/impl/RIJWebArticleUtilImpl;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/api/IRIJWebArticleUtil;", "()V", "isSupportWebViewAnimation", "", "isSupportWebViewReuse", "isSupportWebViewVasSonic", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleUtilImpl
  implements IRIJWebArticleUtil
{
  public boolean isSupportWebViewAnimation()
  {
    return RIJWebArticleUtil.a.d();
  }
  
  public boolean isSupportWebViewReuse()
  {
    return RIJWebArticleUtil.a.b();
  }
  
  public boolean isSupportWebViewVasSonic()
  {
    return RIJWebArticleUtil.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.api.impl.RIJWebArticleUtilImpl
 * JD-Core Version:    0.7.0.1
 */