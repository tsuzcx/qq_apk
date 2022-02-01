package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfoStub;
import com.tencent.mobileqq.imcore.proxy.business.HotChatManagerProxy.Proxy;

final class IMCoreProxyRegister$7
  implements HotChatManagerProxy.Proxy
{
  public HotChatInfoStub a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = (HotChatManager)paramBaseQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.a(paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.7
 * JD-Core Version:    0.7.0.1
 */