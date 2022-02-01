package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
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
    Object localObject = (IQWalletConfigService)this.this$0.mApp.getRuntimeService(IQWalletConfigService.class, "");
    if (localObject != null)
    {
      ((IQWalletConfigService)localObject).registerUpdateListener("preload", this.this$0);
      localObject = ((IQWalletConfigService)localObject).getConfigInfo("preload");
      this.this$0.replaceConfigFromMoggy((ConfigInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */