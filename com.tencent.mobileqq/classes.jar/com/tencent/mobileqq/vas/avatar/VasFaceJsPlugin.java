package com.tencent.mobileqq.vas.avatar;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VasFaceJsPlugin
  extends VasWebviewJsPlugin
{
  public void a(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("faceId");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setup ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("VasFaceJsPlugin", 2, localStringBuilder.toString());
    }
    paramJSONObject = new Bundle();
    paramJSONObject.clear();
    paramJSONObject.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("face_setup", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
  }
  
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
      QLog.d("VasFaceJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("face".equals(paramString2)) && (paramString3 != null)) {
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
          QLog.d("VasFaceJsPlugin", 2, paramString1.toString());
        }
        paramString1 = paramJsBridgeListener.optString("callback");
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("VasFaceJsPlugin", 1, "callback id is null, so return");
          return true;
        }
        if ("setup".equals(paramString3))
        {
          a(paramJsBridgeListener, paramString1);
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
          QLog.e("VasFaceJsPlugin", 2, paramJsBridgeListener.getMessage());
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
      Object localObject = paramBundle.getString("cmd");
      String str = paramBundle.getString("callbackid");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("response:");
        localStringBuilder.append((String)localObject);
        QLog.i("VasFaceJsPlugin", 2, localStringBuilder.toString());
      }
      if ("face_setup".equals(localObject)) {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("result", paramBundle.getInt("result"));
          ((JSONObject)localObject).put("message", "ok");
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("setup result: ");
            paramBundle.append(((JSONObject)localObject).toString());
            QLog.i("VasFaceJsPlugin", 2, paramBundle.toString());
          }
          paramBundle = new StringBuilder();
          paramBundle.append(str);
          paramBundle.append("(");
          paramBundle.append(((JSONObject)localObject).toString());
          paramBundle.append(");");
          super.callJs(paramBundle.toString());
          return;
        }
        catch (JSONException paramBundle)
        {
          QLog.e("VasFaceJsPlugin", 1, "", paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceJsPlugin
 * JD-Core Version:    0.7.0.1
 */