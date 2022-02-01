package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;

class CustomizeStrategyFactory$VoiceResStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  IPreloadService a = null;
  IQWalletConfigService b = null;
  
  CustomizeStrategyFactory$VoiceResStrategy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      this.a = ((IPreloadService)paramBaseQQAppInterface.getRuntimeService(IPreloadService.class, ""));
      this.b = ((IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, ""));
    }
  }
  
  public void a() {}
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.VoiceResStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo, InterfaceRedPkgElem paramInterfaceRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramInterfaceRedPkgElem instanceof VoiceResElem)))
    {
      paramInterfaceRedPkgElem = (VoiceResElem)paramInterfaceRedPkgElem;
      paramRedPacketInfo.icon = paramInterfaceRedPkgElem.b;
      paramRedPacketInfo.resPath = paramInterfaceRedPkgElem.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.VoiceResStrategy
 * JD-Core Version:    0.7.0.1
 */