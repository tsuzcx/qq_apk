package cooperation.qzone.api;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

final class QZoneApiProxy$1
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  QZoneApiProxy$1(long paramLong, QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onPluginManagerLoaded: ");
    Object localObject;
    if (paramPluginManagerClient != null)
    {
      localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));
      QZLog.i("QZoneApiProxy", localObject + " cost " + (System.nanoTime() - this.val$now));
      if (paramPluginManagerClient != null)
      {
        if (paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) {
          QZoneApiProxy.sIsQzoneInstalled = true;
        }
        QZoneApiProxy.access$102(new WeakReference(paramPluginManagerClient));
      }
      if (this.val$callback != null)
      {
        localObject = this.val$callback;
        if ((paramPluginManagerClient == null) || (!paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) || (!QZoneApiProxy.access$200(BaseApplicationImpl.getApplication()))) {
          break label137;
        }
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      ((QZoneApiProxy.QZoneLoadCallback)localObject).onLoadOver(bool);
      return;
      localObject = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.api.QZoneApiProxy.1
 * JD-Core Version:    0.7.0.1
 */