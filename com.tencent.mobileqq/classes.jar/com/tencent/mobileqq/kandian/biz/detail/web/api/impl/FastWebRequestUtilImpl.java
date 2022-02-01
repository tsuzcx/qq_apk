package com.tencent.mobileqq.kandian.biz.detail.web.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebRequestUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/impl/FastWebRequestUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IFastWebRequestUtil;", "()V", "addHeadForUrl", "", "imageUrl", "isHttps", "", "getArticleDisplayParams", "", "context", "Landroid/content/Context;", "getWebAdLink", "getWebRecLink", "setWebAdLink", "", "webAdLinkStr", "setWebRecLink", "webRecLinkStr", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastWebRequestUtilImpl
  implements IFastWebRequestUtil
{
  @Nullable
  public String addHeadForUrl(@Nullable String paramString, boolean paramBoolean)
  {
    return this.$$delegate_0.addHeadForUrl(paramString, paramBoolean);
  }
  
  @Nullable
  public Map<String, String> getArticleDisplayParams(@Nullable Context paramContext)
  {
    return this.$$delegate_0.getArticleDisplayParams(paramContext);
  }
  
  @NotNull
  public String getWebAdLink()
  {
    return this.$$delegate_0.getWebAdLink();
  }
  
  @NotNull
  public String getWebRecLink()
  {
    return this.$$delegate_0.getWebRecLink();
  }
  
  public void setWebAdLink(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "webAdLinkStr");
    this.$$delegate_0.setWebAdLink(paramString);
  }
  
  public void setWebRecLink(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "webRecLinkStr");
    this.$$delegate_0.setWebRecLink(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.impl.FastWebRequestUtilImpl
 * JD-Core Version:    0.7.0.1
 */