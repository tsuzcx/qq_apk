package com.tencent.mobileqq.kandian.glue.router.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.tab.IRIJTabFrame;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/router/api/impl/RIJJumpUtilsImpl;", "Lcom/tencent/mobileqq/kandian/glue/router/api/IRIJJumpUtils;", "()V", "getReadinjoyTabFrame", "Lcom/tencent/mobileqq/kandian/base/tab/IRIJTabFrame;", "context", "Landroid/content/Context;", "getSourceForDownloadAndJumpOtherApp", "", "channelID", "", "jumpFromSelf", "", "schema", "jumpToMiniApp", "", "scheme", "launchParam", "miniAppLaunchListener", "Lcom/tencent/mobileqq/mini/api/MiniAppLaunchListener;", "jumpToNativeSearchResultPage", "keyword", "jumpUrl", "jumpToUrl", "url", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "wxAppId", "wxAppPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "jumpToViola", "title", "params", "jumpToWeb", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJJumpUtilsImpl
  implements IRIJJumpUtils
{
  @Nullable
  public IRIJTabFrame getReadinjoyTabFrame(@Nullable Context paramContext)
  {
    return RIJJumpUtils.a(paramContext);
  }
  
  @Nullable
  public String getSourceForDownloadAndJumpOtherApp(int paramInt)
  {
    return RIJJumpUtils.a(paramInt);
  }
  
  public void jumpFromSelf(@Nullable Context paramContext, @Nullable String paramString)
  {
    RIJJumpUtils.a(paramContext, paramString);
  }
  
  public boolean jumpToMiniApp(@NotNull Context paramContext, @Nullable String paramString, int paramInt, @Nullable MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return RIJJumpUtils.a(paramContext, paramString, paramInt, paramMiniAppLaunchListener);
  }
  
  public void jumpToNativeSearchResultPage(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2)
  {
    RIJJumpUtils.a(paramContext, paramString1, paramString2);
  }
  
  @Nullable
  public Integer jumpToUrl(@Nullable Context paramContext, @Nullable String paramString)
  {
    return RIJJumpUtils.a(paramContext, paramString);
  }
  
  @Nullable
  public Integer jumpToUrl(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    return RIJJumpUtils.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void jumpToViola(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    RIJJumpUtils.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  @Nullable
  public Integer jumpToWeb(@Nullable Context paramContext, @Nullable String paramString)
  {
    return RIJJumpUtils.b(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.api.impl.RIJJumpUtilsImpl
 * JD-Core Version:    0.7.0.1
 */