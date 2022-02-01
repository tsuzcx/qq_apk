package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;

class CustomizeStrategyFactory$ThemeCustomizeStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private BaseQQAppInterface a;
  private IPreloadService b = null;
  
  public CustomizeStrategyFactory$ThemeCustomizeStrategy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
    paramBaseQQAppInterface = this.a;
    if (paramBaseQQAppInterface != null) {
      this.b = ((IPreloadService)paramBaseQQAppInterface.getRuntimeService(IPreloadService.class, ""));
    }
  }
  
  public void a() {}
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    ThreadManager.post(new CustomizeStrategyFactory.ThemeCustomizeStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo, InterfaceRedPkgElem paramInterfaceRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramInterfaceRedPkgElem instanceof ThemeRedPkgElem))) {
      paramRedPacketInfo.background = ((ThemeRedPkgElem)paramInterfaceRedPkgElem).b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.ThemeCustomizeStrategy
 * JD-Core Version:    0.7.0.1
 */