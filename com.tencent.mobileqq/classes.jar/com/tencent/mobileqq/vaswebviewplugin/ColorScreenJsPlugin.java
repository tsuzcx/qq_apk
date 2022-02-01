package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
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
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("ColorScreenJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("colorScreen".equals(paramString2)) && (paramString3 != null)) {
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener == null) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("handleJsRequest JSON = ");
          paramString1.append(paramJsBridgeListener.toString());
          QLog.d("ColorScreenJsPlugin", 2, paramString1.toString());
        }
        paramString1 = paramJsBridgeListener.optString("callback");
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("ColorScreenJsPlugin", 1, "callback id is null, so return");
          return true;
        }
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
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append(" unsupport method name ");
        paramJsBridgeListener.append(paramString3);
        throw new Exception(paramJsBridgeListener.toString());
      }
      catch (Throwable paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorScreenJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
    }
    return false;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      Object localObject1 = paramBundle.getString("cmd");
      String str = paramBundle.getString("callbackid");
      Object localObject2 = paramBundle.getBundle("response");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("response:");
        localStringBuilder.append((String)localObject1);
        QLog.i("ColorScreenJsPlugin", 2, localStringBuilder.toString());
      }
      if ("colorScreen_queryLocal".equals(localObject1))
      {
        if (localObject2 != null)
        {
          int i = ((Bundle)localObject2).getInt("id");
          paramBundle = new JSONObject();
          try
          {
            paramBundle.put("message", "ok");
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("currentId", i);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("query local colorScreen data: ");
              ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
              QLog.i("ColorScreenJsPlugin", 2, ((StringBuilder)localObject2).toString());
            }
            paramBundle.put("data", localObject1);
            paramBundle.put("result", 0);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(str);
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(paramBundle.toString());
            ((StringBuilder)localObject1).append(");");
            super.callJs(((StringBuilder)localObject1).toString());
            return;
          }
          catch (JSONException paramBundle)
          {
            QLog.e("ColorScreenJsPlugin", 1, "", paramBundle);
          }
        }
        return;
      }
      if ("colorScreen_setup".equals(localObject1)) {
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("result", paramBundle.getInt("result"));
          ((JSONObject)localObject1).put("message", "ok");
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("setup result: ");
            paramBundle.append(((JSONObject)localObject1).toString());
            QLog.i("ColorScreenJsPlugin", 2, paramBundle.toString());
          }
          paramBundle = new StringBuilder();
          paramBundle.append(str);
          paramBundle.append("(");
          paramBundle.append(((JSONObject)localObject1).toString());
          paramBundle.append(");");
          super.callJs(paramBundle.toString());
          return;
        }
        catch (JSONException paramBundle)
        {
          QLog.e("ColorScreenJsPlugin", 1, "", paramBundle);
        }
      }
    }
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryLocal ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("ColorScreenJsPlugin", 2, localStringBuilder.toString());
    }
    paramString = DataFactory.a("colorScreen_queryLocal", paramString, this.mOnRemoteResp.key, new Bundle());
    if (paramJSONObject != null) {
      try
      {
        if (paramJSONObject.has("type")) {
          paramString.putString("type", paramJSONObject.getString("type"));
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorScreenJsPlugin", 2, paramJSONObject.getMessage());
        }
      }
    }
    super.sendRemoteReq(paramString, false, false);
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setup ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("ColorScreenJsPlugin", 2, localStringBuilder.toString());
    }
    paramJSONObject = new Bundle();
    paramJSONObject.clear();
    paramJSONObject.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("colorScreen_setup", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */