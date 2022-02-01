package cooperation.qzone.plugin;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class QZonePluginMangerHelper$1
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "onServiceConnected");
    }
    if (QZonePluginMangerHelper.access$000() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      QZonePluginMangerHelper.access$100();
      return;
    }
    paramComponentName = (QZonePluginMangerHelper.OnQzonePluginClientReadyListner)QZonePluginMangerHelper.access$000().get();
    if (paramComponentName == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return OnPluginManagerLoadedListener is null");
      }
      QZonePluginMangerHelper.access$100();
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "binder alive");
      }
      QZonePluginMangerHelper.sClient = new QZonePluginClient(QZoneRemotePluginManager.Stub.asInterface(paramIBinder));
      paramComponentName.onQzonePluginClientReady(QZonePluginMangerHelper.sClient);
    }
    for (;;)
    {
      QZonePluginMangerHelper.access$100();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "binder not alive");
      }
      paramComponentName.onQzonePluginClientReady(null);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected");
    }
    if (QZonePluginMangerHelper.sClient != null)
    {
      QZonePluginMangerHelper.sClient.destroy();
      QZonePluginMangerHelper.sClient = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginMangerHelper.1
 * JD-Core Version:    0.7.0.1
 */