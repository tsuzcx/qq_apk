package com.tencent.mobileqq.kandian.biz.detail.web.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IFastWebRequestUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addHeadForUrl", "", "imageUrl", "isHttps", "", "getArticleDisplayParams", "", "context", "Landroid/content/Context;", "getWebAdLink", "getWebRecLink", "setWebAdLink", "", "webAdLinkStr", "setWebRecLink", "webRecLinkStr", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFastWebRequestUtil
  extends QRouteApi
{
  public static final IFastWebRequestUtil.Companion Companion = IFastWebRequestUtil.Companion.a;
  @NotNull
  public static final String WEB_AD_GRAY = "http://betac.mp.qq.com/cgi-bin/ad/get_mp_ads?";
  @NotNull
  public static final String WEB_AD_STABLE = "https://c.mp.qq.com/cgi-bin/ad/get_mp_ads?";
  @NotNull
  public static final String WEB_AD_TEST = "http://oac.mp.qq.com/cgi-bin/ad/get_mp_ads?";
  @NotNull
  public static final String WEB_REC_STABLE = "https://kandian.qq.com/kandian_article/get_article_recomm?from=native";
  @NotNull
  public static final String WEB_REC_TEST = "http://10.240.163.32/kandian_article/get_article_recomm?from=native";
  
  @Nullable
  public abstract String addHeadForUrl(@Nullable String paramString, boolean paramBoolean);
  
  @Nullable
  public abstract Map<String, String> getArticleDisplayParams(@Nullable Context paramContext);
  
  @NotNull
  public abstract String getWebAdLink();
  
  @NotNull
  public abstract String getWebRecLink();
  
  public abstract void setWebAdLink(@NotNull String paramString);
  
  public abstract void setWebRecLink(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebRequestUtil
 * JD-Core Version:    0.7.0.1
 */