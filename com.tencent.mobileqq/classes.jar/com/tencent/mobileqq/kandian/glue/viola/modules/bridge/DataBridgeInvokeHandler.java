package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/DataBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "followUin", "", "params", "Lorg/json/JSONObject;", "callback", "", "invokeJs", "isFollow", "", "isFollowUin", "nameSpace", "register", "reportToBeacon", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final DataBridgeInvokeHandler.Companion a = new DataBridgeInvokeHandler.Companion(null);
  
  public DataBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("uin");
      if (paramJSONObject != null) {
        ThreadManagerV2.excute((Runnable)new DataBridgeInvokeHandler.isFollowUin..inlined.also.lambda.1(paramJSONObject, this, paramString), 16, null, true);
      }
    }
  }
  
  private final void a(boolean paramBoolean, String paramString)
  {
    JSONObject localJSONObject = new JSONObject().put("follow", paramBoolean);
    a(paramString, new JSONObject().put("response", localJSONObject).put("ret", 0));
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramString = paramJSONObject.optString("event");
    Intrinsics.checkExpressionValueIsNotNull(paramString, "event");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    paramJSONObject = paramJSONObject.optJSONObject("data");
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      Intrinsics.checkExpressionValueIsNotNull(localIterator, "it.keys()");
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Map localMap = (Map)localHashMap;
        Intrinsics.checkExpressionValueIsNotNull(str1, "key");
        String str2 = paramJSONObject.optString(str1);
        Intrinsics.checkExpressionValueIsNotNull(str2, "it.optString(key)");
        localMap.put(str1, str2);
      }
    }
    StatisticCollector.getInstance((Context)BaseApplication.context).collectPerformance(RIJQQAppInterfaceUtil.d(), paramString, true, 0L, 0L, localHashMap, null);
  }
  
  private final void c(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      String str1 = paramJSONObject.optString("uin");
      if (str1 != null)
      {
        int i = paramJSONObject.optInt("isUgc");
        boolean bool1 = true;
        if (i != 1) {
          bool1 = false;
        }
        String str2 = paramJSONObject.optString("avatarUrl");
        boolean bool2 = paramJSONObject.optBoolean("blackScene");
        VideoFeedsHelper.a(RIJQQAppInterfaceUtil.a(), str1, bool1, str2, bool2);
        a(paramString, null);
      }
    }
  }
  
  public void a()
  {
    a("ssoRequest", (Function2)new DataBridgeInvokeHandler.register.1(this));
    a("getUserInfo", (Function2)new DataBridgeInvokeHandler.register.2(this));
    a("getPerformance", (Function2)new DataBridgeInvokeHandler.register.3(this));
    DataBridgeInvokeHandler localDataBridgeInvokeHandler = (DataBridgeInvokeHandler)this;
    a("isFollowUin", (Function2)new DataBridgeInvokeHandler.register.4(localDataBridgeInvokeHandler));
    a("followUin", (Function2)new DataBridgeInvokeHandler.register.5(localDataBridgeInvokeHandler));
    a("reportToBeacon", (Function2)new DataBridgeInvokeHandler.register.6(localDataBridgeInvokeHandler));
  }
  
  @NotNull
  public String b()
  {
    return "data";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.DataBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */