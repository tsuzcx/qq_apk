package com.tencent.mobileqq.qwallet.red.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.qphone.base.util.QLog;

class QWalletRedServiceImpl$1
  implements Runnable
{
  QWalletRedServiceImpl$1(QWalletRedServiceImpl paramQWalletRedServiceImpl) {}
  
  public void run()
  {
    Object localObject = (IQWalletConfigService)QWalletRedServiceImpl.access$000(this.this$0).getRuntimeService(IQWalletConfigService.class, "");
    if (localObject != null)
    {
      ((IQWalletConfigService)localObject).registerUpdateListener("redPoint", this.this$0);
      localObject = ((IQWalletConfigService)localObject).getConfigInfo("redPoint");
      QWalletRedServiceImpl.access$100(this.this$0).parseConfig((ConfigInfo)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("synDataFromMoggy");
      ((StringBuilder)localObject).append(QWalletRedServiceImpl.access$100(this.this$0));
      QLog.d("QWalletRedService", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.impl.QWalletRedServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */