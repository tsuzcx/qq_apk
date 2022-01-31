package com.tencent.mobileqq.vaswebviewplugin;

import anad;
import anah;
import android.os.Bundle;
import android.text.TextUtils;
import anfc;
import badq;
import bahj;
import bbac;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class StarJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "starclub";
  public static final String TAG = "StarJsPlugin";
  private BrowserAppInterface browserApp;
  private Bundle mReqBundle;
  
  public StarJsPlugin()
  {
    this.mPluginNameSpace = "starclub";
  }
  
  public void createShortcut(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StarJsPlugin", 2, "startCreateShortcut " + paramJSONObject.toString());
    }
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str = paramJSONObject.getString("nickname");
      if (bahj.a(this.browserApp.getApp(), new String[] { str }))
      {
        localJSONObject.put("ret", -2);
        super.callJs(paramString + "(" + localJSONObject.toString() + ");");
        return;
      }
      if (!badq.d(this.browserApp.getApplication().getApplicationContext()))
      {
        localJSONObject.put("ret", -3);
        super.callJs(paramString + "(" + localJSONObject.toString() + ");");
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StarJsPlugin", 2, "createShortcut failed: " + paramJSONObject.getMessage());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putString("iconurl", paramJSONObject.getString("iconurl"));
    this.mReqBundle.putString("nickname", str);
    this.mReqBundle.putString("starhomeurl", paramJSONObject.getString("starhomeurl"));
    this.mReqBundle.putString("sid", paramJSONObject.getString("starid"));
    paramJSONObject = anah.a("createShortcut", paramString, this.mOnRemoteResp.key, this.mReqBundle);
    anfc.a().a(paramJSONObject);
  }
  
  protected long getPluginBusiness()
  {
    return 2164260864L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("StarJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    boolean bool1;
    if ((paramString1 == null) || (!"starclub".equals(paramString2)) || (paramString3 == null)) {
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
              QLog.d("StarJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
            }
            paramString1 = paramJsBridgeListener.optString("callback");
            if (!TextUtils.isEmpty(paramString1)) {
              break label171;
            }
            QLog.e("StarJsPlugin", 1, "callback id is null, so return");
            return true;
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          bool1 = bool2;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("StarJsPlugin", 2, paramJsBridgeListener.getMessage());
    return true;
    label171:
    if ("createShortcut".equals(paramString3))
    {
      createShortcut(paramJsBridgeListener, paramString1);
      return true;
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  public void onCreate()
  {
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    for (;;)
    {
      super.onCreate();
      return;
      if (QLog.isColorLevel()) {
        QLog.e("StarJsPlugin", 2, "ERROR!!! StarClub is not running in web process!");
      }
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i("StarJsPlugin", 2, "response:" + (String)localObject);
      }
      if ((localObject == null) || (!"createShortcut".equals(localObject))) {}
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("ret", paramBundle.get("ret"));
      super.callJs(str + "(" + ((JSONObject)localObject).toString() + ");");
      return;
    }
    catch (JSONException paramBundle)
    {
      super.callJsOnError(str, paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.StarJsPlugin
 * JD-Core Version:    0.7.0.1
 */