package com.tencent.mobileqq.pluginsdk;

import android.os.IInterface;

public abstract interface RemotePluginManager
  extends IInterface
{
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
  
  public abstract PluginBaseInfo queryPlugin(String paramString);
  
  public abstract void setListener(RemotePluginManager paramRemotePluginManager);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.RemotePluginManager
 * JD-Core Version:    0.7.0.1
 */