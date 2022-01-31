package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anql;
import bcdb;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileDiyJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    boolean bool1;
    if ((paramString1 == null) || (!"diycard".equals(paramString2)) || (paramString3 == null)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        bool1 = bool2;
        if (paramString2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileDiyJsPlugin", 2, "handleJsRequest JSON = " + paramString2.toString());
          }
          paramJsBridgeListener = paramString2.optString("callback");
          bool1 = bool2;
          if ("edit".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileDiyJsPlugin", 2, "edit " + paramString2.toString());
            }
            long l = paramString2.optLong("id");
            paramString1 = paramString2.optString("url");
            paramString2 = paramString2.optString("defaultText");
            paramString3 = new Intent(this.mRuntime.a(), VipProfileCardDiyActivity.class);
            paramString3.putExtra("extra_from", 2);
            paramString3.putExtra("extra_card_id", l);
            paramString3.putExtra("extra_card_url", paramString1);
            paramString3.putExtra("extra_card_text", paramString2);
            paramString3.putExtra("extra_card_default_text", paramString2);
            this.mRuntime.a().startActivity(paramString3);
            bool1 = bool2;
            if (!TextUtils.isEmpty(paramJsBridgeListener))
            {
              super.callJs(paramJsBridgeListener + "({'result':0});");
              return true;
            }
          }
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("ProfileDiyJsPlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
      }
    }
    return true;
  }
  
  public void onCreate()
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
        paramBundle.setClassLoader(this.mRuntime.a().getClassLoader());
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileDiyJsPlugin", 2, "response:" + str);
      }
      if (str == null) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ProfileDiyJsPlugin
 * JD-Core Version:    0.7.0.1
 */