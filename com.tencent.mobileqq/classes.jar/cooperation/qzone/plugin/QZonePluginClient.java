package cooperation.qzone.plugin;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class QZonePluginClient
  extends IQZonePluginManager
{
  QZoneRemotePluginManager remotePluginManager;
  
  QZonePluginClient(QZoneRemotePluginManager paramQZoneRemotePluginManager)
  {
    this.remotePluginManager = paramQZoneRemotePluginManager;
  }
  
  public boolean cancelInstall(String paramString)
  {
    try
    {
      boolean bool = this.remotePluginManager.cancelInstall(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public void destroy()
  {
    this.remotePluginManager = null;
  }
  
  public void installPituSo(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt)
  {
    try
    {
      this.remotePluginManager.installPituSo(paramOnQZoneLiveSoDownloadListener, paramInt);
      return;
    }
    catch (NullPointerException paramOnQZoneLiveSoDownloadListener)
    {
      QLog.e("QZonePluginClient", 1, paramOnQZoneLiveSoDownloadListener, new Object[0]);
    }
  }
  
  public boolean installPlugin(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt)
  {
    try
    {
      boolean bool = this.remotePluginManager.installPlugin(paramString, paramOnQZonePluginInstallListner, paramInt);
      return bool;
    }
    catch (NullPointerException paramString)
    {
      QLog.e("QZonePluginClient", 1, paramString, new Object[0]);
    }
    return false;
  }
  
  boolean isAlive()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.remotePluginManager != null)
      {
        IBinder localIBinder = this.remotePluginManager.asBinder();
        bool1 = bool2;
        if (localIBinder != null)
        {
          bool1 = bool2;
          if (localIBinder.isBinderAlive())
          {
            boolean bool3 = localIBinder.pingBinder();
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    try
    {
      boolean bool = this.remotePluginManager.isPluginInstalled(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean isReady()
  {
    try
    {
      boolean bool = this.remotePluginManager.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  public PluginRecord queryPlugin(String paramString)
  {
    try
    {
      paramString = this.remotePluginManager.queryPlugin(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (NullPointerException paramString)
    {
      for (;;)
      {
        QLog.w("QZonePluginClient", 1, "", paramString);
      }
    }
  }
  
  public void readyForLaunch(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    try
    {
      installPlugin(paramPluginParams.mPluginID, new QZonePluginClient.1(this, paramOnPluginReadyListener, paramContext, paramPluginParams), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void setReadyToNetworking()
  {
    throw new IllegalAccessException("QZonePluginClient 不能调用setReadyToNetworking");
  }
  
  public void triggerQQDownloadPtuFilter()
  {
    try
    {
      this.remotePluginManager.triggerQQDownloadPtuFilter();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("QZonePluginClient", 1, localNullPointerException, new Object[0]);
    }
  }
  
  public boolean uninstallPlugin(String paramString)
  {
    try
    {
      boolean bool = this.remotePluginManager.uninstallPlugin(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginClient
 * JD-Core Version:    0.7.0.1
 */