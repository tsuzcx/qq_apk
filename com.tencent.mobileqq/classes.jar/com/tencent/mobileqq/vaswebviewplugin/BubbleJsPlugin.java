package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import anvx;
import ascz;
import asdd;
import bifw;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "bubble";
  private static final String OBJECT_NAME = "bubble";
  public static final String TAG = "BubbleJsPlugin";
  private Bundle mReqBundle;
  
  public BubbleJsPlugin()
  {
    this.mPluginNameSpace = "bubble";
  }
  
  public void diySetup(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    int j = paramJSONObject.getInt("textId");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "diySetup " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    this.mReqBundle.putInt("textId", j);
    super.sendRemoteReq(asdd.a("diy_setup", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    startDownload(paramJSONObject, "");
    if (QLog.isColorLevel()) {
      QLog.d("BubbleJsPlugin", 2, paramJSONObject.toString());
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2147483712L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("BubbleJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    boolean bool1;
    if ((paramString1 == null) || (!"bubble".equals(paramString2)) || (paramString3 == null)) {
      bool1 = false;
    }
    label171:
    do
    {
      do
      {
        do
        {
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
                    QLog.d("BubbleJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
                  }
                  paramString1 = paramJsBridgeListener.optString("callback");
                  if (!TextUtils.isEmpty(paramString1)) {
                    break label171;
                  }
                  QLog.e("BubbleJsPlugin", 1, "callback id is null, so return");
                  return true;
                }
              }
              catch (Throwable paramJsBridgeListener)
              {
                bool1 = bool2;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("BubbleJsPlugin", 2, paramJsBridgeListener.getMessage());
          return true;
          if ("queryInfo".equals(paramString3))
          {
            queryInfo(paramJsBridgeListener, paramString1);
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
          if ("startDownload".equals(paramString3))
          {
            startDownload(paramJsBridgeListener, paramString1);
            return true;
          }
          if ("stopDownload".equals(paramString3))
          {
            stopDownload(paramJsBridgeListener, paramString1);
            return true;
          }
          bool1 = bool2;
        } while ("openSecMsg".equalsIgnoreCase(paramString3));
        bool1 = bool2;
      } while ("isSecGroupAvailable".equalsIgnoreCase(paramString3));
      bool1 = bool2;
    } while ("openSecGroup".equalsIgnoreCase(paramString3));
    if ("diySetup".equalsIgnoreCase(paramString3))
    {
      diySetup(paramJsBridgeListener, paramString1);
      return true;
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  public void onCreate()
  {
    this.mReqBundle = new Bundle();
    super.onCreate();
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("srcType");
    int j;
    JSONObject localJSONObject;
    if ((i != 0) && (i == 3))
    {
      i = paramBundle.getInt("id");
      j = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("callbackId");
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      label95:
      super.callJs(paramBundle + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException localJSONException)
    {
      break label95;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject2;
    String str1;
    Object localObject1;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject2 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      localObject1 = paramBundle.getBundle("response");
      if (localObject1 != null) {
        ((Bundle)localObject1).setClassLoader(this.mRuntime.a().getClassLoader());
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleJsPlugin", 2, "response:" + (String)localObject2);
      }
      if ((localObject2 != null) && (!"setup".equals(localObject2))) {
        break label177;
      }
    }
    for (;;)
    {
      label177:
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("result", 0);
        paramBundle.put("message", "ok");
        super.callJs(str1 + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (JSONException paramBundle) {}
      if ("diy_setup".equals(localObject2)) {
        try
        {
          paramBundle = new JSONObject();
          paramBundle.put("result", 0);
          paramBundle.put("msg", "ok");
          super.callJs(str1 + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      if ("queryLocal".equals(localObject2))
      {
        if (localObject1 == null) {
          continue;
        }
        int i = ((Bundle)localObject1).getInt("id");
        String str2 = ((Bundle)localObject1).getString("diyText");
        boolean bool = ((Bundle)localObject1).containsKey("isDiy");
        int j = ((Bundle)localObject1).getInt("voiceprintId", 0);
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("message", "ok");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("currentId", i);
          ((JSONObject)localObject2).put("diyText", str2);
          ((JSONObject)localObject2).put("voiceprintId", j);
          if (bool)
          {
            ((JSONObject)localObject2).put("isDiy", 1);
            str2 = ((Bundle)localObject1).getString("tl");
            if (!TextUtils.isEmpty(str2)) {
              ((JSONObject)localObject2).put("tl", str2);
            }
            str2 = ((Bundle)localObject1).getString("tr");
            if (!TextUtils.isEmpty(str2)) {
              ((JSONObject)localObject2).put("tr", str2);
            }
            str2 = ((Bundle)localObject1).getString("bl");
            if (!TextUtils.isEmpty(str2)) {
              ((JSONObject)localObject2).put("bl", str2);
            }
            localObject1 = ((Bundle)localObject1).getString("br");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((JSONObject)localObject2).put("br", localObject1);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("BubbleJsPlugin", 2, "query local bubble data: " + ((JSONObject)localObject2).toString());
          }
          paramBundle.put("data", localObject2);
          paramBundle.put("result", 0);
          super.callJs(str1 + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          QLog.e("BubbleJsPlugin", 1, "", paramBundle);
          return;
        }
      }
      if ("queryBubbleInfo".equals(localObject2))
      {
        if (localObject1 == null) {
          continue;
        }
        paramBundle = ((Bundle)localObject1).getString("result");
        if (TextUtils.isEmpty(paramBundle)) {
          continue;
        }
        try
        {
          paramBundle = new JSONObject(paramBundle);
          super.callJs(str1 + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      if ("bubble_StopDownLoad".equals(localObject2))
      {
        if (localObject1 == null) {
          continue;
        }
        paramBundle = ((Bundle)localObject1).getString("result");
        if (TextUtils.isEmpty(paramBundle)) {
          continue;
        }
        try
        {
          paramBundle = new JSONObject(paramBundle);
          super.callJs(str1 + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      super.onResponse(paramBundle);
      return;
    }
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "queryInfo " + paramJSONObject.toString());
    }
    int i = paramJSONObject.getInt("id");
    if (i == 0)
    {
      paramJSONObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", 3);
      localJSONObject.put("progress", 100);
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", anvx.a(2131700709));
      super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(asdd.a("queryBubbleInfo", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "queryLocal " + paramJSONObject.toString());
    }
    paramString = asdd.a("queryLocal", paramString, this.mOnRemoteResp.key, new Bundle());
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
          QLog.e("BubbleJsPlugin", 2, paramJSONObject.getMessage());
        }
      }
    }
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "setup " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    int i;
    if (paramJSONObject.has("id"))
    {
      i = paramJSONObject.getInt("id");
      this.mReqBundle.putInt("id", i);
    }
    if (paramJSONObject.has("voiceprintId"))
    {
      i = paramJSONObject.optInt("voiceprintId", 0);
      this.mReqBundle.putInt("voiceprintId", i);
    }
    super.sendRemoteReq(asdd.a("setup", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "startDownload " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(asdd.a("bubble_startDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void stopDownload(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "stopDownload " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(asdd.a("bubble_StopDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin
 * JD-Core Version:    0.7.0.1
 */