package com.tencent.mobileqq.msgforward;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MsgforwardWXWebViewPlugin
  extends WebViewPlugin
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if ((paramString2 == null) || (!"msgForward".equalsIgnoreCase(paramString2)) || (paramString3 == null)) {}
    while ((this.mRuntime == null) || (this.mRuntime.a() == null) || (!"showForwardToWXMsg".equalsIgnoreCase(paramString3)) || (paramVarArgs == null)) {
      return false;
    }
    if (paramVarArgs.length > 0) {
      while (i < paramVarArgs.length)
      {
        QLog.d("MsgforwardWXWebViewPlugin", 1, paramVarArgs[i]);
        i += 1;
      }
    }
    paramJsBridgeListener = "0";
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]).optString("rId");
      paramJsBridgeListener = paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        long l;
        QLog.e("MsgforwardWXWebViewPlugin", 1, "MsgforwardWXWebViewPlugin get resid exception!");
      }
    }
    paramString1 = this.mRuntime.a();
    l = paramJsBridgeListener.hashCode();
    paramString2 = new Intent(paramString1, MultiForwardActivity.class);
    paramString2.putExtra("chat_subType", 3);
    paramString2.putExtra("uin", "0");
    paramString2.putExtra("uintype", 1040);
    paramString2.putExtra("multi_url", paramJsBridgeListener);
    paramString2.putExtra("multi_uniseq", l);
    paramString1.startActivity(paramString2);
    paramString1.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.MsgforwardWXWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */