package com.tencent.mobileqq.proxy.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import mqq.app.AppRuntime;

public class RecentUserProxyServiceImpl
  implements IRecentUserProxyService
{
  RecentUserProxy recentUserProxy = null;
  
  public RecentUserProxy getRecentUserCache()
  {
    return this.recentUserProxy;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (this.recentUserProxy == null) {
      try
      {
        if (this.recentUserProxy == null) {
          this.recentUserProxy = new BaseRecentUserCache((BaseQQAppInterface)paramAppRuntime, paramAppRuntime.getCacheManagerInner().getDBDelayManager());
        }
        return;
      }
      finally {}
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.proxy.api.impl.RecentUserProxyServiceImpl
 * JD-Core Version:    0.7.0.1
 */