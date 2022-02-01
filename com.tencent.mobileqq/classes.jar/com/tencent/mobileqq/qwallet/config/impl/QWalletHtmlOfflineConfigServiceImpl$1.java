package com.tencent.mobileqq.qwallet.config.impl;

import com.tencent.biz.common.offline.HtmlOffline;
import mqq.app.MobileQQ;

class QWalletHtmlOfflineConfigServiceImpl$1
  implements Runnable
{
  QWalletHtmlOfflineConfigServiceImpl$1(QWalletHtmlOfflineConfigServiceImpl paramQWalletHtmlOfflineConfigServiceImpl) {}
  
  public void run()
  {
    HtmlOffline.b("4575", MobileQQ.sMobileQQ.waitAppRuntime(null), true, new QWalletHtmlOfflineConfigServiceImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletHtmlOfflineConfigServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */