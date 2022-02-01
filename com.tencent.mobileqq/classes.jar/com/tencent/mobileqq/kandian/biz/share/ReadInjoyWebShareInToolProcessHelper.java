package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.smtt.sdk.WebSettings;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareInToolProcessHelper;", "Lcom/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper;", "mPlugin", "Lcom/tencent/mobileqq/kandian/biz/detail/web/IReadInJoyWebViewPlugin;", "memberApiClient", "Lcom/tencent/biz/troop/TroopMemberApiClient;", "(Lcom/tencent/mobileqq/kandian/biz/detail/web/IReadInJoyWebViewPlugin;Lcom/tencent/biz/troop/TroopMemberApiClient;)V", "webview", "Lcom/tencent/biz/pubaccount/CustomWebView;", "callBackToJs", "", "result", "", "getActivity", "Landroid/app/Activity;", "getAppInterface", "Lcom/tencent/common/app/AppInterface;", "getCurrentUrl", "getPublicUin", "getReadinjoyShareToWxConfig", "callback", "Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;", "getUin", "onActivityResult", "intent", "Landroid/content/Intent;", "requestCode", "", "resultCode", "", "onFontSizeChange", "index", "textSizeRatio", "", "release", "sendToComputer", "content", "shareResultCallback", "action", "successed", "", "data", "showShareActionSheet", "Landroid/os/Bundle;", "startActivityForResult", "switchRequestCode", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInjoyWebShareInToolProcessHelper
  extends AbstractReadInjoyWebShareHelper
{
  private CustomWebView e;
  private final IReadInJoyWebViewPlugin f;
  private final TroopMemberApiClient g;
  
  public ReadInjoyWebShareInToolProcessHelper(@NotNull IReadInJoyWebViewPlugin paramIReadInJoyWebViewPlugin, @NotNull TroopMemberApiClient paramTroopMemberApiClient)
  {
    this.f = paramIReadInJoyWebViewPlugin;
    this.g = paramTroopMemberApiClient;
    paramIReadInJoyWebViewPlugin = this.f.b();
    if (paramIReadInJoyWebViewPlugin != null)
    {
      this.e = ((CustomWebView)paramIReadInJoyWebViewPlugin);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.CustomWebView");
  }
  
  public int a(byte paramByte)
  {
    return this.f.a(paramByte, true);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((CustomWebView)localObject).getSettings();
    } else {
      localObject = null;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "webview?.getSettings()");
    ((WebSettings)localObject).setTextZoom(com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.c[paramInt]);
    this.g.b(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean, @Nullable String paramString) {}
  
  protected void a(@Nullable Intent paramIntent, byte paramByte)
  {
    this.f.startActivityForResult(paramIntent, paramByte);
  }
  
  public void a(@Nullable Intent paramIntent, byte paramByte, int paramInt)
  {
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramByte == 1)
    {
      a("qq_friend", bool);
      return;
    }
    if (paramByte == 2) {
      a("qzone", bool);
    }
  }
  
  protected void a(@Nullable ITroopMemberApiClientApi.Callback paramCallback)
  {
    this.g.d(paramCallback);
  }
  
  protected void a(@Nullable String paramString, @Nullable ITroopMemberApiClientApi.Callback paramCallback)
  {
    this.g.d(paramString, paramCallback);
  }
  
  @NotNull
  public Activity b()
  {
    for (Activity localActivity = this.f.e(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    if (localActivity == null) {
      Intrinsics.throwNpe();
    }
    return localActivity;
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "result");
    this.e.callJs(this.a, new String[] { paramString });
  }
  
  @NotNull
  public AppInterface c()
  {
    AppRuntime localAppRuntime = this.f.a();
    if (localAppRuntime != null) {
      return (AppInterface)localAppRuntime;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
  
  @Nullable
  public String d()
  {
    return this.f.c();
  }
  
  @Nullable
  public String e()
  {
    return this.f.d();
  }
  
  public void f() {}
  
  @Nullable
  protected String g()
  {
    return this.f.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareInToolProcessHelper
 * JD-Core Version:    0.7.0.1
 */