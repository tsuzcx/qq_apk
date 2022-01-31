package com.tencent.qqmini.proxyimpl;

import ajya;
import amtb;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

class MiniAppProxyImpl$3$1
  implements Runnable
{
  MiniAppProxyImpl$3$1(MiniAppProxyImpl.3 param3) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo != null) {
      this.this$1.val$miniAppInfo.topType = 0;
    }
    if (amtb.g())
    {
      bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131701351) + amtb.c() + ajya.a(2131701350), 0).a();
      return;
    }
    bcql.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.3.1
 * JD-Core Version:    0.7.0.1
 */