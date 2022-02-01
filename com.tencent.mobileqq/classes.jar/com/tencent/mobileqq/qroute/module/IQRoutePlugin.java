package com.tencent.mobileqq.qroute.module;

import android.content.ServiceConnection;

public abstract interface IQRoutePlugin
{
  public abstract void bindService(QRoutePluginOpenParams paramQRoutePluginOpenParams, ServiceConnection paramServiceConnection);
  
  public abstract boolean exist();
  
  public abstract void install(IQRoutePluginInstallListener paramIQRoutePluginInstallListener);
  
  public abstract void install(IQRoutePluginInstallListener paramIQRoutePluginInstallListener, boolean paramBoolean);
  
  public abstract boolean isInstalled();
  
  public abstract Class loadPluginClass(String paramString);
  
  public abstract void openActivityForResult(QRoutePluginOpenParams paramQRoutePluginOpenParams);
  
  public abstract String pluginId();
  
  public abstract QRoutePluginInfo queryPluginInfo();
  
  public abstract void startService(QRoutePluginOpenParams paramQRoutePluginOpenParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.IQRoutePlugin
 * JD-Core Version:    0.7.0.1
 */