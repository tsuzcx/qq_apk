package com.tencent.mobileqq.imcore.proxy.business;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import java.util.List;

public class RecentDataListManagerProxy
{
  private static RecentDataListManagerProxy.Proxy a;
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, List<RecentUser> paramList)
  {
    RecentDataListManagerProxy.Proxy localProxy = a;
    if (localProxy == null) {
      return;
    }
    localProxy.a(paramBaseQQAppInterface, paramList);
  }
  
  public static void a(RecentDataListManagerProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.RecentDataListManagerProxy
 * JD-Core Version:    0.7.0.1
 */