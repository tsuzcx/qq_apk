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
      QQToast.makeText(BaseApplicationImpl.getApplication(), 2131916397, 0).show();
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getApplication(), 2131916398, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.7.1
 * JD-Core Version:    0.7.0.1
 */