import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.2;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.3;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.4;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.5;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.6;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.7;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.8;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.9;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AppBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "downloadApk", "", "param", "Lorg/json/JSONObject;", "callbackId", "", "downloadApp", "jsonObject", "callback", "nameSpace", "register", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tgp
  extends tgo
{
  public static final tgq a = new tgq(null);
  
  public tgp(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("params");
      if (paramJSONObject != null) {
        a().downloadApp(paramJSONObject);
      }
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    a().downloadApk(paramJSONObject, paramString);
  }
  
  @NotNull
  public String a()
  {
    return "app";
  }
  
  public void a()
  {
    a("downloadApp", (Function2)new AppBridgeInvokeHandler.register.1((tgp)this));
    a("downloadApk", (Function2)new AppBridgeInvokeHandler.register.2((tgp)this));
    a("isAppInstalled", (Function2)new AppBridgeInvokeHandler.register.3(this));
    a("launchApp", (Function2)new AppBridgeInvokeHandler.register.4(this));
    a("getDownloadApkState", (Function2)new AppBridgeInvokeHandler.register.5(this));
    a("downloadApkAction", (Function2)new AppBridgeInvokeHandler.register.6(this));
    a("downloadApkPause", (Function2)new AppBridgeInvokeHandler.register.7(this));
    a("downloadApkCancel", (Function2)new AppBridgeInvokeHandler.register.8(this));
    a("downloadApkResume", (Function2)new AppBridgeInvokeHandler.register.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tgp
 * JD-Core Version:    0.7.0.1
 */