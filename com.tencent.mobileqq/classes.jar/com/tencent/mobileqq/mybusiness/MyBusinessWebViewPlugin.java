package com.tencent.mobileqq.mybusiness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

public class MyBusinessWebViewPlugin
  extends WebViewPlugin
{
  public MyBusinessWebViewPlugin()
  {
    this.mPluginNameSpace = "mybusiness";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("mybusiness".equals(paramString2)) && ("notifyContact".equals(paramString3)))
    {
      paramJsBridgeListener = new Bundle();
      paramJsBridgeListener.putString("cmd", "businessNotifyContact");
      if (!WebIPCOperator.a().a()) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), "正在初始化服务，请稍候尝试", 0).show();
      }
      for (;;)
      {
        return true;
        WebIPCOperator.a().a(paramJsBridgeListener);
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (11 == paramByte)
    {
      if (paramInt != -1) {
        break label22;
      }
      this.mRuntime.a().finish();
    }
    label22:
    while (paramInt != 0) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.mybusiness.MyBusinessWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */