package cooperation.qzone;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import cooperation.qzone.plugin.QZonePluginManager;

final class QZoneHelper$9
  implements Runnable
{
  QZoneHelper$9(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QZonePluginManager localQZonePluginManager = (QZonePluginManager)this.val$app.getManager(QQManagerFactory.QZONE_PLUGIN_MANAGER);
    if (localQZonePluginManager != null) {
      localQZonePluginManager.setReadyToNetworking();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.9
 * JD-Core Version:    0.7.0.1
 */