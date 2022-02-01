package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.qwallet.temp.IIndividualRedPacket;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$VIPHBStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$VIPHBStrategy$1(CustomizeStrategyFactory.VIPHBStrategy paramVIPHBStrategy, IIndividualRedPacket paramIIndividualRedPacket, RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      this.a.dealRedPacketToShow(this.b);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CustomizeStrategyFactory", 1, "dealRedPacketToShow failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.VIPHBStrategy.1
 * JD-Core Version:    0.7.0.1
 */