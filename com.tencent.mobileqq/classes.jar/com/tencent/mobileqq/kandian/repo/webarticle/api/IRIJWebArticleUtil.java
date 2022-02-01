package com.tencent.mobileqq.kandian.repo.webarticle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/api/IRIJWebArticleUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isSupportWebViewAnimation", "", "isSupportWebViewReuse", "isSupportWebViewVasSonic", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJWebArticleUtil
  extends QRouteApi
{
  public abstract boolean isSupportWebViewAnimation();
  
  public abstract boolean isSupportWebViewReuse();
  
  public abstract boolean isSupportWebViewVasSonic();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.api.IRIJWebArticleUtil
 * JD-Core Version:    0.7.0.1
 */