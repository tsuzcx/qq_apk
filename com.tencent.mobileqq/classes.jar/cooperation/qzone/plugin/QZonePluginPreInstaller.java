package cooperation.qzone.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.NetworkStateListener;

class QZonePluginPreInstaller
  extends OnQZonePluginInstallListner.Stub
  implements NetworkState.NetworkStateListener
{
  public static final int MSG_RETRY_DOWNLOAD = 1;
  public static final String TAG = "QZonePluginPreInstaller";
  private static final String[] preloadPlugins = { "qzone_live_video_plugin_hack.apk", "qzone_vertical_video_plugin.apk" };
  private static int retryInstallNum;
  private Handler mHandler = new QZonePluginPreInstaller.1(this, Looper.getMainLooper());
  private QZonePluginManager manger;
  private QZonePluginUpdater updater;
  
  QZonePluginPreInstaller(QZonePluginManager paramQZonePluginManager, QZonePluginUpdater paramQZonePluginUpdater)
  {
    this.updater = paramQZonePluginUpdater;
    this.manger = paramQZonePluginManager;
    NetworkState.addListener(this);
  }
  
  public void onDestroy()
  {
    this.mHandler.removeMessages(1);
    retryInstallNum = 0;
    NetworkState.removeListener(this);
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallBegin");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, float paramFloat, long paramLong) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallError, plugin=" + paramString + ", retryInstallNum=" + retryInstallNum);
    }
    paramInt = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
    if ((retryInstallNum < paramInt) && (this.manger != null))
    {
      retryInstallNum += 1;
      paramString = this.mHandler.obtainMessage(1, paramString);
      this.mHandler.sendMessageDelayed(paramString, retryInstallNum * 30 * 1000);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallFinish");
    }
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (QZonePluginManager.canDownloadPlugin()) {
      preload();
    }
  }
  
  void preload()
  {
    if ((QZonePluginManager.canDownloadPlugin()) && (this.updater.getAllPlugins() != null)) {
      try
      {
        String[] arrayOfString = preloadPlugins;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.manger.installPlugin(str, this, 0);
          i += 1;
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("QZonePluginPreInstaller", 1, localRemoteException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginPreInstaller
 * JD-Core Version:    0.7.0.1
 */