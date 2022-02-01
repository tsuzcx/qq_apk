package com.tencent.timi.game.web.business.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.smtt.sdk.WebAccelerator;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.web.business.api.IWebBusinessService;
import com.tencent.timi.game.web.business.impl.common.TimiBrowserActivity;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/web/business/impl/WebBusinessServiceImpl;", "Lcom/tencent/timi/game/web/business/api/IWebBusinessService;", "()V", "webProcessListener", "com/tencent/timi/game/web/business/impl/WebBusinessServiceImpl$webProcessListener$1", "Lcom/tencent/timi/game/web/business/impl/WebBusinessServiceImpl$webProcessListener$1;", "createView", "Landroid/view/View;", "viewName", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "init", "", "launchInscriptionBrowserActivity", "activity", "Landroid/app/Activity;", "url", "anchorBusniessId", "gameId", "", "isAnchor", "", "loadUrl", "preLoadUrl", "preStartWebProcess", "provideViews", "", "serviceDestroy", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class WebBusinessServiceImpl
  implements IWebBusinessService
{
  private final WebBusinessServiceImpl.webProcessListener.1 a = new WebBusinessServiceImpl.webProcessListener.1();
  
  @Nullable
  public View a(@Nullable String paramString, @Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  @NotNull
  public List<String> a()
  {
    List localList = Arrays.asList(new String[0]);
    Intrinsics.checkExpressionValueIsNotNull(localList, "Arrays.asList()");
    return localList;
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull String paramString1, @NotNull String paramString2, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "anchorBusniessId");
    Object localObject = (Context)paramActivity;
    int i = (int)UITools.b((Context)localObject, UITools.a((Context)localObject) * 565.0F / 375.0F);
    localObject = new Intent((Context)localObject, TimiBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString1);
    ((Intent)localObject).putExtra("inscription_data_anchor_id", paramString2);
    ((Intent)localObject).putExtra("inscription_data_game_id", paramInt);
    ((Intent)localObject).putExtra("inscription_data_is_anchor", paramBoolean);
    ((Intent)localObject).putExtra("tg_data_height", i);
    ((Intent)localObject).putExtra("tg_data_from", "tg_timi_browser_from_inscription");
    ((Intent)localObject).putExtra("finish_animation_none", true);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public void a(@Nullable Context paramContext) {}
  
  public void a(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      Logger.c("WebBusinessServiceImpl ", "loadUrl failed : url is empty");
      return;
    }
    TimiBrowserActivity.a(paramContext, paramString);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    try
    {
      WebAccelerateHelper.getInstance().preGetKey(paramString, new Intent(), null);
      WebAccelerateHelper.getInstance().preFetchResource(paramString);
      WebAccelerator.preConnect((Context)MobileQQ.getContext(), paramString, 1, true);
      return;
    }
    catch (Exception paramString)
    {
      Logger.a("WebBusinessServiceImpl ", "preLoadUrl exception", (Throwable)paramString);
    }
  }
  
  public void b()
  {
    Object localObject = MobileQQ.sMobileQQ;
    IWebProcessManagerService localIWebProcessManagerService = null;
    localObject = ((MobileQQ)localObject).waitAppRuntime(null);
    if (localObject != null) {
      localIWebProcessManagerService = (IWebProcessManagerService)((AppRuntime)localObject).getRuntimeService(IWebProcessManagerService.class, "");
    }
    if (localIWebProcessManagerService != null) {
      localIWebProcessManagerService.startWebProcess(-1, (WebProcessStartListener)this.a);
    }
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.WebBusinessServiceImpl
 * JD-Core Version:    0.7.0.1
 */