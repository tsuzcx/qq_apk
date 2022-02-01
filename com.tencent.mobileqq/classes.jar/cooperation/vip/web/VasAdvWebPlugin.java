package cooperation.vip.web;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.VasAdvSupport;
import cooperation.vip.VasAdvSupport.Companion;
import cooperation.vip.perload.VasPreloadService;
import cooperation.vip.perload.VasPreloadService.Companion;
import cooperation.vip.reward.VasRewardAdCallback;
import cooperation.vip.reward.VasRewardAdParams.Builder;
import cooperation.vip.reward.VasRewardAdService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/web/VasAdvWebPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "callJsOnFail", "", "callback", "", "errMsg", "handleGetGdtAdData", "jsonObj", "Lorg/json/JSONObject;", "jsCallback", "handleGetPreloadGdtAd", "handleGetTraceInfo", "handleInitDeviceInfo", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "handleNotifyWebStatus", "handleRewardVideo", "handleWebViewClick", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebPlugin
  extends WebViewPlugin
{
  public static final VasAdvWebPlugin.Companion a = new VasAdvWebPlugin.Companion(null);
  
  public VasAdvWebPlugin()
  {
    this.mPluginNameSpace = "vasAdv";
    VasAdvSupport.a.a().a(null);
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("returnCode", -1);
      localJSONObject.put("errorMsg", paramString2);
      callJs(paramString1, new String[] { localJSONObject.toString(0) });
    }
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = ((IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "tool")).getTianshuWebManager().a();
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject))
      {
        localJSONObject.put("returnCode", 0);
        localJSONObject.put("data", paramJSONObject);
      }
      for (;;)
      {
        callJs(paramString, new String[] { localJSONObject.toString(0) });
        return;
        localJSONObject.put("returnCode", -1);
        localJSONObject.put("errorMsg", "trace info don`t exist");
      }
      a(paramString, paramJSONObject);
    }
    catch (Throwable localThrowable)
    {
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject == null) {}
    }
    for (;;)
    {
      QLog.e("VasAdvWebPlugin", 1, "handleGetTraceInfo failed", localThrowable);
      return;
      paramJSONObject = "handleGetTraceInfo error";
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = paramJSONObject.getString("businessId");
      paramJSONObject = paramJSONObject.getString("status");
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "jsonObj.getString(\"status\")");
      int i = Integer.parseInt(paramJSONObject);
      paramJSONObject = VasAdvWebManager.a;
      Intrinsics.checkExpressionValueIsNotNull(str, "businessId");
      paramJSONObject.a(str, "notify_web_status", null, new Object[] { Integer.valueOf(i) });
      return;
    }
    catch (Throwable localThrowable)
    {
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject == null) {}
    }
    for (;;)
    {
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "handleNotifyWebStatus invalid args", localThrowable);
      return;
      paramJSONObject = "handleNotifyWebStatus error";
    }
  }
  
  private final void c(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("businessId");
      VasAdvWebPlugin.handleGetGdtAdData.eventCallback.1 local1 = new VasAdvWebPlugin.handleGetGdtAdData.eventCallback.1(this, paramString);
      VasAdvWebManager localVasAdvWebManager = VasAdvWebManager.a;
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "businessId");
      localVasAdvWebManager.a(paramJSONObject, "get_gdt_ad_data", (VasAdvWebEvent.Callback)local1, new Object[] { null });
      return;
    }
    catch (Throwable localThrowable)
    {
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject == null) {}
    }
    for (;;)
    {
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "handleGetGdtAdData invalid args", localThrowable);
      return;
      paramJSONObject = "handleGetGdtAdData error";
    }
  }
  
  private final void d(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = paramJSONObject.getString("businessId");
      paramJSONObject = paramJSONObject.getString("areaType");
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "jsonObj.getString(\"areaType\")");
      int i = Integer.parseInt(paramJSONObject);
      paramJSONObject = VasAdvWebManager.a;
      Intrinsics.checkExpressionValueIsNotNull(str, "businessId");
      paramJSONObject.a(str, "handle_web_click", null, new Object[] { Integer.valueOf(i) });
      return;
    }
    catch (Throwable localThrowable)
    {
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject == null) {}
    }
    for (;;)
    {
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "handleWebViewClick invalid args", localThrowable);
      return;
      paramJSONObject = "handleWebViewClick error";
    }
  }
  
  private final void e(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      localObject1 = new VasRewardAdParams.Builder(null, null, null, null, null, null, null, 127, null);
      localObject2 = paramJSONObject.getString("adv_pos");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "jsonObj.getString(\"adv_pos\")");
      localObject1 = ((VasRewardAdParams.Builder)localObject1).a(Integer.parseInt((String)localObject2));
      localObject2 = paramJSONObject.getString("reward_type");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "jsonObj.getString(\"reward_type\")");
      localObject1 = ((VasRewardAdParams.Builder)localObject1).b(Integer.parseInt((String)localObject2));
      localObject2 = paramJSONObject.optString("reward_item");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "jsonObj.optString(\"reward_item\")");
      localObject2 = ((VasRewardAdParams.Builder)localObject1).a((String)localObject2);
      localObject1 = (CharSequence)paramJSONObject.optString("reward_text");
      if (((CharSequence)localObject1).length() != 0) {
        break label298;
      }
      i = 1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int i;
        label298:
        label308:
        paramJSONObject = localThrowable.getMessage();
        if (paramJSONObject != null) {}
        for (;;)
        {
          a(paramString, paramJSONObject);
          QLog.e("VasAdvWebPlugin", 1, "invalid args", localThrowable);
          return;
          paramJSONObject = "handleRewardVideo error";
        }
        if (i != 0)
        {
          String str = null;
          continue;
          label360:
          if (i != 0) {
            str = "biz_src_jc_vip";
          }
        }
      }
    }
    localObject2 = ((VasRewardAdParams.Builder)localObject2).b((String)localObject1);
    localObject1 = (CharSequence)paramJSONObject.optString("biz_src_id");
    if (((CharSequence)localObject1).length() == 0)
    {
      i = 1;
      break label360;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "jsonObj.optString(\"biz_s…fEmpty { Source.SRC_VIP }");
      localObject1 = ((VasRewardAdParams.Builder)localObject2).d((String)localObject1);
      paramJSONObject = (CharSequence)paramJSONObject.optString("gdt_biz_id");
      if (paramJSONObject.length() != 0) {
        break label308;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        paramJSONObject = VasAdvSupport.a.a().a();
      }
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "jsonObj.optString(\"gdt_b…ort.get().vasGdtBizId() }");
      paramJSONObject = ((VasRewardAdParams.Builder)localObject1).c((String)paramJSONObject).a();
      localObject1 = new VasAdvWebPlugin.handleRewardVideo.rewardCallback.1(this, paramString);
      localObject2 = this.mRuntime;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mRuntime");
      localObject2 = ((WebViewPlugin.PluginRuntime)localObject2).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mRuntime.activity");
      new VasRewardAdService((Activity)localObject2, paramJSONObject, (VasRewardAdCallback)localObject1).a();
      return;
      i = 0;
      break;
      i = 0;
      break label360;
    }
  }
  
  private final void f(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = (CharSequence)paramJSONObject.optString("gdt_biz_id");
      if (paramJSONObject.length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          paramJSONObject = VasAdvSupport.a.a().a();
        }
        paramJSONObject = (String)paramJSONObject;
        VasAdvSupport.a.a().a(paramJSONObject);
        return;
      }
      a(paramString, paramJSONObject);
    }
    catch (Throwable localThrowable)
    {
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject == null) {}
    }
    for (;;)
    {
      QLog.e("VasAdvWebPlugin", 1, "handleInitDeviceInfo", localThrowable);
      return;
      paramJSONObject = "handleInitDeviceInfo error";
    }
  }
  
  private final void g(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("businessId");
      Object localObject = VasPreloadService.a;
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "businessId");
      paramJSONObject = ((VasPreloadService.Companion)localObject).a(paramJSONObject);
      localObject = new JSONObject();
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject))
      {
        ((JSONObject)localObject).put("returnCode", 0);
        ((JSONObject)localObject).put("data", new JSONObject().put("preloadAd", paramJSONObject));
      }
      for (;;)
      {
        callJs(paramString, new String[] { ((JSONObject)localObject).toString(0) });
        return;
        ((JSONObject)localObject).put("returnCode", -1);
        ((JSONObject)localObject).put("errorMsg", "preload ad is null");
      }
      a(paramString, paramJSONObject);
    }
    catch (Throwable localThrowable)
    {
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject == null) {}
    }
    for (;;)
    {
      QLog.e("VasAdvWebPlugin", 1, "handleGetPreloadGdtAd failed", localThrowable);
      return;
      paramJSONObject = "handleGetPreloadGdtAd error";
    }
  }
  
  public boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (QLog.isColorLevel()) {
      QLog.d("VasAdvWebPlugin", 2, "handleJsRequest -> url : " + paramString1 + ",pkgName : " + paramString2 + ",method : " + paramString3 + ",args[0 : " + paramVarArgs[0]);
    }
    if ((Intrinsics.areEqual("vasAdv", paramString2) ^ true)) {
      return false;
    }
    String str = (String)ArraysKt.firstOrNull(paramVarArgs);
    if (str != null)
    {
      paramJsBridgeListener = new JSONObject(str);
      paramString1 = paramJsBridgeListener.optString("callback", null);
      boolean bool;
      if (paramString3 == null) {
        bool = false;
      }
      for (;;)
      {
        return bool;
        switch (paramString3.hashCode())
        {
        default: 
          break;
        case -1479864882: 
          if (!paramString3.equals("getGdtAdData")) {
            break;
          }
          c(paramJsBridgeListener, paramString1);
          bool = true;
          break;
        case -1091160153: 
          if (!paramString3.equals("getPreloadGdtAd")) {
            break;
          }
          g(paramJsBridgeListener, paramString1);
          bool = true;
          break;
        case 1467416640: 
          if (!paramString3.equals("handleClick")) {
            break;
          }
          d(paramJsBridgeListener, paramString1);
          bool = true;
          break;
        case 714346717: 
          if (!paramString3.equals("getTraceInfo")) {
            break;
          }
          a(paramJsBridgeListener, paramString1);
          bool = true;
          break;
        case 1696532820: 
          if (!paramString3.equals("initDeviceInfo")) {
            break;
          }
          f(paramJsBridgeListener, paramString1);
          bool = true;
          break;
        case -1007590627: 
          if (!paramString3.equals("notifyWebStatus")) {
            break;
          }
          b(paramJsBridgeListener, paramString1);
          bool = true;
          break;
        case -1091552849: 
          if (!paramString3.equals("showRewardAD")) {
            break;
          }
          e(paramJsBridgeListener, paramString1);
          bool = true;
        }
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.web.VasAdvWebPlugin
 * JD-Core Version:    0.7.0.1
 */