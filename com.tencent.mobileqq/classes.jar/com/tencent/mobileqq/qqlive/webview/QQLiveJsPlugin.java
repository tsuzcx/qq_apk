package com.tencent.mobileqq.qqlive.webview;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class QQLiveJsPlugin
  extends WebViewPlugin
{
  public QQLiveJsPlugin()
  {
    this.mPluginNameSpace = "qq_livestream";
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQLiveCookieManager.a().a(this.mRuntime.d().getApplicationContext(), null, paramString1);
    paramString1 = new JSONObject();
    paramString1.put("code", 0);
    paramString1.put("message", "ok");
    callJs(paramString2, new String[] { paramString1.toString() });
  }
  
  private void a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.getString("lotteryId");
    String str2 = paramJSONObject.getString("roomId");
    String str3 = paramJSONObject.getString("programId");
    paramJSONObject = paramJSONObject.getString("busId");
    paramJSONObject = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(paramJSONObject);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.getLotteryService();
      if (paramJSONObject != null) {
        paramJSONObject.notifyHideLotteryResult(str1, str2, str3);
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = this.mRuntime.d();
    String str = localActivity.getIntent().getStringExtra("extra_web_verify_app_id");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onVerifiedResult] json:");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(", appId:");
      ((StringBuilder)localObject).append(str);
      QLog.d("QQLiveJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    int i = localActivity.getIntent().getIntExtra("extra_web_verify_callback_key", 0);
    Object localObject = paramJSONObject.getString("msg");
    int j = paramJSONObject.getInt("code");
    boolean bool;
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      paramJSONObject = new Intent("qqlive.faceverify");
      paramJSONObject.putExtra("msg_type", 1001);
      paramJSONObject.putExtra("app_id", str);
      paramJSONObject.putExtra("callback_key", i);
      paramJSONObject.putExtra("result_flag", bool);
      paramJSONObject.putExtra("result_code", j);
      paramJSONObject.putExtra("result_msg", (String)localObject);
      localActivity.sendBroadcast(paramJSONObject);
      b(paramString);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("QQLiveJsPlugin", 1, paramJSONObject, new Object[0]);
    }
  }
  
  private boolean a(String paramString)
  {
    return this.mPluginNameSpace.equalsIgnoreCase(paramString);
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    try
    {
      if (paramVarArgs.length > 0) {
        paramString2 = new JSONObject(paramVarArgs[0]);
      } else {
        paramString2 = new JSONObject();
      }
      paramVarArgs = paramString2.optString("callback", "");
      if ("updateIdResult".equals(paramString3))
      {
        a(paramString2, paramVarArgs);
        return true;
      }
      if ("refreshToken".equals(paramString3))
      {
        a(paramString1, paramVarArgs);
        return true;
      }
      if ("hideLotteryWidget".equals(paramString3))
      {
        a(paramString2);
        return true;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[handleJsRequest] method:");
      paramString2.append(paramString3);
      paramString2.append(", e:");
      paramString2.append(paramString1.getMessage());
      QLog.e("QQLiveJsPlugin", 1, paramString2.toString());
    }
    return true;
  }
  
  private void b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", 0);
      localJSONObject.put("message", "ok");
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[callJsOk] callbackId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", e:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("QQLiveJsPlugin", 1, localStringBuilder.toString());
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong != 8589934610L) && (paramLong != 8589934601L)) {
      return super.handleEvent(paramString, paramLong, paramMap);
    }
    this.mRuntime.d().finish();
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (a(paramString2)) {
      return a(paramString1, paramString2, paramString3, paramVarArgs);
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.webview.QQLiveJsPlugin
 * JD-Core Version:    0.7.0.1
 */