package com.tencent.mobileqq.webview.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import mqq.app.MobileQQ;

public class ProxyConfig
{
  public static String a;
  private static boolean b = false;
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("x5_proxy_setting", 4);
    a = localSharedPreferences.getString("http_proxy_address", "");
    b = localSharedPreferences.contains("need_set_proxy");
    localSharedPreferences.edit().remove("need_set_proxy").apply();
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    if (!b) {
      return;
    }
    if ((paramWebView != null) && (paramWebView.getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("address", paramString);
      paramWebView.getX5WebViewExtension().invokeMiscMethod("setHttpSystemProxy", localBundle);
    }
    b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.ProxyConfig
 * JD-Core Version:    0.7.0.1
 */