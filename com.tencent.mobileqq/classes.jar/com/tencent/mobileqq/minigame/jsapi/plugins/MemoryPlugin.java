package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/jsapi/plugins/MemoryPlugin;", "Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin;", "()V", "componentCallbacks", "Landroid/content/ComponentCallbacks2;", "handleNativeRequest", "", "eventName", "jsonParams", "runtime", "Lcom/tencent/mobileqq/mini/webview/JsRuntime;", "callbackId", "", "onDestroy", "", "registerComponentCallback", "callback", "supportedEvents", "", "unRegisterComponentCallback", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MemoryPlugin
  extends BaseJsPlugin
{
  public static final MemoryPlugin.Companion Companion = new MemoryPlugin.Companion(null);
  @NotNull
  public static final String TAG = "MemoryPlugin";
  private ComponentCallbacks2 componentCallbacks;
  
  private final void registerComponentCallback(ComponentCallbacks2 paramComponentCallbacks2)
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
      localBaseApplication.getApplicationContext().registerComponentCallbacks((ComponentCallbacks)paramComponentCallbacks2);
      return;
    }
    catch (Exception paramComponentCallbacks2)
    {
      paramComponentCallbacks2.printStackTrace();
    }
  }
  
  private final void unRegisterComponentCallback(ComponentCallbacks2 paramComponentCallbacks2)
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
      localBaseApplication.getApplicationContext().unregisterComponentCallbacks((ComponentCallbacks)paramComponentCallbacks2);
      return;
    }
    catch (Exception paramComponentCallbacks2)
    {
      paramComponentCallbacks2.printStackTrace();
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
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "super.handleNativeReques…ams, runtime, callbackId)");
        return paramString1;
        switch (paramString1.hashCode())
        {
        }
      }
    } while (!paramString1.equals("onMemoryWarning"));
    this.componentCallbacks = ((ComponentCallbacks2)new MemoryPlugin.handleNativeRequest.1(paramJsRuntime));
    paramString2 = this.componentCallbacks;
    if (paramString2 == null) {
      Intrinsics.throwNpe();
    }
    registerComponentCallback(paramString2);
    paramString1 = ApiUtil.wrapCallbackOk(paramString1, null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "ApiUtil.wrapCallbackOk(eventName, null).toString()");
    return paramString1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.componentCallbacks != null)
    {
      ComponentCallbacks2 localComponentCallbacks2 = this.componentCallbacks;
      if (localComponentCallbacks2 == null) {
        Intrinsics.throwNpe();
      }
      unRegisterComponentCallback(localComponentCallbacks2);
    }
  }
  
  @NotNull
  public Set<String> supportedEvents()
  {
    return SetsKt.setOf("onMemoryWarning");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.MemoryPlugin
 * JD-Core Version:    0.7.0.1
 */