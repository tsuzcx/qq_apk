package com.tencent.qqmini.proxyimpl;

import amtj;
import apyt;
import bjed;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class MiniAppProxyImpl$5$1
  implements Runnable
{
  public MiniAppProxyImpl$5$1(bjed parambjed) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.topType = 0;
    }
    if (apyt.c())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), amtj.a(2131700498) + apyt.a() + amtj.a(2131700497), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.5.1
 * JD-Core Version:    0.7.0.1
 */