package cooperation.qzone.plugin;

import com.tencent.qphone.base.util.QLog;

class QZonePluginManager$PluginInstallForLaunch
  extends OnQZonePluginInstallListner.Stub
{
  private QZonePluginManager.LaunchState mLaunchState;
  
  public QZonePluginManager$PluginInstallForLaunch(QZonePluginManager paramQZonePluginManager, QZonePluginManager.LaunchState paramLaunchState)
  {
    this.mLaunchState = paramLaunchState;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallBegin." + paramString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, float paramFloat, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallDownloadProgress." + paramString);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallError." + paramString + "," + paramInt);
    }
    QZonePluginManager.LaunchState localLaunchState = this.mLaunchState;
    if ((localLaunchState != null) && (localLaunchState.listener != null))
    {
      paramString = this.this$0.queryPlugin(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localLaunchState.params.mApkFilePath = paramString.mInstalledPath;
      }
      paramString = localLaunchState.listener;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.onPluginReady(bool, localLaunchState.context, localLaunchState.params);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.mLaunchState;
    if ((paramString != null) && (paramString.listener != null))
    {
      PluginRecord localPluginRecord = QZonePluginManager.access$100(this.this$0).getInstalledPlugininfo(paramString.params.mPluginID);
      if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
        paramString.params.mApkFilePath = localPluginRecord.mInstalledPath;
      }
      paramString.listener.onPluginReady(true, paramString.context, paramString.params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginManager.PluginInstallForLaunch
 * JD-Core Version:    0.7.0.1
 */