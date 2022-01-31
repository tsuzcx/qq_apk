package com.tencent.mobileqq.qcall;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class RecentCallPluginInfo
  extends WebViewPlugin
{
  public RecentCallPluginInfo()
  {
    this.mPluginNameSpace = "RecentCall";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentCallPluginInfo", 2, "RecentCallPluginInfo  handleJsRequest url : " + paramString1 + ",pkgName: " + paramString2 + ",method: " + paramString3);
    }
    if (TextUtils.isEmpty(paramString3)) {
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    if ("recent_selectmember".equals(paramString3))
    {
      paramJsBridgeListener = this.mRuntime.a();
      paramString1 = new Intent(paramJsBridgeListener, QCallStartBrigeActivity.class);
      paramString1.putExtra("param_from_type", 1);
      paramJsBridgeListener.startActivity(paramString1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.RecentCallPluginInfo
 * JD-Core Version:    0.7.0.1
 */