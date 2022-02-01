package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

class CustomizeStrategyFactory$2
  implements Runnable
{
  CustomizeStrategyFactory$2(CustomizeStrategyFactory paramCustomizeStrategyFactory) {}
  
  public void run()
  {
    synchronized (CustomizeStrategyFactory.a(this.this$0))
    {
      if (!CustomizeStrategyFactory.b(this.this$0))
      {
        BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
        if (localBaseQQAppInterface != null) {
          this.this$0.c = ((IQWalletConfigService)localBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, ""));
        }
        if (this.this$0.c != null) {
          this.this$0.c.registerUpdateListener("redPack", this.this$0);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.2
 * JD-Core Version:    0.7.0.1
 */