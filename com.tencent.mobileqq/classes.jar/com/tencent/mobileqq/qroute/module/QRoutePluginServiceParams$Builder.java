package com.tencent.mobileqq.qroute.module;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

public final class QRoutePluginServiceParams$Builder
{
  public Context context;
  public Intent intent;
  public boolean isPreload = false;
  public IQRoutePlugin.OnOpenResultListener openResultListener;
  public String serviceName;
  public Class serviceProxy;
  public Object session;
  public String subModule = "";
  
  public QRoutePluginServiceParams$Builder(@NonNull Context paramContext)
  {
    this.context = paramContext;
  }
  
  public QRoutePluginServiceParams build()
  {
    QRoutePluginServiceParams localQRoutePluginServiceParams = new QRoutePluginServiceParams(null);
    localQRoutePluginServiceParams.serviceProxy = this.serviceProxy;
    localQRoutePluginServiceParams.intent = this.intent;
    localQRoutePluginServiceParams.context = this.context;
    localQRoutePluginServiceParams.isPreload = this.isPreload;
    localQRoutePluginServiceParams.session = this.session;
    localQRoutePluginServiceParams.subModule = this.subModule;
    localQRoutePluginServiceParams.serviceName = this.serviceName;
    localQRoutePluginServiceParams.openResultListener = this.openResultListener;
    return localQRoutePluginServiceParams;
  }
  
  public Builder setContext(Context paramContext)
  {
    this.context = paramContext;
    return this;
  }
  
  public Builder setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
    return this;
  }
  
  public Builder setIsPreload(boolean paramBoolean)
  {
    this.isPreload = paramBoolean;
    return this;
  }
  
  public Builder setOpenResultListener(IQRoutePlugin.OnOpenResultListener paramOnOpenResultListener)
  {
    this.openResultListener = paramOnOpenResultListener;
    return this;
  }
  
  public Builder setServiceName(String paramString)
  {
    this.serviceName = paramString;
    return this;
  }
  
  public Builder setServiceProxy(Class paramClass)
  {
    this.serviceProxy = paramClass;
    return this;
  }
  
  public Builder setSession(Object paramObject)
  {
    this.session = paramObject;
    return this;
  }
  
  public Builder setSubModule(String paramString)
  {
    this.subModule = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.QRoutePluginServiceParams.Builder
 * JD-Core Version:    0.7.0.1
 */