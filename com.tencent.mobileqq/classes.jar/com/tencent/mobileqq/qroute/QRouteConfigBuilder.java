package com.tencent.mobileqq.qroute;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.module.IQRoutePluginFactory;
import com.tencent.mobileqq.qroute.remote.IQRemoteProxy;
import com.tencent.mobileqq.qroute.route.ILogger;
import com.tencent.mobileqq.qroute.utils.IProcessCheck;

public class QRouteConfigBuilder
{
  private static final ILogger DEFAULT_LOGGER = new QRouteConfigBuilder.1();
  private boolean mForceCheck = false;
  private ILogger mLogger = DEFAULT_LOGGER;
  private IQRoutePluginFactory mPluginFactory;
  private IProcessCheck mProcessCheck = null;
  private String mProcessName = "";
  private IQRemoteProxy mRemoteProxy = null;
  
  public QRouteConfigBuilder(String paramString)
  {
    this.mProcessName = paramString;
  }
  
  public QRouteConfig create()
  {
    return new QRouteConfig(this.mProcessName, this.mForceCheck, this.mProcessCheck, this.mLogger, this.mRemoteProxy, this.mPluginFactory);
  }
  
  public QRouteConfigBuilder setForceCheck(boolean paramBoolean)
  {
    this.mForceCheck = paramBoolean;
    return this;
  }
  
  public QRouteConfigBuilder setLogger(@NonNull ILogger paramILogger)
  {
    this.mLogger = paramILogger;
    return this;
  }
  
  public QRouteConfigBuilder setPluginFactory(IQRoutePluginFactory paramIQRoutePluginFactory)
  {
    this.mPluginFactory = paramIQRoutePluginFactory;
    return this;
  }
  
  public QRouteConfigBuilder setProcessCheck(@NonNull IProcessCheck paramIProcessCheck)
  {
    this.mProcessCheck = paramIProcessCheck;
    return this;
  }
  
  public QRouteConfigBuilder setProcessName(@NonNull String paramString)
  {
    this.mProcessName = paramString;
    return this;
  }
  
  public QRouteConfigBuilder setRemoteProxy(@NonNull IQRemoteProxy paramIQRemoteProxy)
  {
    this.mRemoteProxy = paramIQRemoteProxy;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.QRouteConfigBuilder
 * JD-Core Version:    0.7.0.1
 */