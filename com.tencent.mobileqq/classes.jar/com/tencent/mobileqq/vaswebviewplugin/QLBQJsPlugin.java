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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!"qlbq".equals(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QLBQJsPlugin", 2, "handleJsRequest qlbqjs, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    try
    {
      if ("openGroupEmotion".equals(paramString3)) {
        PublicFragmentActivity.a(this.mRuntime.a(), EmoticonGroupStoreFragment.class);
      }
      return true;
    }
    catch (Throwable paramJsBridgeListener)
    {
      for (;;)
      {
        QLog.e("QLBQJsPlugin", 2, "handleJsRequest exception url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3 + ", msg=" + paramJsBridgeListener.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QLBQJsPlugin
 * JD-Core Version:    0.7.0.1
 */