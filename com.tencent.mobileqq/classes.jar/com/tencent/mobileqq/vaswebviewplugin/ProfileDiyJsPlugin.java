package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ProfileDiyJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "diycard";
  public static final String TAG = "ProfileDiyJsPlugin";
  public Bundle mReqBundle;
  
  public ProfileDiyJsPlugin()
  {
    this.mPluginNameSpace = "diycard";
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
      QLog.d("ProfileDiyJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("diycard".equals(paramString2)) && (paramString3 != null))
    {
      try
      {
        paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramString1 == null) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("handleJsRequest JSON = ");
          paramJsBridgeListener.append(paramString1.toString());
          QLog.d("ProfileDiyJsPlugin", 2, paramJsBridgeListener.toString());
        }
        paramJsBridgeListener = paramString1.optString("callback");
        if ("edit".equals(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("edit ");
            paramString2.append(paramString1.toString());
            QLog.i("ProfileDiyJsPlugin", 2, paramString2.toString());
          }
          long l = paramString1.optLong("id");
          paramString2 = paramString1.optString("url");
          paramString1 = paramString1.optString("defaultText");
          paramString3 = new Intent(this.mRuntime.d(), VipProfileCardDiyActivity.class);
          paramString3.putExtra("extra_from", 2);
          paramString3.putExtra("extra_card_id", l);
          paramString3.putExtra("extra_card_url", paramString2);
          paramString3.putExtra("extra_card_text", paramString1);
          paramString3.putExtra("extra_card_default_text", paramString1);
          this.mRuntime.d().startActivity(paramString3);
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramJsBridgeListener);
            paramString1.append("({'result':0});");
            super.callJs(paramString1.toString());
            return true;
          }
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("ProfileDiyJsPlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
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
      paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (paramBundle != null) {
        paramBundle.setClassLoader(this.mRuntime.d().getClassLoader());
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("response:");
        paramBundle.append(str);
        QLog.i("ProfileDiyJsPlugin", 2, paramBundle.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ProfileDiyJsPlugin
 * JD-Core Version:    0.7.0.1
 */