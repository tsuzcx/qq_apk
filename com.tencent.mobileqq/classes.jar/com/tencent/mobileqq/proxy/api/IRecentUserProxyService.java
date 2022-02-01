package com.tencent.mobileqq.proxy.api;

import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IRecentUserProxyService
  extends IRuntimeService
{
  public abstract RecentUserProxy getRecentUserCache();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.proxy.api.IRecentUserProxyService
 * JD-Core Version:    0.7.0.1
 */