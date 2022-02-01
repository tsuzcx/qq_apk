package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
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
      QLog.d("QQLevelJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("levelicon".equals(paramString2)) && (paramString3 != null))
    {
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener == null) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("handleJsRequest JSON = ");
          paramString1.append(paramJsBridgeListener.toString());
          QLog.d("QQLevelJsPlugin", 2, paramString1.toString());
        }
        paramString1 = paramJsBridgeListener.optString("callback");
        if ("download".equals(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("edit ");
            paramString2.append(paramJsBridgeListener.toString());
            QLog.i("QQLevelJsPlugin", 2, paramString2.toString());
          }
          int i = paramJsBridgeListener.optInt("id");
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("qqVipLevel.");
          paramJsBridgeListener.append(i);
          QuickUpdateIPCModule.download(41L, paramJsBridgeListener.toString(), new QQLevelJsPlugin.1(this, paramString1));
          return true;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QQLevelJsPlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin
 * JD-Core Version:    0.7.0.1
 */