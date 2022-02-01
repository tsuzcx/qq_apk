package com.tencent.mobileqq.imcore;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.imcore.proxy.business.FriendsProxy.Proxy;

final class IMCoreProxyRegister$21
  implements FriendsProxy.Proxy
{
  public boolean a(String paramString)
  {
    return Friends.isValidUin(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.21
 * JD-Core Version:    0.7.0.1
 */