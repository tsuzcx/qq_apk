package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.biz.common.offline.HtmlOffline;
import mqq.app.MobileQQ;

class QQGameHelperImpl$2
  implements Runnable
{
  QQGameHelperImpl$2(QQGameHelperImpl paramQQGameHelperImpl) {}
  
  public void run()
  {
    HtmlOffline.b("4235", MobileQQ.sMobileQQ.waitAppRuntime(null), true, new QQGameHelperImpl.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */