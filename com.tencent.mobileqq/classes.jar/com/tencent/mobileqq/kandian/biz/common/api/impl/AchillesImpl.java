package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.kandian.biz.common.Achilles;
import com.tencent.mobileqq.kandian.biz.common.api.IAchilles;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/AchillesImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IAchilles;", "()V", "installIfDownloaded", "", "callBack", "", "packageName", "runtime", "", "installWhenJump2Web", "queryPreDownloadInfoAladdin", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AchillesImpl
  implements IAchilles
{
  public boolean installIfDownloaded(@Nullable String paramString1, @Nullable String paramString2, @Nullable Object paramObject, boolean paramBoolean)
  {
    Object localObject = paramObject;
    if (!(paramObject instanceof WebViewPlugin.PluginRuntime)) {
      localObject = null;
    }
    return Achilles.a(paramString1, paramString2, (WebViewPlugin.PluginRuntime)localObject, paramBoolean);
  }
  
  @Nullable
  public String queryPreDownloadInfoAladdin(@Nullable String paramString)
  {
    return Achilles.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.AchillesImpl
 * JD-Core Version:    0.7.0.1
 */