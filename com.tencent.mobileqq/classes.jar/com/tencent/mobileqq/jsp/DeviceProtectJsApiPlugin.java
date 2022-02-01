package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.login.api.authdev.IAuthDevUgHelper;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceProtectJsApiPlugin
  extends WebViewPlugin
{
  private String a;
  
  public DeviceProtectJsApiPlugin()
  {
    this.mPluginNameSpace = "deviceProtect";
  }
  
  private void a()
  {
    Object localObject2;
    try
    {
      Object localObject4 = QIPCClientHelper.getInstance().getClient().callServer("DeviceProtectQIPCModule", "ACTION_GET_DEVICE_INFO", null);
      if (((EIPCResult)localObject4).code != 0)
      {
        QLog.e("DeviceProtectJsApiPlugin", 1, "handleGetDeviceInfo error: result.code != EIPCResult.CODE_NO_ERR");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("retCode", -1);
        callJs(this.a, new String[] { ((JSONObject)localObject1).toString() });
        return;
      }
      Object localObject3 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      Object localObject1 = ((EIPCResult)localObject4).data.getString("guid", "");
      localObject2 = ((EIPCResult)localObject4).data.getString("qimei", "");
      String str1 = ((EIPCResult)localObject4).data.getString("subappid", "");
      String str2 = ((EIPCResult)localObject4).data.getString("platform", "");
      String str3 = ((EIPCResult)localObject4).data.getString("brand", "");
      String str4 = ((EIPCResult)localObject4).data.getString("model", "");
      localObject4 = ((EIPCResult)localObject4).data.getString("bssid", "");
      localJSONObject.put("guid", localObject1);
      localJSONObject.put("qimei", localObject2);
      localJSONObject.put("subappid", str1);
      localJSONObject.put("platform", str2);
      localJSONObject.put("brand", str3);
      localJSONObject.put("model", str4);
      localJSONObject.put("bssid", localObject4);
      localJSONObject.put("devInfo", str3 + " " + str4);
      ((JSONObject)localObject3).put("retCode", 0);
      ((JSONObject)localObject3).put("retData", localJSONObject);
      callJs(this.a, new String[] { ((JSONObject)localObject3).toString() });
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("guid:").append((String)localObject1).append("qimei:").append((String)localObject2).append("subappid:").append(str1).append("platform:").append(str2).append("brand:").append(str3).append("model:").append(str4).append("bssid:").append((String)localObject4);
      QLog.d("DeviceProtectJsApiPlugin", 1, "handleGetDeviceInfo info: " + localObject3);
      return;
    }
    catch (Exception localException) {}
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("retCode", -1);
      callJs(this.a, new String[] { ((JSONObject)localObject2).toString() });
      QLog.e("DeviceProtectJsApiPlugin", 1, "GetDeviceInfo callJs error", localException);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("DeviceProtectJsApiPlugin", 1, "GetDeviceInfo callJs JSONException", localJSONException);
      }
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1))
    {
      QLog.d("DeviceProtectJsApiPlugin", 1, "handlePhoneChanged: no args, return.");
      return;
    }
    if ((this.mRuntime == null) || (this.mRuntime.a() == null))
    {
      QLog.d("DeviceProtectJsApiPlugin", 1, "handlePhoneChanged: activity is null.");
      return;
    }
    Object localObject;
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      paramVarArgs = ((JSONObject)localObject).getString("phoneNo");
      localObject = ((JSONObject)localObject).optString("countryCode");
      if (TextUtils.isEmpty(paramVarArgs))
      {
        QLog.d("DeviceProtectJsApiPlugin", 1, "handlePhoneChanged: phone is empty");
        return;
      }
    }
    catch (JSONException paramVarArgs)
    {
      QLog.e("DeviceProtectJsApiPlugin", 1, "handlePhoneChanged: json exception.", paramVarArgs);
      return;
    }
    ((IAuthDevUgHelper)QRoute.api(IAuthDevUgHelper.class)).notifyPhoneChanged(this.mRuntime.a(), paramVarArgs, (String)localObject);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("DeviceProtectJsApiPlugin", 1, "Call getDeviceInfo error, url is empty");
    }
    do
    {
      do
      {
        return false;
        QLog.d("DeviceProtectJsApiPlugin", 1, "Call DeviceProtectJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
      } while (!"deviceProtect".equals(paramString2));
      if ("getDeviceInfo".equals(paramString3))
      {
        QLog.d("DeviceProtectJsApiPlugin", 1, "Call getDeviceInfo, args:" + paramVarArgs);
        paramJsBridgeListener = paramString1.split("#");
        if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length == 2))
        {
          this.a = paramJsBridgeListener[1];
          a();
          return true;
        }
        QLog.e("DeviceProtectJsApiPlugin", 1, "Call getDeviceInfo error, jsapi does not contain callback");
        return false;
      }
    } while (!"changePhoneNo".equals(paramString3));
    QLog.d("DeviceProtectJsApiPlugin", 1, "handleJsRequest: changePhoneNo");
    a(paramVarArgs);
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DeviceProtectJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */