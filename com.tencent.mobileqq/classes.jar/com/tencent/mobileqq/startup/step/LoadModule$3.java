package com.tencent.mobileqq.startup.step;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.imcore.proxy.msg.MsgProxyUtilsProxy.Proxy;

final class LoadModule$3
  implements MsgProxyUtilsProxy.Proxy
{
  public boolean isSaveConversation(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return UinTypeUtil.a(paramString1, paramString2, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadModule.3
 * JD-Core Version:    0.7.0.1
 */