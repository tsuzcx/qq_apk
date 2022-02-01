package com.tencent.mobileqq.gamecenter.util;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.IdleTask;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;

final class QQGameHelper$1
  extends SwiftBrowserIdleTaskHelper.IdleTask
{
  QQGameHelper$1(int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        QLog.i("QQGameHelper", 1, "SwiftBrowserIdleTask--> do preloadsw ");
        if (!QQGameHelper.a()) {
          return 0;
        }
        QQGameHelper.a(NetConnInfoCenter.getServerTimeMillis());
        QQGamePubWebView localQQGamePubWebView = new QQGamePubWebView(BaseApplicationImpl.sApplication);
        WebSettings localWebSettings = localQQGamePubWebView.getSettings();
        String str = localWebSettings.getUserAgentString();
        if (localQQGamePubWebView.getX5WebViewExtension() != null)
        {
          bool = true;
          localWebSettings.setUserAgentString(SwiftWebViewUtils.a(str, "", bool));
          localWebSettings.setJavaScriptEnabled(true);
          localQQGamePubWebView.loadUrl(QQGameConfigUtil.c());
          QLog.i("QQGameHelper", 1, "SwiftBrowserIdleTask--> loadUrl " + QQGameConfigUtil.c());
          localQQGamePubWebView.setWebChromeClient(new QQGameHelper.1.1(this));
          ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameHelper.1.2(this, localQQGamePubWebView), 15000L);
          return 0;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQGameHelper", 1, QLog.getStackTraceString(localThrowable));
        return 0;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameHelper.1
 * JD-Core Version:    0.7.0.1
 */