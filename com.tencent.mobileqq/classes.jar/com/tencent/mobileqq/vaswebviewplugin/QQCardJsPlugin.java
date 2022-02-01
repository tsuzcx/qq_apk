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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("QQCardJsPlugin", 2, "handleJsRequest pkgName=" + paramString2 + " method=" + paramString3);
        }
        if ("qqcard".equals(paramString2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QQCardJsPlugin", 2, "can not handle objectname:" + paramString2);
      return false;
    } while (!"openQQCard".equals(paramString3));
    return openQQCard();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQCardJsPlugin
 * JD-Core Version:    0.7.0.1
 */