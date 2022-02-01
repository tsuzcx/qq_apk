package cooperation.qzone.plugin;

import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;

public class QZonePluginManager
{
  public static final String TAG = "QZonePluginManger";
  
  public static boolean canDownloadPlugin()
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool2 = true;
    int i = ((QzoneConfig)localObject).getConfig("LiveSetting", "PluginDownloadOnlyWifi", 1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("canDownloadPlugin, onlyWifi=");
    ((StringBuilder)localObject).append(i);
    QLog.d("QZonePluginManger", 1, ((StringBuilder)localObject).toString());
    if (i > 0) {
      return NetworkState.isWifiConn();
    }
    i = NetworkState.getNetworkType();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("network type = ");
    ((StringBuilder)localObject).append(i);
    QLog.d("QZonePluginManger", 1, ((StringBuilder)localObject).toString());
    boolean bool1 = bool2;
    if (1 != i)
    {
      bool1 = bool2;
      if (4 != i)
      {
        bool1 = bool2;
        if (5 != i)
        {
          if (3 == i) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginManager
 * JD-Core Version:    0.7.0.1
 */