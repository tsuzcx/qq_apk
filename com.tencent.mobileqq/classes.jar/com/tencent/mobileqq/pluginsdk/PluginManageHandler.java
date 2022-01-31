package com.tencent.mobileqq.pluginsdk;

import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public class PluginManageHandler
{
  private static volatile PluginManageHandler b;
  public static Handler handler;
  RemotePluginManager a;
  private IPluginManagerProvider c;
  private RemotePluginManager.Stub d;
  private PluginManageWrapper e;
  
  private void a()
  {
    if (this.d != null) {
      return;
    }
    getPluginIOHandler().post(new f(this));
  }
  
  private void b()
  {
    if (this.a != null) {}
    try
    {
      this.a.setListener(this.e);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("plugin_tag", 2, "notifyReadyToClient ", localException);
    }
  }
  
  public static final PluginManageHandler getInstance()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new PluginManageHandler();
      }
      return b;
    }
    finally {}
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
  
  public IBinder getBinder()
  {
    if (this.e == null) {
      this.e = new PluginManageWrapper();
    }
    return this.e;
  }
  
  public void setPluginManagerProvider(IPluginManagerProvider paramIPluginManagerProvider, boolean paramBoolean)
  {
    this.c = paramIPluginManagerProvider;
    if (this.c == null)
    {
      this.e = null;
      this.d = null;
    }
    while (!paramBoolean) {
      return;
    }
    a();
  }
  
  public static abstract interface IPluginManagerProvider
  {
    public abstract RemotePluginManager.Stub onGetPluginManager();
  }
  
  public class PluginManageWrapper
    extends RemotePluginManager.Stub
  {
    public PluginManageWrapper() {}
    
    public void cancelInstall(String paramString)
    {
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.d(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return;
        }
      }
      try
      {
        PluginManageHandler.a(PluginManageHandler.this).cancelInstall(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("plugin_tag", 4, "installPlugin " + PluginManageHandler.a(PluginManageHandler.this));
      }
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.d(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null) {
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
            PluginManageHandler.a(PluginManageHandler.this).installPlugin(paramString, paramOnPluginInstallListener);
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
      throws RemoteException
    {
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.d(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return false;
        }
      }
      return PluginManageHandler.a(PluginManageHandler.this).isPlugininstalled(paramString);
    }
    
    public boolean isReady()
    {
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.d(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return false;
        }
      }
      try
      {
        boolean bool = PluginManageHandler.a(PluginManageHandler.this).isReady();
        return bool;
      }
      catch (RemoteException localRemoteException) {}
      return false;
    }
    
    public PluginBaseInfo queryPlugin(String paramString)
    {
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.d(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return null;
        }
      }
      try
      {
        paramString = PluginManageHandler.a(PluginManageHandler.this).queryPlugin(paramString);
        return paramString;
      }
      catch (RemoteException paramString) {}
      return null;
    }
    
    public void setListener(RemotePluginManager paramRemotePluginManager)
      throws RemoteException
    {
      PluginManageHandler.this.a = paramRemotePluginManager;
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "PluginManageHandler setListener");
      }
      if (PluginManageHandler.a(PluginManageHandler.this) != null)
      {
        paramRemotePluginManager.setListener(this);
        return;
      }
      PluginManageHandler.d(PluginManageHandler.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManageHandler
 * JD-Core Version:    0.7.0.1
 */