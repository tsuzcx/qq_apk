package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.imcore.proxy.troop.TroopAssistantManagerProxy.Proxy;
import com.tencent.mobileqq.managers.TroopAssistantManager;

final class IMCoreProxyRegister$9
  implements TroopAssistantManagerProxy.Proxy
{
  public int a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      return TroopAssistantManager.a().a(null, (QQAppInterface)paramBaseQQAppInterface);
    }
    return 0;
  }
  
  public TroopAssistantData b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      return TroopAssistantManager.a().d((QQAppInterface)paramBaseQQAppInterface);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.9
 * JD-Core Version:    0.7.0.1
 */