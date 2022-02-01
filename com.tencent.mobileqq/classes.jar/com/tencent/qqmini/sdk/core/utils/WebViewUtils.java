package com.tencent.qqmini.sdk.core.utils;

import android.os.Build.VERSION;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class WebViewUtils
{
  private static volatile boolean a = false;
  
  public static void a()
  {
    if (AppLoaderFactory.g().isMainProcess()) {
      return;
    }
    if (!a)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        try
        {
          WebView.setDataDirectorySuffix(AppLoaderFactory.g().getProcessName());
          a = true;
          QMLog.i("WebViewUtils", "setWebViewMultiProcess: done");
          return;
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("WebViewUtils", "setWebViewMultiProcess: error --> ", localThrowable);
          return;
        }
      }
      a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.WebViewUtils
 * JD-Core Version:    0.7.0.1
 */