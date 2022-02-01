package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import aqyp;
import aqyt;
import bgve;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PraiseJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "praise";
  public static final String TAG = "PraiseJsPlugin";
  public Bundle mReqBundle;
  
  public PraiseJsPlugin()
  {
    this.mPluginNameSpace = "praise";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("PraiseJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    boolean bool1;
    if ((paramString1 == null) || (!"praise".equals(paramString2)) || (paramString3 == null)) {
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
              QLog.d("PraiseJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
            }
            paramString1 = paramJsBridgeListener.optString("callback");
            if (TextUtils.isEmpty(paramString1))
            {
              QLog.e("PraiseJsPlugin", 1, "callback id is null, so return");
              return true;
            }
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("PraiseJsPlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
          return true;
        }
      }
      if ("queryLocal".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.i("PraiseJsPlugin", 2, "queryLocal " + paramJsBridgeListener.toString());
        }
        paramString1 = aqyt.a("queryPraiseLocal", paramString1, this.mOnRemoteResp.key, new Bundle());
        try
        {
          if (paramJsBridgeListener.has("type")) {
            paramString1.putString("type", paramJsBridgeListener.getString("type"));
          }
          super.sendRemoteReq(paramString1, false, false);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PraiseJsPlugin", 2, paramJsBridgeListener.getMessage());
            }
          }
        }
      }
      bool1 = bool2;
    } while (!"setup".equals(paramString3));
    int i = paramJsBridgeListener.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("PraiseJsPlugin", 2, "setup " + paramJsBridgeListener.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(aqyt.a("setupPraise", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    return true;
  }
  
  public void onCreate()
  {
    this.mReqBundle = new Bundle();
    super.onCreate();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    String str1;
    String str2;
    Object localObject;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      str1 = paramBundle.getString("cmd");
      str2 = paramBundle.getString("callbackid");
      localObject = paramBundle.getBundle("response");
      if (localObject != null) {
        ((Bundle)localObject).setClassLoader(this.mRuntime.a().getClassLoader());
      }
      if (QLog.isColorLevel()) {
        QLog.i("PraiseJsPlugin", 2, "response:" + str1);
      }
      if (str1 != null)
      {
        if (!"queryPraiseLocal".equals(str1)) {
          break label239;
        }
        if (localObject != null) {
          i = ((Bundle)localObject).getInt("id");
        }
      }
    }
    label239:
    do
    {
      try
      {
        paramBundle = new JSONObject();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("currentId", i);
        paramBundle.put("data", localObject);
        paramBundle.put("result", 0);
        super.callJs(str2 + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (JSONException paramBundle)
      {
        QLog.e("PraiseJsPlugin", 1, "onResponse: cmd=" + str1 + " failed.", paramBundle);
        return;
      }
      if (!"setupPraise".equals(str1)) {
        break;
      }
    } while (localObject == null);
    int i = ((Bundle)localObject).getInt("id");
    int j = ((Bundle)localObject).getInt("code");
    paramBundle = ((Bundle)localObject).getString("url");
    try
    {
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentId", i);
      localJSONObject.put("url", paramBundle);
      ((JSONObject)localObject).put("result", j);
      ((JSONObject)localObject).put("data", localJSONObject);
      super.callJs(str2 + "(" + ((JSONObject)localObject).toString() + ");");
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.e("PraiseJsPlugin", 1, "onResponse: cmd=" + str1 + " failed.", paramBundle);
      return;
    }
    super.onResponse(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.PraiseJsPlugin
 * JD-Core Version:    0.7.0.1
 */