package com.tencent.mobileqq.qroute;

import com.tencent.mobileqq.qroute.module.IQRoutePluginFactory;
import com.tencent.mobileqq.qroute.remote.IQRemoteProxy;
import com.tencent.mobileqq.qroute.route.ILogger;
import com.tencent.mobileqq.qroute.utils.IProcessCheck;

public class QRouteConfig
{
  private boolean mForceCheck;
  private ILogger mLogger;
  private IQRoutePluginFactory mPluginFactory;
  private IProcessCheck mProcessCheck;
  private String mProcessName;
  private IQRemoteProxy mRemoteProxy;
  
  QRouteConfig(String paramString, boolean paramBoolean, IProcessCheck paramIProcessCheck, ILogger paramILogger, IQRemoteProxy paramIQRemoteProxy, IQRoutePluginFactory paramIQRoutePluginFactory)
  {
    this.mProcessName = paramString;
    this.mForceCheck = paramBoolean;
    this.mProcessCheck = paramIProcessCheck;
    this.mLogger = paramILogger;
    this.mRemoteProxy = paramIQRemoteProxy;
    this.mPluginFactory = paramIQRoutePluginFactory;
  }
  
  public ILogger getLogger()
  {
    return this.mLogger;
  }
  
  public IQRoutePluginFactory getPluginFactory()
  {
    return this.mPluginFactory;
  }
  
  public IProcessCheck getProcessCheck()
  {
    return this.mProcessCheck;
  }
  
  public String getProcessName()
  {
    return this.mProcessName;
  }
  
  public IQRemoteProxy getRemoteProxy()
  {
    return this.mRemoteProxy;
  }
  
  public boolean isForceCheck()
  {
    return this.mForceCheck;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.QRouteConfig
 * JD-Core Version:    0.7.0.1
 */