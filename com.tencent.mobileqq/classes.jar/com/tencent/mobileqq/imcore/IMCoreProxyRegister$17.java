package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.ConversationDataFactoryInjector;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.business.ConversationDataFactoryProxy.Proxy;

final class IMCoreProxyRegister$17
  implements ConversationDataFactoryProxy.Proxy
{
  public int a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return paramInt;
    }
    return ConversationDataFactoryInjector.a((QQAppInterface)paramBaseQQAppInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.17
 * JD-Core Version:    0.7.0.1
 */