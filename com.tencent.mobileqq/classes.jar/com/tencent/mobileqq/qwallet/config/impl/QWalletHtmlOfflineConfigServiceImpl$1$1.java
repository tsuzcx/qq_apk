package com.tencent.mobileqq.qwallet.config.impl;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class QWalletHtmlOfflineConfigServiceImpl$1$1
  implements AsyncBack
{
  QWalletHtmlOfflineConfigServiceImpl$1$1(QWalletHtmlOfflineConfigServiceImpl.1 param1) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("load finish,bid = 4575code = ");
      paramString.append(paramInt);
      QLog.d("QWalletHtmlOfflineConfigServiceImpl", 2, paramString.toString());
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletHtmlOfflineConfigServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */