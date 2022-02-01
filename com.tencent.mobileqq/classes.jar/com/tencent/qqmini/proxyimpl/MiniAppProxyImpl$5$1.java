package com.tencent.qqmini.proxyimpl;

import anvx;
import arbw;
import bkpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class MiniAppProxyImpl$5$1
  implements Runnable
{
  public MiniAppProxyImpl$5$1(bkpl parambkpl) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.topType = 0;
    }
    if (arbw.c())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), anvx.a(2131700849) + arbw.a() + anvx.a(2131700848), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.5.1
 * JD-Core Version:    0.7.0.1
 */