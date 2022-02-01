package com.tencent.mobileqq.qroute.module;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

public final class QRoutePluginActivityParams$Builder
{
  public String activityName;
  public Class activityProxy;
  public int activityRequestCode = -1;
  public Context context;
  public Dialog dialog;
  public Intent intent;
  public IQRoutePlugin.OnOpenResultListener openResultListener;
  public Object session;
  public String subModule = "";
  public int timeoutMills;
  
  public QRoutePluginActivityParams$Builder(@NonNull Context paramContext)
  {
    this.context = paramContext;
  }
  
  public QRoutePluginActivityParams build()
  {
    QRoutePluginActivityParams localQRoutePluginActivityParams = new QRoutePluginActivityParams(null);
    localQRoutePluginActivityParams.activityRequestCode = this.activityRequestCode;
    localQRoutePluginActivityParams.dialog = this.dialog;
    localQRoutePluginActivityParams.intent = this.intent;
    localQRoutePluginActivityParams.activityName = this.activityName;
    localQRoutePluginActivityParams.openResultListener = this.openResultListener;
    localQRoutePluginActivityParams.timeoutMills = this.timeoutMills;
    localQRoutePluginActivityParams.activityProxy = this.activityProxy;
    localQRoutePluginActivityParams.subModule = this.subModule;
    localQRoutePluginActivityParams.context = this.context;
    localQRoutePluginActivityParams.session = this.session;
    return localQRoutePluginActivityParams;
  }
  
  public Builder setActivityName(String paramString)
  {
    this.activityName = paramString;
    return this;
  }
  
  public Builder setActivityProxy(Class paramClass)
  {
    this.activityProxy = paramClass;
    return this;
  }
  
  public Builder setActivityRequestCode(int paramInt)
  {
    this.activityRequestCode = paramInt;
    return this;
  }
  
  public Builder setDialog(Dialog paramDialog)
  {
    this.dialog = paramDialog;
    return this;
  }
  
  public Builder setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
    return this;
  }
  
  public Builder setOpenResultListener(IQRoutePlugin.OnOpenResultListener paramOnOpenResultListener)
  {
    this.openResultListener = paramOnOpenResultListener;
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
  
  public Builder setTimeoutMills(int paramInt)
  {
    this.timeoutMills = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.QRoutePluginActivityParams.Builder
 * JD-Core Version:    0.7.0.1
 */