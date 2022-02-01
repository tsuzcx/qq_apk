package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/jsapi/plugins/LifecyclePlugin;", "Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin;", "()V", "cacheJsRuntime", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/mini/webview/JsRuntime;", "Lkotlin/collections/HashMap;", "handleLifecycleEvent", "", "eventName", "params", "handleNativeRequest", "jsonParams", "webview", "callbackId", "", "onDestroy", "supportedEvents", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LifecyclePlugin
  extends BaseJsPlugin
{
  private final HashMap<String, JsRuntime> cacheJsRuntime = new HashMap();
  
  public final void handleLifecycleEvent(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    JsRuntime localJsRuntime = (JsRuntime)this.cacheJsRuntime.get(paramString1);
    if (localJsRuntime != null) {
      localJsRuntime.evaluateSubcribeJS(paramString1, paramString2, -1);
    }
  }
  
  @NotNull
  public String handleNativeRequest(@Nullable String paramString1, @Nullable String paramString2, @Nullable JsRuntime paramJsRuntime, int paramInt)
  {
    if (paramString1 == null) {}
    do
    {
      for (;;)
      {
        paramString1 = super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "super.handleNativeReques…ams, webview, callbackId)");
        return paramString1;
        switch (paramString1.hashCode())
        {
        }
      }
    } while (!paramString1.equals("onAppEnterBackground"));
    for (;;)
    {
      if (!this.cacheJsRuntime.containsKey(paramString1))
      {
        paramString2 = (Map)this.cacheJsRuntime;
        if (paramJsRuntime == null) {
          Intrinsics.throwNpe();
        }
        paramString2.put(paramString1, paramJsRuntime);
      }
      paramString1 = ApiUtil.wrapCallbackOk(paramString1, null).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "ApiUtil.wrapCallbackOk(eventName, null).toString()");
      return paramString1;
      if (!paramString1.equals("onAppStop")) {
        break;
      }
      continue;
      if (!paramString1.equals("onPause")) {
        break;
      }
      continue;
      if (!paramString1.equals("onAppEnterForeground")) {
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.cacheJsRuntime.clear();
  }
  
  @NotNull
  public Set<String> supportedEvents()
  {
    return SetsKt.setOf(new String[] { "onAppEnterForeground", "onAppEnterBackground", "onAppStop", "onPause" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.LifecyclePlugin
 * JD-Core Version:    0.7.0.1
 */