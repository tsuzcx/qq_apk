package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentDataListManagerInjector;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.business.RecentDataListManagerProxy.Proxy;
import java.util.List;

final class IMCoreProxyRegister$18
  implements RecentDataListManagerProxy.Proxy
{
  public void a(BaseQQAppInterface paramBaseQQAppInterface, List<RecentUser> paramList)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return;
    }
    RecentDataListManagerInjector.a((QQAppInterface)paramBaseQQAppInterface, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.18
 * JD-Core Version:    0.7.0.1
 */