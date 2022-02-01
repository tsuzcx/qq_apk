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
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && ("msgForward".equalsIgnoreCase(paramString2)))
    {
      if (paramString3 == null) {
        return false;
      }
      if (this.mRuntime != null)
      {
        if (this.mRuntime.d() == null) {
          return false;
        }
        if (("showForwardToWXMsg".equalsIgnoreCase(paramString3)) && (paramVarArgs != null)) {
          if (paramVarArgs.length > 0)
          {
            int i = 0;
            while (i < paramVarArgs.length)
            {
              QLog.d("MsgforwardWXWebViewPlugin", 1, paramVarArgs[i]);
              i += 1;
            }
          }
        }
      }
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("rId");
    }
    catch (Exception paramJsBridgeListener)
    {
      label111:
      long l;
      break label111;
    }
    QLog.e("MsgforwardWXWebViewPlugin", 1, "MsgforwardWXWebViewPlugin get resid exception!");
    paramJsBridgeListener = "0";
    paramString1 = this.mRuntime.d();
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.MsgforwardWXWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */