package com.tencent.mobileqq.kandian.repo.webarticle;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebArticleOptimizeUtil;", "", "()V", "TAG", "", "getUrlUseVasSonic", "url", "getUrlUseWebViewPool", "getWebUrlWithOptimization", "usePendingTransition", "", "context", "Landroid/content/Context;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleOptimizeUtil
{
  public static final RIJWebArticleOptimizeUtil a = new RIJWebArticleOptimizeUtil();
  
  private final String b(String paramString)
  {
    if (!RIJWebArticleUtil.a.b()) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getUrlUseWebViewPool] before url = ");
    localStringBuilder.append(paramString);
    QLog.i("RIJWebArticleOptimizeUtil", 1, localStringBuilder.toString());
    paramString = HtmlOffline.a(paramString, "_wwv=64");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getUrlUseWebViewPool] after result = ");
    localStringBuilder.append(paramString);
    QLog.i("RIJWebArticleOptimizeUtil", 1, localStringBuilder.toString());
    return paramString;
  }
  
  private final String c(String paramString)
  {
    if (!RIJWebArticleUtil.a.c()) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getUrlUseVasSonic] before url = ");
    localStringBuilder.append(paramString);
    QLog.i("RIJWebArticleOptimizeUtil", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("_sonic_xv=");
    localStringBuilder.append(15L);
    paramString = HtmlOffline.a(HtmlOffline.a(HtmlOffline.a(paramString, localStringBuilder.toString()), "sonic=1"), "_tbs_xv=1");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getUrlUseVasSonic] after result = ");
    localStringBuilder.append(paramString);
    QLog.i("RIJWebArticleOptimizeUtil", 1, localStringBuilder.toString());
    return paramString;
  }
  
  @Nullable
  public final String a(@Nullable String paramString)
  {
    return c(b(paramString));
  }
  
  public final void a(@Nullable Context paramContext)
  {
    if ((RIJWebArticleUtil.a.d()) && ((paramContext instanceof Activity))) {
      ((Activity)paramContext).overridePendingTransition(2130771996, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleOptimizeUtil
 * JD-Core Version:    0.7.0.1
 */