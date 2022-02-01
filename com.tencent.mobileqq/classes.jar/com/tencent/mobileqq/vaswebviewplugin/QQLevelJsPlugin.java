package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQLevelJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "levelicon";
  private static final String TAG = "QQLevelJsPlugin";
  
  public QQLevelJsPlugin()
  {
    this.mPluginNameSpace = "levelicon";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQLevelJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    boolean bool1;
    if ((paramString1 == null) || (!"levelicon".equals(paramString2)) || (paramString3 == null)) {
      bool1 = false;
    }
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
            QLog.d("QQLevelJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
          }
          paramString1 = paramJsBridgeListener.optString("callback");
          bool1 = bool2;
          if ("download".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQLevelJsPlugin", 2, "edit " + paramJsBridgeListener.toString());
            }
            int i = paramJsBridgeListener.optInt("id");
            QuickUpdateIPCModule.a(41L, "qqVipLevel." + i, new QQLevelJsPlugin.1(this, paramString1));
            return true;
          }
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QQLevelJsPlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin
 * JD-Core Version:    0.7.0.1
 */