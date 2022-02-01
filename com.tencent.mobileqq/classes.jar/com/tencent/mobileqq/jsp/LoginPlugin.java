package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LoginPlugin
  extends WebViewPlugin
{
  public LoginPlugin()
  {
    this.mPluginNameSpace = "login";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity instanceof BasePluginActivity); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("login".equals(paramString2)) && ("openSmsPage".equals(paramString3))) {}
    for (;;)
    {
      try
      {
        addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("countryCode");
        paramString2 = paramJsBridgeListener.optString("uin");
        paramString3 = paramJsBridgeListener.optString("phone");
        int j = paramJsBridgeListener.optInt("mentrance");
        int k = Integer.parseInt(paramJsBridgeListener.optString("verifySeq"));
        if (paramJsBridgeListener.optInt("isFromOpenSdk", 0) == 1)
        {
          i = 1;
          paramVarArgs = new Intent();
          if (i == 0) {
            break label258;
          }
          paramJsBridgeListener = "/base/login/authDevVerifyCodeOpenSdk";
          paramVarArgs.putExtra("phone_num", paramString3);
          paramVarArgs.putExtra("country_code", paramString1);
          paramVarArgs.putExtra("mobile_type", 0);
          paramVarArgs.putExtra("from_login", true);
          paramVarArgs.putExtra("uin", paramString2);
          paramVarArgs.putExtra("seq", k);
          RouteUtils.a(a(), paramVarArgs, paramJsBridgeListener, 12);
          paramJsBridgeListener = "";
          if (j == 1)
          {
            paramJsBridgeListener = "1";
            ReportController.a(null, "dc00898", "", "", "0X800ADE1", "0X800ADE1", 0, 0, paramJsBridgeListener, "", "", "");
            return true;
          }
          if (j != 2) {
            continue;
          }
          paramJsBridgeListener = "2";
          continue;
          return false;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e("LoginPlugin", 1, new Object[] { "deal login jsbridge error : ", paramJsBridgeListener.getMessage() });
      }
      int i = 0;
      continue;
      label258:
      paramJsBridgeListener = "/base/login/authDevVerifyCode";
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.LoginPlugin
 * JD-Core Version:    0.7.0.1
 */