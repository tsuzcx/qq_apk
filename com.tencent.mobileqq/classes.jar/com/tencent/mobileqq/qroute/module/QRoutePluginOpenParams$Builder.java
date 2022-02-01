package com.tencent.mobileqq.qroute.module;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class QRoutePluginOpenParams$Builder
{
  private int acitivtyRequestCode = -1;
  private String componentName;
  private Class containerClass;
  private Context context;
  private Intent intent;
  private boolean isPreload = false;
  private IQRoutePlugin.OnOpenResultListener openPluginListener;
  private String pluginName;
  private String subModule;
  
  public QRoutePluginOpenParams build()
  {
    QRoutePluginOpenParams localQRoutePluginOpenParams = new QRoutePluginOpenParams(null);
    localQRoutePluginOpenParams.component = this.componentName;
    localQRoutePluginOpenParams.intent = this.intent;
    localQRoutePluginOpenParams.activityRequestCode = this.acitivtyRequestCode;
    localQRoutePluginOpenParams.isPreload = this.isPreload;
    localQRoutePluginOpenParams.componentContainer = this.containerClass;
    localQRoutePluginOpenParams.subModule = this.subModule;
    localQRoutePluginOpenParams.pluginName = this.pluginName;
    localQRoutePluginOpenParams.openResultListener = this.openPluginListener;
    localQRoutePluginOpenParams.context = this.context;
    if (localQRoutePluginOpenParams.intent == null) {
      localQRoutePluginOpenParams.intent = new Intent();
    }
    if ((localQRoutePluginOpenParams.intent.getComponent() == null) && (this.containerClass != null))
    {
      ComponentName localComponentName = new ComponentName(this.context, this.containerClass);
      localQRoutePluginOpenParams.intent.setComponent(localComponentName);
    }
    return localQRoutePluginOpenParams;
  }
  
  public Builder setActivityRequestCode(int paramInt)
  {
    this.acitivtyRequestCode = paramInt;
    return this;
  }
  
  public Builder setComponentName(String paramString)
  {
    this.componentName = paramString;
    return this;
  }
  
  public Builder setComponentProxyClass(Class paramClass)
  {
    this.containerClass = paramClass;
    return this;
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
  
  public Builder setOpenResultListener(IQRoutePlugin.OnOpenResultListener paramOnOpenResultListener)
  {
    this.openPluginListener = paramOnOpenResultListener;
    return this;
  }
  
  public Builder setPluginName(String paramString)
  {
    this.pluginName = paramString;
    return this;
  }
  
  public Builder setPreload(boolean paramBoolean)
  {
    this.isPreload = paramBoolean;
    return this;
  }
  
  public Builder setSubModuleId(String paramString)
  {
    this.subModule = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.QRoutePluginOpenParams.Builder
 * JD-Core Version:    0.7.0.1
 */