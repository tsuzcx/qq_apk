package com.tencent.qqmini.proxyimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.widget.QQToast;

class MiniAppProxyImpl$6$1
  implements Runnable
{
  MiniAppProxyImpl$6$1(MiniAppProxyImpl.6 param6) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.topType = 0;
    }
    if (MiniAppConfProcessor.e())
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131899586));
      localStringBuilder.append(MiniAppConfProcessor.f());
      localStringBuilder.append(HardCodeUtil.a(2131899585));
      QQToast.makeText(localBaseApplicationImpl, localStringBuilder.toString(), 0).show();
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.6.1
 * JD-Core Version:    0.7.0.1
 */