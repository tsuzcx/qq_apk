package cooperation.qzone.api;

import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

final class QZoneApiProxy$2
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isQzoneInstalled: ");
    if (paramPluginManagerClient != null) {}
    for (Object localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));; localObject = "null")
    {
      QZLog.i("QZoneApiProxy", localObject);
      if ((paramPluginManagerClient != null) && (paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"))) {
        QZoneApiProxy.sIsQzoneInstalled = true;
      }
      QZoneApiProxy.access$102(new WeakReference(paramPluginManagerClient));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.api.QZoneApiProxy.2
 * JD-Core Version:    0.7.0.1
 */