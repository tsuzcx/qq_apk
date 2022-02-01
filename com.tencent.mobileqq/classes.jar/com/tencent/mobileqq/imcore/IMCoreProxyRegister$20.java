package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy.Proxy;

final class IMCoreProxyRegister$20
  implements TempMsgBoxManagerProxy.Proxy
{
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    return ((TempMsgBoxManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.20
 * JD-Core Version:    0.7.0.1
 */