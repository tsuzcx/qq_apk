package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareInToolProcessHelper;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.smtt.sdk.WebSettings;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/ReadInjoyWebShareHelperAction;", "", "plugin", "Lcom/tencent/mobileqq/kandian/biz/detail/web/IReadInJoyWebViewPlugin;", "client", "Lcom/tencent/biz/troop/TroopMemberApiClient;", "(Lcom/tencent/mobileqq/kandian/biz/detail/web/IReadInJoyWebViewPlugin;Lcom/tencent/biz/troop/TroopMemberApiClient;)V", "callback", "", "getClient", "()Lcom/tencent/biz/troop/TroopMemberApiClient;", "clientCallback", "Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;", "getPlugin", "()Lcom/tencent/mobileqq/kandian/biz/detail/web/IReadInJoyWebViewPlugin;", "readInjoyWebShareHelper", "Lcom/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareInToolProcessHelper;", "callBackToJs", "", "bundle", "Landroid/os/Bundle;", "onActivityResult", "intent", "Landroid/content/Intent;", "requestCode", "", "resultCode", "", "onDestroy", "onFontSizeChange", "showShareActionSheet", "data", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInjoyWebShareHelperAction
{
  public static final ReadInjoyWebShareHelperAction.Companion a = new ReadInjoyWebShareHelperAction.Companion(null);
  private String b;
  private ReadInjoyWebShareInToolProcessHelper c;
  private final ITroopMemberApiClientApi.Callback d;
  @NotNull
  private final IReadInJoyWebViewPlugin e;
  @NotNull
  private final TroopMemberApiClient f;
  
  public ReadInjoyWebShareHelperAction(@NotNull IReadInJoyWebViewPlugin paramIReadInJoyWebViewPlugin, @NotNull TroopMemberApiClient paramTroopMemberApiClient)
  {
    this.e = paramIReadInJoyWebViewPlugin;
    this.f = paramTroopMemberApiClient;
    this.b = "";
    this.d = ((ITroopMemberApiClientApi.Callback)new ReadInjoyWebShareHelperAction.clientCallback.1(this));
  }
  
  private final void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("index");
    paramBundle.getFloat("textSizeRatio");
    paramBundle = this.e.b();
    if (paramBundle != null)
    {
      paramBundle = ((CustomWebView)paramBundle).getSettings();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "webview.getSettings()");
      paramBundle.setTextZoom(com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.c[i]);
      this.f.b(i);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.CustomWebView");
  }
  
  public final void a()
  {
    ReadInjoyWebShareInToolProcessHelper localReadInjoyWebShareInToolProcessHelper = this.c;
    if (localReadInjoyWebShareInToolProcessHelper != null) {
      localReadInjoyWebShareInToolProcessHelper.a();
    }
  }
  
  public final void a(@Nullable Intent paramIntent, byte paramByte, int paramInt)
  {
    ReadInjoyWebShareInToolProcessHelper localReadInjoyWebShareInToolProcessHelper = this.c;
    if (localReadInjoyWebShareInToolProcessHelper != null) {
      localReadInjoyWebShareInToolProcessHelper.a(paramIntent, paramByte, paramInt);
    }
  }
  
  public final void a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    Object localObject = this.e.b();
    if (localObject != null)
    {
      ((CustomWebView)localObject).callJs(this.b, new String[] { paramBundle.getString("result") });
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.CustomWebView");
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    try
    {
      localObject = new JSONObject(paramString);
      if (!((JSONObject)localObject).optBoolean("showShareActionSheetInMainProcess", false))
      {
        this.c = new ReadInjoyWebShareInToolProcessHelper(this.e, this.f);
        localObject = this.c;
        if (localObject == null) {
          return;
        }
        ((ReadInjoyWebShareInToolProcessHelper)localObject).a(paramString);
        return;
      }
      localObject = ((JSONObject)localObject).optString("callback");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "json.optString(\"callback\")");
      this.b = ((String)localObject);
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label77:
      int i;
      break label77;
    }
    i = this.f.e(this.d);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("seq", i);
    ((Bundle)localObject).putString("data", paramString);
    ((Bundle)localObject).putInt("code_share_qzone_key", this.e.a((byte)2, true));
    ((Bundle)localObject).putString("uin_key", this.e.c());
    ((Bundle)localObject).putString("public_uin_key", this.e.d());
    ((Bundle)localObject).putString("current_url_key", this.e.f());
    this.f.a(165, (Bundle)localObject);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ReadInjoyWebShareHelperAction
 * JD-Core Version:    0.7.0.1
 */