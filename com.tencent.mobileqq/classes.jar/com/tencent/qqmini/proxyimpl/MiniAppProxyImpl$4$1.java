package com.tencent.qqmini.proxyimpl;

import anni;
import aqpv;
import bjxd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class MiniAppProxyImpl$4$1
  implements Runnable
{
  public MiniAppProxyImpl$4$1(bjxd parambjxd) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.topType = 0;
    }
    if (aqpv.c())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), anni.a(2131700156) + aqpv.a() + anni.a(2131700155), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.4.1
 * JD-Core Version:    0.7.0.1
 */