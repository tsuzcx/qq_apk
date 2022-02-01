package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$SkinRedPacketStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$SkinRedPacketStrategy$1(CustomizeStrategyFactory.SkinRedPacketStrategy paramSkinRedPacketStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    if (CustomizeStrategyFactory.d().e()) {
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
          if ((this.this$0.a != null) && (this.this$0.b != null))
          {
            CustomizeStrategyFactory.SkinRedPacketStrategy.a(this.this$0, this.this$0.a, this.this$0.b, this.a);
            return;
          }
          CustomizeStrategyFactory.d().a(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.SkinRedPacketStrategy.1
 * JD-Core Version:    0.7.0.1
 */