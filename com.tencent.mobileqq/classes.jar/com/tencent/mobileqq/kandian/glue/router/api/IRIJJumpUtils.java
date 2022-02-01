package com.tencent.mobileqq.kandian.glue.router.api;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.tab.IRIJTabFrame;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/router/api/IRIJJumpUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getReadinjoyTabFrame", "Lcom/tencent/mobileqq/kandian/base/tab/IRIJTabFrame;", "context", "Landroid/content/Context;", "getSourceForDownloadAndJumpOtherApp", "", "channelID", "", "jumpFromSelf", "", "schema", "jumpToMiniApp", "", "scheme", "launchParam", "miniAppLaunchListener", "Lcom/tencent/mobileqq/mini/api/MiniAppLaunchListener;", "jumpToNativeSearchResultPage", "keyword", "jumpUrl", "jumpToUrl", "url", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "wxAppId", "wxAppPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "jumpToViola", "title", "params", "jumpToWeb", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJJumpUtils
  extends QRouteApi
{
  @Nullable
  public abstract IRIJTabFrame getReadinjoyTabFrame(@Nullable Context paramContext);
  
  @Nullable
  public abstract String getSourceForDownloadAndJumpOtherApp(int paramInt);
  
  public abstract void jumpFromSelf(@Nullable Context paramContext, @Nullable String paramString);
  
  public abstract boolean jumpToMiniApp(@NotNull Context paramContext, @Nullable String paramString, int paramInt, @Nullable MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract void jumpToNativeSearchResultPage(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2);
  
  @Nullable
  public abstract Integer jumpToUrl(@Nullable Context paramContext, @Nullable String paramString);
  
  @Nullable
  public abstract Integer jumpToUrl(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3);
  
  public abstract void jumpToViola(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3);
  
  @Nullable
  public abstract Integer jumpToWeb(@Nullable Context paramContext, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
 * JD-Core Version:    0.7.0.1
 */