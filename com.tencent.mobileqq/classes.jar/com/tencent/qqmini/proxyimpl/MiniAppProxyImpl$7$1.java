package com.tencent.qqmini.proxyimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class MiniAppProxyImpl$7$1
  implements Runnable
{
  MiniAppProxyImpl$7$1(MiniAppProxyImpl.7 param7) {}
  
  public void run()
  {
    if (this.a.a.topType == 1)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131719146, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2131719147, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.7.1
 * JD-Core Version:    0.7.0.1
 */