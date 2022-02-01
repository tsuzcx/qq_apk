package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
      QLog.d("PraiseJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("praise".equals(paramString2)))
    {
      if (paramString3 == null) {
        return false;
      }
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
          QLog.d("PraiseJsPlugin", 2, paramString1.toString());
        }
        paramString1 = paramJsBridgeListener.optString("callback");
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("PraiseJsPlugin", 1, "callback id is null, so return");
          return true;
        }
        if ("queryLocal".equals(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("queryLocal ");
            paramString2.append(paramJsBridgeListener.toString());
            QLog.i("PraiseJsPlugin", 2, paramString2.toString());
          }
          paramString1 = DataFactory.a("queryPraiseLocal", paramString1, this.mOnRemoteResp.key, new Bundle());
          try
          {
            if (paramJsBridgeListener.has("type")) {
              paramString1.putString("type", paramJsBridgeListener.getString("type"));
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PraiseJsPlugin", 2, paramJsBridgeListener.getMessage());
            }
          }
          super.sendRemoteReq(paramString1, false, false);
          return true;
        }
        if ("setup".equals(paramString3))
        {
          int i = paramJsBridgeListener.getInt("id");
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("setup ");
            paramString2.append(paramJsBridgeListener.toString());
            QLog.i("PraiseJsPlugin", 2, paramString2.toString());
          }
          this.mReqBundle.clear();
          this.mReqBundle.putInt("id", i);
          super.sendRemoteReq(DataFactory.a("setupPraise", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          return true;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("PraiseJsPlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
      }
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    this.mReqBundle = new Bundle();
    super.onCreate();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      String str = paramBundle.getString("cmd");
      Object localObject1 = paramBundle.getString("callbackid");
      Object localObject2 = paramBundle.getBundle("response");
      if (localObject2 != null) {
        ((Bundle)localObject2).setClassLoader(this.mRuntime.d().getClassLoader());
      }
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("response:");
        ((StringBuilder)localObject3).append(str);
        QLog.i("PraiseJsPlugin", 2, ((StringBuilder)localObject3).toString());
      }
      if (str != null)
      {
        int i;
        if ("queryPraiseLocal".equals(str))
        {
          if (localObject2 == null) {
            return;
          }
          i = ((Bundle)localObject2).getInt("id");
          try
          {
            paramBundle = new JSONObject();
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("currentId", i);
            paramBundle.put("data", localObject2);
            paramBundle.put("result", 0);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("(");
            ((StringBuilder)localObject2).append(paramBundle.toString());
            ((StringBuilder)localObject2).append(");");
            super.callJs(((StringBuilder)localObject2).toString());
            return;
          }
          catch (JSONException paramBundle)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onResponse: cmd=");
            ((StringBuilder)localObject1).append(str);
            ((StringBuilder)localObject1).append(" failed.");
            QLog.e("PraiseJsPlugin", 1, ((StringBuilder)localObject1).toString(), paramBundle);
            return;
          }
        }
        if ("setupPraise".equals(str))
        {
          if (localObject2 != null)
          {
            i = ((Bundle)localObject2).getInt("id");
            int j = ((Bundle)localObject2).getInt("code");
            localObject2 = ((Bundle)localObject2).getString("url");
            try
            {
              paramBundle = new JSONObject();
              try
              {
                localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("currentId", i);
                ((JSONObject)localObject3).put("url", localObject2);
                paramBundle.put("result", j);
                paramBundle.put("data", localObject3);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append("(");
                ((StringBuilder)localObject2).append(paramBundle.toString());
                ((StringBuilder)localObject2).append(");");
                super.callJs(((StringBuilder)localObject2).toString());
                return;
              }
              catch (JSONException paramBundle) {}
              localObject1 = new StringBuilder();
            }
            catch (JSONException paramBundle) {}
            ((StringBuilder)localObject1).append("onResponse: cmd=");
            ((StringBuilder)localObject1).append(str);
            ((StringBuilder)localObject1).append(" failed.");
            QLog.e("PraiseJsPlugin", 1, ((StringBuilder)localObject1).toString(), paramBundle);
          }
        }
        else {
          super.onResponse(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.PraiseJsPlugin
 * JD-Core Version:    0.7.0.1
 */