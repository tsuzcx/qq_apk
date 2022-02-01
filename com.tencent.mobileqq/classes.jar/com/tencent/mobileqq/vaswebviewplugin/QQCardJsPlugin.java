package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;

public class QQCardJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "qqcard";
  private static final String TAG = "QQCardJsPlugin";
  
  public QQCardJsPlugin()
  {
    this.mPluginNameSpace = "qqcard";
  }
  
  private boolean openQQCard()
  {
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest pkgName=");
        paramJsBridgeListener.append(paramString2);
        paramJsBridgeListener.append(" method=");
        paramJsBridgeListener.append(paramString3);
        QLog.d("QQCardJsPlugin", 2, paramJsBridgeListener.toString());
      }
      if (!"qqcard".equals(paramString2))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("can not handle objectname:");
          paramJsBridgeListener.append(paramString2);
          QLog.i("QQCardJsPlugin", 2, paramJsBridgeListener.toString());
        }
        return false;
      }
      if ("openQQCard".equals(paramString3)) {
        return openQQCard();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQCardJsPlugin
 * JD-Core Version:    0.7.0.1
 */