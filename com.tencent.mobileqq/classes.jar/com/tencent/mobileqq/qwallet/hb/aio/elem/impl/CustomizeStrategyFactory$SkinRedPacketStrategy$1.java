package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$SkinRedPacketStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$SkinRedPacketStrategy$1(CustomizeStrategyFactory.SkinRedPacketStrategy paramSkinRedPacketStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    if (CustomizeStrategyFactory.a().b()) {
      try
      {
        synchronized (CustomizeStrategyFactory.a)
        {
          CustomizeStrategyFactory.a.wait(5000L);
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("CustomizeStrategyFactory", 2, "SkinRedPacketStrategy");
          }
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletConfigIQWalletConfigService != null))
          {
            CustomizeStrategyFactory.SkinRedPacketStrategy.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService, this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletConfigIQWalletConfigService, this.a);
            return;
          }
          CustomizeStrategyFactory.a().a(this.a);
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.SkinRedPacketStrategy.1
 * JD-Core Version:    0.7.0.1
 */