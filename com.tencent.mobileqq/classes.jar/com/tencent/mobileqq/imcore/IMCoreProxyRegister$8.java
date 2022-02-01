package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.proxy.troop.TroopManagerProxy.Proxy;

final class IMCoreProxyRegister$8
  implements TroopManagerProxy.Proxy
{
  public TroopInfo a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = (TroopManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.a(paramString, true);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.8
 * JD-Core Version:    0.7.0.1
 */