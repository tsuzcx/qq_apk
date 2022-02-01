package com.tencent.qapmsdk.impl.instrumentation;

import android.annotation.TargetApi;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.webview.WebViewX5Proxy;

public class QAPMWebChromeClient
{
  private static final int PROGRESS_CONTROL = 15;
  private static final String TAG = "QAPM_Impl_QAPMWebChromeClient";
  private static int injectMax = 0;
  
  public static void initJsMonitor(WebView paramWebView, int paramInt)
  {
    WebViewX5Proxy.getInstance().setCodeTypeIsX5(false);
    if ((AndroidVersion.isKitKat()) && (paramInt >= 15)) {}
    try
    {
      if (!WebViewX5Proxy.getInstance().getWebViewMonitorState()) {
        return;
      }
      Logger.INSTANCE.i(new String[] { "QAPM_Impl_QAPMWebChromeClient", "webview  initJsMonitor gather  begin !!" });
      if (paramWebView.getSettings().getJavaScriptEnabled()) {
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMWebChromeClient", "javascript has enable!" });
      }
      for (;;)
      {
        QAPMJavaScriptBridge.getInstance().initFileJS(paramWebView, paramInt);
        return;
        paramWebView.getSettings().setJavaScriptEnabled(true);
      }
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  @TargetApi(19)
  private static void injectScriptFile(WebView paramWebView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMWebChromeClient
 * JD-Core Version:    0.7.0.1
 */