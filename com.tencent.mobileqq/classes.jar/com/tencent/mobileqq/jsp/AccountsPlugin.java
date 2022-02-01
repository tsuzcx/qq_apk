package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class AccountsPlugin
  extends WebViewPlugin
{
  private Activity a;
  
  public AccountsPlugin()
  {
    this.mPluginNameSpace = "accounts";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity instanceof BasePluginActivity); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("accounts".equals(paramString2)) && ("faceDelete".equals(paramString3)))
    {
      QLog.d("AccountsPlugin", 1, "receive api METHOD_DELETE_FACE");
      this.a.setResult(-1);
      this.a.finish();
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AccountsPlugin
 * JD-Core Version:    0.7.0.1
 */