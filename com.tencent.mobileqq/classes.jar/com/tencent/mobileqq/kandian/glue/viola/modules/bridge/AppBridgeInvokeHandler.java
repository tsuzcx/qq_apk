package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AppBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "downloadApk", "", "param", "Lorg/json/JSONObject;", "callbackId", "", "downloadApp", "jsonObject", "callback", "nameSpace", "register", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AppBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final AppBridgeInvokeHandler.Companion a = new AppBridgeInvokeHandler.Companion(null);
  
  public AppBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("params");
      if (paramJSONObject != null) {
        d().downloadApp(paramJSONObject);
      }
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    d().downloadApk(paramJSONObject, paramString);
  }
  
  public void a()
  {
    AppBridgeInvokeHandler localAppBridgeInvokeHandler = (AppBridgeInvokeHandler)this;
    a("downloadApp", (Function2)new AppBridgeInvokeHandler.register.1(localAppBridgeInvokeHandler));
    a("downloadApk", (Function2)new AppBridgeInvokeHandler.register.2(localAppBridgeInvokeHandler));
    a("isAppInstalled", (Function2)new AppBridgeInvokeHandler.register.3(this));
    a("launchApp", (Function2)new AppBridgeInvokeHandler.register.4(this));
    a("getDownloadApkState", (Function2)new AppBridgeInvokeHandler.register.5(this));
    a("downloadApkAction", (Function2)new AppBridgeInvokeHandler.register.6(this));
    a("downloadApkPause", (Function2)new AppBridgeInvokeHandler.register.7(this));
    a("downloadApkCancel", (Function2)new AppBridgeInvokeHandler.register.8(this));
    a("downloadApkResume", (Function2)new AppBridgeInvokeHandler.register.9(this));
  }
  
  @NotNull
  public String b()
  {
    return "app";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.AppBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */