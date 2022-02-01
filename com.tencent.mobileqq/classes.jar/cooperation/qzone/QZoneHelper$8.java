package cooperation.qzone;

import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.plugin.QZonePluginManager;

final class QZoneHelper$8
  implements Runnable
{
  QZoneHelper$8(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QZonePluginManager localQZonePluginManager = (QZonePluginManager)this.val$app.getManager(175);
    if (localQZonePluginManager != null) {
      localQZonePluginManager.setReadyToNetworking();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.8
 * JD-Core Version:    0.7.0.1
 */