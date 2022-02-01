package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.msg.ConversationFacadeProxy.Proxy;

final class IMCoreProxyRegister$3
  implements ConversationFacadeProxy.Proxy
{
  public int a(Message paramMessage, int paramInt, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (((paramBaseQQAppInterface instanceof QQAppInterface)) && ((paramMessage instanceof Message)))
    {
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getConversationFacade();
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.a(paramMessage.frienduin, paramInt);
      }
    }
    return 0;
  }
  
  public int a(Message paramMessage, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (((paramBaseQQAppInterface instanceof QQAppInterface)) && ((paramMessage instanceof Message)))
    {
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getConversationFacade();
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.a(paramMessage.frienduin, paramMessage.istroop);
      }
    }
    return 0;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)paramBaseQQAppInterface).getConversationFacade().b(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.3
 * JD-Core Version:    0.7.0.1
 */