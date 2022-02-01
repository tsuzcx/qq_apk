package com.tencent.mobileqq.pluginsdk;

import android.os.Handler;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

public class PluginManageHandler
{
  public static Handler handler;
  private static volatile PluginManageHandler sInstance;
  RemotePluginManager mClientProxy;
  private PluginManageHandler.IPluginManagerProvider mManagerProvider;
  private RemotePluginManager.Stub mPluginManager;
  private PluginManageHandler.PluginManageWrapper mWrapper;
  
  private void ensureManagerReady()
  {
    if (this.mPluginManager != null) {
      return;
    }
    getPluginIOHandler().post(new PluginManageHandler.1(this));
  }
  
  public static final PluginManageHandler getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new PluginManageHandler();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static Handler getPluginIOHandler()
  {
    try
    {
      if (handler == null) {
        handler = new Handler(IPluginAdapterProxy.getProxy().getSubThreadLooper());
      }
      Handler localHandler = handler;
      return localHandler;
    }
    finally {}
  }
  
  private void notifyReadyToClient()
  {
    RemotePluginManager localRemotePluginManager = this.mClientProxy;
    if (localRemotePluginManager != null) {
      try
      {
        localRemotePluginManager.setListener(this.mWrapper);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "notifyReadyToClient ", localException);
        }
      }
    }
  }
  
  public IBinder getBinder()
  {
    if (this.mWrapper == null) {
      this.mWrapper = new PluginManageHandler.PluginManageWrapper(this);
    }
    return this.mWrapper;
  }
  
  public void setPluginManagerProvider(PluginManageHandler.IPluginManagerProvider paramIPluginManagerProvider, boolean paramBoolean)
  {
    if (this.mManagerProvider != paramIPluginManagerProvider)
    {
      this.mWrapper = null;
      this.mPluginManager = null;
      this.mManagerProvider = paramIPluginManagerProvider;
    }
    if ((this.mManagerProvider != null) && (paramBoolean)) {
      ensureManagerReady();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManageHandler
 * JD-Core Version:    0.7.0.1
 */