package com.tencent.qqmini.proxyimpl;

import anzj;
import arfd;
import bkyg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class MiniAppProxyImpl$5$1
  implements Runnable
{
  public MiniAppProxyImpl$5$1(bkyg parambkyg) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.topType = 0;
    }
    if (arfd.c())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131700263) + arfd.a() + anzj.a(2131700262), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.5.1
 * JD-Core Version:    0.7.0.1
 */