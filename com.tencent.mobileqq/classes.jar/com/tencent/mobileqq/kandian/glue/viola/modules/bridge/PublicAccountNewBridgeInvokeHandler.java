package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/PublicAccountNewBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "getRIJAppType", "", "param", "Lorg/json/JSONObject;", "callbackId", "", "getUserInfo", "nameSpace", "register", "showReadInJoyNativeCommentView", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublicAccountNewBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final PublicAccountNewBridgeInvokeHandler.Companion a = new PublicAccountNewBridgeInvokeHandler.Companion(null);
  
  public PublicAccountNewBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      String str;
      if (TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        str = paramString;
      } else {
        str = paramJSONObject.optString("callback");
      }
      ReadInJoyLegacyUtils.a(paramJSONObject, str, (CallCommentJs)new PublicAccountNewBridgeInvokeHandler.showReadInJoyNativeCommentView..inlined.also.lambda.1(this, paramString));
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "call getRIJAppType");
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        paramString = paramJSONObject.optString("callback");
      }
      try
      {
        paramJSONObject = new JSONObject().put("app_type", ReadinjoyReportUtils.h()).toString();
        Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "JSONObject().put(\"app_ty…portAppType()).toString()");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("callback: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("result: ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("PublicAccountNewBridgeInvokeHandler", 1, localStringBuilder.toString());
        a(paramString, paramJSONObject);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("PublicAccountNewBridgeInvokeHandler", 1, paramJSONObject.getMessage());
      }
    }
  }
  
  private final void c(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "call getUserInfo");
      String str;
      if (TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        str = paramString;
      } else {
        str = paramJSONObject.optString("callback");
      }
      try
      {
        ReadInJoyUserInfoModule.a(Long.parseLong(paramJSONObject.opt("uin").toString()), (IReadInJoyUserInfoModule.RefreshUserInfoCallBack)new PublicAccountNewBridgeInvokeHandler.getUserInfo..inlined.also.lambda.1(str, this, paramString));
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("PublicAccountNewBridgeInvokeHandler", 1, paramJSONObject.getMessage());
        a(str, ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getUserInfoFailStr(paramJSONObject.getMessage()));
      }
    }
  }
  
  public void a()
  {
    PublicAccountNewBridgeInvokeHandler localPublicAccountNewBridgeInvokeHandler = (PublicAccountNewBridgeInvokeHandler)this;
    a("showReadInJoyNativeCommentView", (Function2)new PublicAccountNewBridgeInvokeHandler.register.1(localPublicAccountNewBridgeInvokeHandler));
    a("getRIJAppType", (Function2)new PublicAccountNewBridgeInvokeHandler.register.2(localPublicAccountNewBridgeInvokeHandler));
    a("getUserInfo", (Function2)new PublicAccountNewBridgeInvokeHandler.register.3(localPublicAccountNewBridgeInvokeHandler));
  }
  
  @NotNull
  public String b()
  {
    return "publicAccountNew";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.PublicAccountNewBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */