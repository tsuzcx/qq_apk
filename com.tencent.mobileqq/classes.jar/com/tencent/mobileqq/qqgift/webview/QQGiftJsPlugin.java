package com.tencent.mobileqq.qqgift.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QQGiftJsPlugin
  extends WebViewPlugin
{
  public QQGiftJsPlugin()
  {
    this.mPluginNameSpace = "qq_gift";
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = QQGiftCookieManager.a().b();
    if (paramString1 != null)
    {
      QQGiftCookieManager.a().a(this.mRuntime.d().getApplicationContext(), paramString1);
      b(paramString2);
      return;
    }
    paramString1 = new JSONObject();
    paramString1.put("code", -1);
    paramString1.put("message", "get p_skey null");
    callJs(paramString2, new String[] { paramString1.toString() });
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("options");
    Activity localActivity = this.mRuntime.d();
    if (localActivity != null)
    {
      Intent localIntent2 = localActivity.getIntent();
      Intent localIntent1 = new Intent(localActivity, QQBrowserActivity.class);
      localIntent1.setData(Uri.parse(str));
      localIntent1.putExtra("startOpenPageTime", System.currentTimeMillis());
      Object localObject = null;
      if (localJSONObject != null) {
        paramJSONObject = localJSONObject.optString("businessId", null);
      } else {
        paramJSONObject = null;
      }
      if (paramJSONObject != null) {
        paramString = paramJSONObject;
      } else if (localIntent2 == null) {
        paramString = null;
      } else {
        paramString = localIntent2.getStringExtra("big_brother_source_key");
      }
      localIntent1.putExtra("big_brother_source_key", paramString);
      paramString = (String)localObject;
      if (localIntent2 != null)
      {
        localObject = localIntent2.getStringExtra("big_brother_ref_source_key");
        paramString = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramString = localIntent2.getStringExtra("big_brother_source_key");
        }
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = paramJSONObject;
      }
      localIntent1.putExtra("big_brother_ref_source_key", (String)localObject);
      localIntent1.putExtra("url", str);
      localIntent1.setFlags(0);
      if ((localJSONObject != null) && (localJSONObject.optInt("target") == 1)) {
        localIntent1.putExtra("articalChannelId", 0);
      }
      localActivity.startActivity(localIntent1);
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
      if ("closeChargePanel".equals(paramString3))
      {
        b(paramString2, paramVarArgs);
        return true;
      }
      if ("refreshToken".equals(paramString3))
      {
        a(paramString1, paramVarArgs);
        return true;
      }
      if ("chargePageLoaded".equals(paramString3))
      {
        c(paramString2, paramVarArgs);
        return true;
      }
      if ("openFullScreenUrl".equals(paramString3))
      {
        a(paramString2, paramVarArgs);
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
      QLog.e("QQGiftJsPlugin", 1, paramString2.toString());
    }
    return true;
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
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
      QLog.e("QQGiftJsPlugin", 1, localStringBuilder.toString());
    }
  }
  
  private void b(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = paramJSONObject.getString("msg");
    int i = paramJSONObject.getInt("code");
    Object localObject2 = this.mRuntime.d();
    Intent localIntent = ((Activity)localObject2).getIntent();
    boolean bool2 = false;
    boolean bool1 = false;
    int j = localIntent.getIntExtra("extra_web_recharge_callback_key", 0);
    int k = ((Activity)localObject2).getIntent().getIntExtra("extra_web_open_recharge_process_id_key", 0);
    int m = ((Activity)localObject2).getIntent().getIntExtra("extra_web_scene_id_key", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[closeChargePanel] json:");
      ((StringBuilder)localObject2).append(paramJSONObject);
      ((StringBuilder)localObject2).append(", busId:");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(", process:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(", callbackKey:");
      ((StringBuilder)localObject2).append(j);
      QLog.d("QQGiftJsPlugin", 2, ((StringBuilder)localObject2).toString());
    }
    if (MobileQQ.sProcessId == k)
    {
      paramJSONObject = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(m).f();
      if (i == 0) {
        bool1 = true;
      }
      paramJSONObject.a(j, bool1, i, (String)localObject1);
    }
    else
    {
      paramJSONObject = new Bundle();
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
      paramJSONObject.putBoolean("params_key_success", bool1);
      paramJSONObject.putInt("params_key_code", i);
      paramJSONObject.putString("params_key_msg", (String)localObject1);
      paramJSONObject.putInt("params_key_business_id", m);
      paramJSONObject.putInt("params_key_callback_key", j);
      QIPCClientHelper.getInstance().getClient().callServer("QQGiftServerIPCModule", "action_notify_recharge_callback", paramJSONObject);
    }
    try
    {
      this.mRuntime.d().finish();
    }
    catch (Exception paramJSONObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mRuntime.getActivity().finish() e:");
      ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
      QLog.e("QQGiftJsPlugin", 1, ((StringBuilder)localObject1).toString());
    }
    b(paramString);
  }
  
  private void c(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGiftJsPlugin", 2, "onChargePageLoaded");
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong != 8589934610L) && (paramLong != 8589934601L)) {
      return super.handleEvent(paramString, paramLong, paramMap);
    }
    if ((this.mRuntime != null) && (this.mRuntime.d() != null)) {
      this.mRuntime.d().finish();
    }
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (a(paramString2)) {
      return a(paramString1, paramString2, paramString3, paramVarArgs);
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftJsPlugin
 * JD-Core Version:    0.7.0.1
 */