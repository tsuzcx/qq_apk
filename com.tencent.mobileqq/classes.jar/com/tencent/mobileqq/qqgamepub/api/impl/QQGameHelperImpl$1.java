package com.tencent.mobileqq.qqgamepub.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.IdleTask;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import mqq.app.MobileQQ;

class QQGameHelperImpl$1
  extends SwiftBrowserIdleTaskHelper.IdleTask
{
  QQGameHelperImpl$1(QQGameHelperImpl paramQQGameHelperImpl, int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        QLog.i("QQGamePub_QQGameHelper", 1, "SwiftBrowserIdleTask--> do preloadsw ");
        if (!this.a.canLoad()) {
          return 0;
        }
        this.a.savePreloadTime(NetConnInfoCenter.getServerTimeMillis());
        QQGamePubWebView localQQGamePubWebView = new QQGamePubWebView(MobileQQ.sMobileQQ);
        Object localObject = localQQGamePubWebView.getSettings();
        String str = ((WebSettings)localObject).getUserAgentString();
        if (localQQGamePubWebView.getX5WebViewExtension() != null)
        {
          bool = true;
          ((WebSettings)localObject).setUserAgentString(SwiftWebViewUtils.a(str, "", bool));
          ((WebSettings)localObject).setJavaScriptEnabled(true);
          localQQGamePubWebView.loadUrl(((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getPreloadUrl());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("SwiftBrowserIdleTask--> loadUrl ");
          ((StringBuilder)localObject).append(((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getPreloadUrl());
          QLog.i("QQGamePub_QQGameHelper", 1, ((StringBuilder)localObject).toString());
          localQQGamePubWebView.setWebChromeClient(new QQGameHelperImpl.1.1(this));
          ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameHelperImpl.1.2(this, localQQGamePubWebView), 15000L);
          return 0;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQGamePub_QQGameHelper", 1, QLog.getStackTraceString(localThrowable));
        return 0;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */