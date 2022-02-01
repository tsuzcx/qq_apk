package com.tencent.mobileqq.kandian.biz.detail.web.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebArticleOptimizeUtil;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleOptimizeUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/impl/RIJWebArticleOptimizeUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IRIJWebArticleOptimizeUtil;", "()V", "getWebUrlWithOptimization", "", "url", "usePendingTransition", "", "context", "Landroid/content/Context;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleOptimizeUtilImpl
  implements IRIJWebArticleOptimizeUtil
{
  @Nullable
  public String getWebUrlWithOptimization(@Nullable String paramString)
  {
    return RIJWebArticleOptimizeUtil.a.a(paramString);
  }
  
  public void usePendingTransition(@Nullable Context paramContext)
  {
    RIJWebArticleOptimizeUtil.a.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.impl.RIJWebArticleOptimizeUtilImpl
 * JD-Core Version:    0.7.0.1
 */