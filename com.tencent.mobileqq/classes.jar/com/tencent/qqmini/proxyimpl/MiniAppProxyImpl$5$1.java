package com.tencent.qqmini.proxyimpl;

import bjxe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class MiniAppProxyImpl$5$1
  implements Runnable
{
  public MiniAppProxyImpl$5$1(bjxe parambjxe) {}
  
  public void run()
  {
    if (this.a.a.topType == 1)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131717863, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2131717864, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.5.1
 * JD-Core Version:    0.7.0.1
 */