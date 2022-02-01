package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy.Proxy;
import com.tencent.mobileqq.utils.ContactUtils;

final class IMCoreProxyRegister$4
  implements ContactUtilsProxy.Proxy
{
  public String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      return ContactUtils.a((QQAppInterface)paramBaseQQAppInterface, paramString, true);
    }
    return paramString;
  }
  
  public String b(BaseQQAppInterface paramBaseQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      return ContactUtils.a((QQAppInterface)paramBaseQQAppInterface, paramString, true);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.4
 * JD-Core Version:    0.7.0.1
 */