package com.tencent.mobileqq.pluginsdk;

import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public class PluginManageHandler$PluginManageWrapper
  extends RemotePluginManager.Stub
{
  public PluginManageHandler$PluginManageWrapper(PluginManageHandler paramPluginManageHandler) {}
  
  public void cancelInstall(String paramString)
  {
    if (PluginManageHandler.access$000(this.this$0) == null)
    {
      PluginManageHandler.access$300(this.this$0);
      if (PluginManageHandler.access$000(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
        }
        return;
      }
    }
    try
    {
      PluginManageHandler.access$000(this.this$0).cancelInstall(paramString);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "installPlugin " + PluginManageHandler.access$000(this.this$0));
    }
    if (PluginManageHandler.access$000(this.this$0) == null)
    {
      PluginManageHandler.access$300(this.this$0);
      if (PluginManageHandler.access$000(this.this$0) == null) {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
        }
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          PluginManageHandler.access$000(this.this$0).installPlugin(paramString, paramOnPluginInstallListener);
          if (QLog.isDevelopLevel())
          {
            QLog.i("plugin_tag", 4, "installPlugin done");
            return;
          }
        }
        catch (RemoteException paramString) {}
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("plugin_tag", 4, "installPlugin", paramString);
  }
  
  public boolean isPlugininstalled(String paramString)
  {
    if (PluginManageHandler.access$000(this.this$0) == null)
    {
      PluginManageHandler.access$300(this.this$0);
      if (PluginManageHandler.access$000(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
        }
        return false;
      }
    }
    return PluginManageHandler.access$000(this.this$0).isPlugininstalled(paramString);
  }
  
  public boolean isReady()
  {
    if (PluginManageHandler.access$000(this.this$0) == null)
    {
      PluginManageHandler.access$300(this.this$0);
      if (PluginManageHandler.access$000(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
        }
        return false;
      }
    }
    try
    {
      boolean bool = PluginManageHandler.access$000(this.this$0).isReady();
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
  
  public PluginBaseInfo queryPlugin(String paramString)
  {
    if (PluginManageHandler.access$000(this.this$0) == null)
    {
      PluginManageHandler.access$300(this.this$0);
      if (PluginManageHandler.access$000(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
        }
        return null;
      }
    }
    try
    {
      paramString = PluginManageHandler.access$000(this.this$0).queryPlugin(paramString);
      return paramString;
    }
    catch (RemoteException paramString) {}
    return null;
  }
  
  public void setListener(RemotePluginManager paramRemotePluginManager)
  {
    this.this$0.mClientProxy = paramRemotePluginManager;
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginManageHandler setListener");
    }
    if (PluginManageHandler.access$000(this.this$0) != null)
    {
      paramRemotePluginManager.setListener(this);
      return;
    }
    PluginManageHandler.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManageHandler.PluginManageWrapper
 * JD-Core Version:    0.7.0.1
 */