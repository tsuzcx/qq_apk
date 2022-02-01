package com.tencent.mobileqq.flashshow.api.hybird;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class FSJsPlugin
  extends WebViewPlugin
{
  public static final String PLUGIN_NAMESPACE = "qflash";
  private static final String TAG = "FSJSPlugin";
  
  public FSJsPlugin()
  {
    this.mPluginNameSpace = "qflash";
  }
  
  private boolean checkArgsValid(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 1)) {
      return true;
    }
    QLog.e("FSJSPlugin", 2, "args is null");
    return false;
  }
  
  private void handleUpdateNativeUserFollowState(String paramString)
  {
    Object localObject = new FSJsPlugin.SafeJsonObject(this, paramString);
    paramString = ((FSJsPlugin.SafeJsonObject)localObject).optString("uin");
    int i = ((FSJsPlugin.SafeJsonObject)localObject).optInt("followState");
    String str = ((FSJsPlugin.SafeJsonObject)localObject).optString("nick");
    localObject = ((FSJsPlugin.SafeJsonObject)localObject).optString("avatar");
    if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof FSHybirdFragment))) {
      ((FSHybirdFragment)this.mRuntime.f()).a(paramString, i, str, (String)localObject);
    }
  }
  
  private void parseJsBridge(String paramString, String[] paramArrayOfString)
  {
    if ((TextUtils.equals(paramString, "updateUserFollowState")) && (checkArgsValid(paramArrayOfString))) {
      handleUpdateNativeUserFollowState(paramArrayOfString[0]);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qflash".equals(paramString2))
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest:");
      paramJsBridgeListener.append(paramString1);
      QLog.i("FSJSPlugin", 2, paramJsBridgeListener.toString());
      try
      {
        parseJsBridge(paramString3, paramVarArgs);
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.d("FSJSPlugin", 2, paramJsBridgeListener, new Object[0]);
      }
      return true;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSJsPlugin
 * JD-Core Version:    0.7.0.1
 */