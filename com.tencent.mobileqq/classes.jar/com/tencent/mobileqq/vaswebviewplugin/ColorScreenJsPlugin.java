package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ColorScreenJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "colorScreen";
  public static final String TAG = "ColorScreenJsPlugin";
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    boolean bool1;
    if ((paramString1 == null) || (!"colorScreen".equals(paramString2)) || (paramString3 == null)) {
      bool1 = false;
    }
    do
    {
      for (;;)
      {
        return bool1;
        try
        {
          paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
          bool1 = bool2;
          if (paramJsBridgeListener != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ColorScreenJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
            }
            paramString1 = paramJsBridgeListener.optString("callback");
            if (!TextUtils.isEmpty(paramString1)) {
              break label171;
            }
            QLog.e("ColorScreenJsPlugin", 1, "callback id is null, so return");
            return true;
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          bool1 = bool2;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ColorScreenJsPlugin", 2, paramJsBridgeListener.getMessage());
    return true;
    label171:
    if ("queryLocal".equals(paramString3))
    {
      queryLocal(paramJsBridgeListener, paramString1);
      return true;
    }
    if ("setup".equals(paramString3))
    {
      setup(paramJsBridgeListener, paramString1);
      return true;
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      Bundle localBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i("ColorScreenJsPlugin", 2, "response:" + (String)localObject);
      }
      if (!"colorScreen_queryLocal".equals(localObject)) {
        break label233;
      }
      if (localBundle != null)
      {
        i = localBundle.getInt("id");
        paramBundle = new JSONObject();
      }
    }
    label233:
    while (!"colorScreen_setup".equals(localObject)) {
      try
      {
        int i;
        paramBundle.put("message", "ok");
        localObject = new JSONObject();
        ((JSONObject)localObject).put("currentId", i);
        if (QLog.isColorLevel()) {
          QLog.i("ColorScreenJsPlugin", 2, "query local colorScreen data: " + ((JSONObject)localObject).toString());
        }
        paramBundle.put("data", localObject);
        paramBundle.put("result", 0);
        super.callJs(str + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (JSONException paramBundle)
      {
        QLog.e("ColorScreenJsPlugin", 1, "", paramBundle);
        return;
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", paramBundle.getInt("result"));
      ((JSONObject)localObject).put("message", "ok");
      if (QLog.isColorLevel()) {
        QLog.i("ColorScreenJsPlugin", 2, "setup result: " + ((JSONObject)localObject).toString());
      }
      super.callJs(str + "(" + ((JSONObject)localObject).toString() + ");");
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.e("ColorScreenJsPlugin", 1, "", paramBundle);
    }
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ColorScreenJsPlugin", 2, "queryLocal " + paramJSONObject.toString());
    }
    paramString = DataFactory.a("colorScreen_queryLocal", paramString, this.mOnRemoteResp.key, new Bundle());
    if (paramJSONObject != null) {}
    try
    {
      if (paramJSONObject.has("type")) {
        paramString.putString("type", paramJSONObject.getString("type"));
      }
      super.sendRemoteReq(paramString, false, false);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorScreenJsPlugin", 2, paramJSONObject.getMessage());
        }
      }
    }
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("ColorScreenJsPlugin", 2, "setup " + paramJSONObject.toString());
    }
    paramJSONObject = new Bundle();
    paramJSONObject.clear();
    paramJSONObject.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("colorScreen_setup", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */