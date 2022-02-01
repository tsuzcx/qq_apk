package com.tencent.mobileqq.qroute.module;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

public final class QRoutePluginReceiverParams$Builder
{
  public Context context;
  public Intent intent;
  public boolean isPreload = false;
  public String receiverName;
  public Class receiverProxy;
  public Object session;
  public String subModule = "";
  
  public QRoutePluginReceiverParams$Builder(@NonNull Context paramContext)
  {
    this.context = paramContext;
  }
  
  public QRoutePluginReceiverParams build()
  {
    QRoutePluginReceiverParams localQRoutePluginReceiverParams = new QRoutePluginReceiverParams(null);
    localQRoutePluginReceiverParams.isPreload = this.isPreload;
    localQRoutePluginReceiverParams.context = this.context;
    localQRoutePluginReceiverParams.session = this.session;
    localQRoutePluginReceiverParams.intent = this.intent;
    localQRoutePluginReceiverParams.subModule = this.subModule;
    localQRoutePluginReceiverParams.receiverName = this.receiverName;
    localQRoutePluginReceiverParams.receiverProxy = this.receiverProxy;
    return localQRoutePluginReceiverParams;
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
  
  public Builder setReceiverName(String paramString)
  {
    this.receiverName = paramString;
    return this;
  }
  
  public Builder setReceiverProxy(Class paramClass)
  {
    this.receiverProxy = paramClass;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.QRoutePluginReceiverParams.Builder
 * JD-Core Version:    0.7.0.1
 */