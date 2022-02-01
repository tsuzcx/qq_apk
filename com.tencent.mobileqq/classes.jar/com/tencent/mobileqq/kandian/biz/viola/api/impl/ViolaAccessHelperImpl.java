package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/ViolaAccessHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaAccessHelper;", "()V", "getviolaurlfromweb", "", "webUrl", "isKanDianWebHost", "", "isViolaUrlFromWeb", "saveViolaFollowChannel", "", "channelUrl", "startViolaPage", "context", "Landroid/content/Context;", "title", "jsUrl", "bundle", "Landroid/os/Bundle;", "useTransParentfragment", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaAccessHelperImpl
  implements IViolaAccessHelper
{
  @NotNull
  public String getviolaurlfromweb(@Nullable String paramString)
  {
    paramString = ViolaAccessHelper.c(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "ViolaAccessHelper.getViolaUrlFromWeb(webUrl)");
    return paramString;
  }
  
  public boolean isKanDianWebHost(@Nullable String paramString)
  {
    return ViolaAccessHelper.b(paramString);
  }
  
  public boolean isViolaUrlFromWeb(@Nullable String paramString)
  {
    return ViolaAccessHelper.c(paramString);
  }
  
  public void saveViolaFollowChannel(@Nullable String paramString)
  {
    ViolaAccessHelper.a(paramString);
  }
  
  public void startViolaPage(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle)
  {
    ViolaAccessHelper.a(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public void startViolaPage(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    ViolaAccessHelper.a(paramContext, paramString1, paramString2, paramBundle, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.ViolaAccessHelperImpl
 * JD-Core Version:    0.7.0.1
 */