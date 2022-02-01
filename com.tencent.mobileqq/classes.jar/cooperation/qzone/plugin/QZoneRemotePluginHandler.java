package cooperation.qzone.plugin;

import android.os.Binder;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QZoneRemotePluginHandler
  extends QZoneRemotePluginManager.Stub
{
  private static String TAG = "QZoneRemotePluginHandler";
  private static QZoneRemotePluginHandler instance;
  private WeakReference<QQAppInterface> appInterfaceRef;
  private IQZonePluginManager pluginManger;
  
  private void ensureManager()
  {
    Object localObject = null;
    if (this.appInterfaceRef != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.appInterfaceRef.get();
      localObject = localQQAppInterface;
      if (localQQAppInterface != null)
      {
        this.pluginManger = ((IQZonePluginManager)localQQAppInterface.getManager(QQManagerFactory.QZONE_PLUGIN_MANAGER));
        localObject = localQQAppInterface;
      }
    }
    QLog.i(TAG, 1, "appInterface:" + localObject + ",pluginManger=" + this.pluginManger);
  }
  
  public static QZoneRemotePluginHandler getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QZoneRemotePluginHandler();
      }
      return instance;
    }
    finally {}
  }
  
  public boolean cancelInstall(String paramString)
  {
    ensureManager();
    if (this.pluginManger == null) {
      return false;
    }
    return this.pluginManger.cancelInstall(paramString);
  }
  
  @Nullable
  public QQAppInterface getAppInterface()
  {
    if (this.appInterfaceRef == null) {
      return null;
    }
    return (QQAppInterface)this.appInterfaceRef.get();
  }
  
  public Binder getBinder()
  {
    return this;
  }
  
  public void installPituSo(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "installPituSo");
    }
    ensureManager();
    if (this.pluginManger == null) {
      return;
    }
    this.pluginManger.installPituSo(paramOnQZoneLiveSoDownloadListener, paramInt);
  }
  
  public boolean installPlugin(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "installPlugin:" + paramString);
    }
    ensureManager();
    if (this.pluginManger == null) {
      return false;
    }
    return this.pluginManger.installPlugin(paramString, paramOnQZonePluginInstallListner, paramInt);
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isPluginInstalled:" + paramString);
    }
    ensureManager();
    if (this.pluginManger != null) {
      return this.pluginManger.isPluginInstalled(paramString);
    }
    return false;
  }
  
  public boolean isReady()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isReady");
    }
    ensureManager();
    if (this.pluginManger == null) {
      return false;
    }
    return this.pluginManger.isReady();
  }
  
  public PluginRecord queryPlugin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "queryPlugin:" + paramString);
    }
    ensureManager();
    if (this.pluginManger == null) {
      return null;
    }
    return this.pluginManger.queryPlugin(paramString);
  }
  
  public void setAppInterface(QQAppInterface paramQQAppInterface)
  {
    this.appInterfaceRef = new WeakReference(paramQQAppInterface);
  }
  
  public void triggerQQDownloadPtuFilter()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "triggerQQDownloadPtuFilter");
    }
    ensureManager();
    if (this.pluginManger == null) {
      return;
    }
    this.pluginManger.triggerQQDownloadPtuFilter();
  }
  
  public boolean uninstallPlugin(String paramString)
  {
    ensureManager();
    if (this.pluginManger == null) {
      return false;
    }
    return this.pluginManger.uninstallPlugin(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneRemotePluginHandler
 * JD-Core Version:    0.7.0.1
 */