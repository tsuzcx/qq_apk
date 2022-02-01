package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigApi.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class PreloadServiceImpl$1
  implements Runnable
{
  PreloadServiceImpl$1(PreloadServiceImpl paramPreloadServiceImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "synDataFromMoggy");
    }
    Object localObject = (QWalletConfigManager)this.this$0.mApp.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localObject != null)
    {
      ((QWalletConfigManager)localObject).c("preload", this.this$0);
      localObject = ((QWalletConfigManager)localObject).a("preload");
      this.this$0.replaceConfigFromMoggy((IQWalletConfigApi.ConfigInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */