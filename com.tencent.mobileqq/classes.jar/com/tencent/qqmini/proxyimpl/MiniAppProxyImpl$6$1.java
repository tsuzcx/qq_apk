package com.tencent.qqmini.proxyimpl;

import bjee;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class MiniAppProxyImpl$6$1
  implements Runnable
{
  public MiniAppProxyImpl$6$1(bjee parambjee) {}
  
  public void run()
  {
    if (this.a.a.topType == 1)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131718236, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2131718237, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.6.1
 * JD-Core Version:    0.7.0.1
 */