package com.tencent.mobileqq.vas.adv.web;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.preload.VasPreloadService;
import com.tencent.mobileqq.vas.adv.preload.VasPreloadService.Companion;
import com.tencent.mobileqq.vas.adv.reward.VasRewardAdService;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams.Builder;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Callback;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/web/VasAdvWebPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "callJsOnFail", "", "callback", "", "errMsg", "getActivity", "Landroid/app/Activity;", "getPreloadGdtAdJson", "Lorg/json/JSONObject;", "adJson", "getVasRewardAdCallback", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "jsCallback", "handleGetGdtAdData", "jsonObj", "handleGetPreloadGdtAd", "handleGetTraceInfo", "handleInitDeviceInfo", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "handleNotifyWebStatus", "handleRewardVideo", "handleWebViewClick", "Companion", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebPlugin
  extends WebViewPlugin
{
  public static final VasAdvWebPlugin.Companion a = new VasAdvWebPlugin.Companion(null);
  
  public VasAdvWebPlugin()
  {
    this.mPluginNameSpace = "vasAdv";
    VasAdvSupport.a.a().a(null);
  }
  
  private final Activity a()
  {
    Object localObject = this.mRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mRuntime");
    localObject = ((WebViewPlugin.PluginRuntime)localObject).d();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mRuntime.activity");
    return localObject;
  }
  
  private final VasRewardAdCallback a(String paramString)
  {
    return (VasRewardAdCallback)new VasAdvWebPlugin.getVasRewardAdCallback.1(this, paramString);
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
      paramJSONObject = ((IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "tool")).getTianshuWebManager().getTraceInfoOfLastClick();
      JSONObject localJSONObject = new JSONObject();
      boolean bool = TextUtils.isEmpty((CharSequence)paramJSONObject);
      if (!bool)
      {
        localJSONObject.put("returnCode", 0);
        localJSONObject.put("data", paramJSONObject);
      }
      else
      {
        localJSONObject.put("returnCode", -1);
        localJSONObject.put("errorMsg", "trace info don`t exist");
      }
      callJs(paramString, new String[] { localJSONObject.toString(0) });
      return;
    }
    catch (Throwable localThrowable)
    {
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject == null) {
        paramJSONObject = "handleGetTraceInfo error";
      }
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "handleGetTraceInfo failed", localThrowable);
    }
  }
  
  private final JSONObject b(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      localJSONObject.put("returnCode", 0);
      localJSONObject.put("data", new JSONObject().put("preloadAd", paramString));
      return localJSONObject;
    }
    localJSONObject.put("returnCode", -1);
    localJSONObject.put("errorMsg", "preload ad is null");
    return localJSONObject;
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
      if (paramJSONObject == null) {
        paramJSONObject = "handleNotifyWebStatus error";
      }
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "handleNotifyWebStatus invalid args", localThrowable);
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
      if (paramJSONObject == null) {
        paramJSONObject = "handleGetGdtAdData error";
      }
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "handleGetGdtAdData invalid args", localThrowable);
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
      if (paramJSONObject == null) {
        paramJSONObject = "handleWebViewClick error";
      }
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "handleWebViewClick invalid args", localThrowable);
    }
  }
  
  private final void e(JSONObject paramJSONObject, String paramString)
  {
    int i;
    try
    {
      localBuilder = new VasRewardAdParams.Builder();
      localObject = paramJSONObject.getString("adv_pos");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "jsonObj.getString(\"adv_pos\")");
      localBuilder.setAdvPos(Integer.valueOf(Integer.parseInt((String)localObject)));
      localObject = paramJSONObject.getString("reward_type");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "jsonObj.getString(\"reward_type\")");
      localBuilder.setRewardType(Integer.valueOf(Integer.parseInt((String)localObject)));
      localBuilder.setRewardItem(paramJSONObject.optString("reward_item"));
      localObject = (CharSequence)paramJSONObject.optString("reward_text");
      i = ((CharSequence)localObject).length();
      j = 0;
      if (i != 0) {
        break label293;
      }
      i = 1;
    }
    catch (Throwable localThrowable)
    {
      VasRewardAdParams.Builder localBuilder;
      Object localObject;
      int j;
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject != null) {
        break label275;
      }
      paramJSONObject = "handleRewardVideo error";
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "invalid args", localThrowable);
      return;
    }
    localBuilder.setRewardText((String)localObject);
    localBuilder.setUin(Long.valueOf(VasAdvSupport.a.a().a()));
    localObject = (CharSequence)paramJSONObject.optString("biz_src_id");
    if (((CharSequence)localObject).length() == 0) {
      i = 1;
    }
    for (;;)
    {
      localBuilder.setBizSrcId((String)localObject);
      paramJSONObject = (CharSequence)paramJSONObject.optString("gdt_biz_id");
      i = j;
      if (paramJSONObject.length() == 0) {
        i = 1;
      }
      if (i != 0) {
        paramJSONObject = VasAdvSupport.a.a().f();
      }
      localBuilder.setGdtBizId((String)paramJSONObject);
      paramJSONObject = localBuilder.build();
      localObject = a(paramString);
      new VasRewardAdService(a(), paramJSONObject, (VasRewardAdCallback)localObject).a();
      return;
      label275:
      label293:
      i = 0;
      if (i == 0) {
        break;
      }
      String str = null;
      break;
      i = 0;
      if (i != 0) {
        str = "biz_src_jc_vip";
      }
    }
  }
  
  private final void f(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = (CharSequence)paramJSONObject.optString("gdt_biz_id");
        if (paramJSONObject.length() == 0)
        {
          i = 1;
          if (i != 0) {
            paramJSONObject = VasAdvSupport.a.a().f();
          }
          paramJSONObject = (String)paramJSONObject;
          VasAdvSupport.a.a().a(paramJSONObject);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        paramJSONObject = localThrowable.getMessage();
        if (paramJSONObject == null) {
          paramJSONObject = "handleInitDeviceInfo error";
        }
        a(paramString, paramJSONObject);
        QLog.e("VasAdvWebPlugin", 1, "handleInitDeviceInfo", localThrowable);
        return;
      }
      int i = 0;
    }
  }
  
  private final void g(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("businessId");
      VasPreloadService.Companion localCompanion = VasPreloadService.a;
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "businessId");
      callJs(paramString, new String[] { b(localCompanion.c(paramJSONObject)).toString(0) });
      return;
    }
    catch (Throwable localThrowable)
    {
      paramJSONObject = localThrowable.getMessage();
      if (paramJSONObject == null) {
        paramJSONObject = "handleGetPreloadGdtAd error";
      }
      a(paramString, paramJSONObject);
      QLog.e("VasAdvWebPlugin", 1, "handleGetPreloadGdtAd failed", localThrowable);
    }
  }
  
  protected boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleJsRequest -> url : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",pkgName : ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",method : ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(",args[0 : ");
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      QLog.d("VasAdvWebPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if ((Intrinsics.areEqual("vasAdv", paramString2) ^ true)) {
      return false;
    }
    Object localObject = (String)ArraysKt.firstOrNull(paramVarArgs);
    if (localObject != null)
    {
      paramJsBridgeListener = new JSONObject((String)localObject);
      paramString1 = paramJsBridgeListener.optString("callback", null);
      if (paramString3 != null) {
        switch (paramString3.hashCode())
        {
        default: 
          break;
        case 1696532820: 
          if (paramString3.equals("initDeviceInfo"))
          {
            f(paramJsBridgeListener, paramString1);
            return true;
          }
          break;
        case 1467416640: 
          if (paramString3.equals("handleClick"))
          {
            d(paramJsBridgeListener, paramString1);
            return true;
          }
          break;
        case 714346717: 
          if (paramString3.equals("getTraceInfo"))
          {
            a(paramJsBridgeListener, paramString1);
            return true;
          }
          break;
        case -1007590627: 
          if (paramString3.equals("notifyWebStatus"))
          {
            b(paramJsBridgeListener, paramString1);
            return true;
          }
          break;
        case -1091160153: 
          if (paramString3.equals("getPreloadGdtAd"))
          {
            g(paramJsBridgeListener, paramString1);
            return true;
          }
          break;
        case -1091552849: 
          if (paramString3.equals("showRewardAD"))
          {
            e(paramJsBridgeListener, paramString1);
            return true;
          }
          break;
        case -1479864882: 
          if (paramString3.equals("getGdtAdData"))
          {
            c(paramJsBridgeListener, paramString1);
            return true;
          }
          break;
        }
      }
      return false;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.VasAdvWebPlugin
 * JD-Core Version:    0.7.0.1
 */