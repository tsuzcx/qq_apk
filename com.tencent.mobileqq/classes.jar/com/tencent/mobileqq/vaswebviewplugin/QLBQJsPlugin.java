package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class QLBQJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String NAME_SPACE = "qlbq";
  private static final String TAG = "QLBQJsPlugin";
  
  public QLBQJsPlugin()
  {
    this.mPluginNameSpace = "qlbq";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString1)) && ("qlbq".equals(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest qlbqjs, url=");
        paramJsBridgeListener.append(paramString1);
        paramJsBridgeListener.append(", pkgName=");
        paramJsBridgeListener.append(paramString2);
        paramJsBridgeListener.append(", methodName=");
        paramJsBridgeListener.append(paramString3);
        QLog.d("QLBQJsPlugin", 2, paramJsBridgeListener.toString());
      }
      try
      {
        if ("openGroupEmotion".equals(paramString3)) {
          PublicFragmentActivity.a(this.mRuntime.d(), EmoticonGroupStoreFragment.class);
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("handleJsRequest exception url=");
        paramVarArgs.append(paramString1);
        paramVarArgs.append(", pkgName=");
        paramVarArgs.append(paramString2);
        paramVarArgs.append(", methodName=");
        paramVarArgs.append(paramString3);
        paramVarArgs.append(", msg=");
        paramVarArgs.append(paramJsBridgeListener.getMessage());
        QLog.e("QLBQJsPlugin", 2, paramVarArgs.toString());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QLBQJsPlugin
 * JD-Core Version:    0.7.0.1
 */