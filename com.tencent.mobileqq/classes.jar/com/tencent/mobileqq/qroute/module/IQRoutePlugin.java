package com.tencent.mobileqq.qroute.module;

import android.content.ServiceConnection;

public abstract interface IQRoutePlugin
{
  public abstract void bindService(QRoutePluginServiceParams paramQRoutePluginServiceParams, ServiceConnection paramServiceConnection);
  
  public abstract boolean exist();
  
  public abstract void install(IQRoutePluginInstallListener paramIQRoutePluginInstallListener);
  
  public abstract void install(IQRoutePluginInstallListener paramIQRoutePluginInstallListener, boolean paramBoolean);
  
  public abstract boolean isInstalled();
  
  public abstract void loadPlugin();
  
  public abstract Class loadPluginClass(String paramString);
  
  public abstract String pluginId();
  
  public abstract QRoutePluginInfo queryPluginInfo();
  
  public abstract void sendBroadcast(QRoutePluginReceiverParams paramQRoutePluginReceiverParams);
  
  public abstract void startActivityForResult(QRoutePluginActivityParams paramQRoutePluginActivityParams);
  
  public abstract void startService(QRoutePluginServiceParams paramQRoutePluginServiceParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.IQRoutePlugin
 * JD-Core Version:    0.7.0.1
 */