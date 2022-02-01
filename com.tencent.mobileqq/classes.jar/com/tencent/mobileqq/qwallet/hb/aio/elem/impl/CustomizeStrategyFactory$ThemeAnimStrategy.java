package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;

class CustomizeStrategyFactory$ThemeAnimStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private IPreloadService jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService = null;
  
  public CustomizeStrategyFactory$ThemeAnimStrategy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    paramBaseQQAppInterface = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
    if (paramBaseQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService = ((IPreloadService)paramBaseQQAppInterface.getRuntimeService(IPreloadService.class, ""));
    }
  }
  
  public void a() {}
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    ThreadManager.post(new CustomizeStrategyFactory.ThemeAnimStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo, InterfaceRedPkgElem paramInterfaceRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramInterfaceRedPkgElem instanceof ThemeRedPkgElem))) {
      paramRedPacketInfo.animInfo = ((ThemeRedPkgElem)paramInterfaceRedPkgElem).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.ThemeAnimStrategy
 * JD-Core Version:    0.7.0.1
 */