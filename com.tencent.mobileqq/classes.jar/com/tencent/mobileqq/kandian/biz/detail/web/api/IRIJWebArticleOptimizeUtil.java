package com.tencent.mobileqq.kandian.biz.detail.web.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IRIJWebArticleOptimizeUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getWebUrlWithOptimization", "", "url", "usePendingTransition", "", "context", "Landroid/content/Context;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJWebArticleOptimizeUtil
  extends QRouteApi
{
  @Nullable
  public abstract String getWebUrlWithOptimization(@Nullable String paramString);
  
  public abstract void usePendingTransition(@Nullable Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebArticleOptimizeUtil
 * JD-Core Version:    0.7.0.1
 */