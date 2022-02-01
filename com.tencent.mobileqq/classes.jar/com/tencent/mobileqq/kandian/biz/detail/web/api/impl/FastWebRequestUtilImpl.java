package com.tencent.mobileqq.kandian.biz.detail.web.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/impl/FastWebRequestUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IFastWebRequestUtil;", "()V", "addHeadForUrl", "", "imageUrl", "isHttps", "", "getArticleDisplayParams", "", "context", "Landroid/content/Context;", "getWebAdLink", "getWebRecLink", "setWebAdLink", "", "webAdLinkStr", "setWebRecLink", "webRecLinkStr", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastWebRequestUtilImpl
  implements IFastWebRequestUtil
{
  public static final FastWebRequestUtilImpl.Companion Companion = new FastWebRequestUtilImpl.Companion(null);
  @NotNull
  private static String webAdLink = "https://c.mp.qq.com/cgi-bin/ad/get_mp_ads?";
  @NotNull
  private static String webRecLink = "https://kandian.qq.com/kandian_article/get_article_recomm?from=native";
  
  @Nullable
  public String addHeadForUrl(@Nullable String paramString, boolean paramBoolean)
  {
    return FastWebRequestUtil.a(paramString, paramBoolean);
  }
  
  @Nullable
  public Map<String, String> getArticleDisplayParams(@Nullable Context paramContext)
  {
    return FastWebRequestUtil.a(paramContext);
  }
  
  @NotNull
  public String getWebAdLink()
  {
    return webAdLink;
  }
  
  @NotNull
  public String getWebRecLink()
  {
    return webRecLink;
  }
  
  public void setWebAdLink(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "webAdLinkStr");
    webAdLink = paramString;
  }
  
  public void setWebRecLink(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "webRecLinkStr");
    webRecLink = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.impl.FastWebRequestUtilImpl
 * JD-Core Version:    0.7.0.1
 */